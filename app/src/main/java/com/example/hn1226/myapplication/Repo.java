package com.example.hn1226.myapplication;

public class Repo {
    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        login = login.replace(",", "");
        return login + "\n";
    }

    public String getUser(){
        return "\n" + login;
    }

    public String getContribution(){
        return "\n" + contributions;
    }
}
