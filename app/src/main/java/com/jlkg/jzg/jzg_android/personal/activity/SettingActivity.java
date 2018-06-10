package com.jlkg.jzg.jzg_android.personal.activity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.other.event.LogoutEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ApplicationUpdateService;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.ll_password)
    LinearLayout llPassword;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.ll_feedback)
    LinearLayout llFeedback;
    @BindView(R.id.tv_updateCount)
    TextView tvUpdateCount;
    @BindView(R.id.ll_update)
    LinearLayout llUpdate;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    private String apkUrl;
    private String appVersion;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (!PrefUtils.getBoolean(this, "isLogin", false)) {
            tvLogout.setVisibility(View.GONE);
        }else{
            tvLogout.setVisibility(View.VISIBLE);
        }
        ApiManager.updateList(this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                try {
                    JSONObject jsonObject = JSON.parseObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("content");
                    if (jsonArray == null || jsonArray.size() <= 0) {
                        return;
                    }
                    JSONObject jsonObjectContent = jsonArray.getJSONObject(0);
                    apkUrl = jsonObjectContent.getString("appAndroidUrl");
                    appVersion = jsonObjectContent.getString("appVersion");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @OnClick({R.id.tv_logout, R.id.ll_password, R.id.ll_phone, R.id.ll_feedback, R.id.ll_update, R.id.ll_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_password:
                //密码管理
                if (!PrefUtils.getBoolean(this, "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(ChangePasswordActivity.class);
                break;
            case R.id.ll_phone:
                //客户电话
                DialogUtils.showSettingDialog(this, false, "4008606025", "拨打", R.color.color_6ace89, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        if (ActivityCompat.checkSelfPermission(SettingActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            requestRxPermissions(Manifest.permission.CALL_PHONE);
                            return;
                        }

                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "4008606025"));
                        if (intent.resolveActivity(SettingActivity.this.getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });
                break;
            case R.id.ll_feedback:
                //意见反馈
                openActivity(FeedbackActivity.class);
                break;
            case R.id.ll_update:
                //软件更新
                if (android.text.TextUtils.isEmpty(apkUrl)) {
                    return;
                }
                PackageManager manager = this.getPackageManager();
                final PackageInfo info;
                try {
                    info = manager.getPackageInfo(this.getPackageName(), 0);
                    String versionName = info.versionName;
                    if (!versionName.equals(appVersion)) {
                        DialogUtils.showSettingDialog(this, false, "检查到新版本" + appVersion, "去更新", R.color.color_6ace89, new DialogUtils.onCommitListener() {
                            @Override
                            public void onCommit() {
                                Intent intent = new Intent(SettingActivity.this, ApplicationUpdateService.class);
                                intent.putExtra("url", apkUrl);
                                startService(intent);
                            }
                        });
                    } else {
                        toast("您已是最新版本！");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.ll_mine:
                //关于我们
                openActivity(AboutUsActivity.class);
                break;
            case R.id.tv_logout:
                //退出登录
                DialogUtils.showSettingDialog(this, false, "确定要退出本次登录", "确定", R.color.color_1f1f1f, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        PrefUtils.setBoolean(mContext, "isLogin", false);
                        MyApplication.sCompanyLoginBean = null;
                        MyApplication.sTeamLoginBean = null;
                        EventBus.getDefault().post(new LogoutEvent());
                        finish();
                    }
                });
                break;
        }
    }


    //请求权限
    private void requestRxPermissions(final String... permissions) {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(permissions).subscribe(new Consumer<Boolean>() {


            @Override
            public void accept(@NonNull Boolean granted) throws Exception {
                if (granted) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + AppConstants.SERVICETEL));
                    if (intent.resolveActivity(SettingActivity.this.getPackageManager()) != null) {
                        if (ActivityCompat.checkSelfPermission(SettingActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(intent);
                    }
                } else {

                }
            }
        });
    }
}
