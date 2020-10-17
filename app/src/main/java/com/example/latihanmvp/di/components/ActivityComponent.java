package com.example.latihanmvp.di.components;

import com.example.latihanmvp.di.annotations.PerActivity;
import com.example.latihanmvp.di.modules.ActivityModule;
import com.example.latihanmvp.ui.activity.main.MainActivity;
import com.example.latihanmvp.ui.activity.main.MainPresenter;
import com.example.latihanmvp.ui.activity.second.SecondActivity;
import com.example.latihanmvp.ui.activity.second.SecondPresenter;
import com.example.latihanmvp.ui.activity.third.ThirdActivity;
import com.example.latihanmvp.ui.activity.third.ThirdPresenter;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
@PerActivity
public interface ActivityComponent extends ApplicationComponent {

    void inject(MainActivity activity);

    void inject(MainPresenter presenter);

    void inject(SecondActivity activity);

    void inject(SecondPresenter presenter);

    void inject(ThirdActivity activity);

    void inject(ThirdPresenter presenter);
}


