package com.mockup.allexamples.RX;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;

import com.mockup.allexamples.Interfaces.MovieAPI;
import com.mockup.allexamples.R;
import com.mockup.allexamples.RX.models.ApiClientRetrofit;
import com.mockup.allexamples.RX.models.Movie;
import com.mockup.allexamples.RX.models.Movies;

import java.util.ArrayList;

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

        recyclerView = findViewById(R.id.recycler);
        mAdapter = new MoviesAdapter(this);
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



        MovieAPI apiService =
                ApiClientRetrofit.getClient().create(MovieAPI.class);

        Call<Movies> call = apiService.getTopRatesMovies(API_KEY);
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                int statusCode = response.code();
                ArrayList<Movie> movies = response.body().getMovies();
                mAdapter.addMovie(movies);

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                // Log error here since request failed

            }
        });


    }


}
