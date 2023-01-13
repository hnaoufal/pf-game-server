package com.pr.gameserver.application.websockets.server;

import com.pr.gameserver.application.websockets.common.StaticData;
import jakarta.websocket.OnMessage;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(StaticData.REGION_PATH)
public class EchoEndpoint {
    @OnMessage
    public String echo(String message) {
        return message;
    }
}
