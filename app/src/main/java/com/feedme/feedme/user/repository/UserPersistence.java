package com.feedme.feedme.user.repository;

import com.feedme.feedme.user.User;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Athmos on 27/05/2017.
 */

public class UserPersistence implements UserPersistenceContract {

    private User user = new User();

    private User existingUser = new User();

    @Override
    public Observable<User> getUser() {

        try {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<User> result = realm.where(User.class).findAll();
                    user = realm.copyFromRealm(result).get(0);
                }
            });
        } finally {
            if (user != null)
                return Observable.just(user);
        }
        return null;
    }

    @Override
    public Observable<User> addUser(final User user) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealm(user);
                }
            });

        } finally {
            return Observable.just(user);
        }
    }
}
