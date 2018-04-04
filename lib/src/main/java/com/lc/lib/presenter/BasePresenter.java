package com.lc.lib.presenter;

import com.lc.lib.presenter.view.BaseView;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BasePresenter<V extends BaseView> {
    public V mView;
}
