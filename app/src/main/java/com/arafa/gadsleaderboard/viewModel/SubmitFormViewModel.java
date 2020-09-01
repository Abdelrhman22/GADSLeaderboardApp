package com.arafa.gadsleaderboard.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arafa.gadsleaderboard.models.SubmissionRequest;
import com.arafa.gadsleaderboard.remote.Repository;

public class SubmitFormViewModel extends ViewModel {

    public static final int STATUS_NEUTRAL = 0;
    public static final int STATUS_OK = 1;
    public static final int STATUS_ERROR = -1;
    private MutableLiveData<Integer> status = new MutableLiveData<>();

    public MutableLiveData<Integer> submitRequestLiveData(SubmissionRequest request){
        status = Repository.getInstance().submitRequest(request);
        return status;
    }
    public LiveData<Integer> getStatus() {
        return status;
    }
}
