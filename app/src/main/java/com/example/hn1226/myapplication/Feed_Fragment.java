package com.example.hn1226.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Feed_Fragment extends Fragment {

    TextView JavacodeTextview;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<GameInfo> gameInfoArrayList = new ArrayList<>();

    //RecyclerView mRecyclerView = getView().findViewById(R.id.recycler_view);
    //RecyclerView.LayoutManager mLayoutManager;

    public Feed_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRecyclerView();
        View view = inflater.inflate(R.layout.feed_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(0);
        mAdapter = new MyAdapter(gameInfoArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    private void setRecyclerView(){
        gameInfoArrayList.add(new GameInfo(R.drawable.image_01, "League of Legends"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_02, "Maple Story"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_03, "Star Craft"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_04, "Kart Rider"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_05, "Enter the Gungeon"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_06, "The binding of Issac Rebirth"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_07, "TEKKEN 7"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_08, "DARK SOULS 3"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_09, "Hearth Stones"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_10, "Mabinogi"));
    }
}