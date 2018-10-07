package com.example.hn1226.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {

    TextView JavacodeTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        JavacodeTextview = (TextView)findViewById(R.id.xmlTextview);


        Intent content = getIntent();

        JavacodeTextview.setText(
                "Name = " + getResources().getString(R.string.myName)+
                        "\nStuNum = " + content.getExtras().getInt("stuNum")+
                        "\nMail = " + content.getExtras().getString("mail")+
                        "\nPhone = " + content.getExtras().getString("phoneNum")
        );

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_a,new MainFragment());
        fragmentTransaction.commit();
    }
}