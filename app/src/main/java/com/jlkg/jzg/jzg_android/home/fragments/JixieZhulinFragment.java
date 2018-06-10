package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.adapters.JixieZulinListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.CompanyListBean;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.job.activitys.JobDetailActivity;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * 机械租赁
 */
public class JixieZhulinFragment extends BaseFragment implements OnItemClickListener, SelectTypeView.OnSelectResultListener, OnRefreshLoadmoreListener {


    @BindView(R.id.select_type_view)
    SelectTypeView mSelectTypeView;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    private List<JIXieZulinBean.ContentBean> mList = new ArrayList<>();
    private int page;
    private String districtId = "", cateId = "";

    public JixieZhulinFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_jixie_zhulin;
    }

    @Override
    protected void initView() {
        super.initView();
        mSelectTypeView.setType(5, this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(new JixieZulinListAdapter(getActivity(), mList, this));
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLayout.autoRefresh();
    }

    private void loadData() {
        if (page == 0) {
            mList.clear();
        }
        ApiManager.machineAsksQuery(page, districtId, cateId,getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                JIXieZulinBean bean = JSON.parseObject(response, JIXieZulinBean.class);
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
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 0;
        loadData();
    }

    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        bundle.putInt("id", mList.get(position).getId());
        openActivity(JobDetailActivity.class, bundle);
    }

    @Override
    public void onSelectResultListener(int type, String str) {
        if (type == 2) {
            districtId = str;
            if (TextUtils.isEmpty(str)) districtId = "";
        } else if (type == 3) {
            cateId = str;
            if (TextUtils.isEmpty(str)) cateId = "";
        }
        mRefreshLayout.autoRefresh();
    }
}
