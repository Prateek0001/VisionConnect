package com.prateek.visionconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.prateek.visionconnect.databinding.ActivityMainBinding;
import com.prateek.visionconnect.fragment.AddFragment;
import com.prateek.visionconnect.fragment.AddPostFragment;
import com.prateek.visionconnect.fragment.HomeFragment;
import com.prateek.visionconnect.fragment.NotificationFragment;
import com.prateek.visionconnect.fragment.ProfileFragment;
import com.prateek.visionconnect.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        MainActivity.this.setTitle("My Profile");
        binding.toolbar.setVisibility(View.GONE);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        //set HomeFragment as Default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    binding.toolbar.setVisibility(View.GONE);
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.notification:
                    binding.toolbar.setVisibility(View.GONE);
                    selectedFragment = new NotificationFragment();
                    break;
                case R.id.add:
                    binding.toolbar.setVisibility(View.GONE);
                    selectedFragment = new AddPostFragment();
                    break;
                case R.id.search:
                    binding.toolbar.setVisibility(View.GONE);
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.profile:
                    binding.toolbar.setVisibility(View.VISIBLE);
                    selectedFragment = new ProfileFragment();
                    break;

            }
            // It will help to replace the
            // one fragment to other.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }
}