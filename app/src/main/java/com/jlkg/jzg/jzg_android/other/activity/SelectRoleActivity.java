package com.jlkg.jzg.jzg_android.other.activity;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.utils.PreFiled;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectRoleActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    MyToolbar mToolbar;
    @BindView(R.id.iv_company_select)
    ImageView mIvCompanySelect;
    @BindView(R.id.fl_company)
    FrameLayout mFlCompany;
    @BindView(R.id.iv_class_select)
    ImageView mIvClassSelect;
    @BindView(R.id.fl_class)
    FrameLayout mFlClass;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_role;
    }


    @OnClick(R.id.fl_company)
    void selectCompany() {
        mFlCompany.setSelected(true);
        mFlClass.setSelected(false);
        mIvCompanySelect.setVisibility(View.VISIBLE);
        mIvClassSelect.setVisibility(View.GONE);
        mFlCompany.postDelayed(new Runnable() {
            @Override
            public void run() {
                PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, true);
                MyApplication.isCompany = true;
//                EventBus.getDefault().post("login");
                MyApplication.hasSelectRole = true;
                setResult(Activity.RESULT_OK);
                finish();
//                openActivity(MainActivity.class);
            }
        }, 500);
    }

    @OnClick(R.id.fl_class)
    void selectClass() {
        mFlClass.setSelected(true);
        mFlCompany.setSelected(false);
        mIvCompanySelect.setVisibility(View.GONE);
        mIvClassSelect.setVisibility(View.VISIBLE);
        mFlClass.postDelayed(new Runnable() {
            @Override
            public void run() {
                PrefUtils.setBoolean(mContext, PreFiled.ISCOMPANY, false);
                MyApplication.isCompany = false;
//                EventBus.getDefault().post("login");
                MyApplication.hasSelectRole = true;
                setResult(Activity.RESULT_OK);
                finish();
//                openActivity(MainActivity.class);
            }
        }, 500);
    }
}
