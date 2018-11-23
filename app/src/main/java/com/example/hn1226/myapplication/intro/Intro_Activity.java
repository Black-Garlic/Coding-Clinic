package com.example.hn1226.myapplication.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hn1226.myapplication.main.Main_Activity;
import com.example.hn1226.myapplication.R;


public class Intro_Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        imageView = (ImageView)findViewById(R.id.logoIcon);

        button = (Button)findViewById(R.id.button);
    }

    public void ButtonClick(View v){
        Intent second = new Intent(this, Main_Activity.class);

        switch (v.getId()){
            case R.id.button :
                startActivity(second);
                break;
        }
    }
}