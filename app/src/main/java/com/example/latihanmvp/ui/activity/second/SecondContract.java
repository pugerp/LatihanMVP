package com.example.latihanmvp.ui.activity.second;

import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.ui._core.mvp.MvpView;

import java.util.List;

public interface SecondContract {
    interface View extends MvpView{
        void onSuccess(List<EmployeeResp> employees);
        void onFailed(String message);
    }
    interface Presenter{
        void loadAllEmployee();
    }
}
