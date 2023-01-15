package com.pr.gameserver.domain.interactors.websocket;

import com.pr.gameserver.domain.interactors.websocket.messagehandlers.AllMessageHandler;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.LoginMessage;
import com.pr.gameserver.domain.usecases.websocket.NeedRefreshUserListMsg;
import com.pr.gameserver.domain.usecases.websocket.RollTheDice;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.LoginHandler;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.NeedRefreshUserListHandler;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.RollTheDiceHandler;

import java.util.Map;

public class ServerMessageHandler extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginMessage.class.getName(), new LoginHandler());
        handleMap.put(RollTheDice.class.getName(), new RollTheDiceHandler());
        handleMap.put(NeedRefreshUserListMsg.class.getName(), new NeedRefreshUserListHandler());
    }
}
