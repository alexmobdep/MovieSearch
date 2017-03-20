package com.example.alex.moviesearch.ui.screens.movie_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alex.moviesearch.Constants;
import com.example.alex.moviesearch.R;
import com.example.alex.moviesearch.model.movie.Genre;
import com.example.alex.moviesearch.model.movie.Movie;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    private ImageView mPoster;
    private TextView mTitle;
    private TextView mBudget;
    private TextView mOverView;
    private TextView mVoteAverage;
    private TextView mVoteCount;
    private TextView mDuration;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mPoster = (ImageView) view.findViewById(R.id.poster_imv);
        mTitle = (TextView) view.findViewById(R.id.title_tv);
        mBudget = (TextView) view.findViewById(R.id.budget_tv);
        mOverView = (TextView) view.findViewById(R.id.overview_tv);
        mVoteAverage = (TextView) view.findViewById(R.id.vote_average_tv);
        mVoteCount = (TextView) view.findViewById(R.id.vote_count_tv);
        mDuration = (TextView) view.findViewById(R.id.movie_duration_tv);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(Movie movie) {
        setDataToViews(movie);
    }

    private void setDataToViews(Movie movie){
        Glide.with(getActivity())
                .load(Constants.IMAGE_BASE_PATH + movie.getPosterPath())
                .into(mPoster);

        String title = movie.getTitle();
        String budget = movie.getBudget();
        String homePage = movie.getHomepage();
        String overView = movie.getOverview();
        String releaseDate = movie.getReleaseDate();
        double popularity = movie.getPopularity();
        double voteAverage = movie.getVoteAverage();
        int minutes = movie.getMinutes();
        int voteCount = movie.getVoteCount();

        mTitle.setText(title);
        mBudget.setText(budget + "$");
        mOverView.setText(overView);
        mVoteAverage.setText(String.valueOf(voteAverage) + " / 10");
        mVoteCount.setText(String.valueOf(voteCount));
        mDuration.setText(String.valueOf(minutes));


        List<String> companies = new ArrayList<>();
        for (int i = 0; i < movie.getCompanies().size(); i++) {
            companies.add(movie.getCompanies().get(i).getName());
        }

        List<String> countries = new ArrayList<>();
        for (int i = 0; i < movie.getCountries().size(); i++) {
            countries.add(movie.getCountries().get(i).getCountryName());
        }

        List<Genre> genres = new ArrayList<>();
        for (Genre genre : movie.getGenres()) {
            genres.add(genre);
        }
    }
}
