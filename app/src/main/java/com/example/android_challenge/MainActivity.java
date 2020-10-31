package com.example.android_challenge;

import android.os.Bundle;
import android.view.MenuItem;
//import android.widget.Toolbar;

import com.example.android_challenge.Fragments.DownloadFragment;
import com.example.android_challenge.Fragments.ExploreFragment;
import com.example.android_challenge.Fragments.HomeFragment;
import com.example.android_challenge.Fragments.HubFragment;
import com.example.android_challenge.Fragments.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
   private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch(menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment=new HomeFragment();
                            break;
                        case R.id.explore:
                            selectedFragment=new ExploreFragment();
                            break;
                        case R.id.studypage:
                            selectedFragment=new StudyFragment();
                            break;

                        case R.id.downloads:
                            selectedFragment=new DownloadFragment();
                            break;

                        case R.id.hub:
                            selectedFragment=new HubFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;

                }
            };


}