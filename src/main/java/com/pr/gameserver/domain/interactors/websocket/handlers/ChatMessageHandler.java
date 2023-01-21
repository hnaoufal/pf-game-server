package com.pr.gameserver.domain.interactors.websocket.handlers;

import com.pr.gameserver.application.websockets.ServerController;
import com.pr.gameserver.domain.interactors.websocket.helpers.MessageHandler;
import com.pr.gameserver.domain.entities.messages.ChatMessage;
import jakarta.websocket.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatMessageHandler extends MessageHandler<ChatMessage> {
    private static final Logger log = LoggerFactory.getLogger(ChatMessageHandler.class);

    @Override
    public Class<ChatMessage> getMessageClass() {
        return ChatMessage.class;
    }

    @Override
    protected void handle(Session session, ChatMessage object) {
        ServerController.getInstance().sendAllExceptCurrentUser(session, object);
    }
}
