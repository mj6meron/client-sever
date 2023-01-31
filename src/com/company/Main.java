package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    private static InetAddress HOST = null;
    private static final int serverPort = 1234;

    public static void main(String[] args) {
        try {
            HOST = InetAddress.getLocalHost();

            // Connect to server
            Socket socket = new Socket(HOST, serverPort);
            System.out.println("Connected to " + HOST.getHostName() + ":" + serverPort);


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = in.readLine();
            JOptionPane.showMessageDialog(null, serverMessage);
            System.out.println("Server Message: " + serverMessage);


            socket.close();
            System.exit(0);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
