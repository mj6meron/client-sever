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

            // we need to return something!
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Welcome to Echo Server, Today's date is: " + (new java.util.Date()).toString());
            System.out.println("Server send date!");

            // maybe get some input
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Message from client: " + (in.readLine()).toString());


            client.close();
            serverSocket.close();
            System.out.println("Socket closed");


        } catch (Exception e) {
    }
  }
}
