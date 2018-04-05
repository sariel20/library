package com.lc.lib.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lc.lib.common.BaseApplication;
import com.lc.lib.injection.component.ActivityComponent;
import com.lc.lib.injection.component.DaggerActivityComponent;
import com.lc.lib.injection.module.ActivityModule;
import com.lc.lib.presenter.BasePresenter;
import com.lc.lib.presenter.view.BaseView;

import javax.inject.Inject;


/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    /*标注属性*/
    @Inject
    public P mPresenter;

    public ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityInjection();
    }

    private void initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(new BaseApplication().initAppInjection())
                .activityModule(new ActivityModule(this))
                .build();
    }

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
