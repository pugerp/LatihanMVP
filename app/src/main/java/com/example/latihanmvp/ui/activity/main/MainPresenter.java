package com.example.latihanmvp.ui.activity.main;

import androidx.annotation.NonNull;

import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.ui._core.base.BasePresenter;

import javax.inject.Inject;


public class MainPresenter extends BasePresenter<ActivityComponent, MainActivity> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void doSomething() {
        mView.showToast("MVP Success !!");
    }


    @Override
    public void setComponent(@NonNull ActivityComponent component) {
        component.inject(this);
    }
}
