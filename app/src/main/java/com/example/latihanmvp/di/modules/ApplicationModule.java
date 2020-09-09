package com.example.latihanmvp.di.modules;

import android.content.Context;

import com.example.latihanmvp.di.annotation.AppContext;
import com.example.latihanmvp.root.App;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    final App app;

    public ApplicationModule(@NotNull App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @AppContext
    Context provideContext() {
        return this.app;
    }
}
