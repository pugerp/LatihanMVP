package com.example.latihanmvp.ui.fragment;

import androidx.annotation.NonNull;

import com.example.latihanmvp.data.model.PagingResponse;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.di.components.FragmentComponent;
import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.base.BasePresenter;

import javax.inject.Inject;

public class FirstPresenter extends BasePresenter<FragmentComponent, FirstFragment> implements FirstContract.Presenter {

    @Inject
    public FirstPresenter() {
    }

    public void getEmployee() {
        mView.showLoading();
        addSubscribe(networkInterface.getAllEmployess(), new NetworkCallback<PagingResponse<EmployeeResp>>() {
            @Override
            public void onSuccess(PagingResponse<EmployeeResp> model) {
                mView.onSuccess(model.getData().get(0));
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
    public void setComponent(@NonNull FragmentComponent component) {
        component.inject(this);
    }
}
