package com.jlkg.jzg.jzg_android.contract;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.contract.beans.ContractEvens;
import com.jlkg.jzg.jzg_android.contract.fragments.ContractApplyFragment;
import com.jlkg.jzg.jzg_android.contract.fragments.ContractChildFragment;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

/**
 * 合约
 */
public class ContractFragment extends BaseFragment {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.fl_noLogin)
    FrameLayout mFlNoLogin;
    private String[] pageTitles = new String[]{"待确认", "待签约", "已签约", "待付款", "已完成", "已终止"};
    private Fragment[] mFragments;

    public ContractFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contract;
    }

    @Override
    protected void initView() {
        super.initView();
        if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.GONE);
                mTabLayout.setVisibility(View.GONE);
                return;
            }
        } else {
            if (MyApplication.sTeamLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.GONE);
                mTabLayout.setVisibility(View.GONE);
                return;
            }
        }
        mFragments = new Fragment[pageTitles.length];
        mViewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(mFragments.length);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.GONE);
                mTabLayout.setVisibility(View.GONE);
                return;
            }
        } else {
            if (MyApplication.sTeamLoginBean == null) {
                mFlNoLogin.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.GONE);
                mTabLayout.setVisibility(View.GONE);
                return;
            }
        }
    }

    class MyFragmentPageAdapter extends FragmentPagerAdapter {

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (mFragments[position] == null) {
                if (position == 0) {
                    ContractApplyFragment fragment = ContractApplyFragment.getInstances(position);
                    fragment.setArguments(getArguments());
                    mFragments[position] = fragment;
                } else {
                    ContractChildFragment fragment = ContractChildFragment.getInstances(position - 1);
                    fragment.setArguments(getArguments());
                    mFragments[position] = fragment;
                }
            }
            return mFragments[position];
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position];
        }

        @Override
        public int getCount() {
            return pageTitles.length;
        }
    }

    @Subscribe
    public void contractEven(ContractEvens evens) {
//        mFragments[evens.getType()].;
    }
}
