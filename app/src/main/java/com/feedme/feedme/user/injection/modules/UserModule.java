package com.feedme.feedme.user.injection.modules;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.user.usecase.AddUser;
import com.feedme.feedme.user.usecase.GetUsers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Athmos on 27/05/2017.
 */

@Module
public class UserModule {

    @Provides
    @Singleton
    AddUser providesAddUser(DataRepository dataRepository) {
        return new AddUser(dataRepository);
    }

    @Provides
    @Singleton
    GetUsers providesGetUser(DataRepository dataRepository) {
        return new GetUsers(dataRepository);
    }
}
