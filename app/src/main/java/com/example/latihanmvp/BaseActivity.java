package com.example.latihanmvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

public abstract class BaseActivity extends Activity {
    protected abstract int getLayout();
    protected abstract void setup(Bundle savedInstanceState);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setup(savedInstanceState);
    }

    public void showToastMessage(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
