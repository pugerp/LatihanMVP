package com.example.latihanmvp.ui.activity.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.latihanmvp.R;
import com.example.latihanmvp.ui.base.BaseActivity;

public class SecondActivity extends BaseActivity<SecondPresenter> implements SecondContract.View {

    public static void startActivity(Activity activity){
        activity.startActivity(new Intent(activity, SecondActivity.class));
    }

    @Override
    protected void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    protected SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void setup(Bundle savedInstanceState) {

    }
}
