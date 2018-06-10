package com.jlkg.jzg.jzg_android.job.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.job.adapters.JobListAdapter;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchJobActivity extends BaseActivity implements OnItemClickListener, OnRefreshLoadmoreListener {

    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    private List<ProjectListBean.ContentBean> mList = new ArrayList<>();
    private int page = 0;
    private String mSearchKey = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_job;
    }

    @Override
    protected void initViews() {
        super.initViews();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(new JobListAdapter(this, mList, this));
        refreshLayout.setOnRefreshLoadmoreListener(this);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mSearchKey = etSearch.getText().toString().trim();
                    hideSoftKeyboard(etSearch);
                    refreshLayout.autoRefresh();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        refreshLayout.autoRefresh();
    }

    private void loadData() {
        if (page == 0) {
            mList.clear();
        }
        ApiManager.projectHireSearch(mSearchKey, page, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ProjectListBean bean = JSON.parseObject(response, ProjectListBean.class);
                page = bean.getNumber() + 1;
                mList.addAll(bean.getContent());
                recycleView.getAdapter().notifyDataSetChanged();
                refreshLayout.finishLoadmore(true);
                refreshLayout.finishRefresh(true);
                refreshLayout.setLoadmoreFinished(bean.isLast());
            }

            @Override
            public void onError(String msg) {
                refreshLayout.finishLoadmore(false);
                refreshLayout.finishRefresh(false);
            }
        });
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
        page = 0;
        loadData();
    }

    @OnClick(R.id.tv_cancel)
    void cancel() {

        mSearchKey = etSearch.getText().toString().trim();
        hideSoftKeyboard(etSearch);
        refreshLayout.autoRefresh();
    }
}
