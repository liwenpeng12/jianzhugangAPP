package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
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
import butterknife.OnClick;

public class CompanySearchActivity extends BaseActivity implements OnItemClickListener, OnRefreshLoadmoreListener {


    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private List<CompanyListBean.ContentBean> mList = new ArrayList<>();
    private int page = 0;
    private String mSearchKey = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_search;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new CompanyNameListAdapter(this, mList, this));
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideSoftKeyboard(mEtSearch);
                    mSearchKey = mEtSearch.getText().toString().trim();
                    mRefreshLayout.autoRefresh();
                    return true;
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
        if (page == 0) {
            mList.clear();
        }
        ApiManager.searchCompanyList(page, mSearchKey,this, new HttpUtils.OnCallBack() {
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

    @OnClick(R.id.tv_cancel)
    void cancel() {
        mSearchKey = mEtSearch.getText().toString().trim();
        mRefreshLayout.autoRefresh();
       // finish();
    }
}
