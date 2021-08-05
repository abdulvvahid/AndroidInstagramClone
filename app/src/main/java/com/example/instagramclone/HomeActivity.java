package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.instagramclone.Fragments.Home.HomeFragment;
import com.example.instagramclone.Fragments.Like.LikeFragment;
import com.example.instagramclone.Fragments.Profile.ProfileFragment;
import com.example.instagramclone.Fragments.Search.SearchFragment;
import com.example.instagramclone.Fragments.Share.ShareFragment;
import com.example.instagramclone.Utils.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: ");

        setupBottomNavigationView();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: creating...");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewEx.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){

                    case R.id.ic_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.ic_search:
                        selectedFragment = new SearchFragment();
                        break;
                    case R.id.ic_share:
                        selectedFragment = new ShareFragment();
                        break;
                    case R.id.ic_notification:
                        selectedFragment = new LikeFragment();
                        break;
                    case R.id.ic_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        };
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }
}