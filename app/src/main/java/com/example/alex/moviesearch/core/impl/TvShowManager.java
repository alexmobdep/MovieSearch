package com.example.alex.moviesearch.core.impl;

import com.example.alex.moviesearch.model.movie.Movie;
import com.example.alex.moviesearch.model.tv_show.TvShow;
import com.example.alex.moviesearch.model.tv_show.TvShowsResponse;
import com.example.alex.moviesearch.model.wrappers.tv_show_wrapper.PopularTvShow;
import com.example.alex.moviesearch.network.TheMovieSearchService;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowManager implements com.example.alex.moviesearch.core.TvShowManager {
    private TheMovieSearchService service;

    public TvShowManager(TheMovieSearchService service) {
        this.service = service;
    }

    @Override
    public void getPopularTvShows(String apiKey, String language, int pages) {
        Call<TvShowsResponse> call = service.getPopularTvShows(apiKey, language, pages);
        call.enqueue(new Callback<TvShowsResponse>() {
            @Override
            public void onResponse(Call<TvShowsResponse> call, Response<TvShowsResponse> response) {
                EventBus.getDefault().post(new PopularTvShow(response.body().getResultsList()));
            }

            @Override
            public void onFailure(Call<TvShowsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getTvShowInfo(int tvShowId, String apiKey, String language) {
        Call<TvShow> call = service.getTvShowInfo(tvShowId, apiKey, language);
        call.enqueue(new Callback<TvShow>() {
            @Override
            public void onResponse(Call<TvShow> call, Response<TvShow> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<TvShow> call, Throwable t) {

            }
        });
    }
}
