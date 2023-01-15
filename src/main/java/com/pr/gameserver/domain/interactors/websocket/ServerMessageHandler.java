package com.pr.gameserver.domain.interactors.websocket;

import com.pr.gameserver.domain.interactors.websocket.actionhandlers.ChatMessageHandler;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.LoginHandler;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.NeedRefreshUserListHandler;
import com.pr.gameserver.domain.interactors.websocket.actionhandlers.RollTheDiceHandler;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.AllMessageHandler;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.ChatMessage;
import com.pr.gameserver.domain.usecases.websocket.LoginMessage;
import com.pr.gameserver.domain.usecases.websocket.NeedRefreshUserListMsg;
import com.pr.gameserver.domain.usecases.websocket.RollTheDice;

import java.util.Map;

public class ServerMessageHandler extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginMessage.class.getSimpleName(), new LoginHandler());
        handleMap.put(RollTheDice.class.getSimpleName(), new RollTheDiceHandler());
        handleMap.put(NeedRefreshUserListMsg.class.getSimpleName(), new NeedRefreshUserListHandler());
        handleMap.put(ChatMessage.class.getSimpleName(), new ChatMessageHandler());
    }
}
