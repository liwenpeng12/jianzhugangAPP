package com.jlkg.jzg.jzg_android.contract.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.contract.activitys.ContractDetailActivity;
import com.jlkg.jzg.jzg_android.contract.activitys.ContractEvaluateActivity;
import com.jlkg.jzg.jzg_android.contract.activitys.WebActivity;
import com.jlkg.jzg.jzg_android.contract.adapters.ContractAdapter;
import com.jlkg.jzg.jzg_android.contract.beans.ContractEvens;
import com.jlkg.jzg.jzg_android.contract.beans.OrderBean;
import com.jlkg.jzg.jzg_android.other.event.ConstartRefreshEvent;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.ApplyForPaymentActivity;
import com.jlkg.jzg.jzg_android.personal.bean.ProjectApplictionBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 合约子fragment
 */
public class ContractChildFragment extends BaseFragment implements OnItemClickListener, OnRefreshLoadmoreListener, ContractAdapter.OnConfimApplyListener {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.fl_noLogin)
    FrameLayout mFlNoLogin;
    //0:待签约 1：已签约   2：待付款  3:已完成  4:已终止
    private int type;
    private int page;
    private String mStatus = "";
    private List<ProjectApplictionBean.ContentBean> mList = new ArrayList<>();
    private static final int APPPAY = 2;//申请付款请求码

    public ContractChildFragment() {
    }

    public static ContractChildFragment getInstances(int type) {
        ContractChildFragment fragment = new ContractChildFragment();
        fragment.type = type;
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contract_child;
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ContractAdapter adapter = new ContractAdapter(this.getActivity(), mList, type, this, this);
        mRecycleView.setAdapter(adapter);
        switch (type) {
            case 0:
                mStatus = "CONTRACT_STATUS_SUBMITED";
                break;
            case 1:
                mStatus = "CONTRACT_STATUS_SIGNED";
                break;
            case 2:
                mStatus = "CONTRACT_STATUS_WAIT_PAY";
                break;
            case 3:
                mStatus = "CONTRACT_STATUS_DONE";
                break;
            case 4:
                mStatus = "CONTRACT_STATUS_CANCELED";
                break;
        }
        adapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, final int pos, int child) {
                ProjectApplictionBean.ContentBean contentBean = mList.get(pos);
                switch (type) {
                    case AppConstants.CLICK_01:
                        switch (ContractChildFragment.this.type) {
                            case 0:
                                if (!(MyApplication.isCompany && (contentBean.getApplyCompany() == null || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId())))
                                    constartCancel(pos);
                                break;
                            case 1:
                                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId())))
                                    constartCancel(pos);
                                break;
                            case 2:
                                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId())))
                                    constartCancel(pos);
                                break;
                            case 3:
                            case 4:
                                Bundle bundle = new Bundle();
                                bundle.putInt("contractId", contentBean.getId());
                                if (contentBean.getApplyCompany() != null)
                                    bundle.putInt("companyId", contentBean.getApplyCompany().getId());
                                if (contentBean.getTeam() != null) {
                                    bundle.putInt("teamId", contentBean.getTeam().getId());
                                }
                                if (contentBean.getProject() != null) {
                                    bundle.putInt("projectId", contentBean.getProject().getId());
                                }
                                if (contentBean.getProjectApply() != null) {
                                    bundle.putInt("machineAskId", contentBean.getProjectApply().getMachineAskId());
                                }
                                if (contentBean.getProjectApply() != null && contentBean.getProjectApply().getMachineAskId() != 0) {
                                    if (contentBean.getApplyCompany() != null) {
                                        bundle.putInt("type", ContractEvaluateActivity.COMPANYLEASE);
                                    } else {
                                        bundle.putInt("type", ContractEvaluateActivity.TEAMLEASE);
                                    }
                                } else {
                                    if (contentBean.getApplyCompany() != null) {
                                        bundle.putInt("type", ContractEvaluateActivity.COMPANYWORK);
                                    } else {
                                        bundle.putInt("type", ContractEvaluateActivity.TEAMWORK);
                                    }
                                }
                                openActivity(ContractEvaluateActivity.class, bundle);
                                break;
                        }
                        break;
                    case AppConstants.CLICK_02:
                        switch (ContractChildFragment.this.type) {
                            case 0:
                                changeStatus(pos, "CONTRACT_STATUS_SUBMITED");
                                break;
                            case 1:
                                if (!(MyApplication.isCompany && (contentBean.getApplyCompany() == null || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("id", mList.get(pos).getId());
                                    bundle.putString("auditNo", mList.get(pos).getContractNo());
                                    openActivityForResult(ApplyForPaymentActivity.class, APPPAY, bundle);
                                } else {
                                    DialogUtils.showSettingDialog(getActivity(), false, "确定完成？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                                        @Override
                                        public void onCommit() {
                                            completeContract(mList.get(pos).getId() + "");
                                        }
                                    });
                                }
                                break;
                            case 2:
                                if (!(MyApplication.isCompany && (contentBean.getApplyCompany() == null || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("id", mList.get(pos).getId());
                                    bundle.putString("auditNo", mList.get(pos).getContractNo());
                                    openActivityForResult(ApplyForPaymentActivity.class, APPPAY, bundle);
                                } else {
                                    DialogUtils.showSettingDialog(getActivity(), false, "确定完成？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                                        @Override
                                        public void onCommit() {
                                            completeContract(mList.get(pos).getId() + "");
                                        }
                                    });
                                }
                                break;
                            case 3:
                            case 4:
                                Bundle bundle = new Bundle();
                                bundle.putString("url", ApiManager.getContractDetailUrl(mList.get(pos).getId()));
                                openActivity(WebActivity.class, bundle);
                                break;
                        }
                        break;
                    case AppConstants.CLICK_03:
                        if (mList.get(pos).isLookOrder()) {
                            mList.get(pos).setLookOrder(!mList.get(pos).isLookOrder());
                            mRecycleView.getAdapter().notifyItemChanged(pos);
                        } else
                            getOrderDetail(pos);
                        break;

                }
            }
        });
    }

    /**
     * 获取合约下订单信息
     *
     * @param pos
     */
    public void getOrderDetail(final int pos) {
        setLoading(true);
        ApiManager.getOrder(mList.get(pos).getId(), getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<OrderBean> list = JSON.parseArray(response, OrderBean.class);
                if (list == null || list.size() < 1) {
                    onError("获取订单失败");
                    return;
                }
                mList.get(pos).setOrderBean(list);
                mList.get(pos).setLookOrder(true);
                mRecycleView.getAdapter().notifyItemChanged(pos);
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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && getView().getVisibility() == View.VISIBLE) {
            mRefreshLayout.autoRefresh();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == APPPAY && resultCode == Activity.RESULT_OK && type != 2) {
            EventBus.getDefault().post(new ContractEvens(3));
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
        mRefreshLayout.autoRefresh();
    }

    public void loadData() {
        if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                return;
            }
        } else {
            if (MyApplication.sTeamLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                return;
            }
        }
        if (page == 0) {
            mList.clear();
        }
        ApiManager.contactsList(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(),
                mStatus, page, getActivity(),new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        ProjectApplictionBean projectApplictionBean = JSON.parseObject(response, ProjectApplictionBean.class);
                        page = projectApplictionBean.getNumber() + 1;
                        mList.addAll(projectApplictionBean.getContent());
                        mRecycleView.getAdapter().notifyDataSetChanged();
                        mRefreshLayout.finishLoadmore(true);
                        mRefreshLayout.finishRefresh(true);
                        mRefreshLayout.setLoadmoreFinished(projectApplictionBean.isLast());
                        setLoading(false);
                    }

                    @Override
                    public void onError(String msg) {
                        mRefreshLayout.finishLoadmore(false);
                        mRefreshLayout.finishRefresh(false);
                        setLoading(false);
                    }
                });
    }


    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", position + 1);
        bundle.putInt("id", mList.get(position).getId());
        openActivity(ContractDetailActivity.class, bundle);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 0;
        loadData();
    }

    //修改合同状态
    public void changeStatus(final int pos, String status) {
        switch (status) {
            case "CONTRACT_STATUS_SUBMITED":
                DialogUtils.showSettingDialog(this.getActivity(), false, "确认签约？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        agreeContract(mList.get(pos).getId() + "");

                    }
                });
                break;
            case "CONTRACT_STATUS_SIGNED":
                DialogUtils.showSettingDialog(this.getActivity(), false, "确认签约？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        agreeContract(mList.get(pos).getId() + "");
                    }
                });
                break;
            case "CONTRACT_STATUS_WAIT_PAY":
                DialogUtils.showSettingDialog(this.getActivity(), false, "确认已付款？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                    @Override
                    public void onCommit() {
                        // gotoSave(projectApplictionBean.getContent().get(pos).getId()+"","CONTRACT_STATUS_DONE");
                        completeContract(mList.get(pos).getId() + "");
                    }
                });
                break;
            case "CONTRACT_STATUS_DONE":

                constartCancel(pos);
                break;
            case "CONTRACT_STATUS_CANCELED":
                constartCancel(pos);
                break;
        }
    }

    //取消合同
    private void constartCancel(final int pos) {

        DialogUtils.showSettingDialog(ContractChildFragment.this.getActivity(), false, "确认取消？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                //  gotoSave(projectApplictionBean.getContent().get(pos).getId()+"","CONTRACT_STATUS_CANCELED");

                ApiManager.cancelContract(mList.get(pos).getId() + "", ContractChildFragment.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        ConstartRefreshEvent constartRefreshEvent = new ConstartRefreshEvent();
                        constartRefreshEvent.addArrayList(0);
                        constartRefreshEvent.addArrayList(4);
                        EventBus.getDefault().post(new ContractEvens(5));
                        mRefreshLayout.autoRefresh();
                    }

                    @Override
                    public void onError(String msg) {
                        showToast(msg);
                    }
                });
            }
        });
    }

    //确认签约
    public void agreeContract(String contractId) {
        ApiManager.agreeContract(contractId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ConstartRefreshEvent constartRefreshEvent = new ConstartRefreshEvent();
                constartRefreshEvent.addArrayList(0);
                constartRefreshEvent.addArrayList(1);
                EventBus.getDefault().post(new ContractEvens(2));
                mRefreshLayout.autoRefresh();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    //确认完成
    public void completeContract(String contractId) {
        ApiManager.completeContract(contractId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ConstartRefreshEvent constartRefreshEvent = new ConstartRefreshEvent();
                constartRefreshEvent.addArrayList(2);
                constartRefreshEvent.addArrayList(3);
                EventBus.getDefault().post(new ContractEvens(4));
                mRefreshLayout.autoRefresh();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Subscribe
    public void contractEven(ContractEvens evens) {
        if ((type == evens.getType() - 1) && mRefreshLayout != null) {
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void itemClickListener(final int position, final int i) {
        DialogUtils.showSettingDialog(this.getActivity(), false, "确认付款申请？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                setLoading(true);
                ApiManager.confirmApply(mList.get(i).getOrderBean().get(position).getId(), getActivity(),new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        getOrderDetail(i);
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
            }
        });
    }
}
