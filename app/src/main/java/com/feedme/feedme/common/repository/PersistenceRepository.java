package com.feedme.feedme.common.repository;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.repository.UserPersistence;

import io.reactivex.Observable;

/**
 * Created by Athmos on 27/05/2017.
 */

public class PersistenceRepository {

    private final UserPersistence userPersistance;

    public PersistenceRepository(UserPersistence userPersistance) {
        this.userPersistance = userPersistance;

    }

    public Observable<User> getUser() {
        return userPersistance.getUser();
    }

    public Observable<User> addUser(User user){
        return userPersistance.addUser(user);
    }

}
