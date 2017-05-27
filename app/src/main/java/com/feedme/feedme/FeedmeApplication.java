package com.feedme.feedme;

import com.feedme.feedme.common.injection.components.DaggerApplicationComponent;
import com.feedme.feedme.common.injection.modules.AppModule;

/**
 * Created by Athmos on 26/05/2017.
 */

public class FeedmeApplication extends FeedmeBaseApplication {

    @Override
    public void onCreate() {

        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this)).build();
    }

}
