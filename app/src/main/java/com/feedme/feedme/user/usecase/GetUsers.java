package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.user.User;
import com.feedme.feedme.user.repository.UserPersistence;

import java.util.List;

/**
 * Created by Athmos on 26/05/2017.
 */

public class GetUsers {

    private final DataRepository dataRepository;

    public GetUsers(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void execute(final List<User> users, final GetUsersListener listener) {
        dataRepository.getUser(listener);
    }

    //  TODO implementer dans ConnexionPresenter
    public interface GetUsersListener {
        void onGetUsers(List<User> users);
    }

}
