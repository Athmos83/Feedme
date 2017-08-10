package com.feedme.feedme.feed.domain.usecase;

import com.feedme.feedme.common.domain.usecase.ObservableFromConsumerUseCase;
import com.feedme.feedme.common.domain.usecase.SingleUseCase;
import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.feed.repository.FeedRepository;
import com.feedme.feedme.main.views.presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Single;

public class GetFeed {

    protected FeedRepository feedRepository;

    public GetFeed(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public void execute(MainPresenter.getFeedListener getFeedListener) {
        feedRepository.getFeedFromApi(getFeedListener);
    }

}
