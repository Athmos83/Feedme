package com.feedme.feedme.connexion.views.presenter;

import android.content.Context;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.GetUsers;

import java.util.List;

/**
 * Created by Athmos on 26/05/2017.
 */

public class ConnexionPresenter implements GetUsers.GetUsersListener {

    public ConnexionPresenter() {

    }

    @Override
    public void onGetUsers(List<User> users) {

    }

    public interface View {

        Context getContext();

        void onUserFound();

        void onUserNotFound();
    }
}
