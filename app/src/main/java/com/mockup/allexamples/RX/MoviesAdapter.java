package com.mockup.allexamples.RX;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mockup.allexamples.R;
import com.mockup.allexamples.RX.models.Movie;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private ArrayList<Movie> movies;
    private int rowLayout;
    private Context context;
    @NonNull
    @Override
    public MoviesAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup, false);
        return new MovieHolder(view);
    }

    public MoviesAdapter(ArrayList<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }



    public MoviesAdapter(Context context) {

        this.context = context;
        this.movies = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        movieHolder.movieTitle.setText(movies.get(i).getTitle());
        movieHolder.movieDescription.setText(movies.get(i).getOverview());
        movieHolder.data.setText(movies.get(i).getReleaseDate());
        movieHolder.rating.setText(movies.get(i).getVoteCount());

    }

    @Override
    public int getItemCount() {

        return movies.size();
    }
    public void addMovie(ArrayList<Movie> movieslist) {
        movies.addAll(movieslist);
        notifyDataSetChanged();
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
