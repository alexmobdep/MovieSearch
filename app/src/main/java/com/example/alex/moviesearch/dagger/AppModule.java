package com.example.alex.moviesearch.dagger;

import android.app.Application;

import com.example.alex.moviesearch.core.ActorManager;
import com.example.alex.moviesearch.core.MovieManager;
import com.example.alex.moviesearch.core.TvShowManager;
import com.example.alex.moviesearch.network.TheMovieSearchService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private final Application app;


    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    Application provideApplication() {
        return app;
    }

    @Provides
    ActorManager provideActorManager(TheMovieSearchService service){
        return new com.example.alex.moviesearch.core.impl.ActorManager(service);
    }

    @Provides
    MovieManager provideMovieManager(TheMovieSearchService service){
        return new com.example.alex.moviesearch.core.impl.MovieManager(service);
    }

    @Provides
    TvShowManager provideTvShowManager(TheMovieSearchService service){
        return new com.example.alex.moviesearch.core.impl.TvShowManager(service);
    }

    @Provides
    @Singleton
    TheMovieSearchService provideApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TheMovieSearchService.class);
    }

}
