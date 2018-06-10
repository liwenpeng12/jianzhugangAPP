package com.jlkg.jzg.jzg_android.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jlkg.jzg.baselibrary.weidget.BannerGlideImageLoader;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.activitys.ClassActivity;
import com.jlkg.jzg.jzg_android.home.activitys.CompanyListActivity;
import com.jlkg.jzg.jzg_android.home.activitys.MallActivity;
import com.jlkg.jzg.jzg_android.home.activitys.MessageActivity;
import com.jlkg.jzg.jzg_android.release.activitys.ReleaseWorkerActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.banner)
    Banner mBanner;

    public HomeFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();
        List<String> imgs = new ArrayList<>();
        imgs.add("https://jianzhugang.oss-cn-shenzhen.aliyuncs.com/appImages/banner1.png");
        imgs.add("https://jianzhugang.oss-cn-shenzhen.aliyuncs.com/appImages/banner2.png");
        imgs.add("https://jianzhugang.oss-cn-shenzhen.aliyuncs.com/appImages/banner3.png");
        mBanner.setImageLoader(new BannerGlideImageLoader()).setImages(imgs).start();
//        DialogUtils.showToastDialog(getActivity(), "你提交的公司信息审核已通过");
    }

    @OnClick({R.id.fl_1, R.id.fl_2, R.id.fl_3, R.id.fl_4, R.id.fl_5, R.id.fl_6, R.id.ib_right})
    void click(View v) {
        switch (v.getId()) {
            case R.id.fl_1:
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
                    }*//* else if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                        DialogUtils.showInvitedDia(mContext, true);
                        return;
                    }*//*
                }*/
                openActivity(ReleaseWorkerActivity.class);
                break;
            case R.id.fl_2:
                ((MainActivity) getActivity()).setTab(1);
                break;
            case R.id.fl_3:
                openActivity(CompanyListActivity.class);
                break;
            case R.id.fl_4:
                Bundle bundle = new Bundle();
                bundle.putString("type", ClassActivity.TEAMPAGE);
                openActivity(ClassActivity.class, bundle);
                break;
            case R.id.fl_5:
                openActivity(MallActivity.class);
                break;
            case R.id.fl_6:
                Bundle bundle1 = new Bundle();
                bundle1.putString("type", ClassActivity.MECHANICAL);
                openActivity(ClassActivity.class, bundle1);
                break;
            case R.id.ib_right:
                openActivity(MessageActivity.class);
                break;
        }
    }
}
