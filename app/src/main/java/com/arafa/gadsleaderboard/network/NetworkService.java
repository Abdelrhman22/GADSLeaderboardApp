package com.arafa.gadsleaderboard.network;

import com.arafa.gadsleaderboard.api.GadsApi;

public class NetworkService {

    public GadsApi getGadsApi(){
        return RetrofitClient.createService(GadsApi.class,RetrofitClient.GADS_BASE_URL);
    }
}
