package com.pr.gameserver.application.websockets.server;

import com.pr.gameserver.application.websockets.common.StaticData;
import com.pr.gameserver.application.websockets.common.UserInfo;
import com.pr.gameserver.application.websockets.common.msginteraction.UserInfoHelper;
import com.pr.gameserver.application.websockets.common.msginteraction.message.ReceiveScore;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class GameInfo {
    private static final int MAX_WAIT = StaticData.MAX_WAIT_SEC;
    private static final int SCORE_FOR_WIN = StaticData.SCORE_FOR_WIN;
    private static GameInfo gameInfo = new GameInfo();
    public static GameInfo getInstance() {
        return gameInfo;
    }
    private GameInfo() {
    }

    boolean isDone;
    boolean gameInProcess = false;

    UserInfo currentUser;

    class CountSkip {
        public final static byte MAX_SKIP = 3;
        public UserInfo userInfo;
        public byte skip = 0;

        public CountSkip(UserInfo userInfo) {
            this.userInfo = userInfo;
        }
    }
    public void startGame() {
        UserInfoHelper.getInstance().getUserInfoList().stream().forEach(userInfo -> userInfo.setScore(0));

        Thread gameTread = new Thread(this::startGameInTread);
        gameTread.start();
    }

    private void startGameInTread() {
        try {
            gameInProcess = true;
            UserInfoHelper.getInstance().getUserInfoList().
                    stream().forEach(userInfo -> userInfo.setIsActive(true));

            final LinkedList<CountSkip> fullListUsers = UserInfoHelper.getInstance().getUserInfoList().
                    stream().map(CountSkip::new).collect(Collectors.toCollection(LinkedList::new));

            boolean finish = false;
            while (!finish) {
                boolean existUser = false;
                for (CountSkip user : fullListUsers) {
                    if (user.userInfo.isActive()&&user.userInfo.isOnline()) {
                        currentUser = user.userInfo;
                        existUser = true;
                        boolean success = waitResponse();

                        if (!success) {
                            skip(user);
                        } else {
                            user.skip = 0;
                            finish = checkFinish(user);
                        }
                        if (finish) {
                            break;
                        }
                    }
                }

                if (!existUser) {
                    stopGame();
                    finish = true;
                }
            }
        } catch (InterruptedException e) {
            stopGame();
        }
    }

    private void stopGame() {
        gameInProcess = false;
    }

    public void setReceived(ReceiveScore score) {
        currentUser.setScore(calculateScore(currentUser.getScore(), score));
        isDone = true;
    }

    private int calculateScore(int score, ReceiveScore receive) {
        switch (receive.getScore()) {
            case 1:
                return 0;
            case 2:
            case 3:
            case 4:
            case 5:
                return score + receive.getScore();
            case 6:
                final int i = score - 3;
                return (score - 3) > 0? i: 0;
            default:
                return score;
        }
    }

    private boolean checkFinish(CountSkip user) {
        if (user.userInfo.getScore()>= SCORE_FOR_WIN) {
            makeWinner(user.userInfo);
            return true;
        }
        return false;
    }

    private void makeWinner(UserInfo userInfo) {
        gameInProcess = false;
    }

    private void skip(CountSkip user) {
        user.skip++;
        if(user.skip==CountSkip.MAX_SKIP) {
            user.userInfo.setIsActive(false);
        }
    }


    private boolean waitResponse() throws InterruptedException {
        boolean success = false;
        Long endTime = System.currentTimeMillis() + MAX_WAIT;
        while (System.currentTimeMillis() < endTime) {

            if(isDone) {
                success = true;
                isDone = false;
                break;
            }
            Thread.sleep(100);
        }

        return success;
    }
}
