package com.learning.sample.robotiumtest.main;

/**
 * Created by Duc on 12/22/2016.
 */

public class MainStateMaintainer {

    private static MainStateMaintainer instance;
    private MainProvidedPresenterOps presenter;

    private MainStateMaintainer() {

    }

    public static MainStateMaintainer getInstance() {
        if (instance == null) {
            instance = new MainStateMaintainer();
        }
        return instance;
    }

    public boolean checkExist() {
        if (presenter != null) {
            return true;
        }
        return false;
    }

    public MainProvidedPresenterOps getPresenter() {
        return presenter;
    }

    public void setPresenter(MainProvidedPresenterOps presenter) {
        this.presenter = presenter;
    }

}
