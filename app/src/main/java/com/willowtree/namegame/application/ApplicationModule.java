package com.willowtree.namegame.application;

import com.google.gson.GsonBuilder;
import com.willowtree.namegame.BuildConfig;
import com.willowtree.namegame.api.WillowtreeApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    WillowtreeApiService provideWillowtreeApiService(Retrofit retrofit){
        return retrofit.create(WillowtreeApiService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(
                new GsonBuilder()
                        .create());
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.WILLOWTREE_API_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
            Timber.d(message);
        });
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

}