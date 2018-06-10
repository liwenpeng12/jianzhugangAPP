package com.jlkg.jzg.jzg_android.contract.activitys;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.contract.adapters.ContractDetailAppListAdapter;
import com.jlkg.jzg.jzg_android.contract.beans.ContractDetailBean;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class ContractDetailActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.btn_bottom_left)
    Button mBtnBottomLeft;
    @BindView(R.id.btn_bottom_right)
    Button mBtnBottomRight;
    @BindView(R.id.lin_bottom)
    LinearLayout mLinBottom;
    @BindView(R.id.fl_bottom)
    FrameLayout mFlBottom;
    @BindView(R.id.iv_heard)
    ImageView mIvHeard;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.tv_contract_name)
    TextView mTvContractName;
    @BindView(R.id.tv_need_left)
    TextView mTvNeedLeft;
    @BindView(R.id.tv_need_right)
    TextView mTvNeedRight;
    @BindView(R.id.lin_need)
    LinearLayout mLinNeed;
    @BindView(R.id.tv_type_left)
    TextView mTvTypeLeft;
    @BindView(R.id.tv_type_right)
    TextView mTvTypeRight;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_node)
    TextView mTvNode;
    @BindView(R.id.iv_apply_heard)
    ImageView mIvApplyHeard;
    @BindView(R.id.tv_apply_name)
    TextView mTvApplyName;
    @BindView(R.id.tv_apply_phone)
    TextView mTvApplyPhone;
    @BindView(R.id.iv_call)
    ImageView mIvCall;
    @BindView(R.id.tv_remark)
    TextView mTvRemark;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.lin_apply_list)
    LinearLayout mLinApplyList;
    @BindView(R.id.lin_type)
    LinearLayout mLinType;
    private int mType;
    public static final int APPLYTEAM = 1;//申请，类型：班组
    public static final int APPLYCOMPANY = 2;//申请，类型：劳务公司
    public static final int SIGNING = 3;//签约
    public static final int PAYAPPLY = 4;//付款申请
    public static final int PAYCONFIM = 5;//付款确认
    public static final int PLATFORMPAY = 6;//平台付款
    public static final int PAYCOMPLETE = 7;//付款完成
    public static final int COMPLETE = 8;//已完成
    public static final int CANCEL = 9;//已终止
    private int mId;
    private ContractDetailBean mBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getInt("type");
            mId = getIntent().getExtras().getInt("id");
        }
        mTvAddress.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mMyToolbar.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", ApiManager.getContractDetailUrl(mId));
                openActivity(WebActivity.class, bundle);
            }
        });
    }


    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.contactsDetail(mId,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                mBean = JSON.parseObject(response, ContractDetailBean.class);
                switch (mBean.getStatus().getId()) {
                    case "CONTRACT_STATUS_SUBMITED":
                        if (mBean.getProjectApply() != null && mBean.getProjectApply().getProjectHire() != null
                                && mBean.getProjectApply().getProjectHire().getType() != null
                                && mBean.getProjectApply().getProjectHire().getType().getId().equals("PROJECT_TYPE_LAO_WU")) {
                            mType = APPLYCOMPANY;
                        } else {
                            mType = APPLYTEAM;
                        }
                        break;
                    case "CONTRACT_STATUS_SIGNED":
                        mType = SIGNING;
                        break;
                    case "CONTRACT_STATUS_WAIT_PAY":
                        mType = PAYAPPLY;
                        break;
                    case "CONTRACT_STATUS_DONE":
                        mType = COMPLETE;
                        break;
                    case "CONTRACT_STATUS_CANCELED":
                        mType = CANCEL;
                        break;
                }
                setView();
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    @OnClick(R.id.iv_call)
    void call() {
        if (!android.text.TextUtils.isEmpty(mTvApplyPhone.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(this, mTvApplyPhone.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(ContractDetailActivity.this, mTvApplyPhone.getText().toString().trim());
                }
            });
    }

    private void setView() {
        if (mBean == null) return;
        if (mBean.getCompany() != null) {
            TextUtils.setText(mTvName, mBean.getCompany().getTitle());
            if (mBean.getCompany().getTouxiang() != null)
                GlideUtils.LoadImgCircleCrop(mContext, mBean.getCompany().getTouxiang().getUrl(), mIvHeard);
        }
        TextUtils.setText(mTvContractName, mBean.getTitle());
//        if (mBean.getProjectApply() != null && mBean.getProjectApply().getProjectHire() != null && mBean.getProjectApply().getProjectHire().getProject() != null)
//            TextUtils.setText(mTvAddress, mBean.getProjectApply().getProjectHire().getProject().getStreetAddress());
        if (mBean.getProject() != null) {
            TextUtils.setText(mTvAddress, mBean.getProject().getDisplayAddress());
        }
        TextUtils.setText(mTvTime, mBean.getCreateDate());
        TextUtils.setText(mTvNode, mBean.getContractNo());

        if (mBean.getTeam() != null) {
            TextUtils.setText(mTvApplyName, mBean.getTeam().getTitle());
            if (mBean.getTeam().getPhoto() != null)
                GlideUtils.LoadImgCircleCrop(mContext, mBean.getTeam().getPhoto().getUrl(), mIvApplyHeard);
            else
                GlideUtils.LoadImgCircleCrop(mContext, null, mIvApplyHeard);
            if (android.text.TextUtils.isEmpty(mBean.getTeam().getPhone())) {
                TextUtils.setText(mTvApplyPhone, mBean.getTeam().getUserName());
            } else {
                TextUtils.setText(mTvApplyPhone, mBean.getTeam().getPhone());
            }
            TextUtils.setText(mTvRemark, mBean.getTeam().getNotes());
        } else if (mBean.getApplyCompany() != null) {
            TextUtils.setText(mTvApplyName, mBean.getApplyCompany().getTitle());
            if (mBean.getApplyCompany().getTouxiang() != null)
                GlideUtils.LoadImgCircleCrop(mContext, mBean.getApplyCompany().getTouxiang().getUrl(), mIvApplyHeard);
            else
                GlideUtils.LoadImgCircleCrop(mContext, null, mIvApplyHeard);
            if (android.text.TextUtils.isEmpty(mBean.getApplyCompany().getPhone())) {
                TextUtils.setText(mTvApplyPhone, mBean.getApplyCompany().getUserName());
            } else {
                TextUtils.setText(mTvApplyPhone, mBean.getApplyCompany().getPhone());
            }
            TextUtils.setText(mTvRemark, mBean.getApplyCompany().getNotes());
        }
        if (mBean.getProjectApply() != null && mBean.getProjectApply().getProjectHire() != null
                && mBean.getProjectApply().getProjectHire().getTeamNeeds() != null) {
            int size = mBean.getProjectApply().getProjectHire().getTeamNeeds().size();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (i == size - 1)
                    builder.append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getTeamType().getTitle())
                            .append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getPeopleNumber());
                else
                    builder.append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getTeamType().getTitle())
                            .append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getPeopleNumber()).append(",");
            }
            TextUtils.setText(mTvNeedRight, builder.toString() + "人");
        }
        if (mBean.getProjectApply() != null && mBean.getProjectApply().getProjectHire() != null && mBean.getProjectApply().getProjectHire().getType() != null) {
            mTvTypeRight.setText(mBean.getProjectApply().getProjectHire().getType().getText());
        }


        switch (mType) {
            case APPLYTEAM:
                if (mBean.getProjectApply() != null && mBean.getProjectApply().getProjectHire() != null
                        && mBean.getProjectApply().getProjectHire().getTeamNeeds() != null) {
                    int size = mBean.getProjectApply().getProjectHire().getTeamNeeds().size();
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1)
                            builder.append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getPeopleNumber());
                        else
                            builder.append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(mBean.getProjectApply().getProjectHire().getTeamNeeds().get(i).getPeopleNumber()).append(",");
                    }
                    TextUtils.setText(mTvNeedRight, builder.toString());
                    mTvTypeRight.setText("班组");
                    mLinApplyList.setVisibility(View.GONE);
                }
