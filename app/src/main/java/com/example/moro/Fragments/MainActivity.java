package com.example.moro.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.moro.Fragments.BurgerMenu.BurgerMenuFragment;
import com.example.moro.Fragments.EventHandler.EventFragment;
import com.example.moro.Fragments.Login.Context;
import com.example.moro.Fragments.Login.FavouritesFragment;
import com.example.moro.Fragments.Login.LoginFragment;
import com.example.moro.Fragments.Login.MyProfile;
import com.example.moro.Fragments.Login.NotLoginState;
import com.example.moro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity    extends AppCompatActivity {

    Context ctx = Context.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment home = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, home).commit();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationView topNav = findViewById(R.id.top_navigation);

        topNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.top_nav_profile:
                    if (ctx.getStates().equals(new NotLoginState())){
                        selectedFragment = new LoginFragment();
                    }else
                        selectedFragment = new MyProfile();
                    break;
                case R.id.top_nav_search:
                    //selectedFragment = new SearchFragment();
                    break;
            }
            if (selectedFragment == null)
                return true;
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, selectedFragment).addToBackStack(null).commit();
            replaceFragment(selectedFragment);
            return true;
        });

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.bot_nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bot_nav_events:
                    selectedFragment = new EventFragment();
                    break;
                case R.id.bot_nav_favorite:
                    selectedFragment = new FavouritesFragment();
                    break;
                case R.id.bot_nav_menu:
                    selectedFragment = new BurgerMenuFragment();
                    break;
            }
            if (selectedFragment == null)
                return true;

            replaceFragment(selectedFragment);
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, selectedFragment).addToBackStack(null).commit();

            return true;
        });

    }

    public void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0); //POP kan være 0

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped){ //fragment not in back stack, create it.
            ft.replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}