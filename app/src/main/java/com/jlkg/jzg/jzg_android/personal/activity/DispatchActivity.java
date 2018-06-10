package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.adapters.MyPagerAdapter;
import com.jlkg.jzg.jzg_android.personal.fragment.EmptyFragment;
import com.jlkg.jzg.jzg_android.personal.fragment.PayoffFragment;
import com.jlkg.jzg.jzg_android.personal.fragment.PersonnelMachineryFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DispatchActivity extends BaseActivity {


    @BindView(R.id.st_work_orders)
    SlidingTabLayout stWorkOrders;
    @BindView(R.id.pager_content)
    ViewPager pagerContent;
    private String[] titles = {"人员", "机械", "可视安全", "发工资"};
    private List<Fragment> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_dispatch;
    }


    @Override
    protected void initData() {
        super.initData();
        arrayList.add(PersonnelMachineryFragment.getInstance(0));//人员
        arrayList.add(PersonnelMachineryFragment.getInstance(1));//机械
        arrayList.add(new EmptyFragment());
        arrayList.add(new PayoffFragment());
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(), arrayList, titles);
        pagerContent.setAdapter(mAdapter);
        stWorkOrders.setViewPager(pagerContent);
    }
}
