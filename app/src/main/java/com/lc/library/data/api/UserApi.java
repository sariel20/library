package com.lc.library.data.api;

import com.lc.lib.data.protocol.BaseResp;
import com.lc.library.data.protocol.RegisterReq;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by LiangCheng on 2018/4/4.
 * 网络请求接口
 */

public interface UserApi {
    @POST("userCenter/register")
    Observable<BaseResp<String>> register(@Body RegisterReq registerReq);
}
