package com.feedme.feedme.common.repository;

import com.feedme.feedme.user.usecase.GetUsers;

/**
 * Created by Athmos on 26/05/2017.
 */

public class DataRepository {

    private final PersistenceRepository persistenceRepository;

    public DataRepository(PersistenceRepository persistenceRepository) {
        this.persistenceRepository = persistenceRepository;

    }

    public void getUser(GetUsers.GetUsersListener listener) {
        this.persistenceRepository.getUser(listener);
    }


}
