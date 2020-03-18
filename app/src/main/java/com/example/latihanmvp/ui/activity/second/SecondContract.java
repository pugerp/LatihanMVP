package com.example.latihanmvp.ui.activity.second;

import com.example.latihanmvp.ui._core.mvp.MvpView;

public interface SecondContract {
    interface View extends MvpView{
        void onSuccess(String employeeName);
        void onFailed(String message);
    }
    interface Presenter{
        void loadAllEmployee();
    }
}
