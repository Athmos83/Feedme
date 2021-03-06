package com.feedme.feedme.user.repository.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Athmos on 17/07/2017.
 */

public class UserRealm extends RealmObject {

    @PrimaryKey
    private String userId;

    private String userName;
    private String email;

    private boolean tmpUser;
    private boolean isConnected;

    public boolean isTmpUser() {
        return tmpUser;
    }

    public void setTmpUser(boolean tmpUser) {
        this.tmpUser = tmpUser;
    }

    public boolean getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
