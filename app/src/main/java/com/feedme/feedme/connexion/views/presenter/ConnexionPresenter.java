package com.feedme.feedme.connexion.views.presenter;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.AddUser;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by Athmos on 26/05/2017.
 */

public class ConnexionPresenter implements AddUser.AddUserListener {

    private ConnexionPresenter.View mainView;
    private AddUser addUser;

    public ConnexionPresenter(ConnexionPresenter.View mainView, AddUser addUser) {
        this.mainView = mainView;
        this.addUser = addUser;
    }


    public void addUser(User user) {
        addUser.execute(user).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        onAddUser(user);
                    }
                });
        ;
    }

    @Override
    public void onAddUser(User user) {
        mainView.onUserAdded();
    }

    public interface View {

        void onUserAdded();
    }
}
