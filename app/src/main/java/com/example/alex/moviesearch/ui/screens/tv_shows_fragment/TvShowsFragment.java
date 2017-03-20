package com.example.alex.moviesearch.ui.screens.tv_shows_fragment;

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
import com.example.alex.moviesearch.core.TvShowManager;
import com.example.alex.moviesearch.model.wrappers.tv_show_wrapper.PopularTvShow;
import com.example.alex.moviesearch.ui.screens.chosen_tv_show.ChosenTvShowFragment;
import com.example.alex.moviesearch.ui.screens.movie_fragment.MovieFragment;
import com.example.alex.moviesearch.ui.screens.tv_shows_fragment.adapters.TvShowsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class TvShowsFragment extends Fragment implements ITvShowInfo{

    @Inject
    TvShowManager tvShowManager;

    private int mPages = 1;

    TvShowsAdapter mTvShowsAdapter;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Application.getComponent().inject(this);
        tvShowManager.getPopularTvShows(Constants.API_KEY, Constants.LANGUAGE, mPages);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        RecyclerView popularShowsView = (RecyclerView) view.findViewById(R.id.popular_tv_shows);
        popularShowsView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mTvShowsAdapter = new TvShowsAdapter(getContext(), this);
        popularShowsView.setAdapter(mTvShowsAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getPopularTvShows(PopularTvShow popularTvShow){
        mTvShowsAdapter.addTvShows(popularTvShow.getList());
        mTvShowsAdapter.notifyDataSetChanged();
    }

    @Override
    public void sendRequestForGettingTvShowInfo(int id) {
        tvShowManager.getTvShowInfo(id, Constants.API_KEY, Constants.LANGUAGE);
        replaceOnChosenTvShowFragment();
    }

    private void replaceOnChosenTvShowFragment(){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main, new ChosenTvShowFragment()).addToBackStack(null).commit();
    }
}
