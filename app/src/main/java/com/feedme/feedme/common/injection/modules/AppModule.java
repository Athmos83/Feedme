package com.feedme.feedme.common.injection.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
        initRealm();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    // Private methods

    private void initRealm() {
        Realm.init(application);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("feedme.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

}