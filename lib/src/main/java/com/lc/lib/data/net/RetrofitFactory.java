package com.lc.lib.data.net;

import com.lc.lib.common.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class RetrofitFactory {

    private static RetrofitFactory retrofitFactory;

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private Interceptor interceptor;

    public static RetrofitFactory getInstence() {
        if (retrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitFactory == null) {
                    retrofitFactory = new RetrofitFactory();
                }
            }
        }
        return retrofitFactory;
    }

    /*创建retrofit方法*/
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    /*初始化Retrofit*/
    private RetrofitFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build();
    }

    /*初始化okHttp*/
    private OkHttpClient initClient() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor())
                .addInterceptor(httpLoggingInterceptor())
                .connectTimeout(Constant.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(Constant.TIME_OUT, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

    /*日志拦截器*/
    private HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /*请求头信息拦截器*/
    private Interceptor interceptor() {
        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("charset", "UTF-8")
                        .build());
            }
        };
        return interceptor;
    }

}
