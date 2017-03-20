package com.example.alex.moviesearch.model.wrappers.movie_wrapper;

import com.example.alex.moviesearch.model.movie.Movie;

import java.util.ArrayList;


public class MovieWrapper {
    private ArrayList<Movie> list;

    public MovieWrapper(ArrayList<Movie> list) {
        this.list = list;
    }

    public ArrayList<Movie> getList() {
        return list;
    }
}
