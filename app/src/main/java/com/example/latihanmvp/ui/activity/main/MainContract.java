package com.example.latihanmvp.ui.activity.main;

import com.example.latihanmvp.MvpView;

public interface MainContract {
    interface View extends MvpView {
        void showToast(String s);
    }
    interface Presenter{
        void doSomething();
    }
}
