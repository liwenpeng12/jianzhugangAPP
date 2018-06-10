package com.jlkg.jzg.jzg_android.home.activitys;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.beans.CompanyTypeListBean;
import com.jlkg.jzg.jzg_android.home.fragments.CompanyListFragment;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 公司列表页
 */
public class CompanyListActivity extends BaseActivity {

    @BindView(R.id.ib_back)
    ImageButton mIbBack;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    //    private String[] mCompanyTypes;
    private Fragment[] mFragments;
    private List<CompanyTypeListBean> listBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_list;
    }

    @Override
    protected void initViews() {
        super.initViews();
        CompanyTypeListBean bean = new CompanyTypeListBean();
        bean.setTitle("全部");
        bean.setId("");
        listBeans.add(bean);
        mBtnBottom.setVisibility(MyApplication.isCompany && MyApplication.sCompanyLoginBean == null ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        ApiManager.getCompanyType(this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<CompanyTypeListBean> list = JSON.parseArray(response, CompanyTypeListBean.class);
                listBeans.addAll(list);
                mFragments = new Fragment[listBeans.size()];
                mViewPager.setOffscreenPageLimit(Integer.MAX_VALUE);
                mViewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager()));
                mTabLayout.setupWithViewPager(mViewPager);
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                setLoading(false);
                mFragments = new Fragment[listBeans.size() + 1];
                mViewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager()));
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });
    }

    @OnClick(R.id.tv_search)
    void search() {
        openActivity(CompanySearchActivity.class);
    }

    @OnClick(R.id.btn_bottom)
    void bottomClick() {
        /*if (MyApplication.isCompany) {
            if (MyApplication.sCompanyLoginBean == null)
                DialogUtils.showNoLoginDialog(mContext);
            else if (MyApplication.sCompanyLoginBean.getCompanyType() == null)
                DialogUtils.showInvitedDia(mContext, true);
        } else {
            if (MyApplication.sTeamLoginBean == null)
                DialogUtils.showNoLoginDialog(mContext);
            else if (MyApplication.sTeamLoginBean.getTeamType() == null)
                DialogUtils.showInvitedDia(mContext, true);
        }*/
        openActivity(LoginActivity.class);
    }


    class MyFragmentPageAdapter extends FragmentPagerAdapter {

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (mFragments[position] == null) {
                CompanyListFragment fragment = new CompanyListFragment();
                fragment.setTypeKey(listBeans.get(position).getId());
                mFragments[position] = fragment;
            }
            return mFragments[position];
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return listBeans.get(position).getTitle();
        }

        @Override
        public int getCount() {
            return listBeans.size();
        }
    }

    @OnClick(R.id.ib_back)
    void back() {
        onBackPressed();
    }
}
