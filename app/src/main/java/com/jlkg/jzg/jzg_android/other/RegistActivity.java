package com.jlkg.jzg.jzg_android.other;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PhoneCodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends TextWatcherBaseActivity {


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
    @BindView(R.id.tv_have_account)
    TextView mTvHaveAccount;
    @BindView(R.id.cb_xieyi)
    CheckBox mCbXieyi;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.et_pswConfirm)
    EditText etPswConfirm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initViews() {
        super.initViews();
        PhoneCodeUtils.getInstance().setText(1, mBtnCode, mEtPhone);
//        EditTextInPutUtils.setEditTextInhibitInputSpace(mEtPhone);
        mEtPhone.addTextChangedListener(this);
        mEtCode.addTextChangedListener(this);
        etPsw.addTextChangedListener(this);
        etPswConfirm.addTextChangedListener(this);
        mCbXieyi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isPhone = PhoneCodeUtils.isMobile(mEtPhone.getText().toString());
                mBtnCode.setEnabled(isPhone && mBtnCode.getText().length() < 6);
                int codeLength = mEtCode.getText().length();
                mBtnNext.setEnabled(isPhone && codeLength == 4 && mCbXieyi.isChecked());
            }
        });
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        boolean isPhone = PhoneCodeUtils.isMobile(mEtPhone.getText().toString());
        mBtnCode.setEnabled(isPhone && mBtnCode.getText().length() < 6);
        int codeLength = mEtCode.getText().length();
        boolean isPsw= !android.text.TextUtils.isEmpty(etPsw.getText().toString())&& !android.text.TextUtils.isEmpty(etPswConfirm.getText().toString());
        mBtnNext.setEnabled(isPhone && codeLength == 4 && mCbXieyi.isChecked()&&isPsw);
    }

    @OnClick(R.id.btn_code)
    void getCode() {
        PhoneCodeUtils.getInstance().requestCodeForRegist(1, this);
    }

    @OnClick(R.id.tv_xieyi)
    void xieyi() {
        openActivity(XieyiActivity.class);
    }

    @OnClick(R.id.btn_next)
    void next() {
        if(etPsw.getText().toString().length()<6){
            toast("密码长度为6-18位");
            return;
        }else if(!etPsw.getText().toString().equals(etPswConfirm.getText().toString())){
            toast("两次输入的密码不一样");
            return;
        }
        setLoading(true);
        ApiManager.regist(mEtPhone.getText().toString().trim(), mEtCode.getText().toString().trim(),etPsw.getText().toString(), MyApplication.isCompany, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                showToast("注册成功");
                finish();
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });

        /*if (MyApplication.isCompany) {
            ApiManager.companySignUp(mEtCode.getText().toString().trim(), mEtPhone.getText().toString().trim(), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    showToast("注册成功，初始密码未123456");
//                    Bundle bundle = new Bundle();
//                    bundle.putString("userName", mEtPhone.getText().toString().trim());
//                    bundle.putString("code", mEtCode.getText().toString().trim());
//                    openActivity(SetPwdActivity.class, bundle);
                    finish();
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                }
            });
        } else {
            ApiManager.teamSignUp(mEtCode.getText().toString().trim(), mEtPhone.getText().toString().trim(), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    showToast("注册成功");
                    Bundle bundle = new Bundle();
                    bundle.putString("userName", mEtPhone.getText().toString().trim());
                    bundle.putString("code", mEtCode.getText().toString().trim());
                    openActivity(SetPwdActivity.class, bundle);
                    finish();
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                }
            });
        }*/
    }

    @OnClick(R.id.tv_have_account)
    void haveAccount() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
