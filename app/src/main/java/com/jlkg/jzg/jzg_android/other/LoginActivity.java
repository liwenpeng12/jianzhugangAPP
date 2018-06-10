package com.jlkg.jzg.jzg_android.other;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.EditTextInPutUtils;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.activity.BindPhoneActivity;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.bean.LoginBean;
import com.jlkg.jzg.jzg_android.other.bean.TeamLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.WxUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PreFiled;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.jlkg.jzg.jzg_android.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends TextWatcherBaseActivity {


    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.tv_user_type)
    TextView mTvUserType;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.tv_regist)
    TextView mTvRegist;
    @BindView(R.id.iv_wechat)
    ImageView mIvWechat;
    private IWXAPI api;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        super.initViews();
        api = WxUtils.regToWx(this);
        mEtPhone.addTextChangedListener(this);
        mEtPwd.addTextChangedListener(this);
        EditTextInPutUtils.setPwdEditTextInhibitInputSpace(mEtPwd);
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        int length = mEtPwd.getText().length();
        mBtnLogin.setEnabled(!TextUtils.isEmpty(mEtPhone.getText().toString()) /*PhoneCodeUtils.isMobile(mEtPhone.getText().toString()) */ && length >= 6 && length <= 18);
    }

    @OnClick(R.id.btn_login)
    void login() {
        setLoading(true);
        ApiManager.login(mEtPhone.getText().toString().trim(), mEtPwd.getText().toString().trim(), MyApplication.isCompany,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                formatResponse(response, null);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                setLoading(false);
                PrefUtils.setBoolean(mContext, "isLogin", false);
            }
        });


        /*if (MyApplication.isCompany)
            ApiManager.companySignln(mEtPhone.getText().toString().trim(), mEtPwd.getText().toString().trim(), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
                    PrefUtils.setString(mContext, PreFiled.COMPANYACCOUNT, mEtPhone.getText().toString().trim());
                    PrefUtils.setString(mContext, PreFiled.COMPANYPWD, mEtPwd.getText().toString().trim());
                    MyApplication.sCompanyLoginBean = bean;
                    PrefUtils.setBoolean(mContext, "isLogin", true);
                    EventBus.getDefault().post("login");
                    PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, true);
                    openActivity(MainActivity.class);
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                    PrefUtils.setBoolean(mContext, "isLogin", false);
                }
            });
        else
            ApiManager.teamSignln(mEtPhone.getText().toString().trim(), mEtPwd.getText().toString().trim(), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    TeamLoginBean bean = JSON.parseObject(response, TeamLoginBean.class);
                    PrefUtils.setString(mContext, PreFiled.TEAMACCOUNT, mEtPhone.getText().toString().trim());
                    PrefUtils.setString(mContext, PreFiled.TEAMPWd, mEtPwd.getText().toString().trim());
                    MyApplication.sTeamLoginBean = bean;
                    PrefUtils.setBoolean(mContext, "isLogin", true);
                    EventBus.getDefault().post("login");
                    PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, false);
                    openActivity(MainActivity.class);
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                    PrefUtils.setBoolean(mContext, "isLogin", false);

                }
            });*/
    }

    private void formatResponse(String response, String wxId) {
        LoginBean loginBean = JSON.parseObject(response, LoginBean.class);
        CompanyLoginBean company = loginBean.getCompany();
        TeamLoginBean team = loginBean.getTeam();
        Log.d("lwp","Company().getPhone:"+loginBean.getCompany().getPhone()+"Team().getPhone:"+loginBean.getTeam().getPhone());
        PrefUtils.setString(mContext,"mPhone",loginBean.getCompany().getPhone());
//        loginBean.getCompany().getPhone();
//        loginBean.getTeam().getPhone();
        MyApplication.sCompanyLoginBean = company;
        MyApplication.sTeamLoginBean = team;
        if (!TextUtils.isEmpty(wxId)) {
            PrefUtils.setString(mContext, PreFiled.WXID, wxId);
        } else {
            PrefUtils.setString(mContext, PreFiled.WXID, "");
        }
        if (MyApplication.isCompany) {
//                    CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
            PrefUtils.setString(mContext, PreFiled.COMPANYACCOUNT, mEtPhone.getText().toString().trim());
            PrefUtils.setString(mContext, PreFiled.COMPANYPWD, mEtPwd.getText().toString().trim());
//                    MyApplication.sCompanyLoginBean = bean;
            PrefUtils.setBoolean(mContext, "isLogin", true);
            EventBus.getDefault().post("login");
            PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, true);
            openActivity(MainActivity.class);
            setLoading(false);
        } else {
//                    TeamLoginBean bean = JSON.parseObject(response, TeamLoginBean.class);
//                    PrefUtils.setString(mContext, PreFiled.TEAMACCOUNT, mEtPhone.getText().toString().trim());
//                    PrefUtils.setString(mContext, PreFiled.TEAMPWd, mEtPwd.getText().toString().trim());
            PrefUtils.setString(mContext, PreFiled.COMPANYACCOUNT, mEtPhone.getText().toString().trim());
            PrefUtils.setString(mContext, PreFiled.COMPANYPWD, mEtPwd.getText().toString().trim());
//                    MyApplication.sTeamLoginBean = bean;
            PrefUtils.setBoolean(mContext, "isLogin", true);
            EventBus.getDefault().post("login");
            PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, false);
            openActivity(MainActivity.class);
            setLoading(false);
        }
    }

    @OnClick(R.id.tv_forget_pwd)
    void forginPwd() {
        openActivity(ForgetPwdActivity.class);
    }

    @OnClick(R.id.tv_regist)
    void regist() {
        openActivity(RegistActivity.class);
    }

    @OnClick(R.id.iv_wechat)
    void weChatLogin() {
        WxUtils.wxLogin(api);
//        openActivity(BindPhoneActivity.class);
    }

    @Subscribe
    public void wxLoginEvent(final WXEntryActivity.WXinfoBean bean) {
//        bean.setOpenid("o6FUT0Ss-O9YisssLCGvVsLtsZgk");
        setLoading(true);
        ApiManager.getPhoneByWxId(bean.getOpenid(),this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                if (TextUtils.isEmpty(response)) {
                    setLoading(false);
                    Bundle bundle = new Bundle();
                    bundle.putString("wxId", bean.getOpenid());
                    openActivity(BindPhoneActivity.class, bundle);
                } else {
                    wxLogin(bean.getOpenid());
                }
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    private void wxLogin(final String wxId) {
        ApiManager.weChartLogin(wxId,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                formatResponse(response, wxId);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

}
