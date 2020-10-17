package com.example.latihanmvp.ui._core.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.di.components.DaggerActivityComponent;
import com.example.latihanmvp.di.modules.ActivityModule;
import com.example.latihanmvp.root.App;
import com.example.latihanmvp.ui._core.mvp.MvpView;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MvpView, BaseFragment.Callback{

    @Inject
    protected P presenter;

    private ActivityComponent activityComponent;
    private ProgressDialog progressDialog;
    protected abstract int getLayout();
    protected abstract void setup(Bundle savedInstanceState);
    protected abstract void setComponent(@NonNull ActivityComponent component);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        createComponent();
        onComponentCreated(activityComponent);
        setup(savedInstanceState);
    }

    private void createComponent() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) this.getApplicationContext()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    private void onComponentCreated(ActivityComponent component) {
        setComponent(component);
    }

    @NotNull
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void showToastMessage(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDetach();
        presenter.onUnsubscribe();
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = ProgressDialog.show(this, null, "Loading, Please wait...", true);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void onFragmentAttach() {

    }

    @Override
    public void onFragmentDetach(String tag) {

    }
}
