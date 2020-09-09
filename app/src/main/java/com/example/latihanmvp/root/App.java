package com.example.latihanmvp.root;

import android.app.Application;

import com.example.latihanmvp.di.components.ApplicationComponent;
import com.example.latihanmvp.di.components.DaggerApplicationComponent;
import com.example.latihanmvp.di.modules.ApplicationModule;
import com.example.latihanmvp.di.modules.NetworkModule;
import com.orhanobut.hawk.Hawk;

import org.jetbrains.annotations.NotNull;

public class App extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        initDagger();
    }

    @NotNull
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();
    }
}
