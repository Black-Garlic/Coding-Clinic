package com.example.hn1226.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView name;

        MyViewHolder(View view){
            super(view);
            picture = view.findViewById(R.id.game_picture);
            name = view.findViewById(R.id.game_name);
        }
    }

    private ArrayList<GameInfo> gameInfoArrayList;
    MyAdapter(ArrayList<GameInfo> gameInfoArrayList){
        this.gameInfoArrayList = gameInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.picture.setImageResource(gameInfoArrayList.get(position).drawableId);
        myViewHolder.name.setText(gameInfoArrayList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return gameInfoArrayList.size();
    }
}