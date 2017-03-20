package com.example.alex.moviesearch.model.tv_show;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvShow {

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("popularity")
    double popularity;

    @SerializedName("id")
    int id;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("vote_average")
    double voteAverage;

    @SerializedName("origin_country")
    ArrayList<String> countriesList;

    @SerializedName("genre_ids")
    ArrayList<Integer> genreIdsList;

    @SerializedName("original_language")
    String originalLang;

    @SerializedName("vote_count")
    int voteCount;

    @SerializedName("name")
    String name;

    @SerializedName("original_name")
    String originalName;

    public String getPosterPath() {
        return posterPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public ArrayList<String> getCountriesList() {
        return countriesList;
    }

    public ArrayList<Integer> getGenreIdsList() {
        return genreIdsList;
    }

    public String getOriginalLang() {
        return originalLang;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }
}
