package com.lc.lib.rx;


import rx.Subscriber;

/**
 * Created by LiangCheng on 2018/4/4.
 * Rx
 */

public class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
