package com.example.latihanmvp.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.latihanmvp.R;
import com.example.latihanmvp.data.model.employee.EmployeeResp;
import com.example.latihanmvp.di.components.FragmentComponent;
import com.example.latihanmvp.ui._core.base.BaseFragment;
import com.example.latihanmvp.ui.activity.second.SecondActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstFragment extends BaseFragment<FirstPresenter> implements FirstContract.View {

    @BindView(R.id.text1)
    TextView text1;

    public static FirstFragment newInstance() {
        return new FirstFragment();
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
    protected void setComponent(@NonNull FragmentComponent component) {
        component.inject(this);
        presenter.onAttach(this);
        presenter.setComponent(component);
    }

    public void onSuccess(EmployeeResp employeeResp) {
        text1.setText(employeeResp.getEmployeeName());
    }

    public void onFailed(String message) {
        Log.e("FAILEDREQ", "onFailed: " + message);
    }

    @OnClick(R.id.text1)
    public void onViewClicked() {
        SecondActivity.startActivity(getActivity());
    }
}
