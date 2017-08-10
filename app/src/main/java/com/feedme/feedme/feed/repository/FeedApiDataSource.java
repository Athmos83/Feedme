package com.feedme.feedme.feed.repository;

import com.feedme.feedme.common.repository.ApiRepository;
import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.main.views.presenter.MainPresenter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Athmos on 07/08/2017.
 */

public class FeedApiDataSource {

    protected ApiRepository apiRepository;

    public Feed feeds;

    public FeedApiDataSource(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public void getFeed(final MainPresenter.getFeedListener getFeedListener) {
        Call<List<Feed>> call = apiRepository.getBaseFeeds();
        call.enqueue(new Callback<List<Feed>>() {
            @Override
            public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
                if (response != null && response.body() != null)
                    getFeedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Feed>> call, Throwable t) {
                getFeedListener.onError();

            }
        });
    }
}
