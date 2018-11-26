package com.example.hn1226.myapplication.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hn1226.myapplication.R;
import com.example.hn1226.myapplication.model.Feed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Feed_Adapter extends RecyclerView.Adapter<Feed_Adapter.FeedViewHolder> {

    class FeedViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView name;
        TextView text;
        TextView like_reply;
        TextView update;
        Button addLike;

        private FeedViewHolder(View view) {
            super(view);
            picture = view.findViewById(R.id.picture);
            name = view.findViewById(R.id.name);
            text = view.findViewById(R.id.text);
            like_reply = view.findViewById(R.id.like_reply);
            update = view.findViewById(R.id.update_time);
            addLike= view.findViewById(R.id.add_like);
        }
    }

    private final LayoutInflater mInflater;
    private List<Feed> mFeeds;

    public Feed_Adapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.recycler_view_row, parent, false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        if (mFeeds != null) {
            Feed current = mFeeds.get(position);
            holder.name.setText(current.getUserName());
            holder.text.setText(current.getText());
            holder.like_reply.setText("Like = " + current.getLikeCount() + "       " + "Reply = " + current.getReplyCount());
            holder.update.setText("" + current.getUpdateAt());
        } else {
            holder.name.setText("No Text");
        }
    }

    public void setTexts(List<Feed> feeds) {
        mFeeds = feeds;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mFeeds != null) {
            return mFeeds.size();
        } else {
            return 0;
        }
    }
}
