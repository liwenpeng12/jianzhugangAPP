package com.jlkg.jzg.jzg_android;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.baidu.mapapi.SDKInitializer;
import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.contract.ContractFragment;
import com.jlkg.jzg.jzg_android.home.HomeFragment;
import com.jlkg.jzg.jzg_android.job.JobFragment;
import com.jlkg.jzg.jzg_android.other.activity.SelectRoleActivity;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.bean.LoginBean;
import com.jlkg.jzg.jzg_android.other.bean.TeamLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.personal.MyUserFragment;
import com.jlkg.jzg.jzg_android.release.activitys.ReleaseLeaseActivity;
import com.jlkg.jzg.jzg_android.release.activitys.ReleaseWorkerActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PreFiled;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.rg_tab)
    RadioGroup mRgTab;
    @BindView(R.id.tv_fabu)
    TextView mTvFabu;
    @BindView(R.id.parent)
    FrameLayout mFlParent;
    @BindView(R.id.rb_mine)
    RadioButton mRbMine;
    private MainFragmentAdapter adapter;
    private View mFabuView;
    private ImageView mIvFabu;
    private TextView mTvFabuZhaogong;
    private TextView mTvFabuZhaozhu;
    private PopupWindow mWindow;
    int rbCheckPosition;

    private void requestPermissions() {
        RxPermissions rxPermission = new RxPermissions(this);
        rxPermission
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE/*
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.CHANGE_WIFI_STATE,
                        Manifest.permission.WRITE_SETTINGS,
                        Manifest.permission.GET_TASKS*/)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!aBoolean) {
                            showToast("您没有允许需要的权限");
                            finish();
                        }
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getExtras() != null) {
            setTab(intent.getExtras().getInt("dex", 0));
        } else {
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SDKInitializer.initialize(getApplicationContext());
//        MyApplication.hasSelectRole = false;
        super.onCreate(savedInstanceState);
        Set<String> set = new HashSet<>();
        if (MyApplication.isCompany) {
            set.add("company");
        } else {
            set.add("team");
        }
        JPushInterface.setTags(mContext, 1, set);
    }

    @OnClick(R.id.tv_fabu)
    void fabu() {
        aboutPopupShowOrHidden();
    }

    @Override
    protected void initViews() {
        super.initViews();
        requestPermissions();
//        mFabuView.setVisibility(View.GONE);
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
//        Fragment fragment = (Fragment) adapter.instantiateItem(mFlContent, 0);
//        selectFragment(fragment);
        mRgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for (int i = 0; i < 5; i++) {
                    if (checkedId == mRgTab.getChildAt(i).getId()) {
                        int position = i;
                        if (position == 4 && !MyApplication.hasSelectRole) {
                            openActivityForResult(SelectRoleActivity.class, 10);
                            return;
                        }
                        rbCheckPosition = position;
                        if (position == 3 || position == 4)
                            position = position - 1;
                        Fragment fragment = (Fragment) adapter.instantiateItem(mFlContent, position);
                        selectFragment(fragment);
                        break;
                    }
                }
            }
        });


        ((RadioButton) mRgTab.getChildAt(0)).setChecked(true);

        mFabuView = LayoutInflater.from(mContext).inflate(R.layout.fragment_release, mFlParent, false);
        mIvFabu = mFabuView.findViewById(R.id.iv_button);
        mTvFabuZhaogong = mFabuView.findViewById(R.id.tv_fabu_zhaogong);
        mTvFabuZhaozhu = mFabuView.findViewById(R.id.tv_fabu_zhaozhu);
        mWindow = new PopupWindow(mFabuView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mIvFabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutPopupShowOrHidden();
            }
        });
        mFabuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutPopupShowOrHidden();
            }
        });
        mTvFabuZhaogong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (!MyApplication.hasSelectRole) {
                    openActivity(SelectRoleActivity.class);
                    return;
                }
                if (MyApplication.isCompany) {
                    if (MyApplication.sCompanyLoginBean == null) {
                        DialogUtils.showNoLoginDialog(mContext);
                        return;
                    }*//* else if (MyApplication.sCompanyLoginBean.getCompanyType() == null) {
                        DialogUtils.showInvitedDia(mContext, true);
                        return;
                    }*//*
                } else {
                    if (MyApplication.sTeamLoginBean == null) {
                        DialogUtils.showNoLoginDialog(mContext);
                        return;
                    } *//*else if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                        DialogUtils.showInvitedDia(mContext, true);
                        return;
                    }*//*
                }*/
                openActivity(ReleaseWorkerActivity.class);
            }
        });
        mTvFabuZhaozhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (!MyApplication.hasSelectRole) {
                    openActivity(SelectRoleActivity.class);
                    return;
                }*/
                /*if (MyApplication.isCompany) {
                    if (MyApplication.sCompanyLoginBean == null) {
                        DialogUtils.showNoLoginDialog(mContext);
                        return;
                    } *//*else if (MyApplication.sCompanyLoginBean.getCompanyType() == null) {
                        DialogUtils.showInvitedDia(mContext, true);
                        return;
                    }*//*
                } else {
                    if (MyApplication.sTeamLoginBean == null) {
                        DialogUtils.showNoLoginDialog(mContext);
                        return;
                    }*//* else if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                        DialogUtils.showInvitedDia(mContext, true);
                        return;
                    }*//*
                }*/
                openActivity(ReleaseLeaseActivity.class);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            Fragment fragment = (Fragment) adapter.instantiateItem(mFlContent, 3);
            selectFragment(fragment);
        } else if (requestCode == 10) {
            backCheckPosition(rbCheckPosition);
        }
    }

    public void setTab(int dex) {
        if (dex == 4 && !MyApplication.hasSelectRole) {
            openActivityForResult(SelectRoleActivity.class, 10);
            return;
        }
        rbCheckPosition = dex;
        if (dex == 3 || dex == 4)
            dex = dex - 1;
        ((RadioButton) mRgTab.getChildAt(dex)).setChecked(true);
    }

    public void backCheckPosition(int dex) {
        rbCheckPosition = dex;
        ((RadioButton) mRgTab.getChildAt(dex)).setChecked(true);
    }

    /**
     * 发布弹窗操作方法
     */
    private void aboutPopupShowOrHidden() {
        if (mWindow == null || !mWindow.isShowing()) {
            mTvFabuZhaozhu.clearAnimation();
            mTvFabuZhaogong.clearAnimation();
            mWindow.showAtLocation(mFlParent, Gravity.CENTER, 0, 0);
            mTvFabuZhaogong.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fabu_in_anim));
            mTvFabuZhaozhu.setAnimation(AnimationUtils.loadAnimation(this, R.anim.zhaozu_in_anim));
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fabu_ratate);
            mIvFabu.setAnimation(animation);
        } else {
            mTvFabuZhaozhu.clearAnimation();
            mTvFabuZhaogong.clearAnimation();
            mTvFabuZhaogong.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fabu_out_anim));
            mTvFabuZhaozhu.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.zhaozu_out_anim));
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fabu_ratate_close);
            mIvFabu.setAnimation(animation);
            mIvFabu.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mWindow.dismiss();
                    mIvFabu.clearAnimation();
                }
            }, 500);
