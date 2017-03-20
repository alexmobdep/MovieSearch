package com.example.alex.moviesearch.core.impl;

import com.example.alex.moviesearch.network.TheMovieSearchService;

/**
 * Created by Alex on 3/6/2017.
 */

public class ActorManager implements com.example.alex.moviesearch.core.ActorManager {
    private TheMovieSearchService service;

    public ActorManager(TheMovieSearchService service) {
        this.service = service;
    }
}
