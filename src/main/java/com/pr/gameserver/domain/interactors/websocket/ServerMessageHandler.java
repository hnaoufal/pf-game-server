package com.pr.gameserver.domain.interactors.websocket;

import com.pr.gameserver.domain.interactors.websocket.actionhandlers.*;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.AllMessageHandler;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.*;

import java.util.Map;

public class ServerMessageHandler extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginMessage.class.getSimpleName(), new LoginHandler());
        handleMap.put(RollTheDice.class.getSimpleName(), new RollTheDiceHandler());
        handleMap.put(NeedRefreshUserListMsg.class.getSimpleName(), new NeedRefreshUserListHandler());
        handleMap.put(ChatMessage.class.getSimpleName(), new ChatMessageHandler());
        handleMap.put(MoveMessage.class.getSimpleName(), new MoveMessageHandler());
    }
}
