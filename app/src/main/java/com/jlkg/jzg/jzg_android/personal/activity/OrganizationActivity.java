package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.event.AddProjectEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.OrganizationAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrganizationActivity extends BaseActivity {
    @BindView(R.id.myToolbar)
    MyToolbar myToolbar;
    @BindView(R.id.tv_project_title)
    TextView tvProjectTitle;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_dispatch)
    TextView tvDispatch;
    @BindView(R.id.tv_labour)
    TextView tvLabour;
    @BindView(R.id.ll_item)
    LinearLayout llItem;
    @BindView(R.id.tv_add)
    TextView tvAdd;

//    @BindView(R.id.myToolbar)
//    MyToolbar myToolbar;
//    @BindView(R.id.list_content)
//    RecyclerView listContent;
//    @BindView(R.id.smart_refresh)
//    SmartRefreshLayout smartRefresh;
//    @BindView(R.id.tv_add)
//    TextView tvAdd;


    private OrganizationAdapter organizationAdapter;
    private List<OrganizationBean> organizationBeansList = new ArrayList<>();
    private OrganizationBean organizationBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_organization;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Subscribe
    public void onEventMainThread(AddProjectEvent event) {
        //smartRefresh.autoRefresh();
        getData();
    }

    @Override
    protected void initViews() {
        super.initViews();
        myToolbar.setTitleText(MyApplication.sCompanyLoginBean.getTitle());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        listContent.setLayoutManager(linearLayoutManager);
//
//        smartRefresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//
//            }
//
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                getData();
//            }
//        });


        if(MyApplication.sCompanyLoginBean.getCompanyType()!=null) {
            if ("COMPANY_TYPE_2".equals(MyApplication.sCompanyLoginBean.getCompanyType().getId())){
                tvAdd.setEnabled(false);
            }
        }else{
            DialogUtils.showInvitedDia(this,true);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        organizationAdapter = new OrganizationAdapter(this, organizationBeansList);
//        listContent.setAdapter(organizationAdapter);
//        organizationAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
//            @Override
//            public void onClick(View v, int type, int pos, int child) {
//                switch (type) {
//                    case AppConstants.CLICK_ITEM:
//                        Bundle bundle=new Bundle();
//                        bundle.putSerializable("data",organizationBeansList.get(pos));
//                        openActivity(ProjectDetailsActivity.class,bundle);
//                        break;
//                    case AppConstants.CLICK_01:
//                        openActivity(DispatchActivity.class);
//                        break;
//                    case AppConstants.CLICK_02:
//                        openActivity(LabourServiceActivity.class);
//                        break;
//                }
//            }
//        });
//
//
//        smartRefresh.autoRefresh();


        getData();
    }

    /**
     * 获取数据
     */
    private void getData() {
        //通过公司名字查找项目
//        ApiManager.queryByName(MyApplication.sCompanyLoginBean.getTitle()+"",this, new HttpUtils.OnCallBack() {
//            @Override
//            public void success(String response) {
//                smartRefresh.finishRefresh();
//                smartRefresh.finishLoadmore();
//                try {
//                    List<OrganizationBean> organizationBeansList= JSON.parseArray(response,OrganizationBean.class);
//                    disposeData(organizationBeansList);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(String msg) {
//                smartRefresh.finishRefresh();
//                smartRefresh.finishLoadmore();
//                toast(msg);
//            }
//        });


        //通过公司Id查找项目
        ApiManager.querById(MyApplication.sCompanyLoginBean.getId() + "", this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
//                smartRefresh.finishRefresh();
//                smartRefresh.finishLoadmore();
                try {
                    // List<OrganizationBean> organizationBeansList= JSON.parseArray(response,OrganizationBean.class);
                    //  disposeData(organizationBeansList);
                    OrganizationBean organizationBean = JSON.parseObject(response, OrganizationBean.class);
                    disposeData02(organizationBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
//                smartRefresh.finishRefresh();
//                smartRefresh.finishLoadmore();
                toast(msg);
            }
        });


    }

    public void disposeData(List<OrganizationBean> organizationBeansList) {
        if (organizationBeansList == null || organizationBeansList.size() <= 0) {
            return;
        }

        this.organizationBeansList = organizationBeansList;
        organizationAdapter.setOrganizationBeanList(this.organizationBeansList);

    }

    public void disposeData02(OrganizationBean organizationBean) {
        this.organizationBean=organizationBean;
        if(organizationBean==null){
            llItem.setVisibility(View.INVISIBLE);
            if(MyApplication.sCompanyLoginBean.getCompanyType()!=null) {
                if (!"COMPANY_TYPE_2".equals(MyApplication.sCompanyLoginBean.getCompanyType().getId())) {
                    tvAdd.setEnabled(true);
                }else{
                    tvAdd.setEnabled(false);
                }
            }
            return;
        }else{
            llItem.setVisibility(View.VISIBLE);
            tvAdd.setEnabled(false);
        }
        tvProjectTitle.setText(organizationBean.name);
        tvIntroduce.setText(organizationBean.description);

    }


    @OnClick({R.id.tv_dispatch, R.id.tv_labour,R.id.tv_add,R.id.ll_item})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dispatch:
                Bundle bundle2=new Bundle();
                bundle2.putString("projectId",organizationBean.id+"");
                bundle2.putString("companyId",MyApplication.sCompanyLoginBean.getId()+"");
                openActivity(DispatchActivity.class,bundle2);
                break;
            case R.id.tv_labour:
                Bundle bundle1=new Bundle();
                bundle1.putString("title",MyApplication.sCompanyLoginBean.getTitle());
                bundle1.putString("companyId",MyApplication.sCompanyLoginBean.getId()+"");
                openActivity(LabourServiceActivity.class,bundle1);
                break;
            case R.id.tv_add:
                openActivity(AddProjectActivity.class);
                break;
            case R.id.ll_item:
                Bundle bundle=new Bundle();
                bundle.putSerializable("data",organizationBean);
                openActivity(ProjectDetailsActivity.class,bundle);
                break;
        }
    }
}
