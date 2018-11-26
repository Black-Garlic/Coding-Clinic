package com.example.hn1226.myapplication.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hn1226.myapplication.model.GameInfo;
import com.example.hn1226.myapplication.R;

import java.util.ArrayList;

public class Game_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<GameInfo> gameInfoArrayList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView name;
        TextView text;
        TextView like_reply;
        TextView update;


        MyViewHolder(View view){
            super(view);
            picture = view.findViewById(R.id.picture);
            name = view.findViewById(R.id.name);
            text = view.findViewById(R.id.text);
            like_reply = view.findViewById(R.id.like_reply);
            update = view.findViewById(R.id.update_time);
        }
    }

    Game_Adapter(ArrayList<GameInfo> gameInfoArrayList, Context context){
        this.gameInfoArrayList = gameInfoArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Glide.with(context).load(gameInfoArrayList.get(position).drawableId).into(myViewHolder.picture);
        myViewHolder.name.setText(gameInfoArrayList.get(position).name);
        myViewHolder.text.setText("Text");
        myViewHolder.like_reply.setText("Like = 0        Reply = 0");
        myViewHolder.update.setText("04");
    }

    @Override
    public int getItemCount() {
        return gameInfoArrayList.size();
    }
}