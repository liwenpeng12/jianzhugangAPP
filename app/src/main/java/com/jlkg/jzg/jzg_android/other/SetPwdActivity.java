package com.jlkg.jzg.jzg_android.other;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.jlkg.jzg.baselibrary.utils.EditTextInPutUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class SetPwdActivity extends TextWatcherBaseActivity {

    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.et_pwd_again)
    EditText mEtPwdAgain;
    @BindView(R.id.btn_finish)
    Button mBtnFinish;
    private String mUserName, mCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_pwd;
    }

    @OnClick(R.id.btn_finish)
    void complete() {
        if (!mEtPwd.getText().toString().equals(mEtPwdAgain.getText().toString())) {
            showToast("你两次输入的密码不一致");
            return;
        }
        setLoading(true);
        ApiManager.resetPwd(mUserName, mEtPwd.getText().toString().trim(), mCode, MyApplication.isCompany,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                showToast("修改成功");
                EventBus.getDefault().post("login");
                openActivity(LoginActivity.class);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });


        /*if (MyApplication.isCompany)
            ApiManager.companyResetPwd(mUserName, mEtPwd.getText().toString().trim(), mCode, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    setLoading(false);
                    showToast("修改成功");
                    EventBus.getDefault().post("login");
                    openActivity(LoginActivity.class);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                    showToast(msg);
                }
            });
        else
            ApiManager.teamResetPwd(mUserName, mEtPwd.getText().toString().trim(), mCode, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    setLoading(false);
                    showToast("修改成功");
                    EventBus.getDefault().post("login");
                    openActivity(LoginActivity.class);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                    showToast(msg);
                }
            });*/
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mUserName = getIntent().getExtras().getString("userName");
            mCode = getIntent().getExtras().getString("code");
        }
        EditTextInPutUtils.setPwdEditTextInhibitInputSpace(mEtPwd);
        EditTextInPutUtils.setPwdEditTextInhibitInputSpace(mEtPwdAgain);
        mEtPwd.addTextChangedListener(this);
        mEtPwdAgain.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        int firstLength = mEtPwd.getText().length();
        int againLength = mEtPwdAgain.getText().length();
        mBtnFinish.setEnabled(firstLength >= 6 && againLength >= 6);
    }
}
