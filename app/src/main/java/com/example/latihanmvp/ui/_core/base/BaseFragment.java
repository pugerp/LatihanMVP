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

import com.example.latihanmvp.network.NetworkClient;
import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.mvp.MvpView;
import com.example.latihanmvp.utils.PreferenceUtils;

import butterknife.ButterKnife;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements MvpView {

    public BaseActivity mActivity;
    protected P presenter;
    protected abstract P createPresenter();
    protected abstract int getLayout();
    protected abstract void setup(View view);
    protected abstract void onAttachView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        presenter = createPresenter();
        presenter.setNetworkInterface(NetworkClient.getInstance().create(NetworkInterface.class));
        onAttachView();
        setup(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CHECKFRAGMENT", "onViewCreated..");
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
