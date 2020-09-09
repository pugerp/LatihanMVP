package com.example.latihanmvp.di.modules;

import androidx.transition.Visibility;

import com.example.latihanmvp.BuildConfig;
import com.example.latihanmvp.network.NetworkInterceptor;
import com.example.latihanmvp.network.NetworkInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    NetworkInterceptor provideNetworkInterceptor() {
        return new NetworkInterceptor();
    }

    @Provides
    @Singleton
    NetworkInterface provideNetworkInterface(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(NetworkInterface.class);
    }

    @Provides
    @Singleton
    OkHttpClient getOkHttpClient(NetworkInterceptor networkInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .addInterceptor(networkInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            if (!builder.interceptors().contains(httpLoggingInterceptor))
                builder.addInterceptor(httpLoggingInterceptor);
        }

        return builder.build();
    }

    Gson getGson() {
        return new GsonBuilder().setLenient().create();
    }
}
