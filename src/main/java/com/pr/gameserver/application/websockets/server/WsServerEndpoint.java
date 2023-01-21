package com.pr.gameserver.application.websockets.server;

import com.pr.gameserver.application.config.StaticData;
import com.pr.gameserver.domain.gameengine.UserInfoHelper;
import com.pr.gameserver.domain.interactors.websocket.ServerMessageHandler;
import jakarta.websocket.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@jakarta.websocket.server.ServerEndpoint(StaticData.REGION_PATH)
public class WsServerEndpoint {
    private static final Logger log = LoggerFactory.getLogger(WsServerEndpoint.class);
    ServerMessageHandler serverMessageHandler = new ServerMessageHandler();

    @OnMessage
    public String onMessage(Session session, String message) {
        log.info("WebServer received request for: " + message + " being processed for session " + session.getId());
        serverMessageHandler.handle(session, message);
        return "Hello " + message;
    }

    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("onOpen");
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException {
        String login = null;
        if(login != null) {
            final UserInfoHelper userInfoHelper = UserInfoHelper.getInstance();
            userInfoHelper.getUserInfoByLogin(login).setIsOnline(false);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("WebServer encountered error for session " + session.getId(), throwable);
    }
}
