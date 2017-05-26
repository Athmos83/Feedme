package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.repository.DataRepository;

/**
 * Created by Athmos on 26/05/2017.
 */

public class GetUsers {

    private final DataRepository dataRepository;

    public GetUsers(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    //  TODO implementer dans ConnexionPresenter
    public interface GetUsersListener {
        void onGetUsers();
    }

}
