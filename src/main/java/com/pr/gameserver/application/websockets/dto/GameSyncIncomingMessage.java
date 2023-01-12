package com.pr.gameserver.application.websockets.dto;

public class GameSyncIncomingMessage {
    private String name;

    public void HelloMessage() {
    }

    public void HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
