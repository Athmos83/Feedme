package com.feedme.feedme.splash.injection.modules;

import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;
import com.feedme.feedme.user.usecase.GetUsers;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    @PerActivity
    SplashPresenter providesSplashPresenter(GetUsers getUsers) {
        return new SplashPresenter(getUsers);
    }

}
