package com.pr.gameserver.domain.interactors.websocket.handlers;

import com.pr.gameserver.application.websockets.ServerController;
import com.pr.gameserver.domain.interactors.websocket.helpers.MessageHandler;
import com.pr.gameserver.domain.entities.messages.MoveMessage;
import jakarta.websocket.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveMessageHandler extends MessageHandler<MoveMessage> {
    private static final Logger log = LoggerFactory.getLogger(MoveMessageHandler.class);

    @Override
    public Class<MoveMessage> getMessageClass() {
        return MoveMessage.class;
    }

    @Override
    protected void handle(Session session, MoveMessage object) {
        ServerController.getInstance().sendAllExceptCurrentUser(session, object);
    }
}
