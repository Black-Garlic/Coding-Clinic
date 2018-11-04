package com.example.hn1226.myapplication.Model;

public class UserInfo {
    public long id;
    public String name;
    public String avatarUrl;
    public String url;

    public UserInfo(long id, String name, String avatarUrl, String url){
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }
}
