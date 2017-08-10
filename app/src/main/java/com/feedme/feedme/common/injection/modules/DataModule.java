package com.feedme.feedme.common.injection.modules;

import com.feedme.feedme.common.repository.ApiRepository;
import com.feedme.feedme.common.repository.IdGenerator;
import com.feedme.feedme.user.repository.UserRealmDataSource;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides @Singleton
    IdGenerator providesPersistenceIdGenerator() {
        return new IdGenerator();
    }

    @Provides @Singleton
    Gson providesGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides @Singleton
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides @Singleton
    Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ApiRepository.BASE_URL_DEV).client(okHttpClient).build();
        return retrofit;
    }

    @Provides @Singleton
    ApiRepository providesApiRepository(Retrofit retrofit) {
        return retrofit.create(ApiRepository.class);
    }
}
