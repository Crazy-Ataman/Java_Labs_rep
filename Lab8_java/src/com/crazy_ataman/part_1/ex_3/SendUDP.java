package com.crazy_ataman.part_1.ex_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendUDP {
    private final DatagramSocket socket;

    public SendUDP(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void sendMessages(String messages, int port) throws IOException {
        DatagramPacket message = new DatagramPacket(messages.getBytes(), messages.getBytes().length, InetAddress.getLocalHost(), port);
        socket.send(message);
    }

    public static void main(String[] args) throws IOException {
        SendUDP udp = new SendUDP(1234);
        udp.sendMessages("UDP: be a star!", 4321);
    }
}
