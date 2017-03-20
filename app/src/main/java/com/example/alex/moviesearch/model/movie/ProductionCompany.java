package com.example.alex.moviesearch.model.movie;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 3/4/2017.
 */

public class ProductionCompany {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
