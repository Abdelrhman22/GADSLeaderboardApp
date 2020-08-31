package com.arafa.gadsleaderboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.arafa.gadsleaderboard.models.LearningLeaders;
import com.arafa.gadsleaderboard.remote.Repository;

import java.util.List;

public class LearningLeadersViewModel extends ViewModel {

    public MutableLiveData<List<LearningLeaders>> getLearningLeadersLiveData() {
        return Repository.getInstance().getLearningLeaders();
    }

}
