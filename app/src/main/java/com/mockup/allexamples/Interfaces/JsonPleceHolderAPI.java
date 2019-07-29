package com.mockup.allexamples.Interfaces;

import com.mockup.allexamples.models.retrofitR.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPleceHolderAPI {

    @GET("posts")
    Call<List<Posts>> getPosts();
}
