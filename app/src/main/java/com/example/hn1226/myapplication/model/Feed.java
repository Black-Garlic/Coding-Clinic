package com.example.hn1226.myapplication.Model;

import com.example.hn1226.myapplication.UserInfo;

import java.util.Date;
import java.util.List;

public class Feed {

    private long Id;

    private UserInfo User;

    private String imageUrl;

    private Date updateAt;

    private String openTo;

    private String text;

    private int likeCount;

    private int replyCount;

    private List<Reply> Replies;

    private long getId() { return Id; }

    private void setId(long Id) { this.Id = Id; }

    private UserInfo getUser() { return User; }

    private void setUser(UserInfo User) { this.User = User; }

    private String getImageUrl() { return imageUrl; }

    private void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    private Date getUpdateAt() { return updateAt; }

    private void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }

    private String getOpenTo() { return openTo; }

    private void setOpenTo(String openTo) { this.openTo = openTo; }

    private String getText() { return text; }

    private void setText(String text) { this.text = text; }

    private int getLikeCount() { return likeCount; }

    private void setLikeCount(int likeCount) { this.likeCount = likeCount; }

    private int getReplyCount() { return replyCount; }

    private void setReplyCount(int replyCount) { this.replyCount = replyCount; }

    private List<Reply> getReplies() { return Replies; }

    private void setReplies() { this.Replies = Replies; }
}
