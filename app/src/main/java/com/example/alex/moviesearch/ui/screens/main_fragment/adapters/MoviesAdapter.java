package com.example.alex.moviesearch.ui.screens.main_fragment.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alex.moviesearch.Constants;
import com.example.alex.moviesearch.R;
import com.bumptech.glide.Glide;
import com.example.alex.moviesearch.model.movie.Movie;
import com.example.alex.moviesearch.ui.screens.main_fragment.IMovieInfo;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context mContext;
    private IMovieInfo mMovieInfo;
    private List<Movie> mMovies = new ArrayList<>();

    public MoviesAdapter(Context context, IMovieInfo movieInfo, List<Movie> movies) {
        mContext = context;
        mMovieInfo = movieInfo;
        mMovies = movies;
    }

    public MoviesAdapter(Context context, IMovieInfo movieInfo) {
        mContext = context;
        mMovieInfo = movieInfo;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView posterImageView;


        ViewHolder(View itemView) {
            super(itemView);
            posterImageView = (ImageView) itemView.findViewById(R.id.poster_imv);
        }
    }

    public void addMovies(ArrayList<Movie> upcomingMoviesList){
        mMovies = upcomingMoviesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(Constants.IMAGE_BASE_PATH + mMovies.get(position).getPosterPath())
                .into(holder.posterImageView);

        holder.posterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMovieInfo.sendRequestForGettingMovieInfo(mMovies.get(holder.getAdapterPosition()).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
