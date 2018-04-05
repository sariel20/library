package com.lc.lib.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by LiangCheng on 2018/4/5.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface PerComponentScope {
}
