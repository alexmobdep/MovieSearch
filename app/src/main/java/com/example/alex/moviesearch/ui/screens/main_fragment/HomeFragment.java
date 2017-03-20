package com.example.alex.moviesearch.ui.screens.main_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.moviesearch.Application;
import com.example.alex.moviesearch.Constants;
import com.example.alex.moviesearch.R;
import com.example.alex.moviesearch.core.MovieManager;
import com.example.alex.moviesearch.model.movie.Movie;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.NowPlayingMovies;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.PopularMovies;
import com.example.alex.moviesearch.model.wrappers.movie_wrapper.UpcomingMovies;
import com.example.alex.moviesearch.ui.screens.main_fragment.adapters.MoviesAdapter;
import com.example.alex.moviesearch.ui.screens.movie_fragment.MovieFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import javax.inject.Inject;


public class HomeFragment extends Fragment implements IMovieInfo {

    private ArrayList<Movie> mUpcomingMovies;
    private ArrayList<Movie> mPopularMovies;
    private ArrayList<Movie> mNowPlayingMovies;

    private MoviesAdapter mUpcomingMoviesAdapter;
    private MoviesAdapter mPopularMoviesAdapter;
    private MoviesAdapter mNowPlayingMoviesAdapter;

    @Inject
    MovieManager movieManager;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Application.getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);
        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initViews(View view){
        Context context = getContext();

        RecyclerView upcomingMoviesView = (RecyclerView) view.findViewById(R.id.upcoming_movies_rv);
        upcomingMoviesView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        RecyclerView popularMoviesView = (RecyclerView) view.findViewById(R.id.popular_movies_rv);
        popularMoviesView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        RecyclerView nowPlayingMoviesView = (RecyclerView) view.findViewById(R.id.now_playing_movies_rv);
        nowPlayingMoviesView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        if (mUpcomingMovies != null && mPopularMovies != null && mNowPlayingMovies != null){
            mUpcomingMoviesAdapter = new MoviesAdapter(context, this, mUpcomingMovies);
            mPopularMoviesAdapter = new MoviesAdapter(context, this, mPopularMovies);
            mNowPlayingMoviesAdapter = new MoviesAdapter(context, this, mNowPlayingMovies);
        }else{
            mUpcomingMoviesAdapter = new MoviesAdapter(context, this);
            mPopularMoviesAdapter = new MoviesAdapter(context, this);
            mNowPlayingMoviesAdapter = new MoviesAdapter(context, this);
        }

        upcomingMoviesView.setAdapter(mUpcomingMoviesAdapter);
        popularMoviesView.setAdapter(mPopularMoviesAdapter);
        nowPlayingMoviesView.setAdapter(mNowPlayingMoviesAdapter);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void gettingUpcomingMoviesEvent(UpcomingMovies upcomingMovies){
        mUpcomingMoviesAdapter.addMovies(upcomingMovies.getList());
        mUpcomingMoviesAdapter.notifyDataSetChanged();
        mUpcomingMovies = upcomingMovies.getList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void gettingPopularMoviesEvent(PopularMovies popularMovies){
        mPopularMoviesAdapter.addMovies(popularMovies.getList());
        mPopularMoviesAdapter.notifyDataSetChanged();
        mPopularMovies = popularMovies.getList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void gettingnowPlayingMovies(NowPlayingMovies nowPlayingMovies){
        mNowPlayingMoviesAdapter.addMovies(nowPlayingMovies.getList());
        mNowPlayingMoviesAdapter.notifyDataSetChanged();
        mNowPlayingMovies = nowPlayingMovies.getList();
    }

    @Override
    public void sendRequestForGettingMovieInfo(int movieId) {
        movieManager.getMovieInfo(movieId, Constants.API_KEY, Constants.LANGUAGE);
        replaceOnMovieFragment();
    }

    private void replaceOnMovieFragment(){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main, new MovieFragment()).addToBackStack(null).commit();
    }
}
