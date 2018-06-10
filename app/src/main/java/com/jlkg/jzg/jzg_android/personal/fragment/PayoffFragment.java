package com.jlkg.jzg.jzg_android.personal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.activity.PayoffDetailsActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.TradingRecordAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffBean;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffBean02;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayoffFragment extends BaseFragment {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    Unbinder unbinder;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private TradingRecordAdapter tradingRecordAdapter;
    private List<PayoffBean> payoffBeanList = new ArrayList<>();
    private String companyId;
    private int page;
    private PayoffBean02 payoffBeanData;
    public PayoffFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_payoff;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initView() {
        super.initView();
        companyId = this.getActivity().getIntent().getExtras().getString("companyId");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
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

    }

    @Override
    protected void initData() {
        super.initData();
        tradingRecordAdapter = new TradingRecordAdapter(this.getActivity(), new ArrayList<String>());

        tradingRecordAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type) {
                    case AppConstants.CLICK_01:
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("data", (Serializable) payoffBeanList.get(pos).getWorkerList());
//                        openActivity(PayoffDetailsActivity.class, bundle);
                        Bundle bundle = new Bundle();
                        bundle.putInt("orderId",payoffBeanData.getContent().get(pos).getId());
                        openActivity(PayoffDetailsActivity.class, bundle);
                        break;
                }
            }
        });
        listContent.setAdapter(tradingRecordAdapter);
        smartRefresh.autoRefresh();
    }

    public void getData() {
//        ApiManager.querById(companyId, this, new HttpUtils.OnCallBack() {
//            @Override
//            public void success(String response) {
//                try {
//                    // List<OrganizationBean> organizationBeansList= JSON.parseArray(response,OrganizationBean.class);
//                    //  disposeData(organizationBeansList);
//                    OrganizationBean organizationBean = JSON.parseObject(response, OrganizationBean.class);
//                    if(organizationBean!=null) {
//                        getPayOff(organizationBean.id + "");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(String msg) {
//                showToast(msg);
//            }
//        });


        ApiManager.getCompanyList(companyId, page, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                try {
                    // List<OrganizationBean> organizationBeansList= JSON.parseArray(response,OrganizationBean.class);
                    //  disposeData(organizationBeansList);
//                    OrganizationBean organizationBean = JSON.parseObject(response, OrganizationBean.class);
//                    if(organizationBean!=null) {
//                        getPayOff(organizationBean.id + "");
//                    }

                    PayoffBean02 payoffBean02 = JSON.parseObject(response, PayoffBean02.class);
                    if(payoffBean02!=null&&payoffBean02.getContent()!=null){
                       if(page==0||payoffBeanData==null||payoffBeanData.getContent()==null){
                           payoffBeanData=payoffBean02;
                       }else{
                           payoffBeanData.getContent().addAll(payoffBean02.getContent());
                       }
                        tradingRecordAdapter.setPayoffBean02(payoffBeanData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    smartRefresh.finishRefresh();
                    smartRefresh.finishLoadmore();
                }
            }

            @Override
            public void onError(String msg) {
                smartRefresh.finishRefresh();
                smartRefresh.finishLoadmore();
                showToast(msg);
            }
        });
    }

    private void getPayOff(String projedctid) {
        // ApiManager.getByProjectId(MyApplication.sCompanyLoginBean.getId()+"",projectId, this, new HttpUtils.OnCallBack() {
        ApiManager.getByProjectId(projedctid, this, new HttpUtils.OnCallBack() {

            @Override
            public void success(String response) {
                try {
                    payoffBeanList = JSON.parseArray(response, PayoffBean.class);
                    tradingRecordAdapter.setPayoffBeanList(payoffBeanList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                try {
//
//                    JSONArray jsonArray= JSON.parseArray(response);
//                    if(jsonArray!=null&&jsonArray.size()>0){
//                        JSONObject jsonObject=jsonArray.getJSONObject(0);
//                        ApiManager.getTeamList(jsonObject.getString("id"), PayoffFragment.this, new HttpUtils.OnCallBack() {
//                            @Override
//                            public void success(String response) {
//
//                            }
//
//                            @Override
//                            public void onError(String msg) {
//
//                            }
//                        });
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    public void disposeDeta() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
