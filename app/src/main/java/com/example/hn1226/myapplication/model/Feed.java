package com.example.hn1226.myapplication.model;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="feed_table")
public class Feed {
    @PrimaryKey(autoGenerate = true)
    private long Id;
/*
    @Ignore
    @Expose
    private UserInfo User;
*/
    private String imageUrl;

    private Date updateAt;

    private String openTo;

    private String text;

    private int likeCount;

    private int replyCount;

    public Feed(@NonNull String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public Feed() {
        this.text = "";
        this.imageUrl = "";
    }

    public long getId() { return Id; }

    public void setId(long Id) { this.Id = Id; }
/*
    public UserInfo getUser() { return User; }

    public void setUser(UserInfo User) { this.User = User; }
*/
    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Date getUpdateAt() { return updateAt; }

    public void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }

    public String getOpenTo() { return openTo; }

    public void setOpenTo(String openTo) { this.openTo = openTo; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public int getLikeCount() { return likeCount; }

    public void setLikeCount(int likeCount) { this.likeCount = likeCount; }

    public int getReplyCount() { return replyCount; }

    public void setReplyCount(int replyCount) { this.replyCount = replyCount; }
}
