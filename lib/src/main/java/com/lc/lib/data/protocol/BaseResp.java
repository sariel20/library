package com.lc.lib.data.protocol;

/**
 * Created by LiangCheng on 2018/4/4.
 * 返回数据公共类
 */

public class BaseResp<T> {
    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "resp:{" +
                "status = " + status +
                "message = " + message +
                "data = " + data +
                "}";
    }
}
