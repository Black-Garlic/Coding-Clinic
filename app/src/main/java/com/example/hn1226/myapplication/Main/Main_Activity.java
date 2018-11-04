package com.example.hn1226.myapplication.Main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hn1226.myapplication.Feed.Feed_Fragment;
import com.example.hn1226.myapplication.Friend.Friend_Fragment;
import com.example.hn1226.myapplication.Intro.Intro_Activity;
import com.example.hn1226.myapplication.Profile.Profile_Fragment;
import com.example.hn1226.myapplication.R;
import com.example.hn1226.myapplication.Upload.Upload_Fragment;

public class Main_Activity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbarSetting();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.home_fragment, new Feed_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Home");
                    return true;
                case R.id.navigation_upload:
                    fragmentTransaction.replace(R.id.home_fragment, new Upload_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Upload");
                    return true;
                case R.id.navigation_friend:
                    fragmentTransaction.replace(R.id.home_fragment, new Friend_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Friend");
                    return true;
                case R.id.navigation_profile:
                    fragmentTransaction.replace(R.id.home_fragment, new Profile_Fragment());
                    fragmentTransaction.commit();
                    toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    private void toolbarSetting(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Intro_Activity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "저장 버튼이 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_setting:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "설정 버튼이 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }
}