package com.jlkg.jzg.jzg_android.personal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;
import com.jlkg.jzg.jzg_android.release.activitys.InputPhoneNumActivity;
import com.jlkg.jzg.jzg_android.release.activitys.NeedActivity;
import com.jlkg.jzg.jzg_android.release.activitys.SelectAddressActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgainReleaseProjectActivity extends TextWatcherBaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.tv_project_name)
    EditText tvProjectName;
    @BindView(R.id.tv_project_address)
    TextView tvProjectAddress;
    @BindView(R.id.tv_push_time)
    TextView tvPushTime;
    @BindView(R.id.tv_contract_name)
    TextView tvContractName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_need_left)
    TextView mTvNeedLeft;
    @BindView(R.id.tv_need)
    TextView tvNeed;
    @BindView(R.id.lin_need)
    LinearLayout mLinNeed;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.tv_type_left)
    TextView mTvTypeLeft;
    @BindView(R.id.tv_type_right)
    TextView mTvTypeRight;
    @BindView(R.id.tv_price)
    EditText tvPrice;
    @BindView(R.id.tv_remark)
    EditText tvRemark;
    private int mId;
    private int mType;
    private String TypeString = "";
    public static final int PHONE = 1;
    public static final int ADDRESS = 2;
    public static final int NEED = 3;
    private String districtId, provinceId;
    private String typeString, numString, modleString;
    private boolean canAdd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_again_release_project;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getInt("type");
            mId = getIntent().getExtras().getInt("id");
        }
        tvProjectName.addTextChangedListener(this);
        tvPrice.addTextChangedListener(this);
        tvContractName.addTextChangedListener(this);
        tvProjectAddress.addTextChangedListener(this);
        mTvPhone.addTextChangedListener(this);
        tvNeed.addTextChangedListener(this);
        mTvTypeRight.addTextChangedListener(this);
        mMyToolbar.setTitleText(mType == 1 ? "招租详情" : "招工详情");
        mTvNeedLeft.setText(mType == 1 ? "机械需求：" : "人员需求：");
        mTvTypeLeft.setText(mType == 1 ? "机械数量：" : "类型：");
