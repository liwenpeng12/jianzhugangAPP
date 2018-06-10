package com.jlkg.jzg.jzg_android.home.fragments;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.activitys.ClassActivity;
import com.jlkg.jzg.jzg_android.home.beans.JixieListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;
import com.jlkg.jzg.jzg_android.release.beans.TeamListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends BaseFragment {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private String[] pageTitles;
    private Fragment[] mFragments;
    private List<SelectTypeBean> mList = new ArrayList<>();

    public TeamFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_team;
    }

    @Override
    protected void initView() {
        super.initView();
        if (getArguments().getString("type").equals(ClassActivity.TEAMPAGE)) {
            setLoading(true);
            ApiManager.teamTypesGetList(getActivity(),new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    List<TeamListBean> teamListBeans = JSON.parseArray(response, TeamListBean.class);
                    int size = teamListBeans.size();
                    for (int i = 0; i < size; i++) {
                        List<TeamListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                        List<SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                        int childSize = titles.size();
                        for (int j = 0; j < childSize; j++) {
                            SelectTypeBean.SelectTypeChildBean bean = new SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                            list.add(bean);
                        }
                        mList.add(new SelectTypeBean(teamListBeans.get(i).getText(), list, teamListBeans.get(i).getId()));
                    }
                    if (mList.size() > 5) {
                        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                    }
                    mFragments = new Fragment[mList.size()];
                    mViewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
                    mTabLayout.setupWithViewPager(mViewPager);
                    setLoading(false);
                    mViewPager.setOffscreenPageLimit(mList.size());
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                }
            });
        } else {
            setLoading(true);
            ApiManager.getDictsCategory(getActivity(),new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    List<JixieListBean> teamListBeans = JSON.parseArray(response, JixieListBean.class);
                    int size = teamListBeans.size();
                    for (int i = 0; i < size; i++) {
                        List<JixieListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                        List<SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                        int childSize = titles.size();
                        for (int j = 0; j < childSize; j++) {
                            SelectTypeBean.SelectTypeChildBean bean = new SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                            list.add(bean);
                        }
                        mList.add(new SelectTypeBean(teamListBeans.get(i).getCategroy(), list, teamListBeans.get(i).getId()));
                    }
                    if (mList.size() > 3) {
                        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                    }
                    mFragments = new Fragment[mList.size()];
                    mViewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
                    mTabLayout.setupWithViewPager(mViewPager);
                    setLoading(false);
                    mViewPager.setOffscreenPageLimit(mList.size());
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    setLoading(false);
                }
            });
            /*mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            mTabLayout.setPadding(0, 0, SizeUtils.dp2px(20), 0);
            pageTitles = getResources().getStringArray(R.array.jiXieTypes);
            mFragments = new Fragment[pageTitles.length];
            mViewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
            mTabLayout.setupWithViewPager(mViewPager);*/
        }

    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
    }

    class MyFragmentPageAdapter extends FragmentPagerAdapter {

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (mFragments[position] == null) {
                ListPageFragment fragment = new ListPageFragment();
                fragment.setArguments(getArguments());
//                if (getArguments().getString("type").equals(ClassActivity.TEAMPAGE)) {
                fragment.setList(mList.get(position).mChildBeans);
//                }
                mFragments[position] = fragment;
            }
            return mFragments[position];
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            if (getArguments().getString("type").equals(ClassActivity.TEAMPAGE)) {
            return mList.get(position).type;
//            }
//            return pageTitles[position];
        }

        @Override
        public int getCount() {
//            if (getArguments().getString("type").equals(ClassActivity.TEAMPAGE)) {
            return mList.size();
//            }
//            return pageTitles.length;
        }
    }
}
