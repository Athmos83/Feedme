package com.feedme.feedme.splash.injection.modules;

import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;
import com.feedme.feedme.user.usecase.GetUsers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Athmos on 26/05/2017.
 */

@Module
public class SplashModule {

    private final SplashPresenter.View splashView;

    public SplashModule(SplashPresenter.View splashView){
        this.splashView = splashView;
    }

    @Provides
    @PerActivity
    SplashPresenter providesSplashPresenter(GetUsers getUsers) {

        return new SplashPresenter(splashView, getUsers);
    }

}
