package com.example.latihanmvp.ui.activity.third;

import androidx.annotation.NonNull;

import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.ui._core.base.BasePresenter;

import javax.inject.Inject;

public class ThirdPresenter extends BasePresenter<ActivityComponent, ThirdActivity> implements ThirdContract.Presenter {

    @Inject
    public ThirdPresenter() {
    }

    @Override
    public void setComponent(@NonNull ActivityComponent component) {
        component.inject(this);
    }
}
