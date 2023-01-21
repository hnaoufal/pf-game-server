package com.pr.gameserver.domain.interactors.websocket.handlers;

import com.pr.gameserver.domain.interactors.websocket.helpers.MessageHandler;
import com.pr.gameserver.domain.entities.messages.NeedRefreshUserListMsg;
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
