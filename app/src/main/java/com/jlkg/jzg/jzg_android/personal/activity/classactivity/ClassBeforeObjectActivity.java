package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.event.RefreshBeforeObjectEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.ClassBeforeObjectAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassBeforeObjectBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassBeforeObjectActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;

    private ClassBeforeObjectAdapter classBeforeObjectAdapter;
    private List<ClassBeforeObjectBean> classBeforeObjectBeanList = new ArrayList<>();
    private int userId;
    private String username;
    private boolean isMyProject;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_before_object;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
      //  EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        userId=getIntent().getExtras().getInt("id");
        username = getIntent().getExtras().getString("username");
        isMyProject = getIntent().getExtras().getBoolean("isMyProject");
        if (!PrefUtils.getBoolean(this, "isLogin", false)) {
            myToolbar.setRightText("");
        }else {
            if(!MyApplication.isCompany&&userId== MyApplication.sTeamLoginBean.getId()) {
                myToolbar.setClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openActivity(AddBeforeObjectActivity.class);
                    }
                });
            }else{
                myToolbar.setRightText("");
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        Log.d("initData","initData");
        super.initData();
        classBeforeObjectAdapter = new ClassBeforeObjectAdapter(this, new ArrayList<String>());
        classBeforeObjectAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type){
                    case AppConstants.CLICK_ITEM:
                        Bundle bundle=new Bundle();

                        bundle.putSerializable("data",classBeforeObjectBeanList.get(pos));
                        bundle.putString("uname",username);
                        bundle.putBoolean("isMyProject",isMyProject);
                        openActivity(BeforeObjectActivity.class,bundle);
                        break;
                }
            }
        });
        listContent.setAdapter(classBeforeObjectAdapter);
        smartRefresh.setEnableLoadmore(false);
        smartRefresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData();
            }
        });
       smartRefresh.autoRefresh();
    }

    public void getData() {
        ApiManager.teamOldProjects(userId+"", this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                smartRefresh.finishRefresh();
                try {
                    classBeforeObjectBeanList = JSON.parseArray(response, ClassBeforeObjectBean.class);
                    classBeforeObjectAdapter.setClassBeforeObjectBeans(classBeforeObjectBeanList);
                } catch (Exception e) {
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


    @Subscribe
    public void onEventMainThread(RefreshBeforeObjectEvent event) {
        getData();
    }
}
