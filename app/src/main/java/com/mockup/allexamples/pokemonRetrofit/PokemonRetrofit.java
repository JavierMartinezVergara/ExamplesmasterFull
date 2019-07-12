package com.mockup.allexamples.pokemonRetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mockup.allexamples.Interfaces.RetrofitPokemonApi;
import com.mockup.allexamples.R;
import com.mockup.allexamples.models.pokemonAPIModel.Pokemon;
import com.mockup.allexamples.models.pokemonAPIModel.PokemonApi;
import com.mockup.allexamples.pokemonRetrofit.adaptores.ListaAdapterPokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonRetrofit extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaAdapterPokemon listaAdapterPokemon;

    private int offset;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonretrofit_activity);

        recyclerView= findViewById(R.id.pokemonlistarecycvlerV);
        listaAdapterPokemon= new ListaAdapterPokemon(this);
        recyclerView.setAdapter(listaAdapterPokemon);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = gridLayoutManager.getChildCount();
                    int totalItemCount = gridLayoutManager.getItemCount();
                    int pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                           // Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerData(offset);
                        }
                    }
                }
            }
        });





        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        offset = 0;

        obtenerData(offset);
    }

    private void obtenerData(int offset) {

        RetrofitPokemonApi serviceRetrofit = retrofit.create(RetrofitPokemonApi.class);
        Call<PokemonApi> respuestaPokemon= serviceRetrofit.obtenerListaPokemon(20,offset );

        respuestaPokemon.enqueue(new Callback<PokemonApi>() {
            @Override
            public void onResponse(Call<PokemonApi> call, Response<PokemonApi> response) {
                aptoParaCargar= true;
                if(response.isSuccessful()){

                    PokemonApi pokemonApirespuesta = response.body();
                    ArrayList<Pokemon> listapokemon = pokemonApirespuesta.getResults();
                    listaAdapterPokemon.adicionarListaPokemon(listapokemon);

                    Log.i("POKEMON","POKEMON " +listapokemon);






                    }

                }

            @Override
            public void onFailure(Call<PokemonApi> call, Throwable t) {

            }

        });
    }
}
