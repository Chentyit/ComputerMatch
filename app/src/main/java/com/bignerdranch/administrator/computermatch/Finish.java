package com.bignerdranch.administrator.computermatch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

public class Finish extends Fragment {

    private View mView;
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private FinishAdapter mAdapter;
    private List<Message> mMessages = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.boll_finish, container, false);
        initList();
        initView();
        return mView;
    }

    private void initView() {
        toolbar = (Toolbar) mView.findViewById(R.id.finish_toolbar);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.finish_recycler_view);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new FinishAdapter(mMessages);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initList() {
        mMessages.clear();
        mMessages.add(new Message("乒乓球", "周一下午2：30", R.drawable.table_tennis));
        mMessages.add(new Message("西操羽毛球场", "周一下午2：30", R.drawable.badminton));
    }

}
