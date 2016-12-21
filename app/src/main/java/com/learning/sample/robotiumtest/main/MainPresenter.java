package com.learning.sample.robotiumtest.main;

/**
 * Created by Duc on 12/20/2016.
 */

public class MainPresenter implements MainProvidedPresenterOps, MainRequiredPresenterOps{

    private MainRequiredViewOps view;
    private MainProvidedModelOps model;

    public MainPresenter(MainRequiredViewOps view){
        this.view = view;
    }

    public void setModel(MainProvidedModelOps model){
        this.model = model;
    }

    @Override
    public void clickLoginButtonRequest() {
        model.login();
    }

    @Override
    public void clickLoginButtonResult() {
        view.login();
    }
}
