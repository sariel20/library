package com.lc.library.service.impl;

import com.lc.lib.data.protocol.BaseResp;
import com.lc.lib.rx.BaseException;
import com.lc.library.data.repository.UserRepository;
import com.lc.library.service.UserService;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by LiangCheng on 2018/4/4.
 */

public class UserServiceImpl implements UserService {
    @Override
    public Observable<Boolean> register(String mobile, String pwd, String code) {
        /*Modul层进行业务处理*/
        UserRepository repository = new UserRepository();
        /*3 向服务器发送请求*/
        return repository.register(mobile, pwd, code)
                /*4 处理返回数据*/
                .flatMap(new Func1<BaseResp<String>, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(BaseResp<String> b) {
                        /*0表示失败，发送error*/
                        if (b.getStatus() != 0) {
                            return Observable.error(new BaseException(b.getStatus(), b.getMessage()));
                        }
                        /*其他值表示成功*/
                        return Observable.just(true);
                    }
                });
    }
}
