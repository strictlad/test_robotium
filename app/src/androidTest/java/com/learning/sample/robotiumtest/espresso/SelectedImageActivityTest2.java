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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SelectedImageActivityTest2 {

    @Rule
    public ActivityTestRule<SelectedImageActivity> mActivityTestRule = new ActivityTestRule<>(SelectedImageActivity.class);

    @Test
    public void selectedImageActivityTest2() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_open_photo), withText("Choose image from gallery"),
                        withParent(allOf(withId(R.id.activity_selected_image),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        pressBack();

    }

}
