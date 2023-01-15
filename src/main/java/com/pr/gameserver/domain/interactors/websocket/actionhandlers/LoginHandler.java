package com.pr.gameserver.domain.interactors.websocket.actionhandlers;

import com.pr.gameserver.domain.gameengine.UserInfoHelper;
import com.pr.gameserver.domain.interactors.websocket.messagehandlers.MessageHandler;
import com.pr.gameserver.domain.usecases.websocket.LoginIndicatorMsg;
import com.pr.gameserver.domain.usecases.websocket.LoginMessage;
import com.pr.gameserver.application.websockets.ServerController;
import jakarta.websocket.Session;

import java.io.IOException;

public class LoginHandler extends MessageHandler<LoginMessage> {
    @Override
    public Class<LoginMessage> getMessageClass() {
        return LoginMessage.class;
    }

    @Override
    protected void handle(Session session, LoginMessage object) {
        final boolean isAddUser = UserInfoHelper.getInstance().createNewUser(object.getLogin());
        String login = object.getLogin();
        if (isAddUser) {
            System.out.println("User is there");
            ServerController.getInstance().addUser(login, session);
            ServerController.getInstance().send(login, new LoginIndicatorMsg(true));
            ServerController.getInstance().sendAll(UserInfoHelper.getInstance());
        } else {
            try {
                ServerController.getInstance().send(session, new LoginIndicatorMsg(false));
                session.close();
            } catch (IOException ignored) {
            }
        }
    }
}