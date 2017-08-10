package com.feedme.feedme.feed.injection.module;

import com.feedme.feedme.common.repository.ApiRepository;
import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.feed.domain.usecase.GetFeed;
import com.feedme.feedme.feed.repository.FeedApiDataSource;
import com.feedme.feedme.feed.repository.FeedRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Athmos on 07/08/2017.
 */

@Module
public class FeedModule {

    @Provides @Singleton
    FeedRepository providesFeedRepository(FeedApiDataSource feedApiDataSource) {
        return new FeedRepository(feedApiDataSource);
    }

    @Provides @Singleton
    FeedApiDataSource providesFeedApiDataSource(ApiRepository apiRepository) {
        return new FeedApiDataSource(apiRepository);
    }

    // usecases

    @Provides @Singleton
    GetFeed providesGetFeed(FeedRepository feedRepository) {
        return new GetFeed(feedRepository);
    }

}
