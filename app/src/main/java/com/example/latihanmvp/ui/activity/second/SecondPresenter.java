package com.example.latihanmvp.ui.activity.second;

import androidx.annotation.NonNull;

import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.data.model.PagingResponse;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.ui._core.base.BasePresenter;

import javax.inject.Inject;

public class SecondPresenter extends BasePresenter<ActivityComponent, SecondActivity> implements SecondContract.Presenter{

    @Inject
    public SecondPresenter() {
    }

    @Override
    public void loadAllEmployee() {
        mView.showLoading();
        addSubscribe(networkInterface.getAllEmployess(), new NetworkCallback<PagingResponse<EmployeeResp>>() {
            @Override
            public void onSuccess(PagingResponse<EmployeeResp> model) {
                mView.onSuccess(model.getData());
            }

            @Override
            public void onFailure(String message) {
                mView.onFailed(message);
            }

            @Override
            public void onFinish() {
                mView.hideLoading();
            }
        });
    }


    @Override
    public void setComponent(@NonNull ActivityComponent component) {
        component.inject(this);
    }
}
