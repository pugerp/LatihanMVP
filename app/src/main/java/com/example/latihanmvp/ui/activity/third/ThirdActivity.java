package com.example.latihanmvp.ui.activity.third;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.latihanmvp.R;
import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.ui._core.base.BaseActivity;

public class ThirdActivity extends BaseActivity<ThirdPresenter> implements ThirdContract.View {
    @Override
    protected int getLayout() {
        return R.layout.activity_third;
    }

    @Override
    protected void setup(Bundle savedInstanceState) {

    }

    @Override
    protected void setComponent(@NonNull ActivityComponent component) {
        component.inject(this);
        presenter.onAttach(this);
        presenter.setComponent(component);
    }
}
