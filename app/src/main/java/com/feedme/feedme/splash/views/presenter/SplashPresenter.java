package com.feedme.feedme.splash.views.presenter;

import android.content.Context;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.GetUsers;
import com.feedme.feedme.user.usecase.GetUsers.GetUsersListener;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Athmos on 26/05/2017.
 */

public class SplashPresenter implements GetUsersListener {

    private final SplashPresenter.View splashView;

    private final GetUsers getUsers;

    public SplashPresenter(
            SplashPresenter.View mainView, GetUsers getUsers) {
        this.splashView = mainView;
        this.getUsers = getUsers;
    }

    public void init() {
        getUsers();
    }


    public void getUsers() {
        getUsers.execute().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        onGetUsers(users);
                    }
                });
    }

    @Override
    public void onGetUsers(List<User> users) {
        if (!users.isEmpty())
            splashView.navigateToMain();
        splashView.navigateToConnexion();
    }

    public interface View {
        void navigateToConnexion();

        void navigateToMain();
    }
}
