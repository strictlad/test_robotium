package com.learning.sample.robotiumtest.lesson;

/**
 * Created by Duc on 12/20/2016.
 */

public interface LessonProvidedPresenterOps {
    void setView(LessonRequiredViewOps view);
    void loadDataRequest();
    void clickLessonRequest(int position);
}
