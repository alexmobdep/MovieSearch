package com.example.alex.moviesearch.model.wrappers.tv_show_wrapper;


import com.example.alex.moviesearch.model.tv_show.TvShow;

import java.util.ArrayList;

public class TvShowWrapper {

    public TvShowWrapper(ArrayList<TvShow> list) {
        this.list = list;
    }

    private ArrayList<TvShow> list;

    public ArrayList<TvShow> getList() {
        return list;
    }
}