//            mTvFabuZhaozhu.clearAnimation();
//            mTvFabuZhaogong.clearAnimation();
//            mIvFabu.clearAnimation();
        }
    }

    private Fragment tempFragment;

    public void selectFragment(Fragment fragment) {

        if (tempFragment != null || tempFragment != fragment) {
            if (!fragment.isAdded()) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (tempFragment != null)
                    transaction.hide(tempFragment);
                transaction.add(R.id.fl_content, fragment).commitAllowingStateLoss();
            } else {
                getSupportFragmentManager().beginTransaction().hide(tempFragment).show(fragment).commitAllowingStateLoss();
            }
        }
        tempFragment = fragment;
    }

    class MainFragmentAdapter extends FragmentPagerAdapter {

        public MainFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new JobFragment();
                case 2:
                    return new ContractFragment();
                case 3:
                    return new MyUserFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    private long close;

    @Override
    public void onBackPressed() {
        if (mWindow != null && mWindow.isShowing()) {
            aboutPopupShowOrHidden();
            return;
        }
        if (System.currentTimeMillis() - close > 1000) {
            close = System.currentTimeMillis();
            toast("再按一次退出APP");
            return;
        }

        super.onBackPressed();
    }

    @Override
    protected void initData() {
        super.initData();
        MyApplication.isCompany = PrefUtils.getBoolean(mContext, PreFiled.ISCOMPANY, true);

        if (!PrefUtils.getBoolean(mContext, "isLogin", false))//|| MyApplication.sCompanyLoginBean != null || MyApplication.sTeamLoginBean != null)
            return;
        setLoading(true);
        String str = PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT, "");
        String username;
        String pwd;
        String wxId = PrefUtils.getString(mContext, PreFiled.WXID, "");
        if (MyApplication.isCompany) {
            username = PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT, "");
            pwd = PrefUtils.getString(mContext, PreFiled.COMPANYPWD, "");
        } else {
//            username = PrefUtils.getString(mContext, PreFiled.TEAMACCOUNT, "");
//            pwd = PrefUtils.getString(mContext, PreFiled.TEAMPWd, "");
            username = PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT, "");
            pwd = PrefUtils.getString(mContext, PreFiled.COMPANYPWD, "");
        }

        if (!TextUtils.isEmpty(wxId)) {
            wxLogin(wxId);
        } else {
            pwdLogin(username, pwd);
        }


        /*if (MyApplication.isCompany)
            ApiManager.companySignln(PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT, ""), PrefUtils.getString(mContext, PreFiled.COMPANYPWD, ""), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    MyApplication.hasSelectRole = true;
                    CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
                    MyApplication.sCompanyLoginBean = bean;
                    PrefUtils.setBoolean(mContext, "isLogin", true);
                    setLoading(false);
                    Set<String> set = new HashSet<>();
                    set.add("company");
                    if (bean.getCompanyType() != null)
                        set.add(bean.getCompanyType().getId());
                    set.add(bean.getId() + "");
                    JPushInterface.setTags(mContext, 1, set);
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                    PrefUtils.setBoolean(mContext, "isLogin", false);
                }
            });
        else
            ApiManager.teamSignln(PrefUtils.getString(mContext, PreFiled.TEAMACCOUNT, ""), PrefUtils.getString(mContext, PreFiled.TEAMPWd, ""), new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    TeamLoginBean bean = JSON.parseObject(response, TeamLoginBean.class);
                    MyApplication.sTeamLoginBean = bean;
                    PrefUtils.setBoolean(mContext, "isLogin", true);
                    setLoading(false);
                    Set<String> set = new HashSet<>();
                    set.add("team");
                    if (bean.getTeamType() != null)
                        set.add(bean.getTeamType().getId() + "");
                    set.add(bean.getId() + "");
                    JPushInterface.setTags(mContext, 1, set);
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                    PrefUtils.setBoolean(mContext, "isLogin", false);
                }
            });*/
    }

    private void wxLogin(final String wxId) {
        ApiManager.weChartLogin(wxId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                formatResponse(response);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    private void pwdLogin(String userName, String pwd) {
        ApiManager.login(userName, pwd, MyApplication.isCompany, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                formatResponse(response);
            }

            @Override
            public void onError(String msg) {
                MyApplication.hasSelectRole = false;
                showToast(msg);
                setLoading(false);
                PrefUtils.setBoolean(mContext, "isLogin", false);
            }
        });
    }

    private void formatResponse(String response) {
        LoginBean loginBean = JSON.parseObject(response, LoginBean.class);
        CompanyLoginBean company = loginBean.getCompany();
        TeamLoginBean team = loginBean.getTeam();
        MyApplication.sCompanyLoginBean = company;
        MyApplication.sTeamLoginBean = team;
        Set<String> set = new HashSet<>();
        if (MyApplication.isCompany) {
            MyApplication.hasSelectRole = true;
//                    CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
//                    MyApplication.sCompanyLoginBean = bean;
            PrefUtils.setBoolean(mContext, "isLogin", true);
            setLoading(false);

            set.add("company");
            set.add("COMPANY");
            if (company != null && company.getCompanyType() != null) {
                set.add(company.getCompanyType().getId() + "" + company.getId());
            }
            set.add(company.getId() + "");
            System.out.println("==========设置标签=公=========");
            if (company.getDistrict() != null) {
                set.add(company.getDistrict().getId() + "");
                set.add(company.getCompanyType().getId() + "" + company.getDistrict().getId());

            }
        } else {
            MyApplication.hasSelectRole = true;
            PrefUtils.setBoolean(mContext, "isLogin", true);
            setLoading(false);
            set.add("team");
            if (team != null && team.getTeamType() != null) {
                set.add(team.getTeamType().getId() + "" + team.getId());
            }
            // set.add(team.getId() + "");
            if (team.getDistrict() != null) {
                set.add("" + team.getDistrict().getId());
                set.add(team.getTeamType().getId() + "" + team.getDistrict().getId());
            }
            System.out.println("==========设置标签==========" + team.getId());

        }

        JPushInterface.setTags(mContext, set, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                System.out.println("===========" + set.toString());
            }
        });
    }


}
