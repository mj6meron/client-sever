package com.company;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientConnectingToRemote{

    private static InetAddress HOST = null;
    private static final int serverPort = 1234;

    public static void main(String[] args) {
        try {
            HOST = InetAddress.getLocalHost();
            // This is where we specify the IP address of the device where the server is running!
            String c = "192.168.0.102";

            // Connect to server
            Socket socket = new Socket(InetAddress.getByName(c), serverPort);
            System.out.println("Connected to " + HOST.getHostName() + ":" + serverPort);

            while (true) {
                // Get inputs from the keyboard
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                // Get input from the server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // out to the server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.print(">");
                String command = keyboard.readLine();

                if (command.equals("exit")) {
                    out.close();
                    in.close();
                    break;
                } else if (command.contains("random")) {
                    out.println(generateRandomName());
                }
                out.println(command);

                // print out whatever the server says!
                String serverMessage = in.readLine();
                //JOptionPane.showMessageDialog(null, serverMessage);
                System.out.println("Server echo: " + serverMessage);

            }



            socket.close();
            System.exit(0);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomName() {
        String[] names = {"Alex", "John", "Jane", "Jim", "Sarah", "Emma", "Michael", "Emilie", "Olivia", "William"};
        String[] adjectives = {"kind", "smart", "funny", "generous", "diligent", "charming", "friendly", "strong", "gentle", "courageous"};
        int nameIndex = (int) (Math.random() * names.length);
        int adjIndex = (int) (Math.random() * adjectives.length);
        return names[nameIndex] + " is a " + adjectives[adjIndex] + " person.";
    }



}

