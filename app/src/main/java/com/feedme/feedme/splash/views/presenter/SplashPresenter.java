package com.feedme.feedme.splash.views.presenter;

import com.feedme.feedme.common.view.BasePresenter;
import com.feedme.feedme.user.domain.model.User;
import com.feedme.feedme.user.usecase.GetUsers;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class SplashPresenter extends BasePresenter {

    private final GetUsers getUsers;

    public SplashPresenter(GetUsers getUsers) {
        this.getUsers = getUsers;
    }

    // public methods

    public void init() {
        getUsers();
    }

    public void getUsers() {
        addSubscription(getUsers.subscribe(new Consumer<User>() {
            @Override
            public void accept(@NonNull User user) throws Exception {
                onGetUsers(user);
            }
        }));
    }

    public void addUser(User user) {
    }

    // GetUsersListener method

    public void onGetUsers(User user) {
        if (user.getUserId() != null)
            ((View) getView()).navigateToMain();
        else
            ((View) getView()).navigateToConnexion();
    }

    // public interface

    public interface View {
        void navigateToConnexion();

        void navigateToMain();
    }
}
