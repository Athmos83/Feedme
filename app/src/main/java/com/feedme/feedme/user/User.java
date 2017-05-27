package com.feedme.feedme.user;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Athmos on 26/05/2017.
 */

public class User extends RealmObject {

    @PrimaryKey
    private String userId;

    private String userName;
    private String email;

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
