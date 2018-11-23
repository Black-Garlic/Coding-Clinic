package com.example.hn1226.myapplication.model;

import java.util.Date;

public class Like {

    private long Id;

    private UserInfo User;

    private Date updateAt;

    public long getId() { return Id; }

    public void setId(long Id) { this.Id = Id; }

    public UserInfo getUser() { return User; }

    public void setUser(UserInfo User) { this.User = User; }

    public Date getUpdateAt() { return updateAt; }

    public void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }
}
