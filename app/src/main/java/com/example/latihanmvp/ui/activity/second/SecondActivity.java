package com.example.latihanmvp.ui.activity.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.latihanmvp.R;
import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.base.BaseActivity;

import butterknife.BindView;

public class SecondActivity extends BaseActivity<SecondPresenter> implements SecondContract.View {

    @BindView(R.id.name)
    TextView name;

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, SecondActivity.class));
    }

    @Override
    protected SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    protected void setup(Bundle savedInstanceState) {
        presenter.loadAllEmployee();
    }

    @Override
    public void onSuccess(String employeeName) {
        name.setText(employeeName);
    }

    @Override
    public void onFailed(String message) {
        Log.d("CHECKFAILED", "failedReq: " + message);
    }
}
