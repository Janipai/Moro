package com.example.moro;

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
import com.example.moro.Fragments.MainActivity;
import com.google.android.gms.dynamic.SupportFragmentWrapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.fragment.app.testing.FragmentScenario.launch;
import static androidx.fragment.app.testing.FragmentScenario.launchInContainer;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityTest {

    /* Builds activity before running tests */
    @Rule
    public ActivityScenarioRule<MainActivity> ruleActivity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void init() {
    }

    @Test
    public void shouldNotBeNull() {
        onView(withId(R.id.mainLayout));
    }

    @Test
    public void shouldHaveHomeFragment() throws Exception {
//        ActivityScenario<MainActivity> act = ruleActivity.getScenario();
        // Have to sleep to ensure the fragment have been attached
        Thread.sleep(1000);
        onView(withId(R.id.fragment_home));
    }

    @Test
    public void eventRightNowRecyclerInteractable() throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.homeRecyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(0, swipeRight()));
        onView(withId(R.id.homeRecyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void eventsRecyclerInteractable() throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.eventlistview)).perform(RecyclerViewActions.actionOnItemAtPosition(0,swipeDown())).perform(click());

    }
}
