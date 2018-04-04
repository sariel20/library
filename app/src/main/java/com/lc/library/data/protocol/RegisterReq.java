package com.lc.library.data.protocol;

/**
 * Created by LiangCheng on 2018/4/4.
 */

public class RegisterReq {
    private String mobile;
    private String pwd;
    private String verifyCode;

    public RegisterReq(String mobile, String pwd, String verifyCode) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.verifyCode = verifyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
