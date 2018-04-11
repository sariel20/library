package com.lc.library.service.impl;

import com.lc.lib.rx.BaseFuncBoolean;
import com.lc.library.data.repository.UserRepository;
import com.lc.library.service.UserService;

import javax.inject.Inject;

import rx.Observable;


/**
 * Created by LiangCheng on 2018/4/4.
 */

public class UserServiceImpl implements UserService {

    @Inject
    UserRepository repository;

    @Inject
    public UserServiceImpl() {
    }

    @Override
    public Observable<Boolean> register(String mobile, String pwd, String code) {
        /*Modul层进行业务处理*/
        /*3 向服务器发送请求*/
        return repository.register(mobile, pwd, code)
                /*4 处理返回数据*/
                .flatMap(new BaseFuncBoolean<String>());
    }
}
