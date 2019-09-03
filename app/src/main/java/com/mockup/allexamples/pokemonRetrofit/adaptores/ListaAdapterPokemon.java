package com.mockup.allexamples.pokemonRetrofit.adaptores;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mockup.allexamples.R;
import com.mockup.allexamples.models.pokemonAPIModel.Pokemon;

import java.util.ArrayList;

public class ListaAdapterPokemon extends RecyclerView.Adapter<ListaAdapterPokemon.ViewHolder> {

    private ArrayList<Pokemon> dataset;

    private Context context;

    public ListaAdapterPokemon(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pokemon, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Pokemon p = dataset.get(i);
        viewHolder.nompokemon.setText(p.getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()

                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.imagepokemon);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokempn) {
        dataset.addAll(listaPokempn);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagepokemon;
        private TextView nompokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagepokemon = itemView.findViewById(R.id.imagePokemon);
            nompokemon = itemView.findViewById(R.id.nompokemon);
        }
    }
}