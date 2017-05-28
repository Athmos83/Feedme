package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.user.User;
import com.feedme.feedme.user.repository.UserPersistence;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Athmos on 26/05/2017.
 */

public class GetUsers {

    private final DataRepository dataRepository;

    public GetUsers(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Observable<User> execute() {
        return dataRepository.getUser();
    }

    //  TODO implementer dans ConnexionPresenter
    public interface GetUsersListener {
        void onGetUsers(User users);
    }

}
