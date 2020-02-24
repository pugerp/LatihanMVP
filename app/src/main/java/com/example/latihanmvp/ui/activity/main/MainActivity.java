package com.example.latihanmvp.ui.activity.main;

import android.os.Bundle;

import com.example.latihanmvp.R;
import com.example.latihanmvp.ui.base.BaseActivity;
import com.example.latihanmvp.ui.activity.second.SecondActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setup(Bundle savedInstanceState) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void showToast(String s) {
        showToastMessage(s);
        SecondActivity.startActivity(this);
    }

    @OnClick(R.id.btnToast)
    public void onViewClicked() {
        presenter.doSomething();
    }
}
