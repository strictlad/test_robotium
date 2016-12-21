package com.learning.sample.robotiumtest.main;

/**
 * Created by Duc on 12/20/2016.
 */

public class MainModel implements MainProvidedModelOps{

    MainRequiredPresenterOps presenter;

    public MainModel(MainRequiredPresenterOps presenter){
        this.presenter = presenter;
    }

    @Override
    public void login() {
        presenter.clickLoginButtonResult();
    }
}
