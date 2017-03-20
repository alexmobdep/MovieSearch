package com.example.alex.moviesearch.core.impl;

import com.example.alex.moviesearch.Constants;
import com.example.alex.moviesearch.model.movie.MovieResponse;
import com.example.alex.moviesearch.model.movie.Movie;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.NowPlayingMovies;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.PopularMovies;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.UpcomingMovies;
import com.example.alex.moviesearch.network.TheMovieSearchService;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieManager implements com.example.alex.moviesearch.core.MovieManager {

    private TheMovieSearchService service;

    public MovieManager(TheMovieSearchService service) {
        this.service = service;
    }

    @Override
    public void getUpcomingMovies(String apiKey, String language) {
        Call<MovieResponse> call = service.getUpcomingMovies(apiKey, language);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                EventBus.getDefault().post(new UpcomingMovies(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getPopularMovies(String apikey, String language, int page) {
        Call<MovieResponse> call = service.getPopularMovies(apikey, language, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                EventBus.getDefault().post(new PopularMovies(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getMovieInfo(int movieId, String apiKey, String language) {
        Call<Movie> call = service.getMovieInfo(movieId, apiKey, language);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }

    @Override
    public void nowPlaying(String apiKey, String language, int page) {
        Call<MovieResponse> call = service.getNowPlaying(Constants.API_KEY, Constants.LANGUAGE, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    EventBus.getDefault().post(new NowPlayingMovies(response.body().getMovies()));
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