//        mBtnBottom.setText(mType == 1 ? "申请招租" : "申请招工");
        mBtnBottom.setVisibility(mType == 1 ? View.GONE : View.VISIBLE);
        mTvTypeRight.setTextColor(mType == 1 ? getResources().getColor(R.color.color_6ace89) : getResources().getColor(R.color.text_333333));
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        String s1 = tvProjectName.getText().toString().trim();
        String s2 = tvContractName.getText().toString().trim();
        String s3 = mTvPhone.getText().toString().trim();
        String s4 = tvProjectAddress.getText().toString().trim();
        String s5 = tvNeed.getText().toString().trim();
        String s6 = mTvTypeRight.getText().toString().trim();
        String s7 = tvPrice.getText().toString().trim();
        mBtnBottom.setEnabled(!android.text.TextUtils.isEmpty(s1) && !android.text.TextUtils.isEmpty(s2) && !android.text.TextUtils.isEmpty(s3)
                && !android.text.TextUtils.isEmpty(s4) && (!android.text.TextUtils.isEmpty(s6) || !MyApplication.isCompany) && !android.text.TextUtils.isEmpty(s5) && !android.text.TextUtils.isEmpty(s7));
    }

    @OnClick({R.id.tv_phone, R.id.tv_project_address, R.id.tv_type_right, R.id.tv_need})
    void click(View v) {
        switch (v.getId()) {
            case R.id.tv_phone:
                openActivityForResult(InputPhoneNumActivity.class, PHONE);
                break;
            case R.id.tv_project_address:
                openActivityForResult(SelectAddressActivity.class, ADDRESS);
                break;
            case R.id.tv_type_right:
                DialogUtils.showZhaoGongTypeDialog(this, new DialogUtils.onReasonListener() {
                    @Override
                    public void onReason(int position) {
                        if (position == 0) mTvTypeRight.setText("全部");
                        else if (position == 1) {
                            mTvTypeRight.setText("劳务公司");
                            modleString = "PROJECT_TYPE_LAO_WU";
                        } else if (position == 2) {
                            mTvTypeRight.setText("班组");
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

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null) {
            setLoading(true);
            //通过公司Id查找项目
            ApiManager.querById(MyApplication.sCompanyLoginBean.getId() + "", this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    OrganizationBean organizationBean = JSON.parseObject(response, OrganizationBean.class);
                    if (organizationBean == null) {
                    } else {
                        tvProjectName.setEnabled(false);
                        tvProjectAddress.setEnabled(false);
                        canAdd = true;
                    }
                }

                @Override
                public void onError(String msg) {
//                    toast("您的公司还没有项目，请先添加项目");
                }
            });
        }
        if (mType == 2) {
            ApiManager.projectHireDetail(mId, this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    ProjectListBean.ContentBean bean = JSON.parseObject(response, ProjectListBean.ContentBean.class);
                    if (bean.getType() != null)
                        TypeString = bean.getType().getId();
                    if (bean.getProject() != null)
                        TextUtils.setText(tvProjectName, bean.getProject().getName());
                    if (bean.getProject() != null) {
                        TextUtils.setText(tvProjectAddress, bean.getProject().getDisplayAddress());
                    }
                    TextUtils.setText(tvPushTime, bean.getPublishedTime());
                    TextUtils.setText(tvContractName, bean.getContacts());
                    TextUtils.setText(mTvPhone, bean.getPhone());
                    int size = bean.getTeamNeeds().size();
                    StringBuilder builder = new StringBuilder();
                    StringBuilder typeBuild = new StringBuilder();
                    StringBuilder numBuild = new StringBuilder();
//                    canAdd = (bean.getProject() != null);
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1) {
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人");
                            typeBuild.append(bean.getTeamNeeds().get(i).getTeamType().getId());
                            numBuild.append(bean.getTeamNeeds().get(i).getPeopleNumber());
                        } else {
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人").append(",");
                            typeBuild.append(bean.getTeamNeeds().get(i).getTeamType().getId()).append(",");
                            numBuild.append(bean.getTeamNeeds().get(i).getPeopleNumber()).append(",");
                        }

                    }

                    typeString = typeBuild.toString();
                    numString = numBuild.toString();

//                    mBtnBottom.setVisibility((bean.getType() != null && bean.getType().getId().equals("PROJECT_TYPE_WORKER") && !MyApplication.isCompany) || (bean.getType() != null && !bean.getType().getId().equals("PROJECT_TYPE_WORKER") && MyApplication.isCompany) ? View.VISIBLE : View.GONE);
                    TextUtils.setText(tvNeed, builder.toString());
                    if (bean.getType() != null) {
                        TextUtils.setText(mTvTypeRight, bean.getType().getText());
                        modleString = bean.getType().getId();
                    }
//                    if (bean.getProject() != null && bean.getProject().getDistrict() != null)
//                        districtId = bean.getProject().getDistrict().getId() + "";
                    districtId = bean.getCityId() + "";
                    TextUtils.setText(tvPrice, bean.getSalary());
                    TextUtils.setText(tvRemark, bean.getMemo());
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                }
            });
            /*if (PrefUtils.getBoolean(mContext, PreFiled.ISLOGIN, false))
                getApplyStatus();*/
        } else {
            ApiManager.machineItem(mId, this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    JIXieZulinBean parentBean = JSON.parseObject(response, JIXieZulinBean.class);
                    JIXieZulinBean.ContentBean bean = parentBean.getContent().get(0);
                    TextUtils.setText(tvProjectName, bean.getTitle());
                    TextUtils.setText(tvProjectAddress, bean.getStreetAddress());
                    TextUtils.setText(tvPushTime, bean.getCreateDate());
                    TextUtils.setText(tvContractName, bean.getContacts());
                    TextUtils.setText(mTvPhone, bean.getMobile());
                    if (bean.getType() != null) {
                        TextUtils.setText(tvNeed, bean.getType().getText() + bean.getShuoming());
                    } else {
                        TextUtils.setText(tvNeed, bean.getShuoming());
                    }
                    TextUtils.setText(mTvTypeRight, bean.getAmount() + "");
                    TextUtils.setText(tvPrice, bean.getPrice());
                    TextUtils.setText(tvRemark, bean.getMemo());
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                }
            });
        }
    }

    private void getApplyStatus() {
        ApiManager.projectApplyStatus(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(), mId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<ProjectListBean.ContentBean> lists = JSON.parseArray(response, ProjectListBean.ContentBean.class);
                mBtnBottom.setEnabled(lists == null || lists.size() < 1);
                if (mBtnBottom.isEnabled()) {
                    mBtnBottom.setText("项目申请");
                } else {
                    mBtnBottom.setText("已申请");
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    @OnClick(R.id.btn_bottom)
    void bottomClick() {
        setLoading(true);
        ApiManager.addProjectHire(tvProjectName.getText().toString(), tvContractName.getText().toString().trim(),
                mTvPhone.getText().toString(), districtId, provinceId, tvProjectAddress.getText().toString(), tvPrice.getText().toString().trim(),
                typeString, numString, modleString, tvRemark.getText().toString().trim(), canAdd, this,
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
                    tvProjectAddress.setText(data.getStringExtra("address"));
                    provinceId = data.getStringExtra("provinceId");
                    break;
                case NEED:
                    tvNeed.setText(data.getStringExtra("need"));
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    /*@OnClick(R.id.tv_phone)
    void callPhone() {
        if (!android.text.TextUtils.isEmpty(mTvPhone.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(this, mTvPhone.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(AgainReleaseProjectActivity.this, mTvPhone.getText().toString().trim());
                }
            });
    }*/
}
