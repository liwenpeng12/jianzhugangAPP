package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassMemberActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.SelectPersonnelAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.personal.bean.SelectPersonnelBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectPersonnelActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;

    private SelectPersonnelAdapter selectPersonnelAdapter;
    private List<SelectPersonnelBean> selectPersonnelBeanList=new ArrayList<>();
    private List<ClassMemberBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_personnel;
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

        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        selectPersonnelAdapter = new SelectPersonnelAdapter(this, new ArrayList());
        selectPersonnelAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type) {
                    case AppConstants.CLICK_ITEM:
                        Bundle bundle = new Bundle();
                        if (selectPersonnelBeanList.get(pos).getTeam() == null) {
                            return;
                        }
                        bundle.putString("teamId", selectPersonnelBeanList.get(pos).getTeam().getId() + "");
                        bundle.putInt("type",1);
                        openActivity(ClassMemberActivity.class, bundle);
                        break;
                }
            }
        });
        listContent.setAdapter(selectPersonnelAdapter);

        myToolbar.setTitleText(getIntent().getExtras().getString("title").split("（")[0] + "人员");
        smartRefresh.autoRefresh();
    }

    public void getData(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("typeId", getIntent().getExtras().getString("typeId"));
        hashMap.put("companyId", getIntent().getExtras().getString("companyId"));
        //hashMap.put("companyId", "20502");

        ApiManager.centerPelples(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                smartRefresh.finishRefresh();
                try {
                    selectPersonnelBeanList= JSON.parseArray(response,SelectPersonnelBean.class);
                    selectPersonnelAdapter.setSelectPersonnelBeans(selectPersonnelBeanList);
//                    if(selectPersonnelBeanList!=null&&selectPersonnelBeanList.size()>0){
//                        ApiManager.getTeamMember(selectPersonnelBeanList.get(0).getTeam().getId()+"", SelectPersonnelActivity.this, new HttpUtils.OnCallBack() {
//                            @Override
//                            public void success(String response) {
//                                list = JSON.parseArray(response, ClassMemberBean.class);
//                                selectPersonnelAdapter.setSelectPersonnelBeans(list);
//                                selectPersonnelAdapter.notifyDataSetChanged();
//                            }
//
//                            @Override
//                            public void onError(String msg) {
//
//                            }
//                        });
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                smartRefresh.finishRefresh();
                toast(msg);
            }
        });
    }

}