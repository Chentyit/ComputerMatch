package com.bignerdranch.administrator.computermatch;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class Home extends Fragment {

    private View mView;
    private List<Message> mHomeMessages = new ArrayList<>();
    private HomeAdapter mHomeAdapter;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private Message[] mMessages = {
            new Message("西操足球场", "周一下午2：30", R.drawable.football),
            new Message("西操篮球场", "周一下午2：30", R.drawable.basketball),
            new Message("西操排球场", "周一下午2：30", R.drawable.volleyball),
            new Message("乒乓球", "周一下午2：30", R.drawable.table_tennis),
            new Message("东操操场", "周一下午2：30", R.drawable.rugby),
            new Message("东操网球场", "周一下午2：30", R.drawable.tennis),
            new Message("西操羽毛球场", "周一下午2：30", R.drawable.badminton),
            new Message("东操操场", "周一下午2：30", R.drawable.baseball)
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.boll_home, container, false);
        setHasOptionsMenu(true);
        initProject();
        refresh();
        return mView;
    }

    private void refresh() {
        mToolbar = (Toolbar) mView.findViewById(R.id.home_toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) mView.findViewById(R.id.home_collapsing_toolbar);
        mImageView = (ImageView) mView.findViewById(R.id.home_weather);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        Glide.with(getActivity()).load(R.drawable.weather).into(mImageView);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.home_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mHomeAdapter = new HomeAdapter(mHomeMessages);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    private void initProject() {
        mHomeMessages.clear();
        for(int i = 0; i < 20; i++) {
            Random random = new Random();
            int index = random.nextInt(mMessages.length);
            mHomeMessages.add(mMessages[index]);
        }
    }

}
