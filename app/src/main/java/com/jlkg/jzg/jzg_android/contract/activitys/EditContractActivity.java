package com.jlkg.jzg.jzg_android.contract.activitys;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.TimePickerView;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.contract.beans.ContractApplyBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class EditContractActivity extends TextWatcherBaseActivity {


    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.tv_project_name)
    TextView mTvProjectName;
    @BindView(R.id.tv_project_address)
    TextView mTvProjectAddress;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.et_all_day_num)
    EditText mEtAllDayNum;
    @BindView(R.id.tv_need_left)
    TextView mTvNeedLeft;
    @BindView(R.id.et_need)
    EditText mEtNeed;
    @BindView(R.id.lin_need)
    LinearLayout mLinNeed;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.tv_type_left)
    TextView mTvTypeLeft;
    @BindView(R.id.et_type_right)
    TextView mEtTypeRight;
    @BindView(R.id.et_style)
    EditText mEtStyle;
    @BindView(R.id.et_pay_time)
    EditText mEtPayTime;
    @BindView(R.id.et_pay_jindu)
    EditText mEtPayJindu;
    @BindView(R.id.et_finish)
    EditText mEtFinish;
    @BindView(R.id.et_require)
    EditText mEtRequire;
    private int mId;
    private String startDate, endDate;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_contract;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mTvStartTime.addTextChangedListener(this);
        mTvEndTime.addTextChangedListener(this);
        mEtAllDayNum.addTextChangedListener(this);
        mEtNeed.addTextChangedListener(this);
        mEtStyle.addTextChangedListener(this);
        mEtPayTime.addTextChangedListener(this);
        mEtPayJindu.addTextChangedListener(this);
        mEtFinish.addTextChangedListener(this);
        mEtRequire.addTextChangedListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mId = getIntent().getExtras().getInt("id");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        String s1 = mTvStartTime.getText().toString().trim();
        String s2 = mTvEndTime.getText().toString().trim();
        String s3 = mEtAllDayNum.getText().toString().trim();
        String s4 = mEtNeed.getText().toString().trim();
        String s5 = mEtStyle.getText().toString().trim();
        String s6 = mEtPayTime.getText().toString().trim();
        String s7 = mEtPayJindu.getText().toString().trim();
        String s8 = mEtFinish.getText().toString().trim();
        String s9 = mEtRequire.getText().toString().trim();
        mBtnBottom.setEnabled(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3)
                && !TextUtils.isEmpty(s4) && !TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s6)
                && !TextUtils.isEmpty(s7) && !TextUtils.isEmpty(s8) && !TextUtils.isEmpty(s9));
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.getApplyDetails(mId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ContractApplyBean bean = JSON.parseObject(response, ContractApplyBean.class);
                if (bean.getProjectHire() != null && bean.getProjectHire().getProject() != null) {
                    com.jlkg.jzg.jzg_android.utils.TextUtils.setText(mTvProjectName, bean.getProjectHire().getProject().getName());
                    com.jlkg.jzg.jzg_android.utils.TextUtils.setText(mTvProjectAddress, bean.getProjectHire().getProject().getStreetAddress());
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
            }
        });
    }

    @OnClick(R.id.btn_bottom)
    void save() {
        setLoading(true);
        ApiManager.commitStartSign(mId, mTvProjectName.getText().toString().trim(),
                mTvProjectAddress.getText().toString().trim(), mTvStartTime.getText().toString().trim(),
                mTvEndTime.getText().toString().trim(), mEtAllDayNum.getText().toString().trim(),
                mEtNeed.getText().toString().trim(), mEtTypeRight.getText().toString().trim(),
                mEtStyle.getText().toString().trim(), mEtPayTime.getText().toString().trim(),
                mEtPayJindu.getText().toString().trim(), mEtFinish.getText().toString().trim(),
                mEtRequire.getText().toString().trim(), this,new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        showToast("保存成功");
                        setResult(Activity.RESULT_OK);
                        setLoading(false);
                        finish();
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
    }

    @OnClick(R.id.tv_start_time)
    void selectStartTime() {
        hideSoftKeyboard();
        new TimePickerView.Builder(mContext, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                startDate = date.getTime() + "";
                mTvStartTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            }
        })
                .setType(new boolean[]{true, true, true, true, true, true})
                .setRangDate(Calendar.getInstance(), null)
                .build().show();
    }

    @OnClick(R.id.tv_end_time)
    void selectEndTime() {
        hideSoftKeyboard();
        new TimePickerView.Builder(mContext, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                endDate = date.getTime() + "";
                mTvEndTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            }
        })
                .setType(new boolean[]{true, true, true, true, true, true})
                .setRangDate(Calendar.getInstance(), null)
                .build().show();
    }
}
