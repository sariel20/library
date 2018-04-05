package com.lc.library.injection.component;

import com.lc.lib.injection.PerComponentScope;
import com.lc.lib.injection.component.ActivityComponent;
import com.lc.library.MainActivity;
import com.lc.library.injection.module.UserModule;

import dagger.Component;

/**
 * Created by LiangCheng on 2018/4/5.
 * 关联
 */
@PerComponentScope
@Component(dependencies = {ActivityComponent.class}, modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity activity);
}
