package com.feedme.feedme.splash.views.presenter;

import android.content.Context;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.AddUser;
import com.feedme.feedme.user.usecase.AddUser.AddUserListener;
import com.feedme.feedme.user.usecase.GetUsers;
import com.feedme.feedme.user.usecase.GetUsers.GetUsersListener;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Athmos on 26/05/2017.
 */

public class SplashPresenter implements GetUsersListener, AddUserListener {

    private final SplashPresenter.View splashView;

    private final GetUsers getUsers;
    private final AddUser addUser;

    public SplashPresenter(
            SplashPresenter.View mainView, GetUsers getUsers, AddUser addUser) {
        this.splashView = mainView;
        this.addUser = addUser;
        this.getUsers = getUsers;
    }

    public void init() {
        User user = new User();
        user.setEmail("thomas");
        user.setUserId("1");
        //addUser(user);
        getUsers();
    }

    public void addUser(User user) {
        addUser.execute(user).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        onAddUser(user);
                    }
                });
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

    @Override
    public void onGetUsers(User user) {
        if (!user.getIsConnected())
            splashView.navigateToMain();
        splashView.navigateToConnexion();
    }

    @Override
    public void onAddUser(User user) {

    }

    public interface View {
        void navigateToConnexion();

        void navigateToMain();
    }
}
