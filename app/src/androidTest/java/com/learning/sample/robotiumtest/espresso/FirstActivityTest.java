package com.learning.sample.robotiumtest.espresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.learning.sample.robotiumtest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FirstActivityTest {

    @Rule
    public ActivityTestRule<FirstActivity> mActivityTestRule = new ActivityTestRule<>(FirstActivity.class);

    @Test
    public void firstActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.inputField), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.inputField), isDisplayed()));
        appCompatEditText2.perform(replaceText("vidu"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.switchActivity), withText("Change text"), isDisplayed()));
        appCompatButton.perform(click());

        pressBack();

    }

}
