package com.lc.lib.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

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

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    /*标注属性*/
    @Inject
    public P mPresenter;

    public ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityInjection();
        injectComponent();
    }

    public abstract void injectComponent();

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

    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
