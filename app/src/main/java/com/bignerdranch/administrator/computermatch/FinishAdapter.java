package com.bignerdranch.administrator.computermatch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class FinishAdapter extends RecyclerView.Adapter<FinishAdapter.ViewHolder> {

    private Context mContext;
    private List<Message> mMessages;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView planPlace;
        TextView planClock;
        ImageView planImage;
        Button change;
        Button delete;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView) view;
            planPlace = (TextView) view.findViewById(R.id.myplan_place_name);
            planClock = (TextView) view.findViewById(R.id.myplan_play_time);
            planImage = (ImageView) view.findViewById(R.id.myplan_ball_name);
            change = (Button) view.findViewById(R.id.change_play);
            delete = (Button) view.findViewById(R.id.delete_play);
        }
    }

    public FinishAdapter(List<Message> mMessages) {
        this.mMessages = mMessages;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.myplan_recycle_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Message message = mMessages.get(position);
        holder.planPlace.setText(message.getPlace());
        holder.planClock.setText(message.getTime());
        Glide.with(mContext).load(message.getImageId()).into(holder.planImage);
        holder.change.setText("分享");
        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, message.getPlace() + message.getTime() + "已结束");
                shareIntent.setType("text/plain");
                //设置分享列表的标题，并且每次都显示分享列表
                mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "已删除", Toast.LENGTH_SHORT).show();
                FinishAdapter.this.notifyItemRemoved(position);
                FinishAdapter.this.notifyDataSetChanged();
                mMessages.remove(position);
            }
        });
    }

    public int getItemCount() {
        return mMessages.size();
    }
}
