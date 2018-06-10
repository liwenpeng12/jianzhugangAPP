package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.event.ChangeRoleEvent;
import com.jlkg.jzg.jzg_android.utils.PreFiled;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassChangeRoleActivity extends BaseActivity {


    @BindView(R.id.img_class)
    ImageView imgClass;
    @BindView(R.id.fl_class)
    FrameLayout flClass;
    @BindView(R.id.tv_class_name)
    TextView tvClassName;
    @BindView(R.id.img_class_approve)
    ImageView imgClassApprove;
    @BindView(R.id.rl_class)
    RelativeLayout rlClass;
    @BindView(R.id.iv_company_select)
    ImageView ivCompanySelect;
    @BindView(R.id.fl_enterprise)
    FrameLayout flEnterprise;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.img_company_approve)
    ImageView imgCompanyApprove;
    @BindView(R.id.rl_company)
    RelativeLayout rlCompany;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_change_role;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);


        if(MyApplication.sCompanyLoginBean!=null){
            tvCompany.setText(MyApplication.sCompanyLoginBean.getTitle());
            if (MyApplication.sCompanyLoginBean.getCompanyType() != null) {
                imgCompanyApprove.setImageResource(R.mipmap.approve);
            } else {
                imgCompanyApprove.setImageResource(R.mipmap.unverified);
            }
        }

        if(MyApplication.sTeamLoginBean!=null){
            if(MyApplication.sTeamLoginBean.getTeamType()!=null) {
                tvClassName.setText(MyApplication.sTeamLoginBean.getTeamType().getTitle());
                imgClassApprove.setImageResource(R.mipmap.approve);
            }else{
                imgClassApprove.setImageResource(R.mipmap.unverified);

            }
        }
    }


    @OnClick({R.id.rl_company, R.id.rl_class})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rl_company:
                if (!MyApplication.isCompany) {
//                    PrefUtils.setBoolean(this, AppConstants.ISLOGIN, false);
                    MyApplication.isCompany = true;
                    ChangeRoleEvent changeRoleEvent = new ChangeRoleEvent();
                    EventBus.getDefault().post(changeRoleEvent);
                    PrefUtils.setBoolean(this, PreFiled.ISCOMPANY, true);
                    setResult(Activity.RESULT_OK);
                }
                finish();
                break;
            case R.id.rl_class:
                /*if (MyApplication.isCompany) {
//                    PrefUtils.setBoolean(this, AppConstants.ISLOGIN, false);
                    MyApplication.isCompany = false;
                    ChangeRoleEvent changeRoleEvent = new ChangeRoleEvent();
                    EventBus.getDefault().post(changeRoleEvent);
                    PrefUtils.getBoolean(this, PreFiled.ISCOMPANY, false);
                    setResult(Activity.RESULT_OK);
                }*/
                finish();
                break;
        }
    }
}
