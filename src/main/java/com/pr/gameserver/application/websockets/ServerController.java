package com.pr.gameserver.application.websockets;

import com.pr.gameserver.domain.interactors.websocket.messagehandlers.Message;
import jakarta.websocket.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServerController {
    private static ServerController serverController = new ServerController();
    private static final Logger log = LoggerFactory.getLogger(ServerController.class);

    public static ServerController getInstance() {
        return serverController;
    }

    private ServerController() {}

    Map<String, Session> sessionList = new HashMap<>();


    public Map<String, Session> getSessionList() {
        return sessionList;
    }

    public void send(Session session, Object object) {
        log.info("sending request with message" + Message.toStringMessage(object));
        try {
            session.getBasicRemote().sendText(Message.toStringMessage(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String login, Object object) {
        try {
            this.getSessionList().get(login).getBasicRemote().sendText(Message.toStringMessage(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAll(Object object) {
        log.info("broadcasting request with message" + Message.toStringMessage(object));
        for (Session session : this.getSessionList().values()) {
            try {
                session.getBasicRemote().sendText(Message.toStringMessage(object));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendAllExceptCurrentUser(Session currentSession, Object object) {
        for (Session session : this.getSessionList().values()) {
            try {
                if (!Objects.equals(currentSession.getId(), session.getId())) {
                    session.getBasicRemote().sendText(Message.toStringMessage(object));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser(String login, Session session) {
        this.getSessionList().put(login, session);
    }
}
