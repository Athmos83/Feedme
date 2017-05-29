package com.feedme.feedme.connexion.injection.modules;

import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.connexion.views.presenter.ConnexionPresenter;
import com.feedme.feedme.user.usecase.AddUser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Athmos on 26/05/2017.
 */

@Module
public class ConnexionModule {
    private ConnexionPresenter.View connexionView;

    public ConnexionModule(ConnexionPresenter.View connexionView) {
        this.connexionView = connexionView;
    }

    @Provides
    @PerActivity
    ConnexionPresenter providesConnexionPresenter(AddUser addUser) {

        return new ConnexionPresenter(connexionView, addUser);
    }
}