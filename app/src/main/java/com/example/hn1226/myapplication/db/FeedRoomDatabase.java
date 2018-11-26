package com.example.hn1226.myapplication.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.hn1226.myapplication.db.dao.FeedDao;
import com.example.hn1226.myapplication.model.Feed;

@Database(entities = {Feed.class}, version=1, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class FeedRoomDatabase extends RoomDatabase {

    public abstract FeedDao feedDao();

    private static FeedRoomDatabase INSTANCE;

    public static FeedRoomDatabase getDatabase (final Context context) {
        if (INSTANCE == null) {
            synchronized (FeedRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), FeedRoomDatabase.class, "feed_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
