package com.feedme.feedme.common.injection.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Athmos on 26/05/2017.
 */

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
                .name("Feedme.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

}