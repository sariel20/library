package com.lc.library.presenter;

import com.lc.lib.presenter.BasePresenter;
import com.lc.lib.rx.BaseSubscriber;
import com.lc.library.presenter.view.RegisterView;
import com.lc.library.service.UserService;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by LiangCheng on 2018/4/4.
 * 中间层
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    @Inject
    UserService userService;

    /*标注构造*/
    @Inject
    public RegisterPresenter() {
    }

    public void register(String mobile, String pwd, String verifyCode) {
        /*2 实现注册接口*/
        userService.register(mobile, pwd, verifyCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<Boolean>() {
                    @Override
                    public void onNext(Boolean t) {
                        /*5 注册回调*/
                        mView.onRegisterResult("注册" + (t ? "成功" : "失败"));
                    }
                });

    }

}
