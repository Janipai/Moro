package com.example.moro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.moro.EventHandler.EventFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment home = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, home).commit();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationView topNav = findViewById(R.id.top_navigation);

        topNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.top_nav_profile:
                        selectedFragment = new LoginFragment();
                        break;
                    case R.id.top_nav_search:
                        //selectedFragment = new SearchFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, selectedFragment).addToBackStack(null).commit();
                return true;
            }
        });

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.bot_nav_events:
                        selectedFragment = new EventFragment();
                        break;
                    case R.id.bot_nav_favorite:
                        //selectedFragment = new FavoriteFragment();
                        break;
                    case R.id.bot_nav_menu:
                        selectedFragment = new BurgerMenuFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, selectedFragment).addToBackStack(null).commit();
                return true;
            }
        });
    }
}