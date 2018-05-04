package com.bignerdranch.administrator.computermatch;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class MyPlan extends Fragment implements View.OnClickListener {

    private View mView;
    private Toolbar toolbar;
    private FloatingActionButton mButton;
    private RecyclerView mRecyclerView;
    private MyPlanAdapter mAdapter;
    private List<Message> mMessages = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.boll_myplan, container, false);
        initList();
        initView();
        return mView;
    }

    private void initView() {
        toolbar = (Toolbar) mView.findViewById(R.id.my_plan_toolbar);
        mButton = (FloatingActionButton) mView.findViewById(R.id.my_plan_fab);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.my_plan_recycler_view);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        mButton.setOnClickListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyPlanAdapter(mMessages);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_plan_fab:
                Toast.makeText(getContext(), "准备添加", Toast.LENGTH_SHORT).show();
                View view2 = LayoutInflater.from(getContext()).inflate(R.layout.add_view, null);
                final EditText place = (EditText) view2.findViewById(R.id.add_place);
                final EditText time = (EditText) view2.findViewById(R.id.add_time);
                final EditText kind = (EditText) view2.findViewById(R.id.add_kind);
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setView(view2)
                        .setTitle("请填写更改信息")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int id;
                                switch (kind.getText().toString()) {
                                    case "篮球":
                                        id = R.drawable.basketball;
                                        break;
                                    case "羽毛球":
                                        id = R.drawable.badminton;
                                        break;
                                    case "足球":
                                        id = R.drawable.football;
                                        break;
                                    case "乒乓球":
                                        id = R.drawable.table_tennis;
                                        break;
                                    case "橄榄球":
                                        id = R.drawable.rugby;
                                        break;
                                    case "网球":
                                        id = R.drawable.tennis;
                                        break;
                                    case "排球":
                                        id = R.drawable.volleyball;
                                        break;
                                    case "棒球":
                                        id = R.drawable.baseball;
                                        break;
                                    default:
                                        id = R.drawable.basketball;
                                        break;
                                }
                                mMessages.add(new Message(place.getText().toString(), time.getText().toString(), id));
                            }
                        })
                        .show();
                break;
            default:
                break;
        }
    }

    private void initList() {
        mMessages.clear();
        mMessages.add(new Message("乒乓球", "周一下午2：30", R.drawable.table_tennis));
        mMessages.add(new Message("西操羽毛球场", "周一下午2：30", R.drawable.badminton));
    }

}
