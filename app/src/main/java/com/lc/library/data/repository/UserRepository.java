package com.lc.library.data.repository;

import com.lc.lib.data.net.RetrofitFactory;
import com.lc.lib.data.protocol.BaseResp;
import com.lc.library.data.api.UserApi;
import com.lc.library.data.protocol.RegisterReq;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by LiangCheng on 2018/4/4.
 * 数据层
 * 访问网络获取数据
 */

public class UserRepository {
    @Inject
    public UserRepository() {
    }

    public Observable<BaseResp<String>> register(String mobile, String pwd, String verifyCode) {
        return RetrofitFactory.getInstence().create(UserApi.class)
                .register(new RegisterReq(mobile, pwd, verifyCode));
    }
}
