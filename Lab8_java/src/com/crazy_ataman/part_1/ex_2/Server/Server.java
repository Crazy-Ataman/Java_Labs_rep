package com.crazy_ataman.part_1.ex_2.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 4004;

    public static LinkedList<ServerThread> serverThreads= new LinkedList<>();
    public static HistoryOfMessage historyOfMessage;

    public static void main(String[] args) throws IOException{
        try (ServerSocket server = new ServerSocket(PORT)) {
            historyOfMessage = new HistoryOfMessage();
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                try {
                    serverThreads.add(new ServerThread(socket));
                } catch (IOException ex) {
                    socket.close();
                }
            }
        }
    }
}
