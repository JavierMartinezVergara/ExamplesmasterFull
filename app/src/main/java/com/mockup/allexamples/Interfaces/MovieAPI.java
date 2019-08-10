package com.mockup.allexamples.Interfaces;

import com.mockup.allexamples.RX.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPI {

    @GET("movie/top_rated")
    Call<Movies> getTopRatesMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<Movies> getMovie(@Path("id") int id, @Query("api_key") String apiKey );

}
