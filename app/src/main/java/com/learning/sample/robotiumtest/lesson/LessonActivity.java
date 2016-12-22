package com.learning.sample.robotiumtest.lesson;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.learning.sample.robotiumtest.R;
import com.learning.sample.robotiumtest.main.MainStateMaintainer;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity implements LessonRequiredViewOps {

    ListView lvLesson;
    LessonAdapter adapter;

    LessonProvidedPresenterOps providedPresenterOps;
    private LessonStateMaintainer stateMaintainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initStateMaintainer();
        setupMVP();
        lvLesson = (ListView) findViewById(R.id.lv_lesson);
        lvLesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                providedPresenterOps.clickLessonRequest(i);
            }
        });
        providedPresenterOps.loadDataRequest();
    }

    private void initStateMaintainer() {
        stateMaintainer = LessonStateMaintainer.getInstance();
    }

    private void setupMVP() {
        if (stateMaintainer.checkExist()) {
            providedPresenterOps = stateMaintainer.getPresenter();
        } else {
            LessonPresenter presenter = new LessonPresenter(this);
            LessonModel model = new LessonModel(presenter);
            presenter.setModel(model);
            providedPresenterOps = presenter;
            stateMaintainer.setPresenter(presenter);
        }
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void selectLesson(Lesson lesson) {
        Toast.makeText(getApplicationContext(), "Start with " + lesson.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLesson(ArrayList<Lesson> data) {
        adapter = new LessonAdapter(this, data);
        lvLesson.setAdapter(adapter);
    }
}