package com.mockup.allexamples.RX;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mockup.allexamples.R;
import com.mockup.allexamples.RX.models.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup, false);
        return new MovieHolder(view);
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        movieHolder.movieTitle.setText(movies.get(i).getTitle());
        movieHolder.movieDescription.setText(movies.get(i).getOverview());

    }

    @Override
    public int getItemCount() {
        return 0;
    }




    public static class MovieHolder extends RecyclerView.ViewHolder{
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            moviesLayout = itemView.findViewById(R.id.movies_layout);
            movieTitle =  itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.subtitle);
            movieDescription = itemView.findViewById(R.id.description);
            rating =  itemView.findViewById(R.id.rating);
        }
    }
}
