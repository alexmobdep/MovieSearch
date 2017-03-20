package com.example.alex.moviesearch.ui.screens.chosen_tv_show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alex.moviesearch.R;
import com.example.alex.moviesearch.model.tv_show.TvShow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class ChosenTvShowFragment extends Fragment {

    private ImageView mTvShowPoster;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chosen_tv_show, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        mTvShowPoster = (ImageView) view.findViewById(R.id.tv_show_poster);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getTvShowInfo(TvShow tvShow){
        String name = tvShow.getOriginalName();

    }


}
