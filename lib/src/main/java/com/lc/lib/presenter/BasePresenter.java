package com.lc.lib.presenter;

import android.content.Context;

import com.lc.lib.presenter.view.BaseView;
import com.lc.lib.utils.NetWorkUtils;

import javax.inject.Inject;


/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BasePresenter<V extends BaseView> {
    public V mView;


    @Inject
    Context context;

    public boolean checkNetWork() {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true;
        }
        mView.onError("网络不可用");
        return false;
    }
}
