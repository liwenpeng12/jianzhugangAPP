package com.jlkg.jzg.jzg_android.personal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.event.ConstartRefreshEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.ApplyForPaymentActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.ProjectApplicationAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ProjectApplictionBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectApplictionFragment extends BaseFragment {


    @BindView(R.id.list_content)
    XRecyclerView listContent;
    Unbinder unbinder;
    //"0待签约", "1已签约", "2待付款","3已完成","4已终止"
    private int type;
    private int page;

    private ProjectApplicationAdapter projectApplicationAdapter;
    private ProjectApplictionBean projectApplictionBean;

    public static ProjectApplictionFragment getInstances(int type) {
        ProjectApplictionFragment projectApplictionFragment = new ProjectApplictionFragment();
        projectApplictionFragment.type = type;
        return projectApplictionFragment;
    }

    public ProjectApplictionFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_appliction;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        listContent.setLoadingMoreEnabled(true);
        listContent.setPullRefreshEnabled(true);

        listContent.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                page=0;
                getProgectData();
            }

            @Override
            public void onLoadMore() {

                page++;
                getProgectData();
            }
        });
        listContent.refresh();
    }

    //获取数据
    public void getProgectData(){
        String status="";
        switch (type){
            case 0:
                status="CONTRACT_STATUS_SUBMITED";
                break;
            case 1:
                status="CONTRACT_STATUS_SIGNED";
                break;
            case 2:
                status="CONTRACT_STATUS_WAIT_PAY";
                break;
            case 3:
                status="CONTRACT_STATUS_DONE";
                break;
            case 4:
                status="CONTRACT_STATUS_CANCELED";
                break;
        }
        ApiManager.contractsQuery(MyApplication.sCompanyLoginBean.getId() + "", status, page + "", "10",this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                if(listContent!=null) {
                    listContent.loadMoreComplete();
                    listContent.refreshComplete();
                }
                try {
                    ProjectApplictionBean projectApplictionBean= JSON.parseObject(response,ProjectApplictionBean.class);
                    upData(projectApplictionBean);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                if(listContent!=null) {
                    listContent.loadMoreComplete();
                    listContent.refreshComplete();
                }
            }
        });
    }

    public void upData(ProjectApplictionBean projectApplictionBean){
        if(projectApplictionBean==null||projectApplictionBean.getContent()==null){
            return;
        }
        if(page==0||this.projectApplictionBean==null||this.projectApplictionBean.getContent()==null) {
            this.projectApplictionBean = projectApplictionBean;
        }else{
            this.projectApplictionBean.getContent().addAll(projectApplictionBean.getContent());
        }
        projectApplicationAdapter.setProjectApplictionBean(this.projectApplictionBean);
    }


    @Override
    protected void initData() {
        super.initData();
        projectApplicationAdapter=new ProjectApplicationAdapter(this.getActivity(),new ArrayList<String>(),type);
        projectApplicationAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type){
                    case AppConstants.CLICK_01:
                        switch (ProjectApplictionFragment.this.type){
                            case 0:

                                constartCancel(pos);
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case AppConstants.CLICK_02:
                        switch (ProjectApplictionFragment.this.type){
                            case 0:
                                changeStatus(pos,"CONTRACT_STATUS_SUBMITED");
                                break;
                            case 1:
                                openActivity(ApplyForPaymentActivity.class);
                                break;
                            case 2:
                                changeStatus(pos,"CONTRACT_STATUS_WAIT_PAY");
                                break;
                            case 3:
                                changeStatus(pos,"CONTRACT_STATUS_DONE");
                                break;
                            case 4:
                                break;
                        }
                        break;
                }
            }
        });
        listContent.setAdapter(projectApplicationAdapter);
    }


    //修改合同状态
    public void changeStatus(final int pos, String status){
        switch (status){
            case "CONTRACT_STATUS_SUBMITED":
                DialogUtils.showSettingDialog(this.getActivity(), false, "确认签约？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        agreeContract(projectApplictionBean.getContent().get(pos).getId()+"");

                    }
                });
                break;
            case "CONTRACT_STATUS_SIGNED":

                break;
            case "CONTRACT_STATUS_WAIT_PAY":
                DialogUtils.showSettingDialog(this.getActivity(), false, "确认已付款？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                       // gotoSave(projectApplictionBean.getContent().get(pos).getId()+"","CONTRACT_STATUS_DONE");
                        completeContract(projectApplictionBean.getContent().get(pos).getId()+"");
                    }
                });
                break;
            case "CONTRACT_STATUS_DONE":

                constartCancel(pos);
                break;
            case "CONTRACT_STATUS_CANCELED":
//                DialogUtils.showSettingDialog(this.getActivity(), false, "确认付款？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
//                    @Override
//                    public void onCommit() {
//
//                    }
//                });
                break;
        }
    }

    //取消合同
    private void constartCancel(final int pos) {

        DialogUtils.showSettingDialog(ProjectApplictionFragment.this.getActivity(), false, "确认取消？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                //  gotoSave(projectApplictionBean.getContent().get(pos).getId()+"","CONTRACT_STATUS_CANCELED");

                ApiManager.cancelContract(projectApplictionBean.getContent().get(pos).getId() + "", ProjectApplictionFragment.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        ConstartRefreshEvent constartRefreshEvent=new ConstartRefreshEvent();
                        constartRefreshEvent.addArrayList(0);
                        constartRefreshEvent.addArrayList(4);
                        EventBus.getDefault().post(constartRefreshEvent);
                    }

                    @Override
                    public void onError(String msg) {
                        showToast(msg);
                    }
                });
            }
        });
    }

    //修改合同状态
    public void gotoSave(String constarsId,String status){
        ApiManager.contractsStatus(constarsId, status, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
              //  listContent.refresh();
                ConstartRefreshEvent constartRefreshEvent=new ConstartRefreshEvent();
                EventBus.getDefault().post(constartRefreshEvent);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    //确认签约
    public void agreeContract(String contractId){
        ApiManager.agreeContract(contractId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ConstartRefreshEvent constartRefreshEvent=new ConstartRefreshEvent();
                constartRefreshEvent.addArrayList(0);
                constartRefreshEvent.addArrayList(1);
                EventBus.getDefault().post(constartRefreshEvent);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    //确认完成
    public void completeContract(String contractId){
        ApiManager.completeContract(contractId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ConstartRefreshEvent constartRefreshEvent=new ConstartRefreshEvent();
                constartRefreshEvent.addArrayList(2);
                constartRefreshEvent.addArrayList(3);
                EventBus.getDefault().post(constartRefreshEvent);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }


    @Subscribe
    public void onEventMainThread(ConstartRefreshEvent recruitWorkersEvent){
        if(listContent!=null){
            if(recruitWorkersEvent.isContains(type)) {
                listContent.refresh();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
