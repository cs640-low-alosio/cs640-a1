import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Iperfer {

  static final int BUF_SIZE = 1000;

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

    if (args[0].equals("-s")) {
      int port = Integer.parseInt(args[2]);

      try {
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setReceiveBufferSize(BUF_SIZE);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in =
            new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        long startTime = System.nanoTime();
        int counter = 1;

        while (in.read() != -1) {
          counter++;
        }
        counter = counter / (BUF_SIZE / Character.BYTES);

        System.out.println("received=" + counter + " KB rate="
            + (counter * 8) / ((System.nanoTime() - startTime) / 1000000) + " Mbps");

        clientSocket.close();
        serverSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else { // otherwise, assume -c
      int port = Integer.parseInt(args[4]);
      String serverIp = args[2];
      int secDur = Integer.parseInt(args[6]);
      
      try {
        Socket clientSocket = new Socket(serverIp, port);
        clientSocket.setSendBufferSize(BUF_SIZE);
        BufferedWriter out =
            new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()), BUF_SIZE);
        
        char[] bytes = new char[BUF_SIZE / Character.BYTES];
        Arrays.fill(bytes, '0');
        long startTime = System.nanoTime();
        long nsecDur = secDur * 1000000000;
        int counter = 0;

        while ((System.nanoTime() - startTime) < nsecDur) {
          out.write(bytes);
          counter++;
        }

        System.out
            .println("sent=" + counter + " KB rate=" + (counter * 8) / (secDur * 1000) + " Mbps");

        clientSocket.close();
      } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
