package com.lc.lib.rx;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class BaseException extends Throwable {
    private int status;
    private String message;

    public BaseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
