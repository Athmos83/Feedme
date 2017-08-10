package com.feedme.feedme.connexion.views.presenter;

import com.feedme.feedme.common.view.BasePresenter;
import com.feedme.feedme.user.domain.model.User;
import com.feedme.feedme.user.usecase.AddUser;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class ConnexionPresenter extends BasePresenter {

    private AddUser addUser;

    public ConnexionPresenter(AddUser addUser) {
        this.addUser = addUser;
    }

    public void addUser(User user) {
        addUser.setUser(user);
        addUser.execute().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        ((View) getView()).onUserAdded();
                    }
                });
    }

    // public interfaces

    public interface View {

        void onUserAdded();
    }
}
