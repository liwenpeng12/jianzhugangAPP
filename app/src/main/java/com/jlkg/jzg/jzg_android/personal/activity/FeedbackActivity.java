package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.TimeUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedbackActivity extends BaseActivity {


    @BindView(R.id.tv_content)
    EditText tvContent;
    @BindView(R.id.tv_complete)
    TextView tvComplete;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        tvContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(tvComplete.getText().toString())){
                    tvComplete.setEnabled(true);
                }else{
                    tvComplete.setEnabled(false);
                }
            }
        });
    }

    @OnClick(R.id.tv_complete)
    public void onViewClicked() {

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("advice",tvContent.getText().toString());
        hashMap.put("feedDate", TimeUtils.getAllDate(System.currentTimeMillis())+"");
        if(MyApplication.isCompany) {
            hashMap.put("type","3");
        }else{
            hashMap.put("type","4");
        }
        if (!PrefUtils.getBoolean(this, "isLogin", false)) {
            //未登录

        }else{
            //已登录
            if(MyApplication.isCompany) {
                if(MyApplication.sCompanyLoginBean!=null){
                    hashMap.put("companyId",MyApplication.sCompanyLoginBean.getId()+"");
                    hashMap.put("phone",MyApplication.sCompanyLoginBean.getPhone());
                }
            }else{
                if(MyApplication.sTeamLoginBean!=null) {
                    hashMap.put("teamId", MyApplication.sTeamLoginBean.getId() + "");
                    hashMap.put("phone",MyApplication.sTeamLoginBean.getPhone()+"");
                }
            }
        }
        ApiManager.saveFeedback(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                showToast("感谢您的宝贵意见");
                finish();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
