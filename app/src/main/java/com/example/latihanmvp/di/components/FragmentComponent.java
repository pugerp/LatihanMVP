package com.example.latihanmvp.di.components;

import com.example.latihanmvp.di.annotations.PerFragment;
import com.example.latihanmvp.di.modules.FragmentModule;
import com.example.latihanmvp.ui.fragment.FirstFragment;
import com.example.latihanmvp.ui.fragment.FirstPresenter;

import dagger.Component;

@Component(dependencies = ActivityComponent.class, modules = FragmentModule.class)
@PerFragment
public interface FragmentComponent extends ActivityComponent {
    void inject(FirstFragment fragment);

    void inject(FirstPresenter presenter);
}
