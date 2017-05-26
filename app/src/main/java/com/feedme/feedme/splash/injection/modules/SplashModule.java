package com.feedme.feedme.splash.injection.modules;

import com.feedme.feedme.splash.views.presenter.SplashPresenter;

import dagger.Module;

/**
 * Created by Athmos on 26/05/2017.
 */

@Module
public class SplashModule {

    private final SplashPresenter.View splashView;

    public SplashModule(SplashPresenter.View splashView){
        this.splashView = splashView;
    }
}
