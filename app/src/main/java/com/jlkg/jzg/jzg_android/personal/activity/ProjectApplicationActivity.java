package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.adapters.MyPagerAdapter;
import com.jlkg.jzg.jzg_android.personal.fragment.ProjectApplictionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectApplicationActivity extends BaseActivity {


    @BindView(R.id.st_work_orders)
    SlidingTabLayout stWorkOrders;
    @BindView(R.id.pager_content)
    ViewPager pagerContent;

    private String[] titles = {"待签约", "已签约", "待付款","已完成","已终止"};
    private List<Fragment> arrayList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_project_application;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        arrayList.add(ProjectApplictionFragment.getInstances(0));
        arrayList.add(ProjectApplictionFragment.getInstances(1));
        arrayList.add(ProjectApplictionFragment.getInstances(2));
        arrayList.add(ProjectApplictionFragment.getInstances(3));
        arrayList.add(ProjectApplictionFragment.getInstances(4));
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(), arrayList, titles);
        pagerContent.setAdapter(mAdapter);
        stWorkOrders.setViewPager(pagerContent);
    }


}
