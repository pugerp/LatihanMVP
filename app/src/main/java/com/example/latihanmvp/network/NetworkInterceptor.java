package com.example.latihanmvp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder().method(original.method(), original.body());
        requestBuilder = requestBuilder
                .header("/HEADER/", "/TOKEN/");
        return chain.proceed(requestBuilder.build());
    }
}
