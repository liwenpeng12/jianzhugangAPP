package com.jlkg.jzg.jzg_android.other.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.jlkg.jzg.baselibrary.utils.EditTextInPutUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.home.fragments.TeamFragment;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.other.bean.ImageLoadBean;
import com.jlkg.jzg.jzg_android.other.bean.TeamLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.release.activitys.SelectAddressActivity;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;
import com.jlkg.jzg.jzg_android.release.beans.TeamListBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TeamInfoActivity extends TextWatcherBaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.tv_team_type)
    TextView mTvTeamType;
    @BindView(R.id.tv_team_address)
    TextView mTvTeamAddress;
    @BindView(R.id.et_team_address)
    EditText mEtTeamAddress;
    @BindView(R.id.tv_team_remark)
    EditText mTvTeamRemark;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private List<TeamListBean> teamListBeans = new ArrayList<>();
    private String[] timeTypeOne = new String[]{"土建", "安装", "其他"};
    private List<List<TeamListBean.TitlesBean>> timeTypeList = new ArrayList<>();
    private int teamTypeId;
    private String IDimg1, IDimg2, name, IDcard;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_team_info;
    }

    @Override
    protected void initViews() {
        super.initViews();
        EditTextInPutUtils.setMaxLengthEditTextInhibitInputSpace(mEtTeamAddress, 50);
        mEtTeamAddress.addTextChangedListener(this);
        mTvTeamAddress.addTextChangedListener(this);
        mTvTeamType.addTextChangedListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            name = getIntent().getExtras().getString("name");
            IDcard = getIntent().getExtras().getString("IDcard");
            IDimg1 = getIntent().getExtras().getString("IDimg1");
            IDimg2 = getIntent().getExtras().getString("IDimg2");
        }
    }

    @Override
    protected void initData() {
        super.initData();
        ApiManager.teamTypesGetList(this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                teamListBeans = JSON.parseArray(response, TeamListBean.class);
                int size = teamListBeans.size();
                for (int i = 0; i < size; i++) {
                    timeTypeList.add(teamListBeans.get(i).getTitles());
                }
            }

            @Override
            public void onError(String msg) {
            }
        });
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        mBtnCommit.setEnabled(!TextUtils.isEmpty(mEtTeamAddress.getText().toString())
                && !TextUtils.isEmpty(mTvTeamAddress.getText().toString())
                && !TextUtils.isEmpty(mTvTeamType.getText().toString()));
    }

    @OnClick(R.id.tv_team_type)
    void selectType() {
        hideSoftKeyboard();
        OptionsPickerView view = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                mTvTeamType.setText(timeTypeList.get(options1).get(option2).getPickerViewText());
                teamTypeId = timeTypeList.get(options1).get(option2).getId();
            }
        }).build();

        view.setPicker(teamListBeans, timeTypeList, null);
        view.show();
    }

    @OnClick(R.id.btn_commit)
    void commit() {
        setLoading(true);
        ApiManager.imageUpload(new File(IDimg1),TeamInfoActivity.this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                final ImageLoadBean bean = JSON.parseObject(response, ImageLoadBean.class);
                ApiManager.imageUpload(new File(IDimg2),TeamInfoActivity.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        ImageLoadBean bean1 = JSON.parseObject(response, ImageLoadBean.class);
                        ApiManager.teamInfoSave(name, IDcard, bean.getId(), bean1.getId(), teamTypeId,
                                mTvTeamAddress.getText().toString().trim(),
                                mEtTeamAddress.getText().toString().trim(),
                                mTvTeamRemark.getText().toString().trim(), MyApplication.sTeamLoginBean.getId(),TeamInfoActivity.this, new HttpUtils.OnCallBack() {
                                    @Override
                                    public void success(String response) {
                                        MyApplication.sTeamLoginBean = JSON.parseObject(response, TeamLoginBean.class);
                                        setLoading(false);
                                        setResult(RESULT_OK);
                                        finish();
                                    }

                                    @Override
                                    public void onError(String msg) {
                                        setLoading(false);
                                        showToast(msg);
                                    }
                                });
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    @OnClick(R.id.tv_team_address)
    void selectAddress() {
        openActivityForResult(SelectAddressActivity.class, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            mTvTeamAddress.setText(data.getStringExtra("address"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
