package com.example.moro;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
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
        assertNotNull(ruleActivity);
    }

    @Test
    public void shouldHaveHomeFragment(){
        ActivityScenario<MainActivity> act = ruleActivity.getScenario();

//        act.onActivity(activity -> activity.getSupportFragmentManager().beginTransaction());
        FragmentScenario<HomeFragment> scenario = launchInContainer(HomeFragment.class);

        onView(withId(R.id.fragment_home)).check(matches(isDisplayed()));


    }

//    @Test
//    public void toolbarLoaded() {
//        onView(withId(R.id.top_navigation_toolbar));
//    }
//
//    @Test
//    public void navigationViewLoaded() {
//        onView(withId(R.id.bottom_navigation));
//    }
//
//    @Test
//    public void eventsLoaded() {
//        onView(withId(R.id.homeRecyclerview));
//    }

}
