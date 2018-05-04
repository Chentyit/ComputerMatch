package com.bignerdranch.administrator.computermatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class Will extends Fragment {

    private View mView;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private WillAdapter mWillAdapter;
    private List<MessageWill> mMessageWills = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.boll_will, container, false);
        initList();
        initView();
        return mView;
    }

    private void initView() {
        mToolbar = (Toolbar) mView.findViewById(R.id.will_toolbar);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.will_recycler_view);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setTitle("");
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mWillAdapter = new WillAdapter(mMessageWills);
        mRecyclerView.setAdapter(mWillAdapter);
    }

    private void initList() {
        mMessageWills.clear();
        mMessageWills.add(new MessageWill("乒乓球", "周一下午2：30", R.drawable.table_tennis, 48, 57, 23));
        mMessageWills.add(new MessageWill("西操羽毛球场", "周一下午2：30", R.drawable.badminton, 23, 21, 3));
    }

}
