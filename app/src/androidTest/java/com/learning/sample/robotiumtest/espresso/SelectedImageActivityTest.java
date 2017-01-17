package com.learning.sample.robotiumtest.espresso;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ImageView;

import com.learning.sample.robotiumtest.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


/**
 * Created by Duc on 1/17/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SelectedImageActivityTest {

    private Instrumentation.ActivityResult mActivityResult;

    @Rule
    public final ActivityTestRule<SelectedImageActivity> rule = new ActivityTestRule<SelectedImageActivity>(SelectedImageActivity.class);

    @Before
    public void setupImageUri(){
        Resources resources = InstrumentationRegistry.getTargetContext().getResources();
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources
                .getResourcePackageName(
                        R.mipmap.ic_launcher) + '/' + resources.getResourceTypeName(
                R.mipmap.ic_launcher) + '/' + resources.getResourceEntryName(
                R.mipmap.ic_launcher));
        Intent resultData = new Intent();
        resultData.setData(imageUri);
        mActivityResult = new Instrumentation.ActivityResult(
                Activity.RESULT_OK, resultData);
    }

    @Test
    public void testSelectImage() {

        //Check the image is not displayed
        onView(withId(R.id.imv_selected)).check(matches(not(hasDrawable())));

        //Setup the intent
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_PICK),
                hasData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
        intending(expectedIntent).respondWith(mActivityResult);

        //Click the select button
        onView(withId(R.id.btn_open_photo)).perform(click());
        intended(expectedIntent);
        Intents.release();

        //Check the image is displayed
        onView(withId(R.id.imv_selected)).check(matches(hasDrawable()));

    }

    public static BoundedMatcher<View, ImageView> hasDrawable() {
        return new BoundedMatcher<View, ImageView>(ImageView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has drawable");
            }

            @Override
            public boolean matchesSafely(ImageView imageView) {
                return imageView.getDrawable() != null;
            }
        };
    }

}
