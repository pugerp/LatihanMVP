package com.example.latihanmvp.ui._core.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.mvp.MvpView;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MvpView, BaseFragment.Callback{

    private ProgressDialog progressDialog;
    protected P presenter;
    protected abstract void onAttachView();
    protected abstract P createPresenter();
    protected abstract int getLayout();
    protected abstract void setup(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        presenter = createPresenter();
        presenter.setNetworkInterface(NetworkClient.getInstance().create(NetworkInterface.class));
        onAttachView();
        setup(savedInstanceState);
    }

    @Override
    public void showToastMessage(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDetach();
        presenter.onUnsubscribe();
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = ProgressDialog.show(this, null, "Loading, Please wait...", true);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void onFragmentAttach() {

    }

    @Override
    public void onFragmentDetach(String tag) {

    }
}
