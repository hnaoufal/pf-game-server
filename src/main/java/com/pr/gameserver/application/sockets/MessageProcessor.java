package com.pr.gameserver.application.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageProcessor {

    private MessageProcessor(){}
    public static void init() {
        int port = 8082;

        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            client = server.accept();
            System.out.println("Client connected");

            // Start Game here

            client.close();
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
