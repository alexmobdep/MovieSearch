package com.example.alex.moviesearch.network;


import com.example.alex.moviesearch.model.movie.MovieResponse;
import com.example.alex.moviesearch.model.movie.Movie;
import com.example.alex.moviesearch.model.tv_show.TvShow;
import com.example.alex.moviesearch.model.tv_show.TvShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieSearchService {

    // all methods for working with movies

    @GET("3/movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("3/movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);

    @GET("3/movie/now_playing")
    Call<MovieResponse> getNowPlaying(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);

    @GET("3/discover/movie?")
    Call<MovieResponse> discoverMovie(@Query("api_key") String apiKey, @Query("language") String language,
                                      @Query("sort_by") String sortBy, @Query("include_adult") boolean includeAdult,
                                      @Query("include_video") boolean includeVideo, @Query("page") int page);

    @GET("3/movie/{movie_id}?")
    Call<Movie> getMovieInfo(@Path("movie_id") int movieId, @Query("api_key") String apiKey, @Query("language") String language);

    // all methods for working with tv-shows

    @GET("3/tv/popular")
    Call<TvShowsResponse> getPopularTvShows(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);

    @GET("3/tv/{tv_id}")
    Call<TvShow> getTvShowInfo(@Path("tv_id") int tvShowId, @Query("api_key") String apiKey, @Query("language") String language);


}
