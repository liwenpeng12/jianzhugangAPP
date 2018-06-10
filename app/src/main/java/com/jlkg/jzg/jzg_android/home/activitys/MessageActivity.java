package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.adapters.MessageListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.MsgListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MessageActivity extends BaseActivity implements OnItemClickListener, OnRefreshLoadmoreListener {

    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private int page;
    private List<MsgListBean.ContentBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new MessageListAdapter(this, list, this));
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLayout.autoRefresh();
    }

    public void loadData() {
        ApiManager.msgList(page, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                MsgListBean bean = JSON.parseObject(response, MsgListBean.class);
                if (page == 0) {
                    list.clear();
                }
                list.addAll(bean.getContent());
                page = bean.getNumber() + 1;
                mRecycleView.getAdapter().notifyDataSetChanged();
                mRefreshLayout.finishLoadmore(true);
                mRefreshLayout.finishRefresh(true);
                mRefreshLayout.setLoadmoreFinished(bean.isLast());
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                mRefreshLayout.finishLoadmore(false);
                mRefreshLayout.finishRefresh(false);
            }
        });
    }


    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("bean", list.get(position));
        openActivity(MessageDetailActivity.class,bundle);
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
}