//                mLinBottom.setVisibility(View.VISIBLE);
//                mFlBottom.setVisibility(View.VISIBLE);
                break;
            case APPLYCOMPANY:
                mTvTypeRight.setText("劳务公司");
                mLinApplyList.setVisibility(View.GONE);
                mLinNeed.setVisibility(View.GONE);
//                mLinBottom.setVisibility(View.VISIBLE);
//                mFlBottom.setVisibility(View.VISIBLE);
                break;
            case SIGNING:
                mLinApplyList.setVisibility(View.GONE);
                mTvStatus.setText("签约");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_ffb74d));
                break;
            case PAYAPPLY:
                mLinApplyList.setVisibility(View.GONE);
                mTvStatus.setText("付款申请");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_f15e5e));
                break;
            case PAYCONFIM:
//                mLinApplyList.setVisibility(View.VISIBLE);
                mTvStatus.setText("付款确认");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_f15e5e));
//                mBtnBottom.setVisibility(View.VISIBLE);
                mBtnBottom.setText("确认付款");
//                mFlBottom.setVisibility(View.VISIBLE);
                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
                mRecycleView.setAdapter(new ContractDetailAppListAdapter(this, null));
                break;
            case PLATFORMPAY:
//                mLinApplyList.setVisibility(View.VISIBLE);
                mTvStatus.setText("平台付款");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_f15e5e));
                break;
            case PAYCOMPLETE:
//                mLinApplyList.setVisibility(View.VISIBLE);
                mTvStatus.setText("付款到账");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_f15e5e));
                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
                mRecycleView.setAdapter(new ContractDetailAppListAdapter(this, null));
                break;
            case COMPLETE:
//                mLinApplyList.setVisibility(View.VISIBLE);
                mTvStatus.setText("已完成");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_63b5f6));
//                mBtnBottom.setVisibility(View.VISIBLE);
                mBtnBottom.setText("删除");
//                mFlBottom.setVisibility(View.VISIBLE);
                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
                mRecycleView.setAdapter(new ContractDetailAppListAdapter(this, null));
                break;
            case CANCEL:
                mTvStatus.setText("已终止");
                mTvStatus.setBackgroundColor(getResources().getColor(R.color.color_c2c2c2));
//                mBtnBottom.setVisibility(View.VISIBLE);
                mBtnBottom.setText("删除");
//                mFlBottom.setVisibility(View.VISIBLE);
                break;
        }
        if (mBean.getProjectApply() != null && mBean.getProjectApply().getMachineAskId() != 0) {
            machineItem(mBean.getProjectApply().getMachineAskId());
            mTvNeedLeft.setText("机械需求：");
            mLinType.setVisibility(View.GONE);
            mLinApplyList.setVisibility(View.GONE);
        }
    }

    /**
     * 获取机械详情
     */
    private void machineItem(int id) {
        ApiManager.machineItem(id,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                JIXieZulinBean parentBean = JSON.parseObject(response, JIXieZulinBean.class);
                JIXieZulinBean.ContentBean bean = parentBean.getContent().get(0);
                if (bean.getType() != null) {
                    TextUtils.setText(mTvNeedRight, bean.getType().getText() + bean.getShuoming());
                } else {
                    TextUtils.setText(mTvNeedRight, bean.getShuoming());
                }
            }

            @Override
            public void onError(String msg) {
            }
        });
    }
}
