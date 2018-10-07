package com.example.hn1226.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView JavacodeTextview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
/*
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/
        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_a,new MainFragment());
        fragmentTransaction.commit();
        */
    }

    public void ButtonClick(View v){
        Intent second = new Intent(this, Bottom_navigation.class);
        int stuNum = 21500453;
        String mail = "hn1226@naver.com";
        String phoneNum = "010-2644-1226";

        switch (v.getId()){
            case R.id.button1 :
                startActivity(second
                        .putExtra("stuNum", stuNum)
                        .putExtra("mail", mail)
                        .putExtra("phoneNum", phoneNum));
                break;
        }
    }
}
