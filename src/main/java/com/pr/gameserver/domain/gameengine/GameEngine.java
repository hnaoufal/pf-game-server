package com.pr.gameserver.domain.gameengine;

import com.pr.gameserver.application.config.StaticData;

public class GameEngine {
    private static final int MAX_WAIT = StaticData.MAX_WAIT_SEC;
    private static final GameEngine gameInfo = new GameEngine();
    public static GameEngine getInstance() {
        return gameInfo;
    }
    private GameEngine() {
    }

    boolean isDone;
    boolean gameInProcess = false;

    UserInfo currentUser;

    public void startGame() {
        UserInfoHelper.getInstance().getUserInfoList().forEach(userInfo -> userInfo.setScore(0));

        Thread gameTread = new Thread(this::startGameInTread);
        gameTread.start();
    }

    private void startGameInTread() {
        gameInProcess = true;
        UserInfoHelper.getInstance().getUserInfoList().forEach(userInfo -> userInfo.setIsActive(true));
    }
}
