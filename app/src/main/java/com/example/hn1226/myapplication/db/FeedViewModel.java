package com.example.hn1226.myapplication.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.hn1226.myapplication.model.Feed;

import java.util.List;

public class FeedViewModel extends AndroidViewModel {
    private FeedRepository mRepository;

    private LiveData<List<Feed>> mAllFeeds;

    public FeedViewModel(Application application) {
        super(application);
        mRepository = new FeedRepository(application);
        mAllFeeds = mRepository.getAllFeed();
    }

    public LiveData<List<Feed>> getAllFeed() {
        return mAllFeeds;
    }

    public void insert(Feed Feed) {
        mRepository.insert(Feed);
    }
}
