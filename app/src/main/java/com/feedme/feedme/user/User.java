package com.feedme.feedme.user;

import io.realm.RealmObject;

/**
 * Created by Athmos on 26/05/2017.
 */

public class User {

    private String userName;
    private String email;

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
