package com.jlkg.jzg.jzg_android.release.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布招工
 */
public class ReleaseWorkerActivity extends TextWatcherBaseActivity implements View.OnTouchListener {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_need)
    TextView mTvNeed;
    @BindView(R.id.et_remark)
    EditText mEtRemark;
    @BindView(R.id.tv_person)
    TextView mTvPerson;
    public static final int PHONE = 1;
    public static final int ADDRESS = 2;
    public static final int NEED = 3;
    @BindView(R.id.line_type)
    View mLineType;
    @BindView(R.id.lin_type)
    LinearLayout mLinType;
    private String districtId, provinceId;
    private String typeString, numString, modleString;
    private boolean canAdd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_worker;
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
                        mEtName.setEnabled(false);
                        mTvAddress.setEnabled(false);
                        canAdd = true;
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
    protected void initViews() {
        super.initViews();
        mLineType.setVisibility(MyApplication.isCompany ? View.VISIBLE : View.GONE);
        mLinType.setVisibility(MyApplication.isCompany ? View.VISIBLE : View.GONE);
        modleString = MyApplication.isCompany ? "" : "PROJECT_TYPE_WORKER";
        mEtName.addTextChangedListener(this);
        mEtMoney.addTextChangedListener(this);
        mTvPerson.addTextChangedListener(this);
        mTvAddress.addTextChangedListener(this);
        mTvPhone.addTextChangedListener(this);
        mTvNeed.addTextChangedListener(this);
        mEtRemark.setOnTouchListener((View.OnTouchListener) this);
        mTvType.addTextChangedListener(this);
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null)
            mTvPhone.setText(MyApplication.sCompanyLoginBean.getUserName());
        else if (!MyApplication.isCompany && MyApplication.sTeamLoginBean != null)
            mTvPhone.setText(MyApplication.sTeamLoginBean.getUserName());
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        String s1 = mEtName.getText().toString().trim();
        String s2 = mTvPerson.getText().toString().trim();
        String s3 = mTvPhone.getText().toString().trim();
        String s4 = mTvAddress.getText().toString().trim();

        String s5 = mTvNeed.getText().toString().trim();
        String s6 = mTvType.getText().toString().trim();
        String s7 = mEtMoney.getText().toString().trim();
        mBtnBottom.setEnabled(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3)
                && !TextUtils.isEmpty(s4) && (!TextUtils.isEmpty(s6) || !MyApplication.isCompany) && !TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s7));
    }

    @OnClick({R.id.tv_phone, R.id.tv_address, R.id.tv_type, R.id.tv_need})
    void click(View v) {
        switch (v.getId()) {
            case R.id.tv_phone:
                openActivityForResult(InputPhoneNumActivity.class, PHONE);
                break;
            case R.id.tv_address:
                openActivityForResult(SelectAddressActivity.class, ADDRESS);
                break;
            case R.id.tv_type:
                DialogUtils.showZhaoGongTypeDialog(this, new DialogUtils.onReasonListener() {
                    @Override
                    public void onReason(int position) {
                        if (position == 0) mTvType.setText("全部");
                        else if (position == 1) {
                            mTvType.setText("劳务公司");
                            modleString = "PROJECT_TYPE_LAO_WU";
                        } else if (position == 2) {
                            mTvType.setText("班组");
                            modleString = "PROJECT_TYPE_WORKER";
                        }
                    }
                });
                break;
            case R.id.tv_need:
                Bundle bundle = new Bundle();
                bundle.putInt("type", NeedActivity.PERSONNEED);
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
        /*if (!canAdd) {
            toast("您的公司还没有项目，请先添加项目");
            return;
        }*/
        setLoading(true);
        ApiManager.addProjectHire(mEtName.getText().toString(), mTvPerson.getText().toString().trim(),
                mTvPhone.getText().toString(), districtId, provinceId, mTvAddress.getText().toString(), mEtMoney.getText().toString().trim(),
                typeString, numString, modleString, mEtRemark.getText().toString().trim(), canAdd,this,
                new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
//                        openActivity(RecruitWorkersActivity.class);
                        showToast("发布成功，请耐心等待审核");
                        Bundle bundle = new Bundle();
                        bundle.putInt("dex", 1);
                        openActivity(MainActivity.class, bundle);
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
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
                    provinceId = data.getStringExtra("provinceId");
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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        switch (view.getId()) {

            case R.id.et_remark:
                // 解决scrollView中嵌套EditText导致不能上下滑动的问题
                view.getParent().requestDisallowInterceptTouchEvent(true);
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
        }
        return false;
    }

    /**
     * EditText竖直方向是否可以滚动
     * @param editText 需要判断的EditText
     * @return true：可以滚动  false：不可以滚动
     */
    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }
}
