package com.example.latihanmvp.ui.base;

import android.util.Log;

import com.example.latihanmvp.MvpView;
import com.example.latihanmvp.network.NetworkCallback;
import com.example.latihanmvp.network.NetworkClient;

import java.net.NetworkInterface;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<V extends MvpView> {

    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;
    protected V mView;

    public void onAttach(V view){
        this.mView = view;
    }

    public void onDetach(){
        mView = null;
    }

    public void onUnsubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
            Log.e("TAG", "onUnsubscribe: ");
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
}
