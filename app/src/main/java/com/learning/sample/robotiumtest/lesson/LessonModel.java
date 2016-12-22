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
        data.add(new Lesson("Chapter 1","Clean Code"));
        data.add(new Lesson("Chapter 2","Meaningful Names"));
        data.add(new Lesson("Chapter 3","Functions"));
        data.add(new Lesson("Chapter 4","Comments"));
        data.add(new Lesson("Chapter 5","Formatting"));
        data.add(new Lesson("Chapter 6","Objects and Data Structures"));
        data.add(new Lesson("Chapter 7","Error handling"));
        data.add(new Lesson("Chapter 8","Boundaries"));
        data.add(new Lesson("Chapter 9","Unit Tests"));
        data.add(new Lesson("Chapter 10","Classes"));

        presenter.loadDataResult(data);
    }

    @Override
    public void getLesson(int position) {
        presenter.clickLessonResult(data.get(position));
    }
}
