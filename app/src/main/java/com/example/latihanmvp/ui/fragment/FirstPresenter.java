package com.example.latihanmvp.ui.fragment;

import com.example.latihanmvp.data.model.PagingResponse;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.base.BasePresenter;

public class FirstPresenter extends BasePresenter<FirstFragment> implements FirstContract.Presenter {

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
}
