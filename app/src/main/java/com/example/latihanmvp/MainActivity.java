package com.example.latihanmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements MainContract.View {

    MainPresenter presenter;
    Button btnToast;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setup(Bundle savedInstanceState) {
        btnToast = findViewById(R.id.btnToast);
        presenter = new MainPresenter();
        onAttachView();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        buttonListener();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void showToast(String s) {
        showToastMessage(s);
    }

    void buttonListener(){
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doSomething();
            }
        });
    }



}
