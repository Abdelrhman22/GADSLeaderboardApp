package com.arafa.gadsleaderboard.services;

import androidx.lifecycle.MutableLiveData;

import com.arafa.gadsleaderboard.models.SubmissionRequest;
import com.arafa.gadsleaderboard.network.NetworkService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleFormApiService {

    private static GoogleFormApiService instance = null;
    private NetworkService networkService;

    public GoogleFormApiService() {
        networkService = new NetworkService();
    }

    // singleton method
    public static GoogleFormApiService getInstance() {
        if (instance == null)
            instance = new GoogleFormApiService();
        return instance;
    }

    public MutableLiveData<Integer> submitRequest(SubmissionRequest request) {
        final MutableLiveData<Integer> status = new MutableLiveData<>();
        networkService.getGoogleFormApi()
                .sendUserData(request.getFirstName(), request.getLastName(), request.getEmail(), request.getUrl())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful())
                            status.postValue(1);
                        else
                            status.postValue(-1);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        status.postValue(-1);
                    }
                });

        return status;
    }


}
