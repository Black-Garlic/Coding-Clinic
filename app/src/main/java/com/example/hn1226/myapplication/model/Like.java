package com.example.hn1226.myapplication.Model;

import com.example.hn1226.myapplication.UserInfo;

import java.util.Date;

public class Like {

    private long Id;

    private UserInfo User;

    private Date updateAt;

    private long getId() { return Id; }

    private void setId(long Id) { this.Id = Id; }

    private UserInfo getUser() { return User; }

    private void setUser(UserInfo User) { this.User = User; }

    private Date getUpdateAt() { return updateAt; }

    private void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }
}
