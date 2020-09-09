package com.example.latihanmvp.di.modules;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latihanmvp.di.annotation.ActivityContext;
import com.example.latihanmvp.di.annotation.PerActivity;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    final AppCompatActivity activity;

    public ActivityModule(@NotNull AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    @Singleton
    @ActivityContext
    Context provideActivityContext() {
        return activity;
    }
}
