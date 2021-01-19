package com.example.moro;

import android.app.Activity;

import com.example.moro.Fragments.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.android.AConfiguration;

import static org.junit.Assert.*;

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