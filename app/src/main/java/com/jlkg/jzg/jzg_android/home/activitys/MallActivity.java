package com.jlkg.jzg.jzg_android.home.activitys;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.fragments.MallListFragment;
import com.jlkg.jzg.jzg_android.home.fragments.MallMapFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MallActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mall;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mViewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class MyFragmentPageAdapter extends FragmentPagerAdapter {

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new MallMapFragment();
            return new MallListFragment();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) return "地图";
            return "列表";
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @OnClick(R.id.btn_bottom)
    void bottomClick() {
        Intent intent = new Intent(this, InstructionActivity.class);
        intent.setType("4");
        startActivity(intent);
    }
}
