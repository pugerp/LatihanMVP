package com.example.latihanmvp;

public interface MainContract {
    interface View extends MvpView{
        void showToast(String s);
    }
    interface Presenter{
        void doSomething();
    }
}
