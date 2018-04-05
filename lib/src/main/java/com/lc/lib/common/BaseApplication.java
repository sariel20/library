package com.lc.lib.common;

import android.app.Application;

import com.lc.lib.injection.component.AppComponent;
import com.lc.lib.injection.component.DaggerAppComponent;
import com.lc.lib.injection.module.AppModule;

/**
 * Created by LiangCheng on 2018/4/5.
 */

public class BaseApplication extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initAppInjection();
    }

    public AppComponent initAppInjection() {
        return appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
