package com.example.hn1226.myapplication.friend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hn1226.myapplication.model.UserInfo;
import com.example.hn1226.myapplication.R;

import java.util.ArrayList;

public class User_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<UserInfo> userInfoArrayList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView picture;

        MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.user_name);
            picture = view.findViewById(R.id.picture);
        }
    }

    User_Adapter(ArrayList<UserInfo> userInfoArrayList, Context context){
        this.userInfoArrayList = userInfoArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_friend, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Glide.with(context).load(userInfoArrayList.get(position).avatarUrl).into(myViewHolder.picture);
        myViewHolder.name.setText(userInfoArrayList.get(position).name);
        myViewHolder.name.append("\n" + userInfoArrayList.get(position).url);
    }

    @Override
    public int getItemCount() {
        return userInfoArrayList.size();
    }
}