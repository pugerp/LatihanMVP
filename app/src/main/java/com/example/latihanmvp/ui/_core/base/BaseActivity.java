package com.example.latihanmvp.ui._core.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{

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
        onAttachView();
        setup(savedInstanceState);
    }

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

    public void showLoading() {
        hideLoading();
        progressDialog = ProgressDialog.show(this, null, "Loading, Please wait...", true);
    }

    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }
//
//    @Override
//    public void onFragmentAttach() {
//
//    }
//
//    @Override
//    public void onFragmentDetach(String tag) {
//
//    }
}
