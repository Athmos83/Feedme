package com.feedme.feedme.user.repository;

import android.content.Context;

import com.feedme.feedme.user.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Athmos on 27/05/2017.
 */

public class UserPersistence implements UserPersistenceContract {

    private List<User> users = new ArrayList<>();

    @Override
    public Observable<List<User>> getUsers() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                users = getAllUsers(realm);
            }
        });
        return Observable.just(users);
    }

    private List<User> getAllUsers(Realm realm) {
        RealmResults<User> result = realm.where(User.class).findAll();
        return realm.copyFromRealm(result);
    }


}
