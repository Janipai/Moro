package com.example.moro;


import androidx.lifecycle.Lifecycle;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.example.moro.Fragments.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityTest {

    /* Builds activity before running tests */
    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void init() {
        activity.getScenario().moveToState(Lifecycle.State.CREATED);
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveHomeFragment(){
        assertNotNull(Espresso.onView(ViewMatchers.withId(R.id.homeFragment)));
    }

}
