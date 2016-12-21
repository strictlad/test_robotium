package com.learning.sample.robotiumtest.lesson;

import java.util.ArrayList;

/**
 * Created by Duc on 12/20/2016.
 */

public class LessonModel implements LessonProvidedModelOps{

    private LessonRequiredPresenterOps presenter;
    private ArrayList<Lesson> data;

    public LessonModel(LessonRequiredPresenterOps presenter){
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        data = new ArrayList<Lesson>();
        data.add(new Lesson("Bai 1","No description"));
        data.add(new Lesson("Bai 2","No description"));
        data.add(new Lesson("Bai 3","No description"));
        data.add(new Lesson("Bai 4","No description"));
        data.add(new Lesson("Bai 5","No description"));
        data.add(new Lesson("Bai 6","No description"));
        data.add(new Lesson("Bai 7","No description"));
        data.add(new Lesson("Bai 8","No description"));
        data.add(new Lesson("Bai 9","No description"));
        data.add(new Lesson("Bai 10","No description"));

        presenter.loadDataResult(data);
    }

    @Override
    public void getLesson(int position) {
        presenter.clickLessonResult(data.get(position));
    }
}
