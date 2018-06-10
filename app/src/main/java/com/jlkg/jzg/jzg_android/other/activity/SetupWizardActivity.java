package com.jlkg.jzg.jzg_android.other.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.baselibrary.utils.SizeUtils;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.adapters.MyPagerAdapter;
import com.jlkg.jzg.jzg_android.other.fragments.ImageFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SetupWizardActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.ll_point_group)
    LinearLayout llPointGroup;
    @BindView(R.id.view_red_point)
    View viewRedPoint;
    @BindView(R.id.tv_bottom)
    TextView mTvBottom;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private int mPointWidth;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_setup_wizard;
    }


    @Override
    protected void initData() {
        arrayList.add(ImageFragment.getInstance(0));
        arrayList.add(ImageFragment.getInstance(1));
//        arrayList.add(ImageFragment.getInstance(2));

        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(), arrayList);
        viewPager.setAdapter(mAdapter);

        // 初始化引导页的小圆点
        for (int i = 0; i < 2; i++) {
            View point = new View(this);
            point.setBackgroundResource(R.mipmap.shape_point_gray);// 设置引导页默认圆点

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    SizeUtils.dp2px(10),
                    SizeUtils.dp2px(10));
            if (i > 0) {
                params.leftMargin = SizeUtils.dp2px(8);// 设置圆点间隔
            }

            point.setLayoutParams(params);// 设置圆点的大小

            llPointGroup.addView(point);// 将圆点添加给线性布局
        }
        // 获取视图树, 对layout结束事件进行监听
        llPointGroup.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    // 当layout执行结束后回调此方法
                    @Override
                    public void onGlobalLayout() {
                        System.out.println("layout 结束");
                        llPointGroup.getViewTreeObserver()
                                .removeGlobalOnLayoutListener(this);
                        try {
                            mPointWidth = llPointGroup.getChildAt(1).getLeft()
                                    - llPointGroup.getChildAt(0).getLeft();
                            System.out.println("圆点距离:" + mPointWidth);
                        } catch (Exception e) {
                            mPointWidth = SizeUtils.dp2px(8);
                        }
                    }
                });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int len = (int) (mPointWidth * positionOffset) + position
                        * mPointWidth;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewRedPoint
                        .getLayoutParams();// 获取当前红点的布局参数
                params.leftMargin = len;// 设置左边距
                viewRedPoint.setLayoutParams(params);// 重新给小红点设置布局参数
            }

            @Override
            public void onPageSelected(int position) {
                mTvBottom.setVisibility(position == arrayList.size() - 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.tv_bottom)
    void bottomClick() {
        PrefUtils.setBoolean(this, "is_user_guide_showed", true);
//        openActivity(SelectRoleActivity.class);
        openActivity(MainActivity.class);
        finish();
    }
}
