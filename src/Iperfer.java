import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Iperfer {
  
  static final int BUF_SIZE = 1000;

  public static void main(String[] args) {
    if (args.length != 7 && args.length != 3) {
      System.out.println("Error: missing or additional arguments");
      return;
    }
    
    if (args.length == 7 && !args[0].equals("-c")) {
      System.out.println("Error: missing or additional arguments");
      return;
    }
    
    if (args.length == 3 && !args[0].equals("-s")) {
      System.out.println("Error: missing or additional arguments");
      return;
    }
    
    if (args[0].equals("-c") && (Integer.parseInt(args[4]) < 1024 || Integer.parseInt(args[4]) > 65535)) {
      System.out.println("Error: port number must be in the range 1024 to 65535");
      return;
    }
    
    if (args[0].equals("-s") && (Integer.parseInt(args[2]) < 1024 || Integer.parseInt(args[2]) > 65535)) {
      System.out.println("Error: port number must be in the range 1024 to 65535");
      return;
    }
    
    if (args[0].equals("-s")) {
      int port = Integer.parseInt(args[2]);
      try {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
        
        long startTime = System.nanoTime();
        int counter = 0;
        char[] buffer = new char[BUF_SIZE / Character.BYTES];
        
//        serverSocket.setReceiveBufferSize(BUF_SIZE);
        
        System.out.println("bytes size: " + Character.BYTES * buffer.length);
        
//        while (in.read(buffer, 0, BUF_SIZE / Character.BYTES) != -1) {
        while (in.read(buffer) != -1) {
//          System.out.print(counter + ", ");
          counter++;
        }
//        counter = counter/(BUF_SIZE / Character.BYTES);
        
        System.out.println();
        
        System.out.println("received=" + counter + " KB rate=" + (counter * 8)/((System.nanoTime() - startTime) / 1000000) + " Mbps");
        
        System.out.println("test clientSocket connected: " + clientSocket.isConnected());
        
        clientSocket.close();
        serverSocket.close();
        
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else { // assume -c
      int port = Integer.parseInt(args[4]);
      String serverIp = args[2];
      int secondsToRun = Integer.parseInt(args[6]);
      
      Socket clientSocket;
      try {
        clientSocket = new Socket(serverIp, port);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()), BUF_SIZE);
        
        char[] bytes = new char[BUF_SIZE / Character.BYTES];
        Arrays.fill(bytes, '0');
        
        //clientSocket.setSoTimeout(secondsToRun*1000);
//        clientSocket.setSendBufferSize(BUF_SIZE);
        
        long startTime = System.nanoTime();
        long duration = (long) (secondsToRun * Math.pow(10, 9));
        int counter = 0;
        
        System.out.println("curr durr: " + (System.nanoTime() - startTime) + ", dur: " + duration);
        
        System.out.println(bytes);
        System.out.println("bytes size: " + Character.BYTES * bytes.length);
        
        while ((System.nanoTime() - startTime) < duration) {
//          System.out.print(counter + ", ");
          out.write(bytes, 0, BUF_SIZE / Character.BYTES);
          counter++;
        }
        System.out.println();
        
        System.out.println("test clientSocket connected: " + clientSocket.isConnected());
        
        System.out.println("sent=" + counter + " KB rate=" + (counter * 8)/(secondsToRun*1000) + " Mbps");
        
        clientSocket.close();
      } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
  }

}
