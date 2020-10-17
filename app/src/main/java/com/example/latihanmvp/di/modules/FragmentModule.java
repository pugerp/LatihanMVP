package com.example.latihanmvp.di.modules;

import androidx.fragment.app.Fragment;

import com.example.latihanmvp.di.annotations.PerFragment;

import org.jetbrains.annotations.NotNull;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    final Fragment fragment;

    public FragmentModule(@NotNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment provideFragment() {
        return fragment;
    }
}
