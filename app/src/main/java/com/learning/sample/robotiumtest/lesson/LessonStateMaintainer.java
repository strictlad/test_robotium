package com.learning.sample.robotiumtest.lesson;

/**
 * Created by Duc on 12/22/2016.
 */

public class LessonStateMaintainer {
    private static LessonStateMaintainer instance;
    private LessonProvidedPresenterOps presenter;

    private LessonStateMaintainer() {

    }

    public static LessonStateMaintainer getInstance() {
        if (instance == null) {
            instance = new LessonStateMaintainer();
        }
        return instance;
    }

    public boolean checkExist() {
        if (presenter != null) {
            return true;
        }
        return false;
    }

    public LessonProvidedPresenterOps getPresenter() {
        return presenter;
    }

    public void setPresenter(LessonProvidedPresenterOps presenter) {
        this.presenter = presenter;
    }
}
