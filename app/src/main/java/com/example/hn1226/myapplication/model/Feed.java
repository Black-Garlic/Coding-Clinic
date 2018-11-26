package com.example.hn1226.myapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

@Entity(tableName="feed_table")
public class Feed {
    @PrimaryKey(autoGenerate = true)
    private long Id;

    private String imageUrl;

    private Date updateAt;

    private String text;

    private String userName;

    private int likeCount = 0;

    private int replyCount = 0;

    public Feed(@NonNull String userName, String text, String imageUrl) {
        this.userName = userName;
        this.text = text;
        this.imageUrl = "1";
        Date date = new Date();
        this.updateAt = date;
    }

    @Ignore
    public Feed() {
        this.text = "";
        this.imageUrl = "";
    }

    public long getId() { return Id; }

    public void setId(long Id) { this.Id = Id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Date getUpdateAt() { return updateAt; }

    public void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public int getLikeCount() { return likeCount; }

    public void setLikeCount(int likeCount) { this.likeCount = likeCount; }

    public int getReplyCount() { return replyCount; }

    public void setReplyCount(int replyCount) { this.replyCount = replyCount; }
}
