package com.feedme.feedme.splash.views.presenter;

import android.content.Context;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.GetUsers;
import com.feedme.feedme.user.usecase.GetUsers.GetUsersListener;

import java.util.List;

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

    @Override
    public void onGetUsers(List<User> users) {

    }

    public interface View {
        void onLaunchApp();
    }
}
