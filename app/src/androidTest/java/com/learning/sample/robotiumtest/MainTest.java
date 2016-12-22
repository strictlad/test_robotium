package com.learning.sample.robotiumtest;

import android.test.ActivityInstrumentationTestCase2;

import com.learning.sample.robotiumtest.lesson.Lesson;
import com.learning.sample.robotiumtest.lesson.LessonActivity;
import com.learning.sample.robotiumtest.main.MainActivity;
import com.robotium.solo.Solo;

/**
 * Created by duc on 12/20/2016.
 */

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private Solo solo;
	private int screenShotCount = 0;

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
		takeScreenShot();
		solo.sleep(5000);
		solo.clickOnView(solo.getView(R.id.btn_login));
		solo.assertCurrentActivity("wrong activity", LessonActivity.class);
		solo.waitForActivity(LessonActivity.class);
		solo.sleep(3000);
		takeScreenShot();
		solo.clickInList(3);
		takeScreenShot();
		solo.sleep(5000);
	}

	private void takeScreenShot(){
		solo.takeScreenshot("Robotium"+screenShotCount);
		screenShotCount++;
	}
}
