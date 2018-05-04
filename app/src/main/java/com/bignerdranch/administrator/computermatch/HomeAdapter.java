package com.bignerdranch.administrator.computermatch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context mContext;
    private List<Message> mHomeMessages;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView placeName;
        TextView timeClock;
        ImageView bollImage;
        Button join;
        Button giveup;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView) view;
            placeName = (TextView) view.findViewById(R.id.place_name);
            timeClock = (TextView) view.findViewById(R.id.play_time);
            bollImage = (ImageView) view.findViewById(R.id.ball_name);
            join = (Button) view.findViewById(R.id.join_play);
            giveup = (Button) view.findViewById(R.id.give_up_play);
        }
    }

    public HomeAdapter(List<Message> mHomeMessages) {
        this.mHomeMessages = mHomeMessages;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recycle_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Message homeMessage = mHomeMessages.get(position);
        holder.placeName.setText(homeMessage.getPlace());
        holder.timeClock.setText(homeMessage.getTime());
        Glide.with(mContext).load(homeMessage.getImageId()).into(holder.bollImage);
        holder.bollImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, homeMessage.getPlace() + homeMessage.getTime() + "打球");
                shareIntent.setType("text/plain");
                //设置分享列表的标题，并且每次都显示分享列表
                mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
            }
        });
        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "已参加", Toast.LENGTH_SHORT).show();
                holder.join.setVisibility(View.INVISIBLE);
                holder.giveup.setVisibility(View.INVISIBLE);
            }
        });
        holder.giveup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "已放弃", Toast.LENGTH_SHORT).show();
                HomeAdapter.this.notifyItemRemoved(position);
                HomeAdapter.this.notifyDataSetChanged();
                mHomeMessages.remove(position);
            }
        });
    }

    public int getItemCount() {
        return mHomeMessages.size();
    }

}
