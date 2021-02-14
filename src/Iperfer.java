import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Iperfer {

  static final int BUF_SIZE = 1000;
  static final int BITS_PER_BYTE = 8;
  static DecimalFormat threePlaces = new DecimalFormat("0.000");

  public static void main(String[] args) {
    // Invalid arguments
    if (args[0].equals("-c")) {
      if (args.length != 7) {
        System.out.println("Error: missing or additional arguments");
        return;
      }
      if (Integer.parseInt(args[4]) < 1024 || Integer.parseInt(args[4]) > 65535) {
        System.out.println("Error: port number must be in the range 1024 to 65535");
        return;
      }
    }
    if (args[0].equals("-s")) {
      if (args.length != 3) {
        System.out.println("Error: missing or additional arguments");
        return;
      }
      if (Integer.parseInt(args[2]) < 1024 || Integer.parseInt(args[2]) > 65535) {
        System.out.println("Error: port number must be in the range 1024 to 65535");
        return;
      }
    }

    if (args[0].equals("-s")) { // Server Mode
      int port = Integer.parseInt(args[2]);

      try {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());

        long startTime = System.nanoTime();
        long charReadCount = 0;
        long totalChar = 0;

        char[] readBuffer = new char[BUF_SIZE / Character.BYTES]; // 500 chars (2 bytes) in one KByte
        // while (in.read() != -1) {
        while ((charReadCount = in.read(readBuffer, 0, BUF_SIZE / Character.BYTES)) != -1) {
          System.out.println("charReadCount: " + charReadCount); // debug
          totalChar += charReadCount;
        }
        
        System.out.println("totalChar: " + totalChar);
        
        long totalKByte = totalChar / (BUF_SIZE / Character.BYTES); // 500 chars (2 bytes) in one KByte
        System.out.println("totalKB: " + totalKByte);
        // totalKByte += 1; // figure out why server is off by one; discussed with Abhinay - one less on server is fine
        totalKByte = totalKByte / 2; // TODO: figure out why off by factor of two
        long totalMbit = totalKByte * BITS_PER_BYTE / 1000;
        long serverDuration = (System.nanoTime() - startTime) / 1000000000;
        double rate = (double) totalMbit / serverDuration;
        
        // debug
        System.out.println("server totalKByte read: " + totalKByte + ", starttime: " + startTime + ", rate: " + threePlaces.format(rate) + ", System.nanoTime: " + System.nanoTime() + ", denom: " + ((System.nanoTime() - startTime) / 1000000));
        // actual output
        System.out
            .println("received=" + totalKByte + " KB rate=" + threePlaces.format(rate) + " Mbps");

        clientSocket.close();
        serverSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else { // Client Mode
      int port = Integer.parseInt(args[4]);
      String serverIp = args[2];
      int secDuration = Integer.parseInt(args[6]);

      try {
        Socket clientSocket = new Socket(serverIp, port);
        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());

        char[] bytes = new char[BUF_SIZE / Character.BYTES]; // 500 chars (2 bytes) in one KByte
        Arrays.fill(bytes, '0');
        long startTime = System.nanoTime();
        long nanosecDuration = (long) (secDuration * Math.pow(10, 9));
        int totalKByte = 0;

        while ((System.nanoTime() - startTime) < nanosecDuration) {
          out.write(bytes, 0, BUF_SIZE / Character.BYTES);
          totalKByte++;
        }
        
        totalKByte = totalKByte / 2; // TODO: figure out why off by factor of two
        long totalMbit = totalKByte * 8 / 1000;
        long clientDuration = (System.nanoTime() - startTime) / 1000000000;
        double rate = (double) totalMbit / clientDuration;
        
        // debug
        System.out.println("client sizeof: " + Character.BYTES * bytes.length + ", totalKByte: " + totalKByte + ", starttime: " + startTime + ", rate: " + threePlaces.format(rate) + ", System.nanoTime: " + System.nanoTime() + ", clientDuration: " + clientDuration + ", nsecDur: " + nanosecDuration + ", calculation: " + (long) (secDuration * Math.pow(10, 9)));
        // actual output
        System.out.println("sent=" + totalKByte + " KB rate=" + threePlaces.format(rate) + " Mbps");

        clientSocket.close();
      } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
