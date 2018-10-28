package com.example.hn1226.myapplication;

import com.google.gson.annotations.SerializedName;

public class Repo {
    private long id;

    @SerializedName("login")
    private String name;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("html_url")
    private String url;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
