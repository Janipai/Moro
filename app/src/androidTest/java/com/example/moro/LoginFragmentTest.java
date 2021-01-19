package com.example.moro;

import android.graphics.LinearGradient;
import android.util.Log;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.typeText;
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
import com.example.moro.Fragments.Login.Context;
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
 * Android test for the Login Fragment.
 * Primarily testing user login
 *
 * @note Thread.Sleep is again used to ensure a stable environment.
 *
 * @author Mads Hansen s195456
 */
@MediumTest
public class LoginFragmentTest {
    ActivityScenario<MainActivity> scenario;

    @Rule
    public ActivityScenarioRule<MainActivity> ruleActivity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void init() throws Exception {
        scenario = ruleActivity.getScenario();
        Thread.sleep(2000);
        scenario.onActivity(activity ->
                activity.replaceFragment(new LoginFragment()));
        Context.getInstance().setLogin(false);
    }

    @Test
    public void testLoginCorrectCredentials() throws Exception {
        Context test = Context.getInstance();
        onView(withId(R.id.emailLogin)).perform(typeText("mikkel@google.dk"));
        onView(withId(R.id.passwordLogin)).perform(typeText("123456"));
        onView(withId(R.id.buttonLogin)).perform(click());
        Thread.sleep(2000);
        assertTrue(test.isLogin());
    }

    @Test
    public void testLoginWrongCredentials() throws Exception {
        Context test = Context.getInstance();;
        onView(withId(R.id.emailLogin)).perform(typeText("dillermanden"));
        onView(withId(R.id.passwordLogin)).perform(typeText("654321"));
        onView(withId(R.id.buttonLogin)).perform(click());
        Thread.sleep(2000);
        assertFalse(test.isLogin());
    }
}