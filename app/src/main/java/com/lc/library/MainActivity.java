package com.lc.library;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lc.lib.ui.activity.BaseMVPActivity;
import com.lc.library.presenter.RegisterPresenter;
import com.lc.library.presenter.view.RegisterView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*实例化presenter和view*/
        mPresenter = new RegisterPresenter();
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
    public void onRegisterResult(boolean stauts) {
        /*6 注册回调方法*/
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
}
