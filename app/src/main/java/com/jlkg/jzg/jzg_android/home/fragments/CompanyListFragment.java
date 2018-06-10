package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.activitys.CompanyDetailActivity;
import com.jlkg.jzg.jzg_android.home.adapters.CompanyNameListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.CompanyListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 公司列表fragment
 */
public class CompanyListFragment extends BaseFragment implements OnItemClickListener, OnRefreshLoadmoreListener {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;
    private String mTypeKey;
    private List<CompanyListBean.ContentBean> mList = new ArrayList<>();
    private int page = 0;

    public CompanyListFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_company_list;
    }

    public void setTypeKey(String typeKey) {
        mTypeKey = typeKey;
    }

    @Override
    protected void initView() {
        super.initView();
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(new CompanyNameListAdapter(getActivity(), mList, this));
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
        if (mRecycleView != null)
            mRefreshLayout.autoRefresh();
    }

    private void loadData() {
        if (page == 0) {
            mList.clear();
        }
        ApiManager.getCompanyList(page, mTypeKey, getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                CompanyListBean bean = JSON.parseObject(response, CompanyListBean.class);
                page = bean.getNumber() + 1;
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
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", mList.get(position).getId());
        bundle.putString("companyName", mList.get(position).getTitle());
        openActivity(CompanyDetailActivity.class, bundle);
    }


    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 0;
        loadData();
    }
}
