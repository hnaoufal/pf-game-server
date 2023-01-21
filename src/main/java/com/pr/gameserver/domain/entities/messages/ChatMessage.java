package com.pr.gameserver.domain.entities.messages;

public class ChatMessage {
    private String message;

    public ChatMessage(String login) {
        this.message = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String login) {
        this.message = login;
    }
}
