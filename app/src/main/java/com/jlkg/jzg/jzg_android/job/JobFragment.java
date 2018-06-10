package com.jlkg.jzg.jzg_android.job;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.job.activitys.JobDetailActivity;
import com.jlkg.jzg.jzg_android.job.activitys.SearchJobActivity;
import com.jlkg.jzg.jzg_android.job.adapters.JobListAdapter;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 招工
 */
public class JobFragment extends BaseFragment implements SelectTypeView.OnSelectResultListener,
        OnItemClickListener, OnRefreshLoadmoreListener {


    @BindView(R.id.select_type_view)
    SelectTypeView mSelectTypeView;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private List<ProjectListBean.ContentBean> mList = new ArrayList<>();
    private int mPage = 0;
    private String districtId = "";
    private String teamType = "";

    public JobFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_job;
    }

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mSelectTypeView.setType(4, this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(new JobListAdapter(getActivity(), mList, JobFragment.this));
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();

    }

    private void loadData() {
        if (mPage == 0) {
            mList.clear();
        }
        ApiManager.projectHireList(districtId, teamType, mPage, getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ProjectListBean bean = JSON.parseObject(response, ProjectListBean.class);
                mPage = bean.getNumber() + 1;
                mList.addAll(bean.getContent());
                mRecycleView.getAdapter().notifyDataSetChanged();
                mRefreshLayout.finishLoadmore(true);
                mRefreshLayout.finishRefresh(true);
                mRefreshLayout.setLoadmoreFinished(bean.isLast());
            }

            @Override
            public void onError(String msg) {
                mRefreshLayout.finishLoadmore(false);
                mRefreshLayout.finishRefresh(false);
            }
        });
    }

    @Override
    public void onSelectResultListener(int type, String str) {
        mPage = 0;
        if (type == 2) {
            districtId = str;
        } else if (type == 3) {
            teamType = str;
        }
        mRefreshLayout.autoRefresh();
    }

    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 2);
        bundle.putInt("id", mList.get(position).getId());
        openActivity(JobDetailActivity.class, bundle);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPage = 0;
        loadData();
    }

    @OnClick(R.id.ib_right)
    void search() {
        openActivity(SearchJobActivity.class);
    }
}
