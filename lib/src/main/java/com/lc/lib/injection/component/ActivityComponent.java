package com.lc.lib.injection.component;

import android.app.Activity;

import com.lc.lib.injection.ActivityScope;
import com.lc.lib.injection.module.ActivityModule;

import dagger.Component;

/**
 * Created by LiangCheng on 2018/4/5.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},
        modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();
}
