package com.example.latihanmvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract void onAttachView();
    protected abstract P createPresenter();
    protected abstract int getLayout();
    protected abstract void setup(Bundle savedInstanceState);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        presenter = createPresenter();
        setup(savedInstanceState);
        ButterKnife.bind(this);
        onAttachView();
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
}
