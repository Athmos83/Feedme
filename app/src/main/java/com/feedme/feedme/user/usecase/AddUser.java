package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.user.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Athmos on 26/05/2017.
 */

public class AddUser {

    private final DataRepository dataRepository;

    public AddUser(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Observable<User> execute(User user) {
        return dataRepository.addUser(user);
    }

    //  TODO implementer dans ConnexionPresenter
    public interface AddUserListener {
        void onAddUser(User user);
    }

}
