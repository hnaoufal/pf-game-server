package com.pr.gameserver.application.websockets.server.msginteraction.handler;

import com.pr.gameserver.application.websockets.common.msginteraction.generic.MessageHandler;
import com.pr.gameserver.application.websockets.common.msginteraction.message.NeedRefreshUserListMsg;
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
