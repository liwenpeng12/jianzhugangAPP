package com.jlkg.jzg.jzg_android.job.activitys;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PreFiled;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 招工详情
 */
public class JobDetailActivity extends BaseActivity {


    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_need_left)
    TextView mTvNeedLeft;
    @BindView(R.id.lin_need)
    LinearLayout mLinNeed;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.tv_type_left)
    TextView mTvTypeLeft;
    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.tv_type_right)
    TextView mTvTypeRight;
    @BindView(R.id.tv_project_name)
    TextView tvProjectName;
    @BindView(R.id.tv_project_address)
    TextView tvProjectAddress;
    @BindView(R.id.tv_push_time)
    TextView tvPushTime;
    @BindView(R.id.tv_contract_name)
    TextView tvContractName;
    @BindView(R.id.tv_need)
    TextView tvNeed;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    private int mType;
    public static final int ZHULIN = 1;
    public static final int ZHAOGONG = 2;
    private int mId;
    private String TypeString = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_job_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getInt("type");
            mId = getIntent().getExtras().getInt("id");
        }
        /*if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getInt("type");
            mLinNeed.setVisibility(mType == 3 ? View.GONE : View.VISIBLE);
            mLine.setVisibility(mType == 3 ? View.GONE : View.VISIBLE);
            mTvNeedLeft.setText(mType == 1 ? "人员需求：" : "机械需求：");
            mTvNeedLeft.setText(mType == 2 ? "机械数量：" : "类型：");
            if (mType == 1) {
                mLinNeed.setVisibility(View.VISIBLE);
                mLine.setVisibility(View.VISIBLE);
            }
        }*/
        mMyToolbar.setTitleText(mType == 1 ? "招租详情" : "招工详情");
        mTvNeedLeft.setText(mType == 1 ? "机械需求：" : "人员需求：");
        mTvTypeLeft.setText(mType == 1 ? "机械数量：" : "类型：");
        mBtnBottom.setText(mType == 1 ? "申请招租" : "申请招工");
        mBtnBottom.setVisibility(mType == 1 ? View.GONE : View.VISIBLE);
        mTvTypeRight.setTextColor(mType == 1 ? getResources().getColor(R.color.color_6ace89) : getResources().getColor(R.color.text_333333));
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        if (mType == 2) {
            ApiManager.projectHireDetail(mId,this, new HttpUtils.OnCallBack() {
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
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1)
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人");
                        else
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人").append(",");
                    }
                    mBtnBottom.setVisibility((bean.getType() != null && bean.getType().getId().equals("PROJECT_TYPE_WORKER") && !MyApplication.isCompany) || (bean.getType() != null && !bean.getType().getId().equals("PROJECT_TYPE_WORKER") && MyApplication.isCompany) ? View.VISIBLE : View.GONE);
                    if(getIntent().getExtras().getInt("myuser",0)==1){
                        mBtnBottom.setVisibility(View.GONE);
                    }
                    TextUtils.setText(tvNeed, builder.toString());
                    if (bean.getType() != null)
                        TextUtils.setText(mTvTypeRight, bean.getType().getText());
                    TextUtils.setText(tvPrice, bean.getSalary());
                    TextUtils.setText(tvRemark, bean.getMemo());
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                }
            });
            if (PrefUtils.getBoolean(mContext, PreFiled.ISLOGIN, false))
                getApplyStatus();
        } else {
            ApiManager.machineItem(mId, this,new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    JIXieZulinBean parentBean = JSON.parseObject(response, JIXieZulinBean.class);
                    JIXieZulinBean.ContentBean bean = parentBean.getContent().get(0);
                    TextUtils.setText(tvProjectName, bean.getTitle());
                    TextUtils.setText(tvProjectAddress, bean.getStreetAddress());
                    TextUtils.setText(tvPushTime, bean.getCreateDate());
                    TextUtils.setText(tvContractName, bean.getContacts());
                    TextUtils.setText(mTvPhone, bean.getMobile());
                    mBtnBottom.setVisibility(bean.getProjectId() == 0 ? View.GONE : View.VISIBLE);
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
        ApiManager.projectApplyStatus(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(), mId, this,new HttpUtils.OnCallBack() {
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
        if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null) {
                DialogUtils.showNoLoginDialog(mContext);
                return;
            } /*else if (MyApplication.sCompanyLoginBean.getCompanyType() == null) {
                DialogUtils.showInvitedDia(mContext, true);
                return;
            }*/
        } else {
            if (MyApplication.sTeamLoginBean == null) {
                DialogUtils.showNoLoginDialog(mContext);
                return;
            } /*else if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                DialogUtils.showInvitedDia(mContext, true);
                return;
            }*/
        }
        if (mType == 2) {
            applyWork();
        } else {
            applyLease();
        }
    }

    /**
     * 申请招租
     */
    private void applyLease() {
        ApiManager.applyMachineAsk(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(), mId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                DialogUtils.showToastDialog(mContext, "申请成功，等待\n" +
                        "发布方同意");
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }


    /**
     * 申请招工
     */
    private void applyWork() {
        if ((MyApplication.isCompany && MyApplication.sCompanyLoginBean == null) || (MyApplication.isCompany && !MyApplication.sCompanyLoginBean.getCompanyType().getId().equals("COMPANY_TYPE_2") && mType == ZHAOGONG)) {
            showToast("你无权限申请项目");
            return;
        }
        ApiManager.updateApplyStatus(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(), mId,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                DialogUtils.showToastDialog(mContext, "申请成功，等待\n" +
                        "发布方同意");
                getApplyStatus();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    @OnClick(R.id.tv_phone)
    void callPhone() {
        if (!android.text.TextUtils.isEmpty(mTvPhone.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(this, mTvPhone.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(JobDetailActivity.this, mTvPhone.getText().toString().trim());
                }
            });
    }

}
