package com.example.hn1226.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.ArrayList;

public class Bottom_navigation extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbar;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.home_fragment, new MainFragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Home");
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction.replace(R.id.home_fragment, new Feed_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Feed");
                    return true;
                case R.id.navigation_notifications:
                    fragmentTransaction.replace(R.id.home_fragment, new Profile_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    private void setRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<GameInfo> gameInfoArrayList = new ArrayList<>();
        gameInfoArrayList.add(new GameInfo(R.drawable.image_01, "League of Legends"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_02, "Maple Story"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_03, "Star Craft"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_04, "Kart Rider"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_05, "Enter the Gungeon"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_06, "The binding of Issac Rebirth"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_07, "TEKKEN 7"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_08, "DARK SOULS 3"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_09, "Hearth Stones"));
        gameInfoArrayList.add(new GameInfo(R.drawable.image_10, "Mabinogi"));

        MyAdapter myAdapter = new MyAdapter(gameInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);
    }

}


