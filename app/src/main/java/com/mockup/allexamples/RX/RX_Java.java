package com.mockup.allexamples.RX;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mockup.allexamples.Interfaces.MovieAPI;
import com.mockup.allexamples.R;
import com.mockup.allexamples.RX.models.ApiClientRetrofit;
import com.mockup.allexamples.RX.models.Movie;
import com.mockup.allexamples.RX.models.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RX_Java extends AppCompatActivity {
    private final static String API_KEY = "466271beadeaccbda07a5a2249924095";
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx__java);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        recyclerView = findViewById(R.id.recyclerViewJavaRx);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        MovieAPI apiService =
                ApiClientRetrofit.getClient().create(MovieAPI.class);

        Call<Movies> call = apiService.getTopRatesMovies(API_KEY);
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getMovies();
                mAdapter = new MoviesAdapter(movies);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                // Log error here since request failed

            }
        });
    }
}
