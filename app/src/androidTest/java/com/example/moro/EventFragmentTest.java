package com.example.moro;

import androidx.fragment.app.testing.FragmentScenario;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static org.junit.Assert.*;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.MediumTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.moro.Fragments.EventHandler.EventFragment;
import com.example.moro.Fragments.MainActivity;

import java.util.concurrent.atomic.AtomicInteger;

import static androidx.fragment.app.testing.FragmentScenario.launch;
import static androidx.fragment.app.testing.FragmentScenario.launchInContainer;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

/**
 * Android test for the Event Fragment
 * Testing events, layout switch
 *
 * @note Thread.Sleep is again used to ensure a stable environment.
 *
 * @author Mads Hansen s195456
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@MediumTest
public class EventFragmentTest {
    ActivityScenario<MainActivity> scenario;


    @Rule
    public ActivityScenarioRule<MainActivity> ruleActivity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        scenario = ruleActivity.getScenario();
        Thread.sleep(1500);
        onView(withId(R.id.bot_nav_events)).perform(click());
        Thread.sleep(1500);
    }

    @Test
    public void layoutSwitchListLayout() {
        onView(withId(R.id.rigthNowGridButton)).perform(click());
        onView(withId(R.id.rigthNowListButton)).perform(click());
        onView(withId(R.id.rigthNowrecyclerview)).perform(click());
    }

    @Test
    public void layoutSwitchGridLayout() throws Exception {
        onView(withId(R.id.rigthNowGridButton)).perform(click());
//        Thread.sleep(1000);
        onView(withId(R.id.rigthNowrecyclerview)).perform(RecyclerViewActions.scrollToPosition(7)).perform(click());
    }
}
