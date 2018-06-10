package com.jlkg.jzg.jzg_android.contract.activitys;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.contract.beans.ContractDetailBean;
import com.jlkg.jzg.jzg_android.contract.beans.ContractEvaBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import butterknife.BindView;
import butterknife.OnClick;

public class ContractEvaluateActivity extends TextWatcherBaseActivity implements RatingBar.OnRatingBarChangeListener {
    public static final int TEAMWORK = 1;//班组招工
    public static final int COMPANYWORK = 2;//公司招工
    public static final int TEAMLEASE = 3;//班组机械；
    public static final int COMPANYLEASE = 4;//公司机械；
    private int mType;
    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.rating_schedule)
    RatingBar mRatingSchedule;
    @BindView(R.id.rating_quality)
    RatingBar mRatingQuality;
    @BindView(R.id.rating_safety)
    RatingBar mRatingSafety;
    @BindView(R.id.rating_integrity)
    RatingBar mRatingIntegrity;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.btn_save)
    Button mBtnSave;

    private int mCompanyId, mTeamId, mProjectId, mMachineAskId, mContractId, mEvaId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract_evaluate;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mEtContent.addTextChangedListener(this);
        mRatingIntegrity.setOnRatingBarChangeListener(this);
        mRatingQuality.setOnRatingBarChangeListener(this);
        mRatingSafety.setOnRatingBarChangeListener(this);
        mRatingSchedule.setOnRatingBarChangeListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getInt("type");
            mCompanyId = getIntent().getExtras().getInt("companyId");
            mTeamId = getIntent().getExtras().getInt("teamId");
            mProjectId = getIntent().getExtras().getInt("projectId");
            mMachineAskId = getIntent().getExtras().getInt("machineAskId");
            mContractId = getIntent().getExtras().getInt("contractId");
        }
        if (mType == COMPANYLEASE || mType == COMPANYWORK) {
            mMyToolbar.setTitleText("评价公司");
        }
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        if (mType == COMPANYLEASE || mType == TEAMLEASE) {
            leaseQuery();
        } else {
            workQuery();
        }
    }


    @OnClick(R.id.btn_save)
    void save() {
        if (mType == COMPANYLEASE || mType == TEAMLEASE) {
            leaseEvaluate();
        } else {
            workEvaluate();
        }
    }

    /**
     * 招工查询评价
     */
    private void workQuery() {
        ApiManager.workQuery(mContractId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ContractDetailBean bean = JSON.parseObject(response, ContractDetailBean.class);
                if (bean != null) {
                    mRatingQuality.setRating(bean.getQualityRating());
                    mRatingSafety.setRating(bean.getSafeRating());
                    mRatingIntegrity.setRating(bean.getCreditRating());
                    mRatingSchedule.setRating(bean.getProgressRating());
                    TextUtils.setText(mEtContent, bean.getReview());
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    /**
     * 机械查询评价
     */
    private void leaseQuery() {
        ApiManager.machineResumesQuery(mContractId,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ContractEvaBean bean = JSON.parseObject(response, ContractEvaBean.class);
                if (bean != null && bean.getContent() != null && bean.getContent().size() > 0) {
                    mEvaId = bean.getContent().get(0).getId();
                    mRatingQuality.setRating(bean.getContent().get(0).getQualityRating());
                    mRatingSafety.setRating(bean.getContent().get(0).getSafeRating());
                    mRatingIntegrity.setRating(bean.getContent().get(0).getCreditRating());
                    mRatingSchedule.setRating(bean.getContent().get(0).getProgressRating());
                    TextUtils.setText(mEtContent, bean.getContent().get(0).getResumeDesc());
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    /**
     * 招工保存评价
     */
    private void workEvaluate() {
        setLoading(true);
        ApiManager.workRateSave(mContractId, mEtContent.getText().toString().trim(),
                (int) mRatingQuality.getRating(), (int) mRatingSafety.getRating(),
                (int) mRatingIntegrity.getRating(), (int) mRatingSchedule.getRating(),this,
                new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        showToast("评价成功");
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
    }

    /**
     * 机械保存评价
     */
    private void leaseEvaluate() {
        setLoading(true);
        ApiManager.machineResumesSave(mEvaId, mType == COMPANYLEASE,
                mType == COMPANYLEASE ? mCompanyId : mTeamId, mProjectId, mMachineAskId, mContractId,
                mEtContent.getText().toString().trim(), (int) mRatingQuality.getRating(), (int) mRatingSafety.getRating(),
                (int) mRatingIntegrity.getRating(), (int) mRatingSchedule.getRating(),this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        showToast("评价成功");
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        mBtnSave.setEnabled(mRatingIntegrity.getRating() > 0 && mRatingSafety.getRating() > 0
                && mRatingQuality.getRating() > 0 && mRatingIntegrity.getRating() > 0
                && !android.text.TextUtils.isEmpty(mEtContent.getText().toString().trim()));
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        mBtnSave.setEnabled(mRatingIntegrity.getRating() > 0 && mRatingSafety.getRating() > 0
                && mRatingQuality.getRating() > 0 && mRatingIntegrity.getRating() > 0
                && !android.text.TextUtils.isEmpty(mEtContent.getText().toString().trim()));
    }
}
