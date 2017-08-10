package com.feedme.feedme.common.repository;

import com.feedme.feedme.feed.domain.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiRepository {

    String BASE_URL_DEV = "https://feedmeonjson.herokuapp.com/api/v1/";

    @Headers({
            "Content-Type: application/json",
            "Authorization: token 58997fb22c9b19ada5b9b76d1d1af0cde7f1ecc2a86e2a699b3593749ba8fe98283a2fefacf2bb8fe185dae5a08f6e2094e02aa72c333d6c3f85d290d8ec6cc3"
    })
    @GET("feed")
    Call<List<Feed>> getBaseFeeds();

//    @Headers({
//            "Content-Type: application/json"
//    })
//    @POST("v1/{country}/app/status")
//    Call<AppStatus> getAppStatus(@Path("country") String country, @Body Status status);
}
