package com.feedme.feedme.user.repository;

import com.feedme.feedme.common.repository.IdGenerator;
import com.feedme.feedme.user.domain.model.User;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Athmos on 28/06/2017.
 */

public class UserRepository {

    private final UserRealmDataSource userRealmDataSource;
    private final IdGenerator idGenerator;

    public UserRepository(UserRealmDataSource userRealmDataSource, IdGenerator idGenerator) {
        this.userRealmDataSource = userRealmDataSource;
        this.idGenerator = idGenerator;
    }

    public Observable<User> addUser(User user) {
        return userRealmDataSource.addUser(user);
    }

    public Single<User> getUser() {
        return userRealmDataSource.getUser();
    }
}
