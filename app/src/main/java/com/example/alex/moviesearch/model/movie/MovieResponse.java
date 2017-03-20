package com.example.alex.moviesearch.model.movie;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    ArrayList<Movie> resultsResponseList;

    @SerializedName("total_results")
    int totalResults;

    @SerializedName("total_pages")
    int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Movie> getMovies() {
        return resultsResponseList;
    }

    public void setResultsResponseList(ArrayList<Movie> resultsResponseList) {
        this.resultsResponseList = resultsResponseList;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
