package com.learning.sample.robotiumtest;

import android.test.ActivityInstrumentationTestCase2;

import com.learning.sample.robotiumtest.lesson.LessonActivity;
import com.learning.sample.robotiumtest.main.MainActivity;
import com.robotium.solo.Solo;

/**
 * Created by duc on 12/20/2016.
 */

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private Solo solo;

	public MainTest() {
		super(MainActivity.class);
	}

	public void setUp() throws Exception{
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

	public void testLogin() throws Exception{
		solo.unlockScreen();
		solo.assertCurrentActivity("wrong activity", MainActivity.class);
		solo.sleep(5000);
		solo.clickOnView(solo.getView(R.id.btn_login));
		solo.assertCurrentActivity("wrong activity", LessonActivity.class);
		solo.sleep(3000);
		solo.clickInList(3);
		solo.sleep(5000);
	}
}
