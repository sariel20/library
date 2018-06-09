package com.lc.library;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.lc.lib.common.AppManager;
import com.lc.lib.ui.activity.BaseMVPActivity;
import com.lc.lib.utils.LogUtils;
import com.lc.library.injection.component.DaggerUserComponent;
import com.lc.library.injection.module.UserModule;
import com.lc.library.presenter.RegisterPresenter;
import com.lc.library.presenter.view.RegisterView;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<RegisterPresenter> implements RegisterView {

    @BindView(R.id.userRegPhoneTIEdit)
    TextInputEditText userRegPhoneTIEdit;
    @BindView(R.id.userRegCodeBtn)
    Button userRegCodeBtn;
    @BindView(R.id.userRegCodeTIEdit)
    TextInputEditText userRegCodeTIEdit;
    @BindView(R.id.userRegPwdTIEdit)
    TextInputEditText userRegPwdTIEdit;
    @BindView(R.id.userRegConfirmPwdTIEdit)
    TextInputEditText userRegConfirmPwdTIEdit;
    @BindView(R.id.userRegCommitBtn)
    Button userRegCommitBtn;

    private long pressTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(new UserModule()).build().inject(this);
        mPresenter.mView = this;
    }


    @OnClick({R.id.userRegCodeBtn, R.id.userRegCommitBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.userRegCodeBtn:
                break;
            case R.id.userRegCommitBtn:
                /*1 注册事件监听，发送至presenter*/
                mPresenter.register(userRegPhoneTIEdit.getText().toString()
                        , userRegPwdTIEdit.getText().toString()
                        , userRegCodeTIEdit.getText().toString());
                break;
        }
    }

    @Override
    public void onRegisterResult(String msg) {
        /*6 注册回调方法*/
        showToast(msg);
        Logger.e(msg);
    }

    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if ((time - pressTime) > 2000) {
            showToast("再按一次退出应用程序");
            pressTime = time;
        } else {
            AppManager.getInstence().exitApp(this);
        }
    }
}
