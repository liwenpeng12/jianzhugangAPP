package com.jlkg.jzg.jzg_android.contract.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.contract.adapters.OrderDetailAdapter;
import com.jlkg.jzg.jzg_android.contract.beans.OrderDetailBean;
import com.jlkg.jzg.jzg_android.job.JobFragment;
import com.jlkg.jzg.jzg_android.job.adapters.JobListAdapter;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 工资明细
 */
public class OrderDetailActivity extends BaseActivity implements OnRefreshLoadmoreListener {

    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private int mPage = 0;
    private List<OrderDetailBean.ContentBean> mList = new ArrayList<>();
    private int mId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mId = getIntent().getExtras().getInt("id");
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new OrderDetailAdapter(this, mList));
        mRefreshLayout.autoRefresh();
    }

    private void loadData() {
        if (mPage == 0) {
            mList.clear();
        }
        ApiManager.getOrderDetail(mId, mPage,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                OrderDetailBean bean = JSON.parseObject(response, OrderDetailBean.class);
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
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPage = 0;
        loadData();
    }
}
