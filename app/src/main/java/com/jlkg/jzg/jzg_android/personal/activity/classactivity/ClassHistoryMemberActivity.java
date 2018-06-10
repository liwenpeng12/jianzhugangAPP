package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.ClassHistoryMemberAdatper;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.personal.event.AddMemberRefreshEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassHistoryMemberActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;


    private ClassHistoryMemberAdatper classHistoryMemberAdatper;
    private List<ClassMemberBean> classMemberBeanList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_history_member;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);

        smartRefresh.setLoadmoreFinished(false);
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
        classHistoryMemberAdatper = new ClassHistoryMemberAdatper(this, new ArrayList());
        listContent.setAdapter(classHistoryMemberAdatper);
        classHistoryMemberAdatper.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type){
                    case AppConstants.CLICK_01:
                        ClassMemberBean classMemberBean=classMemberBeanList.get(pos);
//                        HashMap<String,String> hashMap=new HashMap<>();
//                        hashMap.put("accountId", MyApplication.sTeamLoginBean.getId()+"");
//                        hashMap.put("id",classMemberBean.getId()+"");
//                        hashMap.put("team.id",MyApplication.sTeamLoginBean.getId()+"");
//                        hashMap.put("name",classMemberBean.getTitle());
//                        hashMap.put("phone",classMemberBean.getPhone());
//                        hashMap.put("bankName",classMemberBean.getBankName()+"");
//                        hashMap.put("cardNumber",classMemberBean.getCardNumber());
//                        hashMap.put("idNumber",classMemberBean.getIdNumber());

                        ApiManager.restore(classMemberBean.getId()+"", this, new HttpUtils.OnCallBack() {
                            @Override
                            public void success(String response) {
                                AddMemberRefreshEvent addMemberRefreshEvent=new AddMemberRefreshEvent();
                                EventBus.getDefault().post(addMemberRefreshEvent);
                                finish();
                            }

                            @Override
                            public void onError(String msg) {
                                toast(msg);
                            }
                        });
                        break;
                }
            }
        });
        getData();
    }

    public void getData() {
        Bundle bundle=getIntent().getExtras();
        String teamId="";
        if(bundle==null) {
            teamId= MyApplication.sTeamLoginBean.getId() + "";
        }else{
            teamId=bundle.getString("teamId");
        }
        bundle.putString("teamId",teamId);
        ApiManager.getHisTeamMember(teamId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                smartRefresh.finishRefresh();
                try {
                    classMemberBeanList = JSON.parseArray(response, ClassMemberBean.class);
                    classHistoryMemberAdatper.setClassMemberBeanList(classMemberBeanList);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
