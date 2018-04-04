package com.lc.library.service;


import rx.Observable;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public interface UserService {
    Observable<Boolean> register(String mobile, String pwd, String verifyCode);
}
