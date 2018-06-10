package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApproveActivity extends BaseActivity {


    @BindView(R.id.cir_img)
    CircleImageView cirImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_idNumber)
    TextView tvIdNumber;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_approve;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
    }

    public void initView(){
        if(MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean.touxiang != null) {
                if (!android.text.TextUtils.isEmpty(MyApplication.sCompanyLoginBean.touxiang.getUrl())) {
                    Glide.with(this).load(MyApplication.sCompanyLoginBean.touxiang.getUrl()).into(cirImg);
                } else {

                }
            }
            tvName.setText(MyApplication.sCompanyLoginBean.getContacts());
            tvIdNumber.setVisibility(View.GONE);
        }else{
            if (MyApplication.sTeamLoginBean.getPhoto() != null) {
                if (!android.text.TextUtils.isEmpty(MyApplication.sTeamLoginBean.getPhoto().getUrl())) {
                    Glide.with(this).load(MyApplication.sTeamLoginBean.getPhoto().getUrl()).into(cirImg);
                } else {

                }
            }
            tvName.setText(MyApplication.sTeamLoginBean.getTitle());
            tvIdNumber.setVisibility(View.VISIBLE);
            tvIdNumber.setText(MyApplication.sTeamLoginBean.getIdNumber());
        }
    }
}
