package com.lc.lib.presenter.view;

/**
 * Created by LiangCheng on 2018/4/4.
 */
public interface BaseView {
    void showLoading(String msg);

    void hideLoading();

    void onError();
}
