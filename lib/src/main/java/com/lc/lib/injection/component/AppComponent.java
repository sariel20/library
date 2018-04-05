package com.lc.lib.injection.component;

import android.content.Context;

import com.lc.lib.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LiangCheng on 2018/4/5.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();
}
