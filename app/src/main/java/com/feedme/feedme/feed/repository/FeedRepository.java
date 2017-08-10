package com.feedme.feedme.feed.repository;

import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.main.views.presenter.MainPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class FeedRepository {

    protected FeedApiDataSource feedApiDataSource;

    public FeedRepository(FeedApiDataSource feedApiDataSource) {
        this.feedApiDataSource = feedApiDataSource;
    }

    public void getFeedFromApi(MainPresenter.getFeedListener getFeedListener) {
        feedApiDataSource.getFeed(getFeedListener);
    }
}
