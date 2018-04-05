package com.lc.library.injection.module;

import com.lc.library.service.UserService;
import com.lc.library.service.impl.UserServiceImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LiangCheng on 2018/4/5.
 */

@Module
public class UserModule {
    @Provides
    public UserService providesUserService(UserServiceImpl userService) {
        return userService;
    }
}
