package com.gaoxh.videoapk.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private Retrofit retrofit;
    public Api api;
    private HttpUtils() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS);
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.BASE_URL);
        retrofit = builder.build();
        api = retrofit.create(Api.class);
    }

    public static HttpUtils get() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static HttpUtils sInstance = new HttpUtils();
    }
}
