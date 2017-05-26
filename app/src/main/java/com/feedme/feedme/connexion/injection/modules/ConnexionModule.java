package com.feedme.feedme.connexion.injection.modules;

import com.feedme.feedme.connexion.views.activity.ConnexionActivity;

import dagger.Module;

/**
 * Created by Athmos on 26/05/2017.
 */

@Module
public class ConnexionModule {
    private ConnexionActivity connexionActivity;

    public ConnexionModule(ConnexionActivity connexionActivity) {
        this.connexionActivity = connexionActivity;
    }
}
