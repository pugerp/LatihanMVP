package com.example.latihanmvp.ui.activity.main;

import com.example.latihanmvp.ui.base.BasePresenter;


public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {

    public MainPresenter() {

    }

    @Override
    public void doSomething() {
        mView.showToast("MVP Success !!");
    }
}
