package com.example.hn1226.myapplication.model;

import java.util.Date;

public class Reply {

    private long Id;

    private UserInfo User;

    private String text;

    private int likeCount;

    private int replyCount;

    private Date updateAt;

    public long getId() { return Id; }

    public void setId(long Id) { this.Id = Id; }

    public UserInfo getUser() { return User; }

    public void setUser(UserInfo User) { this.User = User; }

    public Date getUpdateAt() { return updateAt; }

    public void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public int getLikeCount() { return likeCount; }

    public void setLikeCount(int likeCount) { this.likeCount = likeCount; }

    public int getReplyCount() { return replyCount; }

    public void setReplyCount(int replyCount) { this.replyCount = replyCount; }
}
