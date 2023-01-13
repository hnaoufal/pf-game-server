package com.pr.gameserver.application.websockets.server.msginteraction;

import com.pr.gameserver.application.websockets.common.msginteraction.generic.AllMessageHandler;
import com.pr.gameserver.application.websockets.common.msginteraction.generic.MessageHandler;
import com.pr.gameserver.application.websockets.common.msginteraction.message.LoginMessage;
import com.pr.gameserver.application.websockets.common.msginteraction.message.NeedRefreshUserListMsg;
import com.pr.gameserver.application.websockets.common.msginteraction.message.RollTheDice;
import com.pr.gameserver.application.websockets.server.msginteraction.handler.LoginHandler;
import com.pr.gameserver.application.websockets.server.msginteraction.handler.NeedRefreshUserListHandler;
import com.pr.gameserver.application.websockets.server.msginteraction.handler.RollTheDiceHandler;

import java.util.Map;

public class ServerMessageHandler extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginMessage.class.getName(), new LoginHandler());
        handleMap.put(RollTheDice.class.getName(), new RollTheDiceHandler());
        handleMap.put(NeedRefreshUserListMsg.class.getName(), new NeedRefreshUserListHandler());
    }
}
