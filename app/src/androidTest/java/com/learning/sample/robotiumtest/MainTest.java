package com.learning.sample.robotiumtest;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

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
		solo.sleep(1000);
		solo.clickOnView(solo.getView(R.id.btn_login));
		solo.sleep(1000);
//		solo.assertCurrentActivity("wrong activity", MainActivity.class);
//		solo.assertCurrentActivity("wrong activity", LessonActivity.class);
//		solo.assertCurrentActivity("wrong activity", MainActivity.class);
		clickToItem("Unit Tests");
		solo.sleep(1000);

		takeScreenShot();



	}

	public void clickToItem(String s){
		ListView list = (ListView) solo.getView(R.id.lv_lesson);
		for(int i=0; i < list.getAdapter().getCount(); i++){
			View view = getViewAtIndex(list, i, getInstrumentation());
			TextView txtItem_lesson_content = (TextView) view.findViewById(R.id.item_lesson_content);
			if (txtItem_lesson_content.getText().equals(s)){
				solo.clickOnView(view);
				solo.sleep(3000);
				solo.clickOnView(view.findViewById(R.id.btn1));
			}
		}
	}

	public View getViewAtIndex(final ListView listElement, final int indexInList, Instrumentation instrumentation) {
		if (listElement != null) {
			if (indexInList <= listElement.getAdapter().getCount()) {
				scrollListTo(listElement, indexInList, instrumentation);
				int indexToUse = indexInList - listElement.getFirstVisiblePosition();
				return listElement.getChildAt(indexToUse);
			}
		}
		return null;
	}

	public <T extends AbsListView> void scrollListTo(final T listView,
													 final int index, Instrumentation instrumentation) {
		instrumentation.runOnMainSync(new Runnable() {
			@Override
			public void run() {
				listView.setSelection(index);
			}
		});
		instrumentation.waitForIdleSync();
	}

	private void takeScreenShot(){
		solo.takeScreenshot("Robotium"+screenShotCount);
		screenShotCount++;
	}
}
