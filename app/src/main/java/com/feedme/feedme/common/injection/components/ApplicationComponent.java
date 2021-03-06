package com.feedme.feedme.common.injection.components;

import com.feedme.feedme.common.injection.modules.AppModule;
import com.feedme.feedme.common.injection.modules.DataModule;
import com.feedme.feedme.connexion.injection.components.ConnexionSubComponent;
import com.feedme.feedme.connexion.injection.modules.ConnexionModule;
import com.feedme.feedme.feed.injection.module.FeedModule;
import com.feedme.feedme.main.injection.components.MainSubComponent;
import com.feedme.feedme.main.injection.modules.MainModule;
import com.feedme.feedme.splash.injection.components.SplashSubComponent;
import com.feedme.feedme.splash.injection.modules.SplashModule;
import com.feedme.feedme.user.injection.modules.UserModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class,
        UserModule.class, FeedModule.class})
public interface ApplicationComponent {

    MainSubComponent getMainComponent(
            MainModule mainModule);

    ConnexionSubComponent getConnexionComponent(
            ConnexionModule connexionModule);

    SplashSubComponent getSplashComponent(
            SplashModule splashModule);


}
