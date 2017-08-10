package com.feedme.feedme.user.injection.modules;

import com.feedme.feedme.common.repository.IdGenerator;
import com.feedme.feedme.user.repository.UserRealmDataSource;
import com.feedme.feedme.user.repository.UserRepository;
import com.feedme.feedme.user.repository.model.UserRealmMapper;
import com.feedme.feedme.user.usecase.AddUser;
import com.feedme.feedme.user.usecase.GetUsers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides @Singleton
    UserRealmMapper providesUserRealmMapper() {
        return new UserRealmMapper();
    }

    @Provides @Singleton
    UserRealmDataSource providesUserRealmDataSource(UserRealmMapper userRealmMapper) {
        return new UserRealmDataSource(userRealmMapper);
    }

    @Provides @Singleton
    UserRepository providesUserRepository(UserRealmDataSource userRealmDataSource, IdGenerator idGenerator) {
        return new UserRepository(userRealmDataSource, idGenerator);
    }

  //  usecases

    @Provides @Singleton
    AddUser providesAddUser(UserRepository userRepository) {
        return new AddUser(userRepository);
    }

    @Provides @Singleton
    GetUsers providesGetUsers(UserRepository userRepository) {
        return new GetUsers(userRepository);
    }

}
