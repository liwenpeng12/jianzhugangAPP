package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.activitys.MallHomeActivity;
import com.jlkg.jzg.jzg_android.home.adapters.MallListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.MallListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 商城--列表
 */
public class MallListFragment extends BaseFragment implements OnItemClickListener, OnRefreshLoadmoreListener {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private List<MallListBean.DataBean.StoreListBean> mList = new ArrayList<>();
    private int page = 1;

    public MallListFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mall_list;
    }

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(new MallListAdapter(getActivity(), mList, this));
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
        mRefreshLayout.autoRefresh();
    }

    private void loadData() {
        ApiManager.shopsQuery(page + "", getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                if (page == 1) {
                    mList.clear();
                }
                MallListBean bean = JSON.parseObject(response, MallListBean.class);
                page = bean.getData().getPage_now() + 1;
                mList.addAll(bean.getData().getStore_list());
                mRecycleView.getAdapter().notifyDataSetChanged();
                mRefreshLayout.finishLoadmore(true);
                mRefreshLayout.finishRefresh(true);
                mRefreshLayout.setLoadmoreFinished(bean.getData().getPage_now() == bean.getData().getPage_count());
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
//        bundle.putInt("id", mList.get(position).getId());
//        bundle.putString("title", mList.get(position).getTitle());
//        bundle.putString("userName", mList.get(position).getOwnerName());
//        bundle.putString("address", mList.get(position).getDisplayAddress());
//        bundle.putString("saleRange", mList.get(position).getSaleRange());
//        bundle.putString("phone", mList.get(position).getPhone());
//        bundle.putString("url", mList.get(position).getImage().getUrl());
//        bundle.putInt("score", mList.get(position).getStarLevel());
        bundle.putString("id", mList.get(position).getStore_id());
        openActivity(MallHomeActivity.class, bundle);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 1;
        loadData();
    }
}
