package com.feedme.feedme.splash.injection.components;

import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.splash.injection.modules.SplashModule;
import com.feedme.feedme.splash.views.activity.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by Athmos on 26/05/2017.
 */

@PerActivity
@Subcomponent(modules = {SplashModule.class})
public interface SplashSubComponent extends BaseActivityComponent {
    void inject(SplashActivity splashActivity);

}
