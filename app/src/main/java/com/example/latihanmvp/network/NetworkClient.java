package com.example.latihanmvp.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    public static final String BASE_URL = "";
    public static final String API_KEY = "";
    private static Retrofit retrofit;


    public static Retrofit getClient() {
        if (retrofit==null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            OkHttpClient okHttpClient = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
