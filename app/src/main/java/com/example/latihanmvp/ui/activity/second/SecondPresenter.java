package com.example.latihanmvp.ui.activity.second;

import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.network.model.PagingResponse;
import com.example.latihanmvp.network.model.employee.EmployeeResp;
import com.example.latihanmvp.ui.base.BasePresenter;

import retrofit2.Response;

public class SecondPresenter extends BasePresenter<SecondActivity> implements SecondContract.Presenter{

    NetworkInterface networkInterface;

    public SecondPresenter() {
        networkInterface = NetworkClient.getInstance().create(NetworkInterface.class);
    }

    @Override
    public void onAttach(SecondActivity view) {
        super.onAttach(view);
    }

    void loadAllEmployee() {
//        mView.showLoading();
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
//                mView.hideLoading();
            }
        });
    }
}
