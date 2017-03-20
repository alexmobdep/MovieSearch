package com.example.alex.moviesearch.core;

public interface MovieManager {
    void getUpcomingMovies(String apiKey, String language);
    void getPopularMovies(String apikey, String language, int page);
    void getMovieInfo(int movieId, String apiKey, String language);
    void nowPlaying(String apiKey, String language, int page);
}
