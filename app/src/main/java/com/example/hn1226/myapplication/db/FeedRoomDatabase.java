package com.example.hn1226.myapplication.db;

import android.content.Context;

import com.example.hn1226.myapplication.db.dao.FeedDao;
import com.example.hn1226.myapplication.model.Feed;
import com.example.hn1226.myapplication.model.UserInfo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Feed.class}, version=1)
@TypeConverters(DateTypeConverter.class)
public abstract class FeedRoomDatabase extends RoomDatabase{

    public abstract FeedDao feedDao();

    private static FeedRoomDatabase INSTANCE;

    public static FeedRoomDatabase getDatabase (final Context context) {
        if (INSTANCE == null) {
            synchronized (FeedRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), FeedRoomDatabase.class, "feed_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
