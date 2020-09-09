package com.example.latihanmvp.ui._core.base;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.latihanmvp.di.components.ActivityComponent;
import com.example.latihanmvp.di.components.DaggerFragmentComponent;
import com.example.latihanmvp.di.components.FragmentComponent;
import com.example.latihanmvp.di.modules.FragmentModule;
import com.example.latihanmvp.root.App;
import com.example.latihanmvp.ui._core.mvp.MvpView;

import javax.inject.Inject;

import butterknife.ButterKnife;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements MvpView {

    @Inject
    protected P presenter;

    public BaseActivity mActivity;
    private FragmentComponent fragmentComponent;
    protected abstract int getLayout();
    protected abstract void setup(View view);
    protected abstract void setComponent(@NonNull FragmentComponent component);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        createComponent();
        onComponentCreated(fragmentComponent);
        setup(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CHECKFRAGMENT", "onViewCreated..");
    }

    protected void createComponent() {
        fragmentComponent = DaggerFragmentComponent.builder()
                .activityComponent(((BaseActivity) getActivity()).getActivityComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    public void onComponentCreated(@NonNull FragmentComponent component) {
        setComponent(component);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
            mActivity.onFragmentAttach();
        }
    }

    @Override
    public void onDetach() {
        mActivity.onFragmentDetach("detach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDetach();
    }

    @Override
    public void showToastMessage(String s) {
        if (mActivity != null) {
            mActivity.showToastMessage(s);
        }
    }

    @Override
    public void showLoading() {
        if (mActivity != null) {
            hideLoading();
            mActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) {
            mActivity.hideLoading();
        }
    }

    public interface Callback {
        void onFragmentAttach();
        void onFragmentDetach(String tag);
    }
}
