package com.learning.sample.robotiumtest.lesson;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Duc on 12/20/2016.
 */

public interface LessonRequiredViewOps {
    Context getAppContext();
    Context getActivityContext();
    void selectLesson(Lesson lesson);
    void showLesson(ArrayList<Lesson> data);
}
