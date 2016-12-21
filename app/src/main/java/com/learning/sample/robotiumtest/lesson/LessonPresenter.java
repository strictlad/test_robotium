package com.learning.sample.robotiumtest.lesson;

import java.util.ArrayList;

/**
 * Created by Duc on 12/20/2016.
 */

public class LessonPresenter implements LessonProvidedPresenterOps, LessonRequiredPresenterOps{

    LessonRequiredViewOps view;
    LessonModel model;

    public LessonPresenter(LessonRequiredViewOps view){
        this.view = view;
    }

    public void setModel(LessonModel model){
        this.model = model;
    }

    @Override
    public void loadDataRequest() {
        model.loadData();
    }

    @Override
    public void clickLessonRequest(int position) {
        model.getLesson(position);
    }

    @Override
    public void loadDataResult(ArrayList<Lesson> data) {
        view.showLesson(data);
    }

    @Override
    public void clickLessonResult(Lesson lesson) {
        view.selectLesson(lesson);
    }
}
