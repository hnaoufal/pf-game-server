package com.pr.gameserver.application.websockets.common.msginteraction.message;

public class LoginIndicatorMsg {
    boolean isLogin;

    public LoginIndicatorMsg(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
}
