package com.example.moro.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.moro.BuildConfig;
import com.example.moro.Data.DAO.EventDAO;
import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.Fragments.BurgerMenu.BurgerMenuFragment;
import com.example.moro.Fragments.EventHandler.EventFragment;
import com.example.moro.Fragments.Login.Context;
import com.example.moro.Fragments.Login.LoginState;
import com.example.moro.Fragments.Login.NotLoginState;
import com.example.moro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import io.sentry.android.core.SentryAndroid;

import static androidx.lifecycle.Lifecycle.State.RESUMED;
import static androidx.lifecycle.Lifecycle.State.STARTED;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public  static final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Context ctx = Context.getInstance();
    public static ProfileDTO userProfile;
    public static ArrayList<EventDTO> favouritesEvents;
    ArrayList<EventDTO> events;

    public static MainActivity activity;
    ProfileDAO dao = new ProfileDAO();
    BottomNavigationView bottomNav;
    Toolbar topNav;
    SearchView searchView;
    MenuItem searchItem;
    boolean isLoaded = false;
    boolean RUNSONPHONE = Build.PRODUCT.contains("sdk"); //|| Build.MODEL.contains("Emulator");

    public ArrayList<EventDTO> getFavouritesEvents() {
        return favouritesEvents;
    }
    public ArrayList<EventDTO> getAllEvents() {
        return events;
    }
    public void updateFav(){
        favouritesEvents = userProfile.getProfileFavourites();
    }
    public void setEvents(ArrayList<EventDTO> list) {
        System.out.println(list.size());
        events = list;
    }

    public static ProfileDTO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(ProfileDTO profile) {
        userProfile = profile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        replaceFragment(new HomeFragment());

        activity = this;

         /**
         *  Sentry Error tracking initialization
         * @author Mads H.
         */
        SentryAndroid.init(this, options -> {
            options.setDsn("https://5c95bc18ac2347c1a654c669e48ee273@o503098.ingest.sentry.io/5587708");
            options.setBeforeSend(((event, hint) -> {
                /* If run in debug, dont report events */
                if (BuildConfig.DEBUG) {
                    return null;
                } else
                    return event;
            }));
            /* Sets environment */
            if (RUNSONPHONE) {
                options.setEnvironment("PHONE");
            } else {
                options.setEnvironment("EMULATOR");
            }
        });
    }

     /** @author Mads H
     * Sets the menu for top nav to the custom search menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_navigation, menu);
        menu.findItem(R.id.menu_top_nav_search).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_top_nav_profile:
                ctx.profilePressed(getSupportFragmentManager());
                break;
        }
        return true;
    }

    /** @author Mads H.
     * On back press not going to whitescreen from Home fragment.
     */
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * @author Mikkel Johansen s175194
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //mAuth.signOut();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Context context = Context.getInstance();
        if (currentUser == null) {
            Log.d(TAG, "onStart: no user logged in");
            context.setState(new NotLoginState());
            favouritesEvents = new ArrayList<>();
            getEvents();
        } else {
            Log.d(TAG, "onStart: " + currentUser.getUid() + " is logged in");
            context.setState(new LoginState());
            dao.findUserInit(mAuth.getUid(), this);
            //favouritesEvents =
        }
    }

    /** @author Mads H, Shania H */
    public void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0); //POP kan være 0

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped) { //fragment not in back stack, create it.

            ft.setCustomAnimations(R.anim.enter_right_to_left,
                    R.anim.exit_right_to_left,
                    R.anim.enter_left_to_right,
                    R.anim.exit_left_to_right);

            ft.replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
    /**
     * @author Mikkel Johansen s175194
     */
    public void getEvents(){
        EventDAO con = EventDAO.getInstance();
        if(mAuth.getCurrentUser() != null)
            favouritesEvents = userProfile.getProfileFavourites();
        if (favouritesEvents == null)
            favouritesEvents = new ArrayList<>();
        con.getAllEvents(this);
    }
    /**
     * @author Mikkel Johansen s175194
     */
    public void initializingDone() {
        if (getLifecycle().getCurrentState().isAtLeast(STARTED)) {
            replaceFragment(new HomeFragment());

            if (getLifecycle().getCurrentState().isAtLeast(RESUMED)) {
                bottomNav = findViewById(R.id.bottom_navigation);
                topNav = findViewById(R.id.top_navigation_toolbar);
                setSupportActionBar(topNav);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                topNav.setNavigationIcon(null);


                bottomNav.setOnNavigationItemSelectedListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.bot_nav_home:
                            replaceFragment(new HomeFragment());
                            return true;
                        case R.id.bot_nav_events:
                            replaceFragment(new EventFragment());
                            return true;
                        case R.id.bot_nav_favorite:
                            //henvises til login fragment, hvis ikke man er logget in
                            ctx.favouritFragment(getSupportFragmentManager());
                            return true;
                        case R.id.bot_nav_menu:
                            replaceFragment(new BurgerMenuFragment());
                            return true;
                        default:
                            return true;
                    }
                });
            }
        }
        isLoaded = true;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}