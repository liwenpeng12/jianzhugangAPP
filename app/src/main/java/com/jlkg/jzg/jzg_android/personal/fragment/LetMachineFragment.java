package com.jlkg.jzg.jzg_android.personal.fragment;


import android.app.Activity;
import android.content.Intent;
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
import com.jlkg.jzg.jzg_android.job.activitys.JobDetailActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.AgainReleaseLetActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.LetMachineAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.LetMachineBean;
import com.jlkg.jzg.jzg_android.personal.event.LetMachineEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LetMachineFragment extends BaseFragment {


    @BindView(R.id.list_content)
    XRecyclerView listContent;
    Unbinder unbinder;
    //0：全部  1：招租中  2：已完成
    private int type;
    private LetMachineAdapter letMachineAdapter;
    private int page = 0;
    private LetMachineBean letMachineBean;

    public static LetMachineFragment getInstances(int type) {
        LetMachineFragment letMachineFragment = new LetMachineFragment();
        letMachineFragment.type = type;
        return letMachineFragment;
    }

    public LetMachineFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_let_machine;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        listContent.setPullRefreshEnabled(true);
        listContent.setLoadingMoreEnabled(true);
        listContent.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 0;
                getDate();
            }

            @Override
            public void onLoadMore() {
                page++;
                getDate();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        letMachineAdapter = new LetMachineAdapter(this.getActivity(), new ArrayList<String>(), type);
        letMachineAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type) {
                    case AppConstants.CLICK_ITEM:
                        Bundle bundle = new Bundle();
                        bundle.putInt("type", 1);
                        bundle.putInt("id", letMachineBean.getContent().get(pos).getId());
                        openActivity(JobDetailActivity.class, bundle);
                        break;
                    case AppConstants.CLICK_01:
                        //删除
                        delet(pos);
                        break;
                    case AppConstants.CLICK_02:
                        switch (LetMachineFragment.this.type) {
                            case 0:
                                if (letMachineBean.getContent().get(pos).getStatus() != null) {
                                    if ("ASK_DONE".equals(letMachineBean.getContent().get(pos).getStatus().getId())) {
                                        //删除
                                        delet(pos);
                                    } else {
                                        //确认完成
                                        confirm(pos);

                                    }
                                } else {
                                    //确认完成
                                    confirm(pos);
                                }
                                break;
                            case 1:
                                //确认完成
                                confirm(pos);
                                break;
                            case 2:
                                //删除
                                delet(pos);
                                break;
                        }
                        break;
                    case AppConstants.CLICK_03:
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("type", 1);
                        bundle1.putInt("id", letMachineBean.getContent().get(pos).getId());
                        openActivityForResult(AgainReleaseLetActivity.class, 1, bundle1);
                        break;
                }
            }
        });
        listContent.setAdapter(letMachineAdapter);
        listContent.refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }

    @Subscribe
    public void onEventMainThread(LetMachineEvent letMachineEvent) {
        if (letMachineEvent.isPosition(type)) {
            listContent.refresh();
        }
    }


    public void getDate() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", page + "");
        hashMap.put("size", "10");

        if (MyApplication.isCompany) {
            hashMap.put("companyId", MyApplication.sCompanyLoginBean.getId() + "");
        } else {
            hashMap.put("teamId", MyApplication.sTeamLoginBean.getId() + "");
        }

        if (type == 1) {
            hashMap.put("status", "ASK_LETING");
        } else if (type == 2) {
            hashMap.put("status", "ASK_DONE");
        }
        ApiManager.getAppList(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                listContent.refreshComplete();
                listContent.refreshComplete();
                try {
                    LetMachineBean letMachineBean = JSON.parseObject(response, LetMachineBean.class);
                    dispatchData(letMachineBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                listContent.refreshComplete();
                listContent.refreshComplete();
                showToast(msg);
            }
        });
    }

    public void dispatchData(LetMachineBean letMachineBean) {

        if (letMachineBean == null && letMachineBean.getContent() == null) {
            return;
        }

        if (this.letMachineBean == null || page == 0 || this.letMachineBean.getContent() == null) {
            this.letMachineBean = letMachineBean;
        } else {
            this.letMachineBean.getContent().addAll(letMachineBean.getContent());
        }
        letMachineAdapter.setLetMachineBean(this.letMachineBean);
    }


    //公司----删除我的招工
    public void delet(final int pos) {
        DialogUtils.showSettingDialog(this.getActivity(), false, "是否删除该条招工？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                setLoading(true);
                ApiManager.delMachine(letMachineBean.getContent().get(pos).getId() + "", LetMachineFragment.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        LetMachineEvent letMachineEvent = new LetMachineEvent();
                        letMachineEvent.addList(0);
                        letMachineEvent.addList(2);
                        letMachineEvent.addList(1);
                        EventBus.getDefault().post(letMachineEvent);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

        }
    }

    //公司----确认完成
    public void confirm(final int pos) {
        DialogUtils.showSettingDialog(this.getActivity(), false, "确认完成？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {

                setLoading(true);
                ApiManager.machineStatus(letMachineBean.getContent().get(pos).getId() + "", "ASK_DONE", LetMachineFragment.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        LetMachineEvent letMachineEvent = new LetMachineEvent();
                        letMachineEvent.addList(0);
                        letMachineEvent.addList(1);
                        letMachineEvent.addList(2);
                        EventBus.getDefault().post(letMachineEvent);
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
