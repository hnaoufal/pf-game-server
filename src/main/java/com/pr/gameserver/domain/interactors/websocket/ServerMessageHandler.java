package com.pr.gameserver.domain.interactors.websocket;

import com.pr.gameserver.domain.entities.messages.ChatMessage;
import com.pr.gameserver.domain.entities.messages.LoginMessage;
import com.pr.gameserver.domain.entities.messages.MoveMessage;
import com.pr.gameserver.domain.entities.messages.NeedRefreshUserListMsg;
import com.pr.gameserver.domain.interactors.websocket.handlers.*;
import com.pr.gameserver.domain.interactors.websocket.helpers.AllMessageHandler;
import com.pr.gameserver.domain.interactors.websocket.helpers.MessageHandler;

import java.util.Map;

public class ServerMessageHandler extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginMessage.class.getSimpleName(), new LoginHandler());
        handleMap.put(NeedRefreshUserListMsg.class.getSimpleName(), new NeedRefreshUserListHandler());
        handleMap.put(ChatMessage.class.getSimpleName(), new ChatMessageHandler());
        handleMap.put(MoveMessage.class.getSimpleName(), new MoveMessageHandler());
    }
}
