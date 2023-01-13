package com.pr.gameserver.application.websockets.server.msginteraction.handler;

import com.pr.gameserver.application.websockets.common.msginteraction.generic.MessageHandler;
import com.pr.gameserver.application.websockets.common.msginteraction.message.ReceiveScore;
import com.pr.gameserver.application.websockets.common.msginteraction.message.RollTheDice;
import com.pr.gameserver.application.websockets.server.GameInfo;
import jakarta.websocket.Session;

public class RollTheDiceHandler extends MessageHandler<RollTheDice> {
    @Override
    public Class<RollTheDice> getMessageClass() {
        return RollTheDice.class;
    }

    @Override
    protected void handle(Session session, RollTheDice object) {
        final ReceiveScore score = new ReceiveScore();
        GameInfo.getInstance().setReceived(score);
    }
}
