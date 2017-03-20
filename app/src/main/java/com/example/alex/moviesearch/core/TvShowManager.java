package com.example.alex.moviesearch.core;


public interface TvShowManager {

    void getPopularTvShows(String apiKey, String language, int pages);
    void getTvShowInfo(int tvShowId, String apiKey, String language);
}
