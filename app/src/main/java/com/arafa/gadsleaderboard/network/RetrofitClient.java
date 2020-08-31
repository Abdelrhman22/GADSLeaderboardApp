package com.arafa.gadsleaderboard.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    public static final String GADS_BASE_URL = "https://gadsapi.herokuapp.com";

    private static Retrofit getInstance(String BASE_URL) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    // Generic createService
    public static <S> S createService(Class<S> serviceClass, String BASE_URL) {
        return getInstance(BASE_URL).create(serviceClass);
    }
}
