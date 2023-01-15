package com.pr.gameserver.domain.interactors.websocket.actionhandlers;

import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.NeedRefreshUserListMsg;
import jakarta.websocket.Session;

public class NeedRefreshUserListHandler extends MessageHandler<NeedRefreshUserListMsg> {
    @Override
    public Class<NeedRefreshUserListMsg> getMessageClass() {
        return NeedRefreshUserListMsg.class;
    }

    @Override
    protected void handle(Session session, NeedRefreshUserListMsg object) {
        System.out.println("hel");
    }
}
