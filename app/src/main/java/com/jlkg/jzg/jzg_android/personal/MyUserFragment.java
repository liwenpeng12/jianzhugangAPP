package com.jlkg.jzg.jzg_android.personal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.other.event.ChangeRoleEvent;
import com.jlkg.jzg.jzg_android.other.event.LogoutEvent;
import com.jlkg.jzg.jzg_android.other.widget.CircleImageView;
import com.jlkg.jzg.jzg_android.personal.activity.ChangeRoleActivity;
import com.jlkg.jzg.jzg_android.personal.activity.LabourServiceActivity;
import com.jlkg.jzg.jzg_android.personal.activity.LetMachineActivity;
import com.jlkg.jzg.jzg_android.personal.activity.MineInfoActivity;
import com.jlkg.jzg.jzg_android.personal.activity.MywalletActivity;
import com.jlkg.jzg.jzg_android.personal.activity.OrganizationActivity;
import com.jlkg.jzg.jzg_android.personal.activity.ProjectApplicationActivity;
import com.jlkg.jzg.jzg_android.personal.activity.RecruitWorkersActivity;
import com.jlkg.jzg.jzg_android.personal.activity.SettingActivity;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassBeforeObjectActivity;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassChangeRoleActivity;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassMemberActivity;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassMineInfoActivity;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.EvaluateListActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyUserFragment extends BaseFragment {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.ll_recruit)
    LinearLayout llRecruit;
    @BindView(R.id.ll_wallet)
    LinearLayout llWallet;
    @BindView(R.id.ll_organization)
    LinearLayout llOrganization;
    @BindView(R.id.ll_machinery)
    LinearLayout llMachinery;
    @BindView(R.id.ll_project)
    LinearLayout llProject;
    @BindView(R.id.ll_change)
    LinearLayout llChange;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    Unbinder unbinder;
    @BindView(R.id.img_picture)
    CircleImageView imgPicture;
    @BindView(R.id.ll_login)
    LinearLayout llLogin;
    @BindView(R.id.ll_userInfo)
    LinearLayout llUserInfo;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.ll_hisProject)
    LinearLayout llHisProject;
    @BindView(R.id.ll_class)
    LinearLayout llClass;
    @BindView(R.id.ll_add_project)
    LinearLayout llAddProject;
    @BindView(R.id.img_default)
    CircleImageView imgDefault;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.view_ling_guowang)
    View viewLingGuowang;
    @BindView(R.id.ll_my_apply)
    LinearLayout llMyApply;
    @BindView(R.id.view_line_jixie)
    View viewLineJixie;
    @BindView(R.id.ll_evaluate)
    LinearLayout llEvaluate;

    public MyUserFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_user;
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

    @Override
    protected void initView() {
        super.initView();
//        if (PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
//            llUserInfo.setVisibility(View.VISIBLE);
//
//            llLogin.setVisibility(View.GONE);
//            if(MyApplication.isCompany){
//                if(MyApplication.sCompanyLoginBean!=null) {
//                    tvCompany.setText(MyApplication.sCompanyLoginBean.getTitle());
//                    tvName.setText(MyApplication.sCompanyLoginBean.getUserName());
//                }
//            }else {
//                if (MyApplication.sTeamLoginBean != null) {
//                    tvCompany.setText(MyApplication.sTeamLoginBean.getTeamType().getTitle());
//                    tvName.setText(MyApplication.sTeamLoginBean.getTitle());
//                }
//            }
//        } else {
//            llUserInfo.setVisibility(View.GONE);
//            llLogin.setVisibility(View.VISIBLE);
//
//        }

        changeRoleMethod();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (PrefUtils.getBoolean(this.getActivity(), AppConstants.ISLOGIN, false)) {
            llUserInfo.setVisibility(View.VISIBLE);
            llLogin.setVisibility(View.GONE);
            if (MyApplication.isCompany) {
                if (MyApplication.sCompanyLoginBean != null) {
                    tvCompany.setText(MyApplication.sCompanyLoginBean.getTitle());
                    tvName.setText(MyApplication.sCompanyLoginBean.getUserName());
                    if (MyApplication.sCompanyLoginBean.getCompanyType() != null) {
                        tvStatus.setText("已认证");
                    } else {
                        tvStatus.setText("未认证");
                    }
                    if (MyApplication.sCompanyLoginBean.touxiang != null) {
                        //  if(!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getLog))
                        if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.touxiang.getUrl())) {
                            Glide.with(this.getActivity()).load(MyApplication.sCompanyLoginBean.touxiang.getUrl()).into(imgPicture);
                        }
                    }
                }
            } else {
                if (MyApplication.sTeamLoginBean != null) {
                    if (MyApplication.sTeamLoginBean.getTeamType() != null) {
                        tvCompany.setText(MyApplication.sTeamLoginBean.getTeamType().getTitle());
                    }
                    tvName.setText(MyApplication.sTeamLoginBean.getTitle());
                    if (MyApplication.sTeamLoginBean.getTeamType() != null) {
                        tvStatus.setText("已认证");
                    } else {
                        tvStatus.setText("未认证");
                    }
                    if (MyApplication.sTeamLoginBean.getPhoto() != null) {
                        if (!TextUtils.isEmpty(MyApplication.sTeamLoginBean.getPhoto().getUrl())) {
                            Glide.with(this.getActivity()).load(MyApplication.sTeamLoginBean.getPhoto().getUrl()).into(imgPicture);
                        }
                    }
                }
            }
        } else {
            llUserInfo.setVisibility(View.GONE);
            llLogin.setVisibility(View.VISIBLE);
        }
    }

    //切换用户类型后，界面变化
    private void changeRoleMethod() {
        if (MyApplication.isCompany) {

            llProject.setVisibility(View.GONE);
            llHisProject.setVisibility(View.GONE);
            llOrganization.setVisibility(View.VISIBLE);
            llClass.setVisibility(View.GONE);
            llAddProject.setVisibility(View.VISIBLE);
            viewLingGuowang.setVisibility(View.VISIBLE);
            viewLineJixie.setVisibility(View.GONE);
            llEvaluate.setVisibility(View.GONE);

        } else {
            viewLingGuowang.setVisibility(View.VISIBLE);
            viewLineJixie.setVisibility(View.GONE);

            llProject.setVisibility(View.GONE);
            llHisProject.setVisibility(View.VISIBLE);

            llOrganization.setVisibility(View.GONE);
            llClass.setVisibility(View.VISIBLE);
            llAddProject.setVisibility(View.GONE);

            //甲方评价
            llEvaluate.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.ll_class,R.id.ll_evaluate, R.id.ll_hisProject, R.id.ll_login, R.id.ll_userInfo, R.id.ll_recruit, R.id.ll_wallet, R.id.ll_organization, R.id.ll_machinery, R.id.ll_project, R.id.ll_change, R.id.ll_setting, R.id.ll_add_project})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_login:
                openActivity(LoginActivity.class);
                break;
            //个人信息
            case R.id.ll_userInfo:
                if (MyApplication.isCompany) {
                    openActivity(MineInfoActivity.class);
                } else {
                    openActivity(ClassMineInfoActivity.class);
                }
                break;
            //我的招工
            case R.id.ll_recruit:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(RecruitWorkersActivity.class);
                break;

            //我的钱包
            case R.id.ll_wallet:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(MywalletActivity.class);
                break;

            //添加项目
            case R.id.ll_organization:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }

                openActivity(OrganizationActivity.class);
                break;

            //机械招租
            case R.id.ll_machinery:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(LetMachineActivity.class);
                break;

            //项目申请
            case R.id.ll_project:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(ProjectApplicationActivity.class);
                break;

            //切换角色
            case R.id.ll_change:
                if (MyApplication.isCompany) {
                    openActivityForResult(ChangeRoleActivity.class, 10);
                } else {
                    openActivityForResult(ClassChangeRoleActivity.class, 10);
                }
                break;

            //系统设置
            case R.id.ll_setting:
                openActivity(SettingActivity.class);
                break;


            //过往项目
            case R.id.ll_hisProject:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
             //   openActivity(ClassBeforeObjectActivity.class);

                Bundle bundleOld = new Bundle();
                PrefUtils.setBoolean(mContext,"mPhoneNum",true);

                bundleOld.putInt("id", MyApplication.sTeamLoginBean.getId());

                Log.d("lwp","id:"+MyApplication.sTeamLoginBean.getId());

                openActivity(ClassBeforeObjectActivity.class, bundleOld);
                break;

            //班组成员
            case R.id.ll_class:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("teamId", MyApplication.sTeamLoginBean.getId() + "");
                openActivity(ClassMemberActivity.class, bundle);
//                bundle.putInt("id", MyApplication.sTeamLoginBean.getId());
//                openActivity(TeamDetailActivity.class, bundle);

                break;

            //组织架构
            case R.id.ll_add_project:
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", MyApplication.sCompanyLoginBean.getTitle());
                bundle1.putString("companyId", MyApplication.sCompanyLoginBean.getId() + "");
                openActivity(LabourServiceActivity.class, bundle1);
                break;
            case R.id.ll_my_apply:

                break;
            case R.id.ll_evaluate:
                //甲方评价
                if (!PrefUtils.getBoolean(this.getActivity(), "isLogin", false)) {
                    openActivity(LoginActivity.class);
                    return;
                }
                openActivity(EvaluateListActivity.class);
                break;
        }
    }

    @Subscribe
    public void onEventMainThread(ChangeRoleEvent event) {
        changeRoleMethod();
    }

    @Subscribe
    public void onEventMainThread(LogoutEvent event) {
        //退出登录
        llUserInfo.setVisibility(View.GONE);
        llLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            getActivity().finish();
            openActivity(MainActivity.class);
        }
    }
}
