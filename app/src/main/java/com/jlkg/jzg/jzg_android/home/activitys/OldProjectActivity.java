package com.jlkg.jzg.jzg_android.home.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.adapters.OldProjectAdapter;
import com.jlkg.jzg.jzg_android.home.beans.ProjectBean;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 过往项目
 */
public class OldProjectActivity extends BaseActivity {

    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private int mId;
    private List<ProjectBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_old_project;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent() != null && getIntent().getExtras() != null) {
            mId = getIntent().getExtras().getInt("id");
        }
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.queryProjectsByTeam(mId,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                list = JSON.parseArray(response, ProjectBean.class);
                mRecycleView.setAdapter(new OldProjectAdapter(mContext, list));
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }
}
