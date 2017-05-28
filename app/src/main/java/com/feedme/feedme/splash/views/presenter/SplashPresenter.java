package com.feedme.feedme.splash.views.presenter;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.GetUsers;
import com.feedme.feedme.user.usecase.GetUsers.GetUsersListener;

import io.reactivex.android.schedulers.AndroidSchedulers;
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

    // public methods

    public void init() {
        getUsers();
    }

    public void getUsers() {
        getUsers.execute().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        onGetUsers(user);
                    }
                });
    }

    // GetUsersListener method

    @Override
    public void onGetUsers(User user) {
        if (!user.getIsConnected())
            splashView.navigateToMain();
        splashView.navigateToConnexion();
    }

    // public interface

    public interface View {
        void navigateToConnexion();

        void navigateToMain();
    }
}
