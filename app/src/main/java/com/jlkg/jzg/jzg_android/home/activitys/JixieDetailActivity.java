package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JixieDetailActivity extends BaseActivity {
    @BindView(R.id.iv_heard)
    ImageView ivHeard;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_contract_phone)
    TextView tvContractPhone;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_modle)
    TextView tvModle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.tv_jixie_name)
    TextView tvJixieName;
    private int mId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_jixie_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mId = getIntent().getExtras().getInt("id");
        }
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.machineItem(mId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                JIXieZulinBean parentBean = JSON.parseObject(response, JIXieZulinBean.class);
                JIXieZulinBean.ContentBean bean = parentBean.getContent().get(0);
                TextUtils.setText(tvName, bean.getTitle());
                TextUtils.setText(tvJixieName, bean.getTitle());
                TextUtils.setText(tvContractPhone, bean.getMobile());
                GlideUtils.LoadImgCircleCrop(mContext, bean.getImage(), ivHeard);
               /* if (bean.getMachine() != null) {
                    if (bean.getMachine().getImage() != null)
                        GlideApp.with(mContext).load(bean.getMachine().getImage().getUrl()).circleCrop().into(ivHeard);
                }*/
                if (bean.getType() != null)
                    TextUtils.setText(tvType, bean.getType().getText());
                TextUtils.setText(tvModle, bean.getShuoming());
                TextUtils.setText(tvNum, bean.getAmount() + "");
                TextUtils.setText(tvAddress, bean.getStreetAddress());
                   /* int size = bean.getTeamNeeds().size();
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1)
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber());
                        else
                            builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                                    .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append(",");
                    }*/
                TextUtils.setText(tvRemark, bean.getMemo());
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_contract_phone)
    void callPhone() {
        if (!android.text.TextUtils.isEmpty(tvContractPhone.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(this, tvContractPhone.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(JixieDetailActivity.this, tvContractPhone.getText().toString().trim());
                }
            });
    }
}
