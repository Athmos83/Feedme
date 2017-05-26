package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.user.User;

import java.util.List;

/**
 * Created by Athmos on 26/05/2017.
 */

public class AddUser {

    private final DataRepository dataRepository;

    public AddUser(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    //  TODO implementer dans ConnexionPresenter
    public interface AddUserListener {
        void onAddUser(List<User> user);
    }

}
