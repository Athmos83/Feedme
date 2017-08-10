package com.feedme.feedme.connexion.injection.modules;

import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.connexion.views.presenter.ConnexionPresenter;
import com.feedme.feedme.user.usecase.AddUser;

import dagger.Module;
import dagger.Provides;

@Module
public class ConnexionModule {

    @Provides
    @PerActivity
    ConnexionPresenter providesConnexionPresenter(AddUser addUser) {
        return new ConnexionPresenter(addUser);
    }
}