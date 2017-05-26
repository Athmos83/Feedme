package com.feedme.feedme.splash.views.presenter;

import com.feedme.feedme.user.usecase.GetUsers;

/**
 * Created by Athmos on 26/05/2017.
 */

public class SplashPresenter implements GetUsers.GetUsersListener {

    @Override
    public void onGetUsers() {

    }

    public interface View {
        void onLaunchApp();
    }
}
