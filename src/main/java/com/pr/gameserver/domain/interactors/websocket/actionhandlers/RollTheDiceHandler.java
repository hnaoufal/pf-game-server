package com.pr.gameserver.domain.interactors.websocket.actionhandlers;

import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.ReceiveScore;
import com.pr.gameserver.domain.usecases.websocket.RollTheDice;
import com.pr.gameserver.domain.gameengine.GameEngine;
import jakarta.websocket.Session;

public class RollTheDiceHandler extends MessageHandler<RollTheDice> {
    @Override
    public Class<RollTheDice> getMessageClass() {
        return RollTheDice.class;
    }

    @Override
    protected void handle(Session session, RollTheDice object) {
        final ReceiveScore score = new ReceiveScore();
        GameEngine.getInstance().setReceived(score);
    }
}
