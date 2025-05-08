package com.example.api_projectpplg;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TimResponse> getTim();

    @GET("/api/v1/json/3/search_all_teams.php?l=Spanish%20La%20Liga")
    Call<TimResponse> getLaliga();
}
