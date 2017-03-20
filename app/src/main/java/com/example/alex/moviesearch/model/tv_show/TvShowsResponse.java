package com.example.alex.moviesearch.model.tv_show;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvShowsResponse {

    @SerializedName("page")
    int page;

    @SerializedName("results")
    ArrayList<TvShow> resultsList;

    @SerializedName("total_results")
    int totalResults;

    @SerializedName("total_pages")
    int totalPages;

    public int getPage() {
        return page;
    }

    public ArrayList<TvShow> getResultsList() {
        return resultsList;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
