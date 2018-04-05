package com.lc.lib.injection.module;

import android.app.Activity;

import com.lc.lib.injection.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LiangCheng on 2018/4/5.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public Activity providesActivity() {
        return activity;
    }
}
