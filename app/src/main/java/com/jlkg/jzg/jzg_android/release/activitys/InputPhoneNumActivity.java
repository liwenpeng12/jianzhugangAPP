package com.jlkg.jzg.jzg_android.release.activitys;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.other.IdentityConfimActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PhoneCodeUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 输入手机号
 */
public class InputPhoneNumActivity extends TextWatcherBaseActivity {


    @BindView(R.id.tv_user_type)
    TextView mTvUserType;
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
        return R.layout.activity_input_phone_num;
    }

    @Override
    protected void initViews() {
        super.initViews();
        PhoneCodeUtils.getInstance().setText(3, mBtnCode, mEtPhone);
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
        PhoneCodeUtils.getInstance().requestCode(3, this);
    }

    @OnClick(R.id.btn_next)
    void next() {
        ApiManager.validateVerifyCode(mEtPhone.getText().toString().trim(), mEtCode.getText().toString().trim(),this, new HttpUtils.OnCallBack<Object>() {
            @Override
            public void success(String o) {
                Intent intent = new Intent();
                intent.putExtra("phone", mEtPhone.getText().toString().trim());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }

            @Override
            public void onError(String msg) {
                toast("验证失败");
            }
        });
    }
}
