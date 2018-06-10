package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.LabourServiceAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.LabourServiceBean;
import com.jlkg.jzg.jzg_android.personal.event.LabourRefreshEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;
    @BindView(R.id.tv_hint)
    TextView tvHint;

    private LabourServiceAdapter labourServiceAdapter;
    private List<LabourServiceBean> labourServiceBeanList;
    private String preCompanyId;
    private boolean isFinishLoading;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_team;
    }

    @Override
    protected void initViews() {
        super.initViews();
        preCompanyId = getIntent().getExtras().getString("companyId");
        myToolbar.setTitleText(getIntent().getExtras().getString("title"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        labourServiceAdapter = new LabourServiceAdapter(this, new ArrayList<String>());

        labourServiceAdapter.setDetails(false);
        labourServiceAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type){
                    case AppConstants.CLICK_01:
                        Bundle bundle2=new Bundle();
                        bundle2.putString("companyId",labourServiceBeanList.get(pos).id+"");
                        openActivity(DispatchActivity.class,bundle2);
                        break;
                    case AppConstants.CLICK_ITEM:
                        if(labourServiceBeanList.get(pos).companyType!=null){
                            //劳务公司没有下一级
                            if(!"COMPANY_TYPE_2".equals(labourServiceBeanList.get(pos).companyType)) {
                                Bundle bundle = new Bundle();
                                bundle.putString("title", labourServiceBeanList.get(pos).name);
                                bundle.putString("companyId", labourServiceBeanList.get(pos).id + "");
                                openActivity(TeamActivity.class, bundle);
                            }else {
                                toast("该公司没有下一级");
                            }
                        }else{
                            toast("该公司数据异常");
                        }

                        break;
                }
            }
        });
        listContent.setAdapter(labourServiceAdapter);
        getData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    public void getData() {
        ApiManager.getCompanyByParentCompany(preCompanyId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                isFinishLoading=true;
                smartRefresh.finishRefresh();
                try {
                    JSONArray jsonArray = JSON.parseArray(response);
                    if (jsonArray.size() > 0) {
                        labourServiceBeanList = JSON.parseArray(jsonArray.getJSONObject(0).getString("items"), LabourServiceBean.class);
                        disposeData(labourServiceBeanList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                isFinishLoading=false;
                smartRefresh.finishRefresh();
            }
        });
    }


    /**
     * 处理获取的数据
     */
    public void disposeData(List<LabourServiceBean> labourServiceBeanList1) {
        if(labourServiceBeanList1.size()>0){
            smartRefresh.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
        }else{
            //smartRefresh.setVisibility(View.GONE);
           // tvHint.setVisibility(View.VISIBLE);
        }
        labourServiceAdapter.setLabourServiceBeanList(labourServiceBeanList1);
    }

    @OnClick(R.id.tv_addLabour)
    public void onViewClicked() {
        if(isFinishLoading) {
            Bundle bundle = new Bundle();
            bundle.putString("companyId", preCompanyId);
            if (labourServiceBeanList != null && labourServiceBeanList.size() > 0) {
                if ("COMPANY_TYPE_2".equals(labourServiceBeanList.get(0).companyType)) {
                    bundle.putInt("type", 2);
                } else {
                    bundle.putInt("type", 3);
                }
            } else {
                bundle.putInt("type", 1);
            }
            openActivity(AddLabourActivity.class, bundle);
        }else{
            toast("正在加载数据");
        }
    }

    @Subscribe
    public void onEventMainThread(LabourRefreshEvent labourRefreshEvent) {
        getData();
    }


}
