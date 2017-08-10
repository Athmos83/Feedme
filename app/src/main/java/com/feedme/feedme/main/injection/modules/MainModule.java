package com.feedme.feedme.main.injection.modules;

import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.feed.domain.usecase.GetFeed;
import com.feedme.feedme.feed.repository.FeedRepository;
import com.feedme.feedme.main.views.activity.MainActivity;
import com.feedme.feedme.main.views.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @PerActivity
    MainPresenter providesMainpresenter(GetFeed getFeed) {
        return new MainPresenter(getFeed);
    }
}