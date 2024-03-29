package com.pr.gameserver.domain.gameengine;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UserInfoHelper {
    static UserInfoHelper userInfoHelper = new UserInfoHelper();
    public static UserInfoHelper getInstance() {
        return userInfoHelper;
    }
    private UserInfoHelper() {
    }

    ArrayList<UserInfo> userInfoList = new ArrayList<>();

    public boolean createNewUser(String login) {
        final UserInfo userInfo = getUserInfoByLogin(login);
        if (userInfo != null) {
            if(!userInfo.isOnline()) {
                userInfoHelper.getUserInfoByLogin(login).setIsOnline(true);
                return true;
            }
            return false;
        }
        userInfoList.add(new UserInfo(login));
        return true;
    }

    public void addScore(String login, int scoreDifference) {
        final UserInfo userInfo = getUserInfoByLogin(login);
        userInfo.setScore(userInfo.getScore() + scoreDifference);
    }

    public void addWin(String login) {
        final UserInfo userInfo = getUserInfoByLogin(login);
        userInfo.setWinRate(userInfo.getWinRate() + 1);
    }

    public UserInfo getUserInfoByLogin(String login) {
        if(userInfoList.isEmpty()) {
            return null;
        }
        try {
            return userInfoList.stream().findFirst().filter(userInfo -> userInfo.getLogin().equals(login)).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public ArrayList<UserInfo> getUserInfoList() {
        return userInfoList;
    }

}
