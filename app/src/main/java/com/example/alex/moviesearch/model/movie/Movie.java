package com.example.alex.moviesearch.model.movie;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {

    @SerializedName("adult")
    boolean isAdult;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("budget")
    String budget;

    @SerializedName("genres")
    ArrayList<Genre> genres;

    @SerializedName("homepage")
    String homepage;

    @SerializedName("id")
    int id;

    @SerializedName("imdb_id")
    String imdbId;

    @SerializedName("original_language")
    String originalLang;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("overview")
    String overview;

    @SerializedName("popularity")
    double popularity;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("production_companies")
    ArrayList<ProductionCompany> companies;

    @SerializedName("production_countries")
    ArrayList<ProductionCountry> countries;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("revenue")
    String revenue;

    @SerializedName("runtime")
    int minutes;

    @SerializedName("genre_ids")
    ArrayList<Integer> genreIdsList;

    public ArrayList<Integer> getGenreIdsList() {
        return genreIdsList;
    }

    @SerializedName("spoken_languages")
    ArrayList<ProductionCountry> languages;

    @SerializedName("status")
    String status;

    @SerializedName("title")
    String title;

    @SerializedName("video")
    boolean isVideoAvalable;

    @SerializedName("vote_average")
    double voteAverage;

    @SerializedName("vote_count")
    int voteCount;

    public boolean isAdult() {
        return isAdult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getBudget() {
        return budget;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLang() {
        return originalLang;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public ArrayList<ProductionCompany> getCompanies() {
        return companies;
    }

    public ArrayList<ProductionCountry> getCountries() {
        return countries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRevenue() {
        return revenue;
    }

    public int getMinutes() {
        return minutes;
    }

    public ArrayList<ProductionCountry> getLanguages() {
        return languages;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideoAvalable() {
        return isVideoAvalable;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }
}
