package com.feedme.feedme.common.repository;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.repository.UserPersistence;
import com.feedme.feedme.user.usecase.GetUsers;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Athmos on 27/05/2017.
 */

public class PersistenceRepository {

    private final UserPersistence userPersistance;

    public PersistenceRepository(UserPersistence userPersistance) {
        this.userPersistance = userPersistance;

    }

    public void getUser(final GetUsers.GetUsersListener listener) {
        userPersistance.getUsers().subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<List<User>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<User> users) {
                listener.onGetUsers(users);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
