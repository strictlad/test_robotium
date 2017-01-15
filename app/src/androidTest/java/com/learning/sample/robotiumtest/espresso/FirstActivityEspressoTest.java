package com.learning.sample.robotiumtest.espresso;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.learning.sample.robotiumtest.R;
import com.learning.sample.robotiumtest.espresso.FirstActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Duc on 1/15/2017.
 */

@RunWith(AndroidJUnit4.class)
public class FirstActivityEspressoTest {

    @Rule
    public ActivityTestRule<FirstActivity> mActivityRule = new ActivityTestRule<FirstActivity>(FirstActivity.class);

    @Test
    public void ensureTextChangesWork(){

        // type text and the press the button
        onView(ViewMatchers.withId(R.id.inputField)).perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());

        // check that the text was changed
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

    @Test
    public void changeText_newActivity(){
        // type text and then press the button
        onView(withId(R.id.inputField)).perform(typeText("NewText"), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        // this view is in a different Activity, no need to tell Espresso
        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
    }

}
