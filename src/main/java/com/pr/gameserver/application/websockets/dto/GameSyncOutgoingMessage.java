package com.pr.gameserver.application.websockets.dto;

public class GameSyncOutgoingMessage {
    private String content;

    public GameSyncOutgoingMessage(String s) {
        this.content = s;
    }

    public String getContent() {
        return content;
    }
}
