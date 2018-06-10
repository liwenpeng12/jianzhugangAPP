package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.adapters.MyPagerAdapter;
import com.jlkg.jzg.jzg_android.personal.fragment.LetMachineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LetMachineActivity extends BaseActivity {

    @BindView(R.id.st_work_orders)
    SlidingTabLayout stWorkOrders;
    @BindView(R.id.pager_content)
    ViewPager pagerContent;
    private String[] titles = {"全部", "招租中", "已完成"};
    private List<Fragment> arrayList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_let_machine;
    }


    @Override
    protected void initViews() {
        super.initViews();
        arrayList.add(LetMachineFragment.getInstances(0));
        arrayList.add(LetMachineFragment.getInstances(1));
        arrayList.add(LetMachineFragment.getInstances(2));
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(), arrayList, titles);
        pagerContent.setAdapter(mAdapter);
        stWorkOrders.setViewPager(pagerContent);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
