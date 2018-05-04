package com.bignerdranch.administrator.computermatch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daidingkang.SnapUpCountDownTimerView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class WillAdapter extends RecyclerView.Adapter<WillAdapter.ViewHolder> {

    private Context mContext;
    private List<MessageWill> mMessageWills;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView willPlace;
        TextView willClock;
        ImageView willImage;
        SnapUpCountDownTimerView snapUpCountDownTimerView;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView) view;
            willPlace = (TextView) view.findViewById(R.id.will_place_name);
            willClock = (TextView) view.findViewById(R.id.will_play_time);
            willImage = (ImageView) view.findViewById(R.id.will_ball_name);
            snapUpCountDownTimerView = (SnapUpCountDownTimerView) view.findViewById(R.id.will_TimerView);
        }
    }

    public WillAdapter(List<MessageWill> mMessageWills) {
        this.mMessageWills = mMessageWills;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.will_recycle_item, parent, false);
        return new WillAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MessageWill messageWill = mMessageWills.get(position);
        holder.willPlace.setText(messageWill.getPlace());
        holder.willClock.setText(messageWill.getTime());
        Glide.with(mContext).load(messageWill.getImageId()).into(holder.willImage);
        holder.willImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, messageWill.getPlace() + messageWill.getTime() + "打球");
                shareIntent.setType("text/plain");
                //设置分享列表的标题，并且每次都显示分享列表
                mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
            }
        });
        int Hour = messageWill.getHour();
        int Minutes = messageWill.getMinute();
        int Seconds = messageWill.getSeconds();
        holder.snapUpCountDownTimerView.setTime(Hour, Minutes, Seconds);
        holder.snapUpCountDownTimerView.start();
    }

    public int getItemCount() {
        return mMessageWills.size();
    }

}
