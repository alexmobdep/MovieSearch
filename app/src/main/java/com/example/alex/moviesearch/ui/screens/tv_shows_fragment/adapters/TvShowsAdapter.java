package com.example.alex.moviesearch.ui.screens.tv_shows_fragment.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.alex.moviesearch.Constants;
import com.example.alex.moviesearch.R;
import com.example.alex.moviesearch.model.tv_show.TvShow;
import com.example.alex.moviesearch.ui.screens.tv_shows_fragment.ITvShowInfo;

import java.util.ArrayList;
import java.util.List;


public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.ViewHolder> {

    private List<TvShow> mTvShows = new ArrayList<>();
    private ITvShowInfo mTvShowInfo;
    private Context mContext;

    public TvShowsAdapter(Context context, ITvShowInfo tvShowInfo) {
        mContext = context;
        mTvShowInfo = tvShowInfo;
    }

    public TvShowsAdapter(List<TvShow> mTvShows, ITvShowInfo mTvShowInfo, Context mContext) {
        this.mTvShows = mTvShows;
        this.mTvShowInfo = mTvShowInfo;
        this.mContext = mContext;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView posterImageView;

        ViewHolder(View itemView) {
            super(itemView);
            posterImageView = (ImageView) itemView.findViewById(R.id.tv_show_poster);
        }
    }

    public void addTvShows(ArrayList<TvShow> popularTvShowsList){
        mTvShows = popularTvShowsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tv_show_item, parent, false);

        return new TvShowsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext)
                .load(Constants.IMAGE_BASE_PATH + mTvShows.get(position).getPosterPath())
                .into(holder.posterImageView);

        holder.posterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvShowInfo.sendRequestForGettingTvShowInfo(mTvShows.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }
}
