package com.example.latihanmvp.ui.activity.second;

import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.ui._core.mvp.MvpView;

public interface SecondContract {
    interface View extends MvpView{
        void onSuccess(EmployeeResp employee);
        void onFailed(String message);
    }
    interface Presenter{
        void loadAllEmployee();
    }
}
