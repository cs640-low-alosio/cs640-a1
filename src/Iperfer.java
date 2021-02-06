import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Iperfer {

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
        
        System.out.println("test clientSocket connected: " + clientSocket.isConnected());
        
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
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        
        System.out.println("test clientSocket connected: " + clientSocket.isConnected());
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
