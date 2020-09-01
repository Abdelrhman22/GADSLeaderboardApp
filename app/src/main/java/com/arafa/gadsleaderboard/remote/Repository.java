package com.arafa.gadsleaderboard.remote;

import androidx.lifecycle.MutableLiveData;

import com.arafa.gadsleaderboard.models.LearningLeaders;
import com.arafa.gadsleaderboard.models.SkillLeaders;
import com.arafa.gadsleaderboard.models.SubmissionRequest;
import com.arafa.gadsleaderboard.services.GadsApiService;
import com.arafa.gadsleaderboard.services.GoogleFormApiService;

import java.util.List;

public class Repository {

    private static Repository repository;

    public static Repository getInstance() {
        if (repository == null)
            repository = new Repository();
        return repository;
    }

    public MutableLiveData<List<LearningLeaders>> getLearningLeaders() {
        return GadsApiService.getInstance().getLearningLeaders();
    }

    public MutableLiveData<List<SkillLeaders>> getSkillLeaders() {
        return GadsApiService.getInstance().getSkillLeaders();
    }

    public MutableLiveData<Integer> submitRequest(SubmissionRequest request){
        return GoogleFormApiService.getInstance().submitRequest(request);
    }
}
