package com.example.latihanmvp.ui.activity.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.latihanmvp.R;
import com.example.latihanmvp.ui.activity.second.SecondActivity;
import com.example.latihanmvp.ui._core.base.BaseActivity;
import com.example.latihanmvp.ui._core.base.BaseFragment;
import com.example.latihanmvp.ui.fragment.FirstFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.btnToast)
    Button btnToast;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setup(Bundle savedInstanceState) {
        initFragment();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    public void initFragment() {
        fragmentManager = getSupportFragmentManager();
        fragment = getSupportFragmentManager().findFragmentById(frameLayout.getId());
        if (!(fragment instanceof FirstFragment)) {
            moveToFragment(frameLayout.getId(), FirstFragment.newInstance(), FirstFragment.class.getSimpleName());
        }
    }

    public void moveToFragment(int idFragmentView, BaseFragment fragment, String id) {
        fragmentManager.beginTransaction()
                .replace(idFragmentView, fragment, id)
                .commitAllowingStateLoss();
    }

    @Override
    public void showToast(String s) {
        showToastMessage(s);
        SecondActivity.startActivity(this);
    }

    @OnClick(R.id.btnToast)
    public void onViewClicked() {
        presenter.doSomething();
    }
}
