package com.feedme.feedme.user.repository;

import com.feedme.feedme.user.domain.model.User;
import com.feedme.feedme.user.repository.model.UserRealm;
import com.feedme.feedme.user.repository.model.UserRealmMapper;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmResults;

public class UserRealmDataSource {

    private User user = new User();
    private UserRealmMapper userRealmMapper;

    public UserRealmDataSource(UserRealmMapper userRealmMapper) {
        this.userRealmMapper = userRealmMapper;
    }

    public Single<User> getUser() {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<UserRealm> result = realm.where(UserRealm.class).findAll();
                    UserRealm tmpUsers = realm.copyFromRealm(result).get(0);
                    user = userRealmMapper.deserialize(realm.copyFromRealm(result).get(0));
                }
            });
            if (user != null)
                return Single.just(user);
        User noUser = new User();
        return Single.just(noUser);
    }

    public Observable<User> addUser(final User user) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealm(userRealmMapper.serialize(user));
                }
            });

        } finally {
            return Observable.just(user);
        }
    }
}
