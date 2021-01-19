package com.example.moro;
import android.content.Context;
import android.graphics.LinearGradient;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.moro.Fragments.EventHandler.EventFragment;
import com.example.moro.Fragments.HomeFragment;
import com.example.moro.Fragments.Login.LoginFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.facebook.login.Login;
import com.google.android.gms.dynamic.SupportFragmentWrapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.fragment.app.testing.FragmentScenario.launch;
import static androidx.fragment.app.testing.FragmentScenario.launchInContainer;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

/**
 * Android test for the Event Fragment
 * Testing events, layout switch and & search function
 *
 * @note Thread.Sleep is again used to ensure a stable environment.
 *
 * @author Mads Hansen s195456
 */

public class EventFragmentTest {
    ActivityScenario<MainActivity> scenario;


    @Rule
    public ActivityScenarioRule<MainActivity> ruleActivity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        scenario = ruleActivity.getScenario();
        Thread.sleep(1500);
        scenario.onActivity(activity ->
                activity.replaceFragment(new EventFragment()));

    }

    @Test
    public void layoutSwitchListLayout() {
        onView(withId(R.id.rigthNowListButton)).perform(click());
        assertEquals(1, event.testingLayoutInRecycler());
    }

    @Test
    public void layoutSwitchGridLayout() {
        onView(withId(R.id.rigthNowGridButton)).perform(click());
        assertEquals(2, event.testingLayoutInRecycler());
    }
}
