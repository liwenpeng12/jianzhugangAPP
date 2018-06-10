package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.TradingRecordAdapter;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TradingRecordActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;


    private TradingRecordAdapter tradingRecordAdapter;
    private int page;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_trading_record;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        tradingRecordAdapter = new TradingRecordAdapter(this, new ArrayList<String>());
        tradingRecordAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type) {
                    case AppConstants.CLICK_01:
                        openActivity(PayoffDetailsActivity.class);
                        break;
                }
            }
        });
        smartRefresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page=0;
                getData();
            }
        });
        smartRefresh.autoRefresh();
        listContent.setAdapter(tradingRecordAdapter);
    }

    //获取交易记录的数据
    public void getData() {
        if (MyApplication.isCompany) {

        } else {
            //班组
            ApiManager.getDealDeatils(MyApplication.sTeamLoginBean.getId() + "", page, this, new HttpUtils.OnCallBack<String>() {
                @Override
                public void success(String response) {
                    smartRefresh.finishRefresh();
                    smartRefresh.finishLoadmore();
                }

                @Override
                public void onError(String msg) {
                    toast(msg);
                    smartRefresh.finishRefresh();
                    smartRefresh.finishLoadmore();
                }
            });
        }
    }
}
