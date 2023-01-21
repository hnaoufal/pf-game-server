package com.pr.gameserver.domain.entities.messages;

public class FinishGame {
    String winnerLogin;
    boolean isGoodGame;

    public FinishGame(boolean isGoodGame, String winnerLogin) {
        this.winnerLogin = winnerLogin;
        this.isGoodGame = isGoodGame;
    }

    public String getWinnerLogin() {
        return winnerLogin;
    }

    public void setWinnerLogin(String winnerLogin) {
        this.winnerLogin = winnerLogin;
    }

    public boolean isGoodGame() {
        return isGoodGame;
    }

    public void setIsGoodGame(boolean isGoodGame) {
        this.isGoodGame = isGoodGame;
    }
}
