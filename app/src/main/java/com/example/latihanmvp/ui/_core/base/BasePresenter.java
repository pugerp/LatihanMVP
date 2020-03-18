package com.example.latihanmvp.ui._core.base;

import android.util.Log;

import com.example.latihanmvp.network.NetworkInterface;
import com.example.latihanmvp.ui._core.mvp.MvpView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<V extends MvpView> {

    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;
    protected V mView;
    public NetworkInterface networkInterface;

    public void onAttach(V view){
        this.mView = view;
    }

    public void onDetach(){
        mView = null;
    }

    public void onUnsubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            compositeSubscription.unsubscribe();
            Log.e("TAG", "onUnsubscribe...");
        }
    }

    protected <M> void addSubscribe(Observable<M> observable, Subscriber<M> subscriber) {
        this.subscriber = subscriber;
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public void stop() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }
}
