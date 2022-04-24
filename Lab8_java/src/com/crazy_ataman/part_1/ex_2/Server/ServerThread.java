package com.crazy_ataman.part_1.ex_2.Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.historyOfMessage.printHistory(writer);
        start();
    }

    @Override
    public void run() {
        try {
            var message = reader.readLine();
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    message = reader.readLine();
                    if (message.equals("The end.")) {
                        this.downService();
                        break;
                    }
                    System.out.println(message);
                    Server.historyOfMessage.addHistoryElement(message);
                    for (ServerThread vr : Server.serverThreads) {
                        vr.send(message);
                    }
                }
            } catch (NullPointerException ignored) {
            }
        } catch (IOException ex) {
            this.downService();
        }

    }

    private void send(String message) {
        try {
            writer.write(message + "\n");
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
                for (ServerThread vr : Server.serverThreads) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverThreads.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }
}