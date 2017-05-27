package com.feedme.feedme.common.repository;

import com.feedme.feedme.user.User;
import com.feedme.feedme.user.usecase.GetUsers;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Athmos on 26/05/2017.
 */

public class DataRepository {

    private final PersistenceRepository persistenceRepository;

    public DataRepository(PersistenceRepository persistenceRepository) {
        this.persistenceRepository = persistenceRepository;

    }

    public Observable<List<User>> getUser() {
        return this.persistenceRepository.getUser();
    }


}
