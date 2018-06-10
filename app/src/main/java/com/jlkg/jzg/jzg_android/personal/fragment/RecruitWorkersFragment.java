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
import com.jlkg.jzg.jzg_android.job.activitys.JobDetailActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.AgainReleaseProjectActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.ClassRecruitWorkersAdapter;
import com.jlkg.jzg.jzg_android.personal.adapter.RecruitWorkersAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.RecruitWorkersBean;
import com.jlkg.jzg.jzg_android.personal.bean.RecruitWorkersTeamBean;
import com.jlkg.jzg.jzg_android.personal.event.RecruitWorkersEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecruitWorkersFragment extends BaseFragment {


    @BindView(R.id.list_content)
    XRecyclerView listContent;
    Unbinder unbinder;
    //0：全部  1：招聘中  2：已完成
    private int type;
    //公司角色
    private RecruitWorkersAdapter recruitWorkersAdapter;
    //班组角色
    private ClassRecruitWorkersAdapter classRecruitWorkersAdapter;

    private String status;
    private int page = 0;
    private List<RecruitWorkersBean> recruitWorkersBeanList = new ArrayList<>();
    private List<RecruitWorkersTeamBean> recruitWorkersTeamBeanList = new ArrayList<>();

    public static RecruitWorkersFragment getInstances(int type) {
        RecruitWorkersFragment recruitWorkersFragment = new RecruitWorkersFragment();
        recruitWorkersFragment.type = type;
        return recruitWorkersFragment;
    }

    public RecruitWorkersFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recruit_workers;
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        listContent.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 0;
                if (MyApplication.isCompany) {
                    getWorkData();
                } else {
                    getTeamData();
                }
            }

            @Override
            public void onLoadMore() {
                page++;
                if (MyApplication.isCompany) {
                    getWorkData();
                } else {
                    getTeamData();
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        if (MyApplication.isCompany) {
            //公司角色
            recruitWorkersAdapter = new RecruitWorkersAdapter(this.getActivity(), new ArrayList<String>(), type);
            recruitWorkersAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
                @Override
                public void onClick(View v, int type, int pos, int child) {
                    switch (type) {
                        case AppConstants.CLICK_ITEM:
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", 2);
                            bundle.putInt("myuser",1);
                            bundle.putInt("id", recruitWorkersBeanList.get(pos).getId());
                            openActivity(JobDetailActivity.class, bundle);
                            break;
                        case AppConstants.CLICK_01:
                            delet(pos);
                            break;
                        case AppConstants.CLICK_02:
                            switch (RecruitWorkersFragment.this.type) {
                                case 0:

                                    System.out.println("=====status==" + recruitWorkersBeanList.get(pos).getStatus().getId());
                                    if ("HIRE_TYPE_AUDITED".equals(recruitWorkersBeanList.get(pos).getStatus().getId())) {
                                        //确认完成

                                        confirm(pos);
                                    } else {
                                        //删除
                                        delet(pos);
                                    }
                                    break;
                                case 1:
                                    //招聘中
                                    confirm(pos);
                                    break;
                                case 2:
                                    //已完成
                                    delet(pos);
                                    break;
                            }
                            break;
                        case AppConstants.CLICK_03:
                            Bundle bundle1 = new Bundle();
                            bundle1.putInt("type", 2);
                            bundle1.putInt("id", recruitWorkersBeanList.get(pos).getId());
                            openActivity(AgainReleaseProjectActivity.class, bundle1);
                            break;
                    }
                }
            });
            listContent.setAdapter(recruitWorkersAdapter);
        } else {
            //班组角色
            classRecruitWorkersAdapter = new ClassRecruitWorkersAdapter(this.getActivity(), new ArrayList<String>(), type);
            classRecruitWorkersAdapter.setOnClickListener(new ClickUtils.OnClickListener() {
                @Override
                public void onClick(View v, int type, int pos, int child) {
                    switch (type) {
                        case AppConstants.CLICK_ITEM:
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", 2);
                            bundle.putInt("myuser",1);
                            bundle.putInt("id", recruitWorkersTeamBeanList.get(pos).getId());
                            openActivity(JobDetailActivity.class, bundle);
                            break;
                        case AppConstants.CLICK_01:
                            delet(pos);
                            break;
                        case AppConstants.CLICK_02:
                            switch (RecruitWorkersFragment.this.type) {
                                case 0:
                                    System.out.println("=====status==" + recruitWorkersTeamBeanList.get(pos).getStatus().getId());
                                    if ("HIRE_TYPE_AUDITED".equals(recruitWorkersTeamBeanList.get(pos).getStatus().getId())) {
                                        //确认完成

                                        confirm(pos);
                                    } else {
                                        //删除
                                        delet(pos);
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
                            bundle1.putInt("type", 2);
                            bundle1.putInt("id", recruitWorkersTeamBeanList.get(pos).getId());
                            openActivity(AgainReleaseProjectActivity.class, bundle1);
                            break;
                    }
                }
            });
            listContent.setAdapter(classRecruitWorkersAdapter);
        }

        listContent.refresh();
    }

    //公司----删除我的招工
    public void delet(final int pos) {
        DialogUtils.showSettingDialog(this.getActivity(), false, "是否删除该条招工？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                if (MyApplication.isCompany) {
                    ApiManager.doDelete(recruitWorkersBeanList.get(pos).getId(), this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {

                            recruitWorkersBeanList.remove(pos);
                            recruitWorkersAdapter.notifyDataSetChanged();

                            RecruitWorkersEvent recruitWorkersEvent = new RecruitWorkersEvent();
                            EventBus.getDefault().post(recruitWorkersEvent);
                        }

                        @Override
                        public void onError(String msg) {
                            showToast(msg);
                        }
                    });
                } else {
                    ApiManager.doDelete(recruitWorkersTeamBeanList.get(pos).getId(), this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            recruitWorkersTeamBeanList.remove(pos);
                            classRecruitWorkersAdapter.notifyDataSetChanged();
                            RecruitWorkersEvent recruitWorkersEvent = new RecruitWorkersEvent();
                            EventBus.getDefault().post(recruitWorkersEvent);
                        }

                        @Override
                        public void onError(String msg) {
                            showToast(msg);
                        }
                    });
                }
            }
        });
    }

    //公司----确认完成
    public void confirm(final int pos) {
        DialogUtils.showSettingDialog(this.getActivity(), false, "确认完成？", "确定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                if (MyApplication.isCompany) {
                    ApiManager.myprojectConfirm(recruitWorkersBeanList.get(pos).getId() + "", "HIRE_TYPE_CLOSE", this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            listContent.refresh();
                            //   recruitWorkersAdapter.notifyDataSetChanged();
                            RecruitWorkersEvent recruitWorkersEvent = new RecruitWorkersEvent();
                            EventBus.getDefault().post(recruitWorkersEvent);
                        }

                        @Override
                        public void onError(String msg) {
                            showToast(msg);
                        }
                    });
                } else {
                    ApiManager.myprojectConfirm(recruitWorkersTeamBeanList.get(pos).getId() + "", "HIRE_TYPE_CLOSE", this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            listContent.refresh();
                            //   recruitWorkersAdapter.notifyDataSetChanged();
                            RecruitWorkersEvent recruitWorkersEvent = new RecruitWorkersEvent();
                            EventBus.getDefault().post(recruitWorkersEvent);
                        }

                        @Override
                        public void onError(String msg) {
                            showToast(msg);
                        }
                    });
                }
            }
        });
    }

    //获取公司----我的招工
    private void getWorkData() {
        if (type == 0) {

        } else if (type == 1) {
            status = "HIRE_TYPE_AUDITED";
        } else {
            status = "HIRE_TYPE_CLOSE";
        }
        ApiManager.queryHireByPhone(MyApplication.sCompanyLoginBean.getUserName() + "", status, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
//                listContent.refreshComplete();
//                listContent.loadMoreComplete();
//                try {
//                    RecruitWorkersBean recruitWorkersBean= JSON.parseObject(response,RecruitWorkersBean.class);
//                    disposeData(recruitWorkersBean);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }

                listContent.refreshComplete();
                listContent.loadMoreComplete();
                try {
                    recruitWorkersBeanList = JSON.parseArray(response, RecruitWorkersBean.class);
                    disposeDataCompany(recruitWorkersBeanList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);

                listContent.refreshComplete();
                listContent.loadMoreComplete();
            }
        });
    }

    //获取班组---我的招工
    public void getTeamData() {
        if (type == 0) {
            status = "";
        } else if (type == 1) {
            status = "HIRE_TYPE_AUDITED";
        } else {
            status = "HIRE_TYPE_CLOSE";
        }
        ApiManager.queryHireByPhone(MyApplication.sTeamLoginBean.getUserName() + "", status, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                listContent.refreshComplete();
                listContent.loadMoreComplete();
                try {
                    recruitWorkersTeamBeanList = JSON.parseArray(response, RecruitWorkersTeamBean.class);
                    disposeData(recruitWorkersTeamBeanList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                listContent.refreshComplete();
                listContent.loadMoreComplete();
            }
        });
    }

    //公司数据处理
    public void disposeDataCompany(List<RecruitWorkersBean> recruitWorkersTeamBeans) {
//        if(recruitWorkersBean==null||recruitWorkersBean.content==null||recruitWorkersBean.content.size()<=0){
//            return;
//        }
//        if(page==0||this.recruitWorkersBean==null||this.recruitWorkersBean.content==null){
//            this.recruitWorkersBean=recruitWorkersBean;
//        }else{
//            this.recruitWorkersBean.content.addAll(recruitWorkersBean.content);
//        }
//        recruitWorkersAdapter.setRecruitWorkersBean(this.recruitWorkersBean);
        if (recruitWorkersTeamBeans == null) {
            return;
        }
        this.recruitWorkersBeanList = recruitWorkersTeamBeans;
        recruitWorkersAdapter.setRecruitWorkersBean(this.recruitWorkersBeanList);
    }

    //班组数据处理
    public void disposeData(List<RecruitWorkersTeamBean> recruitWorkersTeamBeans) {
        if (recruitWorkersTeamBeans == null) {
            return;
        }
        this.recruitWorkersTeamBeanList = recruitWorkersTeamBeans;
        classRecruitWorkersAdapter.setRecruitWorkersTeamBeanList(this.recruitWorkersTeamBeanList);
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
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(RecruitWorkersEvent recruitWorkersEvent) {
        if (listContent != null) {
            listContent.refresh();
        }
    }
}
