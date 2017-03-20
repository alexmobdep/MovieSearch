package com.example.alex.moviesearch.dagger;

import com.example.alex.moviesearch.ui.MainActivity;
import com.example.alex.moviesearch.ui.screens.main_fragment.HomeFragment;
import com.example.alex.moviesearch.ui.screens.tv_shows_fragment.TvShowsFragment;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(HomeFragment mainFragment);
    void inject(TvShowsFragment tvShowsFragment);
}
