package com.lc.lib.ui.activity;

import com.lc.lib.presenter.BasePresenter;
import com.lc.lib.presenter.view.BaseView;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    public P mPresenter;

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError() {

    }
}
