package com.jlkg.jzg.jzg_android.other;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PhoneCodeUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPwdActivity extends TextWatcherBaseActivity {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.btn_code)
    Button mBtnCode;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_pwd;
    }

    @Override
    protected void initViews() {
        super.initViews();
        PhoneCodeUtils.getInstance().setText(0, mBtnCode, mEtPhone);
        mEtPhone.addTextChangedListener(this);
        mEtCode.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        boolean isPhone = PhoneCodeUtils.isMobile(mEtPhone.getText().toString());
        mBtnCode.setEnabled(isPhone && mBtnCode.getText().length() < 6);
        int codeLength = mEtCode.getText().length();
        mBtnNext.setEnabled(isPhone && codeLength == 4);
    }

    @OnClick(R.id.btn_code)
    void getCode() {
        PhoneCodeUtils.getInstance().requestCodeForRest(0, this);
    }

    @OnClick(R.id.btn_next)
    void next() {
        setLoading(true);
        ApiManager.validateVerifyCode(mEtPhone.getText().toString().trim(), mEtCode.getText().toString().trim(), this,new HttpUtils.OnCallBack<Object>() {
            @Override
            public void success(String o) {
                setLoading(false);
                Bundle bundle = new Bundle();
                bundle.putString("userName", mEtPhone.getText().toString().trim());
                bundle.putString("code", mEtCode.getText().toString().trim());
                openActivity(SetPwdActivity.class, bundle);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                toast(msg);
            }
        });
    }
}
