package com.example.hn1226.myapplication.feed;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hn1226.myapplication.db.FeedViewModel;
import com.example.hn1226.myapplication.model.Feed;
import com.example.hn1226.myapplication.model.GameInfo;
import com.example.hn1226.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Feed_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Game_Adapter mAdapter;
    private Feed_Adapter feedAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<GameInfo> gameInfoArrayList = new ArrayList<>();
    private FeedViewModel mFeedViewModel;

    public Feed_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feed_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(0);
//      setRecyclerView();
//      mAdapter = new Game_Adapter(gameInfoArrayList, getActivity());
        feedAdapter = new Feed_Adapter(getActivity());
        mRecyclerView.setAdapter(feedAdapter);

        mFeedViewModel= ViewModelProviders.of(getActivity()).get(FeedViewModel.class);

        mFeedViewModel.getAllFeed().observe(this, new Observer<List<Feed>>() {
            @Override
            public void onChanged(@Nullable final List<Feed> Feed) {
                // Update the cached copy of the words in the adapter.
                feedAdapter.setTexts(Feed);
            }
        });

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