package com.feedme.feedme.user.repository.model;

import com.feedme.feedme.common.repository.Mapper;
import com.feedme.feedme.user.domain.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Athmos on 27/07/2017.
 */

public class UserRealmMapper implements Mapper<UserRealm, User> {

    @Override
    public UserRealm serialize(User user) {
        UserRealm userRealm = new UserRealm();
        if (user == null) {
            return userRealm;
        }
        userRealm.setUserName(user.getUserName());
        userRealm.setEmail(user.getEmail());
        userRealm.setIsConnected(user.getIsConnected());
        userRealm.setUserId(user.getUserId());
        userRealm.setTmpUser(user.isTmpUser());
        return userRealm;
    }

    @Override
    public List<UserRealm> serialize(List<User> users) {
        List<UserRealm> userRealms = new ArrayList<>();
        if (users == null){
            return userRealms;
        }
        for (User user : users) {
            userRealms.add(serialize(user));
        }
        return userRealms;
    }

    @Override
    public User deserialize(UserRealm userRealm) {
        User user = new User();
        if (userRealm == null) {
            return user;
        }
        user.setUserName(userRealm.getUserName());
        user.setEmail(userRealm.getEmail());
        user.setIsConnected(userRealm.getIsConnected());
        user.setUserId(userRealm.getUserId());
        user.setTmpUser(userRealm.isTmpUser());
        return null;
    }

    @Override
    public List<User> deserialize(List<UserRealm> userRealms) {
        List<User> users = new ArrayList<>();
        if (userRealms == null){
            return users;
        }
        for (UserRealm userRealm : userRealms) {
            users.add(deserialize(userRealm));
        }
        return users;
    }
}
