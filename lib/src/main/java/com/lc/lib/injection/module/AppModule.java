package com.lc.lib.injection.module;

import android.content.Context;

import com.lc.lib.common.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LiangCheng on 2018/4/5.
 */

@Module
public class AppModule {
    private BaseApplication context;

    public AppModule(BaseApplication context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }
}
