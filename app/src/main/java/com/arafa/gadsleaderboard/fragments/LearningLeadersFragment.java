package com.arafa.gadsleaderboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arafa.gadsleaderboard.R;
import com.arafa.gadsleaderboard.adapters.LearningLeadersAdapter;
import com.arafa.gadsleaderboard.models.LearningLeaders;
import com.arafa.gadsleaderboard.viewModel.LearningLeadersViewModel;

import java.util.List;

public class LearningLeadersFragment extends Fragment {

    private View view, emptyView;
    private RecyclerView learningLeadersRecyclerView;
    private LearningLeadersViewModel learningLeadersViewModel;
    private LearningLeadersAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        learningLeadersViewModel = ViewModelProviders.of(this).get(LearningLeadersViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        emptyView = view.findViewById(R.id.emptyView);

        adapter = new LearningLeadersAdapter(getContext());
        learningLeadersRecyclerView = view.findViewById(R.id.learning_leaders_recyclerView);
        learningLeadersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        learningLeadersRecyclerView.setAdapter(adapter);

        learningLeadersViewModel.getLearningLeadersLiveData().observe(this, new Observer<List<LearningLeaders>>() {
            @Override
            public void onChanged(List<LearningLeaders> learningLeaders) {
                if (learningLeaders != null && learningLeaders.size() > 0) {
                    adapter.setItems(learningLeaders);
                    emptyView.setVisibility(View.GONE);
                } else {
                    learningLeadersRecyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }
}
