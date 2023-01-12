package com.pr.gameserver.application.websockets.dto;

public class GameSyncOutgoingMessage {
    private final String content;

    public GameSyncOutgoingMessage(String s) {
        this.content = s;
    }

    public String getContent() {
        return content;
    }
}
