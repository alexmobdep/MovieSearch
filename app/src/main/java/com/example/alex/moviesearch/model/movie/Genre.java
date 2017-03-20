package com.example.alex.moviesearch.model.movie;


import com.google.gson.annotations.SerializedName;

public class Genre {

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
