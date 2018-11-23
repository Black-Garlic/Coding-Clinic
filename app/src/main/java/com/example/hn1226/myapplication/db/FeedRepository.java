package com.example.hn1226.myapplication.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.hn1226.myapplication.db.dao.FeedDao;
import com.example.hn1226.myapplication.model.Feed;

import java.util.List;

public class FeedRepository {
    private FeedDao mFeedDao;
    private LiveData<List<Feed>> mFeed;

    public FeedRepository(Application application) {
        FeedRoomDatabase db = FeedRoomDatabase.getDatabase(application);
        mFeedDao = db.feedDao();
        mFeed = mFeedDao.getAllFeed();
    }

    public LiveData<List<Feed>> getAllFeed() {
        return mFeed;
    }

    public void insert(Feed feed) {
        new insertAsyncTask(mFeedDao).execute(feed);
    }

    public static class insertAsyncTask extends AsyncTask<Feed, Void, Void> {
        private FeedDao mAsyncTaskDao;

        insertAsyncTask(FeedDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Feed... feeds) {
            mAsyncTaskDao.insert(feeds[0]);
            return null;
        }
    }
}
