package com.example.latihanmvp;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {

    @Override
    public void doSomething() {
        mView.showToast("MVP Success !!");
    }
}
