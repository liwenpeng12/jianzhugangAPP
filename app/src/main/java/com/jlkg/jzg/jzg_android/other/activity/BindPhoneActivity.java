package com.jlkg.jzg.jzg_android.other.activity;

import android.text.Editable;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.XieyiActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PhoneCodeUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 绑定手机号
 */
public class BindPhoneActivity extends TextWatcherBaseActivity {


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
    @BindView(R.id.cb_xieyi)
    CheckBox mCbXieyi;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void initViews() {
        super.initViews();
        PhoneCodeUtils.getInstance().setText(2, mBtnCode, mEtPhone);
        mEtPhone.addTextChangedListener(this);
        mEtCode.addTextChangedListener(this);
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
        mBtnCode.setEnabled(isPhone && mBtnCode.getText().length() < 6 && mCbXieyi.isChecked());
        int codeLength = mEtCode.getText().length();
        mBtnNext.setEnabled(isPhone && codeLength == 4);
    }

    @OnClick(R.id.btn_code)
    void getCode() {
        PhoneCodeUtils.getInstance().requestCode(2, this);
    }

    @OnClick(R.id.tv_xieyi)
    void xieyi() {
        openActivity(XieyiActivity.class);
    }

    @OnClick(R.id.btn_next)
    void next() {
        setLoading(true);
//        openActivity(IdentityConfimActivity.class);
        ApiManager.validateVerifyCode(mEtPhone.getText().toString().trim(), mEtCode.getText().toString().trim(),this, new HttpUtils.OnCallBack<Object>() {
            @Override
            public void success(String o) {
                bindPhone(getIntent().getExtras().getString("wxId"), mEtPhone.getText().toString().trim());
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                toast(msg);
            }
        });
    }

    private void bindPhone(String wxId, String phone) {
        ApiManager.wxBindPhone(wxId, phone, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                finish();
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }
}
