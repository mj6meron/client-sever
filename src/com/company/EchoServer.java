package com.company;

import java.io.*;
import java.net.*;

public class EchoServer {
   private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            Socket client = serverSocket.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress().toString());



          while (true) {
              BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
              String request = in.readLine();
              PrintWriter out = new PrintWriter(client.getOutputStream(), true);
              if (request.contains("exit")) {
                  out.close();
                  in.close();
                  break;
              } else {
                  out.println(" >>> " + request);
                  System.out.println("Server sent echo!");
              }
              System.out.println("Message from client: " + request);
            }



            client.close();
            serverSocket.close();
            System.out.println("Socket closed");


        } catch (Exception e) {
    }
  }
}
