package com.feedme.feedme.main.views.presenter;

import com.feedme.feedme.common.view.BasePresenter;
import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.feed.domain.usecase.GetFeed;

import java.util.List;

public class MainPresenter extends BasePresenter {

    protected GetFeed getFeed;
    private List<Feed> feed;

    public MainPresenter(GetFeed getFeed) {
        this.getFeed = getFeed;
    }


    public void onInit() {
        getFeed.execute(new getFeedListener() {
            @Override
            public void onSuccess(List<Feed> feed) {
                if (getView() != null)
                    ((View) getView()).onGetFeed(feed);
            }

            @Override
            public void onError() {

            }
        });
    }

    // public interfaces

    public interface getFeedListener {

        void onSuccess(List<Feed> feeds);

        void onError();
    }

    public interface View {

        void onGetFeed(List<Feed> feed);

    }

}
