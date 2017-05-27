package com.feedme.feedme.user.repository;

import com.feedme.feedme.user.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Athmos on 27/05/2017.
 */

public interface UserPersistenceContract {

    Observable<List<User>> getUsers();

}
