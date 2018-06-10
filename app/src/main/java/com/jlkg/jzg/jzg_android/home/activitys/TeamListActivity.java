package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.KeyboardUtils;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.adapters.JixieListAdapter;
import com.jlkg.jzg.jzg_android.home.adapters.TeamListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.inter.OnSearchListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.release.activitys.ReleaseLeaseActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 班组列表
 */
public class TeamListActivity extends BaseActivity implements OnItemClickListener, OnRefreshLoadmoreListener, OnSearchListener {

    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    private String mType = "", mId = "";
    private String mQueryKey = "";
    private int page = 0;
    private List<TeamInfoListBean.ContentBean> mTeamList = new ArrayList<>();
    private List<JIXieZulinBean.ContentBean> mMachineList = new ArrayList<>();
    private TeamInfoListBean teamInfoListBean;
    private JIXieZulinBean jiXieZulinBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_team_list;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent() != null && getIntent().getExtras() != null) {
            mType = getIntent().getExtras().getString("type");
            mId = getIntent().getExtras().getString("id");
        }
        if (mType.equals(ClassActivity.MECHANICAL)) {
            mBtnBottom.setText("发布机械");
            mMyToolbar.setTitleText("机械列表");
            mEtSearch.setHint("搜索机械");
            mRecycleView.setAdapter(new JixieListAdapter(this, mMachineList, this, this));
        } else {
            mRecycleView.setAdapter(new TeamListAdapter(this, mTeamList, this, this,mId));
            mBtnBottom.setVisibility(!MyApplication.isCompany && MyApplication.sTeamLoginBean == null ? View.VISIBLE : View.GONE);
        }
        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    KeyboardUtils.hideSoftInput(mEtSearch);
                    seacherListener(mEtSearch.getText().toString().trim());
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLayout.autoRefresh();
    }

    private void loadData() {
        if (mType.endsWith(ClassActivity.MECHANICAL)) {
            ApiManager.machinePersonList(page, mQueryKey, mId,this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    if (page == 0) {
                        mMachineList.clear();
                    }
                    jiXieZulinBean = JSON.parseObject(response, JIXieZulinBean.class);
                    page = jiXieZulinBean.getNumber() + 1;
                    mMachineList.addAll(jiXieZulinBean.getContent());
                    mRecycleView.getAdapter().notifyDataSetChanged();
                    mRefreshLayout.finishLoadmore(true);
                    mRefreshLayout.finishRefresh(true);
                    mRefreshLayout.setLoadmoreFinished(jiXieZulinBean.isLast());
                  //  Log.d("lwp","machinePersonList_bean"+ jiXieZulinBean.toString());
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    mRefreshLayout.finishLoadmore(false);
                    mRefreshLayout.finishRefresh(false);
                    setLoading(false);
                }
            });
        } else {

            ApiManager.getTeamListByTypeId(page, mId, mQueryKey, this,new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    if (page == 0) {
                        mTeamList.clear();
                    }
                    teamInfoListBean = JSON.parseObject(response, TeamInfoListBean.class);
                    page = teamInfoListBean.getNumber() + 1;
                    Log.d("lwp","page:"+page);
                    mTeamList.addAll(teamInfoListBean.getContent());
                    mRecycleView.getAdapter().notifyDataSetChanged();
                    mRefreshLayout.finishLoadmore(true);
                    Log.d("lwp","getTeamListByTypeId_bean_bean_content_phone:"+ teamInfoListBean.getContent().get(0).getUserName()+"getSize:"+ teamInfoListBean.getSize()+"getTotalElements:"+ teamInfoListBean.getTotalElements()+"ofelement"+ teamInfoListBean.getNumberOfElements());
                    mRefreshLayout.finishRefresh(true);
                    mRefreshLayout.setLoadmoreFinished(teamInfoListBean.isLast());
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    mRefreshLayout.finishLoadmore(false);
                    mRefreshLayout.finishRefresh(false);
                    setLoading(false);
                }
            });
        }
    }

    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        Log.d("lwp","username:"+teamInfoListBean.getContent().get(position-1).getUserName());
        //手机判断
        if (mQueryKey.equals(PrefUtils.getString(mContext,"mPhone",""))
                || PrefUtils.getString(mContext,"mPhone","").equals(teamInfoListBean.getContent().get(position-1).getUserName())){
            PrefUtils.setBoolean(mContext,"mPhoneNum",true);
        }else {
            PrefUtils.setBoolean(mContext,"mPhoneNum",false);
        }

        //用户名判断
        //  if (queryKey.equals())
        if (mType.equals(ClassActivity.MECHANICAL)) {
            bundle.putInt("id", mMachineList.get(position - 1).getId());
            openActivity(JixieDetailActivity.class, bundle);
        } else {
            bundle.putInt("id", mTeamList.get(position - 1).getId());
            openActivity(TeamDetailActivity.class, bundle);
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        page++;
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 0;
        loadData();
    }

    @Override
    public void seacherListener(String queryKey) {
        Log.d("lwp","querykey"+queryKey+" mphone"+PrefUtils.getString(mContext,"mPhone",""));

        mQueryKey = queryKey;
        mRefreshLayout.autoRefresh();
    }

    @OnClick(R.id.btn_bottom)
    void bottomClick() {
        if (MyApplication.isCompany) {
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
        }
        if (mType.endsWith(ClassActivity.MECHANICAL))
            openActivity(ReleaseLeaseActivity.class);
    }
}
