package com.example.hn1226.myapplication.Model;

import com.example.hn1226.myapplication.UserInfo;

import java.util.Date;

public class Reply {

    private long Id;

    private UserInfo User;

    private String text;

    private int likeCount;

    private int replyCount;

    private Date updateAt;

    private long getId() { return Id; }

    private void setId(long Id) { this.Id = Id; }

    private UserInfo getUser() { return User; }

    private void setUser(UserInfo User) { this.User = User; }

    private Date getUpdateAt() { return updateAt; }

    private void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }

    private String getText() { return text; }

    private void setText(String text) { this.text = text; }

    private int getLikeCount() { return likeCount; }

    private void setLikeCount(int likeCount) { this.likeCount = likeCount; }

    private int getReplyCount() { return replyCount; }

    private void setReplyCount(int replyCount) { this.replyCount = replyCount; }
}
