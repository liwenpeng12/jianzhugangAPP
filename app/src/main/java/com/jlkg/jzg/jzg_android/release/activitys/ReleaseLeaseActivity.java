package com.jlkg.jzg.jzg_android.release.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.LetMachineActivity;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class ReleaseLeaseActivity extends TextWatcherBaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.tv_person)
    TextView mTvPerson;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.tv_need)
    TextView mTvNeed;
    @BindView(R.id.et_remark)
    EditText mEtRemark;
    @BindView(R.id.et_amount)
    EditText mEtAmount;
    private String districtId;
    private String typeString, numString, modleString;
    public static final int PHONE = 1;
    public static final int ADDRESS = 2;
    public static final int NEED = 3;
    public int mProjectId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_lease;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mEtName.addTextChangedListener(this);
        mEtMoney.addTextChangedListener(this);
        mTvPerson.addTextChangedListener(this);
        mTvAddress.addTextChangedListener(this);
        mTvPhone.addTextChangedListener(this);
        mTvNeed.addTextChangedListener(this);
        mEtAmount.addTextChangedListener(this);
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null)
            mTvPhone.setText(MyApplication.sCompanyLoginBean.getUserName());
        else if (!MyApplication.isCompany && MyApplication.sTeamLoginBean != null)
            mTvPhone.setText(MyApplication.sTeamLoginBean.getUserName());
    }

    @Override
    protected void initData() {
        super.initData();
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null) {
            setLoading(true);
            //通过公司Id查找项目
            ApiManager.querById(MyApplication.sCompanyLoginBean.getId() + "", this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    setLoading(false);
                    OrganizationBean organizationBean = JSON.parseObject(response, OrganizationBean.class);
                    if (organizationBean == null) {
//                        toast("您的公司还没有项目，请先添加项目");
                    } else {
                        com.jlkg.jzg.jzg_android.utils.TextUtils.setText(mEtName, organizationBean.name);
                        com.jlkg.jzg.jzg_android.utils.TextUtils.setText(mTvAddress, organizationBean.streetAddress);
                        if (organizationBean.district != null) {
                            districtId = organizationBean.district.id + "";
                        }
                        mProjectId = organizationBean.id;
                        mEtName.setEnabled(false);
                        mTvAddress.setEnabled(false);
                    }
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
//                    toast("您的公司还没有项目，请先添加项目");
                }
            });
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        String s1 = mEtName.getText().toString().trim();
        String s2 = mTvPerson.getText().toString().trim();
        String s3 = mTvPhone.getText().toString().trim();
        String s4 = mTvAddress.getText().toString().trim();
        String s5 = mTvNeed.getText().toString().trim();
        String s7 = mEtMoney.getText().toString().trim();
        String s8 = mEtAmount.getText().toString().trim();
        mBtnBottom.setEnabled(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3)
                && !TextUtils.isEmpty(s4) && !TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s7) && !TextUtils.isEmpty(s8));
    }

    @OnClick({R.id.tv_phone, R.id.tv_address, R.id.tv_need})
    void click(View v) {
        switch (v.getId()) {
            case R.id.tv_phone:
                openActivityForResult(InputPhoneNumActivity.class, PHONE);
                break;
            case R.id.tv_address:
                openActivityForResult(SelectAddressActivity.class, ADDRESS);
                break;
            case R.id.tv_need:
                Bundle bundle = new Bundle();
                bundle.putInt("type", NeedActivity.JIXIENEED);
                openActivityForResult(NeedActivity.class, NEED, bundle);
                break;
        }
    }

    //发布
    @OnClick(R.id.btn_bottom)
    void release() {
        /*if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null) {
                DialogUtils.showNoLoginDialog(mContext);
                return;
            } else if (MyApplication.sCompanyLoginBean.getCompanyType() == null) {
                DialogUtils.showInvitedDia(mContext, true);
                return;
            }
        } else {
            if (MyApplication.sTeamLoginBean == null) {
                DialogUtils.showNoLoginDialog(mContext);
                return;
            } else if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                DialogUtils.showInvitedDia(mContext, true);
                return;
            }
        }*/
//        openActivity(LetMachineActivity.class);
        setLoading(true);
        int id = 0;
        if (MyApplication.sTeamLoginBean == null && MyApplication.sCompanyLoginBean == null) {
            id = 0;
        } else if (MyApplication.isCompany) {
            id = MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId();
        }
        ApiManager.machineAsksSave(id, mEtName.getText().toString().trim(), mTvPerson.getText().toString().trim(), mTvPhone.getText().toString().trim(),
                districtId, mTvAddress.getText().toString().trim(), mEtMoney.getText().toString().trim(), numString,
                typeString, mEtAmount.getText().toString().trim(), mEtRemark.getText().toString().trim(), mProjectId,this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        showToast("发布成功，请耐心等待审核");
                        finish();
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PHONE:
                    mTvPhone.setText(data.getStringExtra("phone"));
                    break;
                case ADDRESS:
                    districtId = data.getStringExtra("districtId");
                    mTvAddress.setText(data.getStringExtra("address"));
                    break;
                case NEED:
                    mTvNeed.setText(data.getStringExtra("need"));
                    typeString = data.getStringExtra("type");
                    numString = data.getStringExtra("num");
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        NeedActivity.mList = null;
        super.onDestroy();
    }
}
