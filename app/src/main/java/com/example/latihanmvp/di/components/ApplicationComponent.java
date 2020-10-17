package com.example.latihanmvp.di.components;

import android.content.Context;

import com.example.latihanmvp.di.annotations.AppContext;
import com.example.latihanmvp.di.modules.ApplicationModule;
import com.example.latihanmvp.di.modules.NetworkModule;
import com.example.latihanmvp.network.NetworkInterface;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class, NetworkModule.class})
@Singleton
public interface ApplicationComponent {

    @AppContext
    Context getContext();
    NetworkInterface getNetworkInterface();

}
