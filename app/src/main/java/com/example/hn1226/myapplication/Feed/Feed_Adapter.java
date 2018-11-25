package com.example.hn1226.myapplication.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hn1226.myapplication.R;
import com.example.hn1226.myapplication.model.Feed;

import java.text.SimpleDateFormat;
import java.util.List;

public class Feed_Adapter extends RecyclerView.Adapter<Feed_Adapter.FeedViewHolder> {

    class FeedViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private ImageView picture;

        private FeedViewHolder(View view) {
            super(view);
            picture = view.findViewById(R.id.game_picture);
            name = view.findViewById(R.id.name);
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
            holder.name.setText(current.getText());
        } else {
            holder.name.setText("No Text");
        }
    }

    void setTexts(List<Feed> feeds) {
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
