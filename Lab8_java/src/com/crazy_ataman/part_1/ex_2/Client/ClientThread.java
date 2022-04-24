package com.crazy_ataman.part_1.ex_2.Client;

import java.io.*;
import java.net.Socket;

public class ClientThread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private BufferedReader inputUser;
    private final String address;
    private final int port;
    private String name;

    public ClientThread(String address, int port) {
        this.address = address;
        this.port = port;

        try {
            this.socket = new Socket(address, port);
        } catch (IOException ex) {
            System.err.println("Socket failed.");
        }

        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.inputName();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException ex) {
            ClientThread.this.downService();
        }
    }

    private void inputName() {
        System.out.print("Input name: ");
        try {
            name = inputUser.readLine();
            writer.write("Welcome " + name + "!\n");
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
            }
        } catch (IOException ignored) {
        }
    }

    private class ReadMessage extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    var message = reader.readLine();
                    System.out.println(message);
                }
            } catch (IOException ex) {
                ClientThread.this.downService();
            }
        }
    }

    public class WriteMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    var message = inputUser.readLine();
                    if (message.equals("The end.")) {
                        writer.write("The end." + "\n");
                        ClientThread.this.downService();
                        break;
                    } else {
                        writer.write(name + ": " + message + "\n");
                    }
                    writer.flush();
                } catch (IOException ex) {
                    ClientThread.this.downService();
                }
            }
        }
    }
}
