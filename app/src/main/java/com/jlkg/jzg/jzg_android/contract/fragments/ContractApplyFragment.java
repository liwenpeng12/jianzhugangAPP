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
import com.jlkg.jzg.jzg_android.contract.activitys.EditContractActivity;
import com.jlkg.jzg.jzg_android.contract.adapters.ContractApplyAdapter;
import com.jlkg.jzg.jzg_android.contract.beans.ContractApplyBean;
import com.jlkg.jzg.jzg_android.contract.beans.ContractEvens;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zcs on 2018/3/30.
 *
 * @describe:待确认签约列表
 */

public class ContractApplyFragment extends BaseFragment implements OnItemClickListener, OnRefreshLoadmoreListener {
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.fl_noLogin)
    FrameLayout mFlNoLogin;
    private int page;
    private List<ContractApplyBean> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contract_child;
    }

    public static ContractApplyFragment getInstances(int type) {
        ContractApplyFragment fragment = new ContractApplyFragment();
        return fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ContractApplyAdapter adapter = new ContractApplyAdapter(this.getActivity(), mList, this);
        mRecycleView.setAdapter(adapter);
        adapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, final int pos, int child) {
                switch (type) {
                    case AppConstants.CLICK_01:
                        DialogUtils.showSettingDialog(getActivity(), false, "拒绝申请？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                            @Override
                            public void onCommit() {
                                if (mList.get(pos).getMachineAskId() != 0) {
                                    denyedLeaseApply(pos);
                                } else if (mList.get(pos).getProjectHire() != null) {
                                    denyedWorkApply(pos);
                                }
                            }
                        });
                        break;
                    case AppConstants.CLICK_02:
                        if (mList.get(pos).getMachineAskId() != 0) {
                            confimLeaseApply(pos);
                        } else if (mList.get(pos).getProjectHire() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", mList.get(pos).getId());
                            openActivityForResult(EditContractActivity.class, 1, bundle);
                        }
                        break;
                }
            }
        });
    }

    /**
     * 同意招租申请
     *
     * @param pos
     */
    private void confimLeaseApply(int pos) {
        ApiManager.applyMachineAskConfirm(mList.get(pos).getId(),getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                EventBus.getDefault().post(new ContractEvens(1));
                mRefreshLayout.autoRefresh();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    /**
     * 拒绝招租申请
     *
     * @param pos
     */
    private void denyedLeaseApply(int pos) {
        ApiManager.leaseDelete(mList.get(pos).getId(),getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                mRefreshLayout.autoRefresh();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }


    /**
     * 拒绝招工申请
     */
    private void denyedWorkApply(int pos) {
        ApiManager.updataApplyStatus(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId()
                        : MyApplication.sTeamLoginBean.getId(), mList.get(pos).getId(),
                "DENYED",getActivity(), new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        mRefreshLayout.autoRefresh();
                    }

                    @Override
                    public void onError(String msg) {
                        showToast(msg);
                    }
                });
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
//        setLoading(true);
        ApiManager.myProjectApplyList(MyApplication.isCompany ? MyApplication.sCompanyLoginBean.getId() : MyApplication.sTeamLoginBean.getId(), page,getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                mList.clear();
                mList.addAll(JSON.parseArray(response, ContractApplyBean.class));
//                if (page == 0) mList.clear();
//                page = bean.getNumber() + 1;
//                mList.addAll(bean.getContent());
                mRecycleView.getAdapter().notifyDataSetChanged();
                mRefreshLayout.finishLoadmore(true);
                mRefreshLayout.finishRefresh(true);
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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && getView().getVisibility() == View.VISIBLE) {
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void itemClickListener(int position) {
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadData();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            EventBus.getDefault().post(new ContractEvens(1));
            mRefreshLayout.autoRefresh();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
