package com.feedme.feedme;

import android.app.Application;

import com.feedme.feedme.common.injection.components.ApplicationComponent;
import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.connexion.injection.components.ConnexionSubComponent;
import com.feedme.feedme.connexion.injection.modules.ConnexionModule;
import com.feedme.feedme.connexion.views.activity.ConnexionActivity;
import com.feedme.feedme.main.MainActivity;
import com.feedme.feedme.main.injection.components.MainSubComponent;
import com.feedme.feedme.main.injection.modules.MainModule;
import com.feedme.feedme.splash.injection.components.SplashSubComponent;
import com.feedme.feedme.splash.injection.modules.SplashModule;
import com.feedme.feedme.splash.views.activity.SplashActivity;

/**
 * Created by Athmos on 26/05/2017.
 */

public class FeedmeBaseApplication extends Application {
    protected ApplicationComponent applicationComponent;

    protected BaseActivityComponent currentActivityComponent;

    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new FeedmeActivityLifecycleCallbacks();
    public static boolean isInForeground;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public ApplicationComponent getAplicationComponent() {
        return applicationComponent;
    }

    public MainSubComponent createMainComponent(MainActivity mainActivity) {
        MainSubComponent mainSubComponent = applicationComponent.getMainComponent(
                new MainModule(mainActivity));
        currentActivityComponent = mainSubComponent;
        return mainSubComponent;
    }

    public ConnexionSubComponent createConnexionComponent(ConnexionActivity connexionActivity) {
        ConnexionSubComponent connexionSubComponent = applicationComponent.getConnexionComponent(
                new ConnexionModule(connexionActivity));
        currentActivityComponent = connexionSubComponent;
        return connexionSubComponent;
    }

    public SplashSubComponent createSplashComponent(SplashActivity splashActivity) {
        SplashSubComponent splashSubComponent = applicationComponent.ge(
                new SplashModule(splashActivity));
        currentActivityComponent = splashSubComponent;
        return splashSubComponent;
    }

}
