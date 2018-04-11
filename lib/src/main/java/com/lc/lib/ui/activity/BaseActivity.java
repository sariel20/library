package com.lc.lib.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lc.lib.common.AppManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstence().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstence().finishActivity(this);
    }
}
