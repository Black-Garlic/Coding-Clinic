package com.example.hn1226.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter_Game extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<GameInfo> gameInfoArrayList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView name;

        MyViewHolder(View view){
            super(view);
            picture = view.findViewById(R.id.game_picture);
            name = view.findViewById(R.id.game_name);
        }
    }

    Adapter_Game(ArrayList<GameInfo> gameInfoArrayList, Context context){
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
    }

    @Override
    public int getItemCount() {
        return gameInfoArrayList.size();
    }
}