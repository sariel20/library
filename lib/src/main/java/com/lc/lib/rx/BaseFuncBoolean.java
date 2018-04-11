package com.lc.lib.rx;

import com.lc.lib.data.protocol.BaseResp;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by LiangCheng on 2018/4/11.
 */

public class BaseFuncBoolean<T> implements Func1<BaseResp<T>, Observable<Boolean>> {
    @Override
    public Observable<Boolean> call(BaseResp<T> b) {
        /*0表示失败，发送error*/
        if (b.getStatus() != 0) {
            return Observable.error(new BaseException(b.getStatus(), b.getMessage()));
        }
         /*其他值表示成功*/
        return Observable.just(true);
    }
}
