package com.learning.sample.robotiumtest.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.learning.sample.robotiumtest.R;
import com.learning.sample.robotiumtest.lesson.LessonActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainRequiredViewOps{

    private MainProvidedPresenterOps providedPresenterOps;

    ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (ImageButton)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        setupMVP();
    }

    private void setupMVP(){
        MainPresenter presenter = new MainPresenter(this);
        MainModel model = new MainModel(presenter);
        presenter.setModel(model);
        providedPresenterOps = presenter;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_login){
            providedPresenterOps.clickLoginButtonRequest();
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

    public void login(){
        Intent phoneIntent = new Intent(MainActivity.this, LessonActivity.class);
        startActivity(phoneIntent);
    }

}
