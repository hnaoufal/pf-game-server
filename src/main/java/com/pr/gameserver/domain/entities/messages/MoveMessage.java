package com.pr.gameserver.domain.entities.messages;

public class MoveMessage {
    private String message;

    public MoveMessage(String coords) {
        this.message = coords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String coords) {
        this.message = coords;
    }
}
