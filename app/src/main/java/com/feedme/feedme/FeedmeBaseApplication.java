package com.feedme.feedme;

import android.app.Application;
import android.content.Context;

import com.feedme.feedme.common.injection.components.ApplicationComponent;
import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.connexion.injection.components.ConnexionSubComponent;
import com.feedme.feedme.connexion.injection.modules.ConnexionModule;
import com.feedme.feedme.connexion.views.activity.ConnexionActivity;
import com.feedme.feedme.main.views.activity.MainActivity;
import com.feedme.feedme.main.injection.components.MainSubComponent;
import com.feedme.feedme.main.injection.modules.MainModule;
import com.feedme.feedme.splash.injection.components.SplashSubComponent;
import com.feedme.feedme.splash.injection.modules.SplashModule;
import com.feedme.feedme.splash.views.activity.SplashActivity;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;
import com.feedme.feedme.user.injection.modules.UserModule;

public abstract class FeedmeBaseApplication extends Application {

    protected ApplicationComponent applicationComponent;

    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new FeedmeActivityLifecycleCallbacks();
    public static boolean isInForeground;

    public static FeedmeBaseApplication get(Application application) {
        return ((FeedmeBaseApplication) application);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
