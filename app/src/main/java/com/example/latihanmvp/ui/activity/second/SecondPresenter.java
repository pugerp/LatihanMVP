package com.example.latihanmvp.ui.activity.second;

import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.data.model.PagingResponse;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.ui._core.base.BasePresenter;

public class SecondPresenter extends BasePresenter<SecondActivity> implements SecondContract.Presenter{

    NetworkInterface networkInterface;

    public SecondPresenter() {
        networkInterface = NetworkClient.getInstance().create(NetworkInterface.class);
    }

    void loadAllEmployee() {
        mView.showLoading();
        addSubscribe(networkInterface.getAllEmployess(), new NetworkCallback<PagingResponse<EmployeeResp>>() {
            @Override
            public void onSuccess(PagingResponse<EmployeeResp> model) {
                mView.setData(model.getData().get(0).getEmployeeName());
            }

            @Override
            public void onFailure(String message) {
                mView.failedReq(message);
            }

            @Override
            public void onFinish() {
                mView.hideLoading();
            }
        });
    }
}
