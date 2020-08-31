package com.arafa.gadsleaderboard.api;

import com.arafa.gadsleaderboard.models.LearningLeaders;
import com.arafa.gadsleaderboard.models.SkillLeaders;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {

    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillLeaders>> getSkillLeaders();
}
