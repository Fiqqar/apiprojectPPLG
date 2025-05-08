package com.example.api_projectpplg;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class laliga extends AppCompatActivity {

    RecyclerView recyclerviewLaliga;
    ProgressBar pbLoadingLaliga;
    TimAdapter adptr;
    LinearLayoutManager managerLayout;
    List<Tim> listTim = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_laliga);

        recyclerviewLaliga = findViewById(R.id.recyclerviewLaliga);
        recyclerviewLaliga.setLayoutManager(new LinearLayoutManager(this));
        pbLoadingLaliga = findViewById(R.id.pbLoadingLaliga);
        adptr = new TimAdapter(listTim);
        recyclerviewLaliga.setAdapter(adptr);
        managerLayout = new LinearLayoutManager(this);

        fetch();
    }

    private void fetch() {
        RetrofitClient.getRetrofitClient().getLaliga().enqueue(new Callback<TimResponse>() {
            @Override
            public void onResponse(Call<TimResponse> call, Response<TimResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Tim> teams = response.body().getTeams();
                    if (teams != null) {
                        listTim.addAll(teams);
                        adptr.notifyDataSetChanged();
                        recyclerviewLaliga.setVisibility(View.VISIBLE);
                    }
                    pbLoadingLaliga.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<TimResponse> call, Throwable throwable) {
                pbLoadingLaliga.setVisibility(View.GONE);
                Toast.makeText(laliga.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API_ERROR", "Error while fetching data: " + throwable.getMessage());
            }
        });
    }
}