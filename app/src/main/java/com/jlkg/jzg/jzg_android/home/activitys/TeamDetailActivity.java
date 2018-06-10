package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
import com.jlkg.jzg.jzg_android.home.fragments.TeamInfoFragment;
import com.jlkg.jzg.jzg_android.home.fragments.TeamPersonsFragment;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import butterknife.BindView;

/**
 * 班组详情
 */
public class TeamDetailActivity extends BaseActivity {

    @BindView(R.id.iv_heard)
    ImageView mIvHeard;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_score)
    TextView mTvScore;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private int mId;
    private TeamInfoFragment teamInfoFragment = new TeamInfoFragment();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_team_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null)
            mId = getIntent().getExtras().getInt("id");
        mViewPager.setAdapter(new MyFragmentPagerAdater(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.getTeamDetailByTeamId(mId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                TeamInfoListBean.ContentBean bean = JSON.parseObject(response, TeamInfoListBean.ContentBean.class);

                String photo = "";
                if (bean.getPhoto() != null)
                    photo = bean.getPhoto().getUrl();
                GlideUtils.LoadImgCircleCrop(mContext,photo,mIvHeard);
                TextUtils.setText(mTvName, bean.getTitle());
                TextUtils.setText(mTvScore, bean.getStarsLevel() + "");
                teamInfoFragment.setData(bean);
                Bundle bundle = new Bundle();
                bundle.putInt("id", mId);
                teamInfoFragment.setArguments(bundle);
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                setLoading(false);
            }
        });
    }

    class MyFragmentPagerAdater extends FragmentPagerAdapter {

        public MyFragmentPagerAdater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return teamInfoFragment;
            TeamPersonsFragment fragment = new TeamPersonsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", mId);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) return "班组信息";
            else return "班组成员";
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
