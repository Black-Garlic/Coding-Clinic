package com.example.hn1226.myapplication;

public class Repo {
    String login;
    String html_url;

    int contributions;

    public String getUser(){
        return "\n" + login;
    }

    public String getContribution(){
        return "\n" + contributions;
    }
}
