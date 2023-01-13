package com.pr.gameserver.application.websockets.server.msginteraction.handler;

import com.pr.gameserver.application.websockets.common.msginteraction.UserInfoHelper;
import com.pr.gameserver.application.websockets.common.msginteraction.generic.MessageHandler;
import com.pr.gameserver.application.websockets.common.msginteraction.message.LoginIndicatorMsg;
import com.pr.gameserver.application.websockets.common.msginteraction.message.LoginMessage;
import com.pr.gameserver.application.websockets.server.ServerController;
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
        if (isAddUser) {
        } else {
            try {
                ServerController.getInstance().send(session, new LoginIndicatorMsg(false));
                session.close();
            } catch (IOException ignored) {
            }
        }
    }
}
