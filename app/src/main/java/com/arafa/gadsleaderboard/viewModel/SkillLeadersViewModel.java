package com.arafa.gadsleaderboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arafa.gadsleaderboard.models.SkillLeaders;
import com.arafa.gadsleaderboard.remote.Repository;

import java.util.List;

public class SkillLeadersViewModel extends ViewModel {

    public MutableLiveData<List<SkillLeaders>> getSkillLeadersLiveData(){
        return Repository.getInstance().getSkillLeaders();
    }
}
