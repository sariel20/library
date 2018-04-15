package com.lc.lib.rx;


import com.lc.lib.presenter.view.BaseView;

import rx.Subscriber;

/**
 * Created by LiangCheng on 2018/4/4.
 * Rx
 */

public class BaseSubscriber<T> extends Subscriber<T> {
    private BaseView view;
    private String msg;

    /**
     * 用于显示加载框
     *
     * @param msg      加载框提示内容
     * @param baseView
     */
    public BaseSubscriber(String msg, BaseView baseView) {
        this.msg = msg;
        this.view = baseView;
    }

    @Override
    public void onCompleted() {
        view.showLoading(msg);
    }

    @Override
    public void onError(Throwable e) {
        view.hideLoading();
    }

    @Override
    public void onNext(T t) {

    }
}
