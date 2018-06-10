package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.personal.adapter.PayoffDetailsAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffDetailsBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayoffDetailsActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;

    private PayoffDetailsAdapter payoffDetailsAdapter;
    private int page;
    private PayoffDetailsBean payoffDetailsBeanData;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_payoff_details;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
//        Serializable serializable=getIntent().getExtras().getSerializable("data");
//        if(serializable==null){
//            return;
//        }
//        List<PayoffBean.WorkerListBean> workerListBeans= (List<PayoffBean.WorkerListBean>) serializable;
        payoffDetailsAdapter=new PayoffDetailsAdapter(this,new ArrayList());
        listContent.setAdapter(payoffDetailsAdapter);

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void getData(){
        ApiManager.getPageDetails(getIntent().getExtras().getInt("orderId") + "", page, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                smartRefresh.finishLoadmore();
                smartRefresh.finishRefresh();
                try {
                    PayoffDetailsBean payoffDetailsBean= JSON.parseObject(response,PayoffDetailsBean.class);
                    if(payoffDetailsBean!=null&&payoffDetailsBean.getContent()!=null){
                        if(page==0||payoffDetailsBeanData==null||payoffDetailsBeanData.getContent()==null){
                            payoffDetailsBeanData=payoffDetailsBean;
                        }else {
                            payoffDetailsBeanData.getContent().addAll(payoffDetailsBean.getContent());
                        }
                        payoffDetailsAdapter.setPayoffDetailsBean(payoffDetailsBeanData);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                smartRefresh.finishLoadmore();
                smartRefresh.finishRefresh();
                toast(msg);
            }
        });
    }
}
