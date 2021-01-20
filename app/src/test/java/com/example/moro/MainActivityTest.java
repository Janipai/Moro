package com.example.moro;

import android.content.Intent;

import com.example.moro.Fragments.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;

import static org.junit.Assert.assertNotNull;

//@RunWith(JUnit4.class)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    /* Builds activity before running tests */
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class).
                create().
                resume().
                get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveHomeFragment() throws Exception {
        assertNotNull(activity.getSupportFragmentManager().findFragmentById(R.id.homeFragment));
    }

}