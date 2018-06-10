package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.adapters.TeamEvaluationAdapter;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
import com.jlkg.jzg.jzg_android.home.beans.TeamRateReviewBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassBeforeObjectActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.SharedPreferencesUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamInfoFragment extends BaseFragment {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.nsv_view)
    NestedScrollView mNsvView;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_team_type)
    TextView tvTeamType;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.tv_old_project)
    TextView tvOldProject;
    private TeamInfoListBean.ContentBean mData;

    public TeamInfoFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_team_info;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);

        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setNestedScrollingEnabled(false);
        mNsvView.scrollTo(0, 0);
        mNsvView.scrollBy(0, 0);
    }

    @Override
    protected void initData() {
        super.initData();
        if (mData != null) {
            TextUtils.setText(tvName, mData.getTitle());
            if (!android.text.TextUtils.isEmpty(mData.getUserName()) && mData.getUserName().length() > 10) {
                String str = mData.getUserName();
                SharedPreferencesUtils.setParam(getActivity(),"isusername", str);
                char[] chars = str.toCharArray();
                chars[3] = '*';
                chars[4] = '*';
                chars[5] = '*';
                chars[6] = '*';
                TextUtils.setText(tvPhone, String.valueOf(chars));
            }


            tvPhone.setClickable(false);
            if(mData.getTeamType()!=null&&mData.getTeamType().getCategory()!=null) {
                TextUtils.setText(tvTeamType, mData.getTeamType().getCategory().getText() + "    " + mData.getTeamType().getTitle());
            }
            TextUtils.setText(tvAddress, mData.getDisplayAddress());
            TextUtils.setText(tvRemark, mData.getNotes());
            setLoading(true);
            ApiManager.teamRateReview(mData.getId(),getActivity(), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    List<TeamRateReviewBean> list = JSON.parseArray(response, TeamRateReviewBean.class);
                    mRecycleView.setAdapter(new TeamEvaluationAdapter(getActivity(), list));
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                }
            });
        }
    }

    public void setData(TeamInfoListBean.ContentBean data) {
        mData = data;
        initData();
    }


    @OnClick(R.id.tv_old_project)
    void oldProject() {
        Bundle bundle = new Bundle();
        String userName = mData.getUserName();
//        if (getArguments() != null) {
//            bundle.putInt("id", getArguments().getInt("id"));
//        }
//        openActivity(OldProjectActivity.class, bundle);

        if (getArguments() != null) {
            bundle.putInt("id", getArguments().getInt("id"));
        }
        bundle.putString("username",userName);
        openActivity(ClassBeforeObjectActivity.class, bundle);
    }

    @OnClick(R.id.tv_phone)
    void callPhone() {
        if (!android.text.TextUtils.isEmpty(tvPhone.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(getActivity(), tvPhone.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(getActivity(), tvPhone.getText().toString().trim());
                }
            });
    }

}
