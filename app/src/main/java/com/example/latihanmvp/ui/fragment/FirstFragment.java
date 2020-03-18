package com.example.latihanmvp.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.latihanmvp.R;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.base.BaseFragment;

import butterknife.BindView;

public class FirstFragment extends BaseFragment<FirstPresenter> implements FirstContract.View {

    @BindView(R.id.text1)
    TextView text1;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    protected FirstPresenter createPresenter() {
        return new FirstPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void setup(View view) {
        presenter.getEmployee();
    }

    @Override
    protected void onAttachView() {
        presenter.onAttach(this);
    }

    public void onSuccess(EmployeeResp employeeResp) {
        text1.setText(employeeResp.getEmployeeName());
    }

    public void onFailed(String message) {
        Log.e("FAILEDREQ", "onFailed: "+message);
    }
}
