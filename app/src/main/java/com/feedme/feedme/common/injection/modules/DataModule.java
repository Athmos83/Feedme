package com.feedme.feedme.common.injection.modules;

import com.feedme.feedme.common.repository.DataRepository;
import com.feedme.feedme.common.repository.PersistenceRepository;
import com.feedme.feedme.user.repository.UserPersistence;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Athmos on 27/05/2017.
 */

@Module
public class DataModule {
    // Data repository provider

    @Provides @Singleton
    PersistenceRepository providesPersistenceRepository(UserPersistence userPersistance) {

        return new PersistenceRepository(userPersistance);
    }

    @Provides
    @Singleton
    UserPersistence providesUserPersistence() {
        return new UserPersistence();
    }
    // Data repository provider

    @Provides @Singleton
    DataRepository providesDataRepository(
            PersistenceRepository persistenceRepository) {
        return new DataRepository(persistenceRepository);
    }
}
