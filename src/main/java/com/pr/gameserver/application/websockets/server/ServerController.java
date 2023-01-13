package com.pr.gameserver.application.websockets.server;

import com.pr.gameserver.application.websockets.common.msginteraction.generic.Message;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServerController {
    private static ServerController serverController = new ServerController();

    public static ServerController getInstance() {
        return serverController;
    }

    private ServerController() {
    }

    Map<String, Session> sessionList = new HashMap<>();


    public Map<String, Session> getSessionList() {
        return sessionList;
    }

    public void send(String login, Object object) {
        System.out.println(login);
        System.out.println(object);
    }

    public void send(Session session, Object object) {
        try {
            session.getBasicRemote().sendText(Message.toStringMessage(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAll(Object object) {
    }

    public void addUser(String login, Session session) {
    }
}
