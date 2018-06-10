package com.jlkg.jzg.jzg_android.personal.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineCompanyInfoActivity extends BaseActivity {


    @BindView(R.id.tv_company_address)
    TextView tvCompanyAddress;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_isDen)
    TextView tvIsDen;
    @BindView(R.id.tv_company_number)
    TextView tvCompanyNumber;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_memo)
    TextView tvMemo;
    @BindView(R.id.tv_fixedLine)
    TextView tvFixedLine;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_website)
    TextView tvWebsite;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_company_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        initViews();
    }

    @Override
    protected void initViews() {
        super.initViews();

        myToolbar.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        tvCompanyAddress.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        if (MyApplication.sCompanyLoginBean == null) {
            return;
        }

        tvCompanyName.setText(MyApplication.sCompanyLoginBean.getTitle());
        tvCompanyNumber.setText(MyApplication.sCompanyLoginBean.getOrganizationCode());
        if (MyApplication.sCompanyLoginBean.getCompanyType() != null) {
            tvIsDen.setText("已认证");
            tvType.setText(MyApplication.sCompanyLoginBean.getCompanyType().getText());
        } else {
            tvIsDen.setText("未认证");
        }

        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.streetAddress)) {
            tvCompanyAddress.setText("公司地址：" + MyApplication.sCompanyLoginBean.streetAddress);
        }
        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getNotes())
                && !"null".equals(MyApplication.sCompanyLoginBean.getNotes())) {
            tvMemo.setText(MyApplication.sCompanyLoginBean.getNotes() + "");
        }
        tvName.setText(MyApplication.sCompanyLoginBean.getContacts());
        tvPhone.setText(MyApplication.sCompanyLoginBean.getPhone());

        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getFax())) {
            tvFixedLine.setText(MyApplication.sCompanyLoginBean.getFax());
        }

        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getEmail())) {
            tvEmail.setText(MyApplication.sCompanyLoginBean.getEmail());
        }

        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getWebsite())) {
            tvWebsite.setText(MyApplication.sCompanyLoginBean.getWebsite());
        }


    }


    public void update() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", MyApplication.sCompanyLoginBean.getId() + "");
        if(!TextUtils.isEmpty(tvName.getText().toString())) {
            hashMap.put("contacts", tvName.getText().toString());
        }else{
            tvName.requestFocus();
            toast("联系人不能为空");
            return;
        }

       // if(!TextUtils.isEmpty(tvFixedLine.getText().toString())) {
            hashMap.put("fax", tvFixedLine.getText().toString());
      //  }

      //  if(!TextUtils.isEmpty(tvEmail.getText().toString())) {
            hashMap.put("email", tvEmail.getText().toString());
       // }

        //if(!TextUtils.isEmpty(tvWebsite.getText().toString())) {
            hashMap.put("website", tvWebsite.getText().toString());
        //}
        setLoading(true);
        ApiManager.updeateCompany(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {

                ApiManager.getCompanyInfo(MyApplication.sCompanyLoginBean.getId() + "", MineCompanyInfoActivity.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
                        MyApplication.sCompanyLoginBean = bean;
                        finish();
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        toast(msg);
                    }
                });

            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                toast(msg);
            }
        });
    }
}
