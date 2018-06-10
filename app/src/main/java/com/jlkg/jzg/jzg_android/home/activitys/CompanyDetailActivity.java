package com.jlkg.jzg.jzg_android.home.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.adapters.CompanyProjectListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.ProjectBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 公司详情
 */
public class CompanyDetailActivity extends BaseActivity implements OnItemClickListener {

    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    private String companyName;
    private int mCompanyId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent() != null && getIntent().getExtras() != null) {
            companyName = getIntent().getExtras().getString("companyName");
            mCompanyId = getIntent().getExtras().getInt("id");
        }
        TextUtils.setText(tvCompanyName, companyName);
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.companyProjects(mCompanyId+"",this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<ProjectBean> list = JSON.parseArray(response, ProjectBean.class);
                mRecycleView.setAdapter(new CompanyProjectListAdapter(CompanyDetailActivity.this, list, CompanyDetailActivity.this));
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    @Override
    public void itemClickListener(int position) {

    }
}
