package com.mockup.allexamples.Interfaces;



import com.mockup.allexamples.models.pokemonAPIModel.PokemonApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitPokemonApi {

    @GET("pokemon")
    Call<PokemonApi> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);


}
