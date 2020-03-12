package com.example.latihanmvp.ui._core.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public Activity mActivity;
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
        onAttachView();
        setup(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CHECKFRAGMENT", "onViewCreated..");
        mActivity = getActivity();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof BaseActivity) {
//            BaseActivity activity = (BaseActivity) context;
//            this.mActivity = activity;
//            activity.onFragmentAttach();
//
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDetach();
    }
//
//    public interface Callback {
//        void onFragmentAttach();
//        void onFragmentDetach(String tag);
//    }
}
