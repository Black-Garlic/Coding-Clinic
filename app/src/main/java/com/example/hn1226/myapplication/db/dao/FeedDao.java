package com.example.hn1226.myapplication.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.hn1226.myapplication.model.Feed;

import java.util.List;


@Dao
public interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Feed feed);

    @Query("SELECT * FROM feed_table ORDER BY updateAt DESC")
    LiveData<List<Feed>> getAllFeed();
}
