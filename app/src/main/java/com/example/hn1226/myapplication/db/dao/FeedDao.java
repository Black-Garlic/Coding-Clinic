package com.example.hn1226.myapplication.db.dao;

import android.arch.lifecycle.LiveData;

import com.example.hn1226.myapplication.model.Feed;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface FeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Feed feed);

    @Query("SELECT * FROM feed_table ORDER BY updateAt DESC")
    LiveData<List<Feed>> getAllFeed();
}
