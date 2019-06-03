package com.example.latihanmvp;

public abstract class BasePresenter<V extends MvpView> {
    V mView;

    public void onAttach(V view){
        this.mView = view;
    }

    public void onDetach(){
        mView = null;
    }
}
