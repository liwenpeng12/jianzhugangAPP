package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.fragments.BeanTeamFragment;
import com.jlkg.jzg.jzg_android.home.fragments.JixieZhulinFragment;
import com.jlkg.jzg.jzg_android.home.fragments.NearJiXieFragment;
import com.jlkg.jzg.jzg_android.home.fragments.TeamFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class ClassActivity extends BaseActivity {
    @BindView(R.id.ib_back)
    ImageButton mIbBack;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.tv_center)
    TextView mTvCenter;
    public static final String TEAMPAGE = "teamPage";
    public static final String MECHANICAL = "mechanicalPage";
    public static final String ZHULIN = "zhulin";
    private String mType;
    private String[][] tabs = new String[][]{new String[]{"班组类型", "附近的班组"}, new String[]{"机械分类", "附近的机械"}};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() == null || getIntent().getExtras() == null) {
            toast("使用此界面必须传type类型");
            return;
        }
        mType = getIntent().getExtras().getString("type");

        PrefUtils.setBoolean(mContext,"mPhoneNum",false);

        if (mType.equals(TEAMPAGE)) {
            mTvLeft.setText("班组类型");
            mTvRight.setText("附近的班组");
            mTvCenter.setVisibility(View.GONE);
        }
        initFragment(true, false);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    private void initFragment(boolean left, boolean isCenter) {
        mTvLeft.setSelected(left && !isCenter);
        mTvRight.setSelected(!left && !isCenter);
        mTvCenter.setSelected(isCenter);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (left && !isCenter) {
            Fragment rightFrgment = getSupportFragmentManager().findFragmentByTag("right");
            if (rightFrgment != null) {
                transaction.hide(rightFrgment);
            }
            Fragment centerFragment = getSupportFragmentManager().findFragmentByTag("center");
            if (centerFragment != null)
                transaction.hide(centerFragment);
            Fragment leftFragment = getSupportFragmentManager().findFragmentByTag("left");
            if (leftFragment != null) {
                transaction.show(leftFragment);
            } else {
                leftFragment = new TeamFragment();
                Bundle build = new Bundle();
                build.putString("type", mType);
                leftFragment.setArguments(build);
                transaction.add(R.id.fl_content, leftFragment, "left");
            }
        } else if (isCenter) {
            Log.d("lwp","initFragment1");
            Fragment leftFrgment = getSupportFragmentManager().findFragmentByTag("left");
            if (leftFrgment != null) {
                Log.d("lwp","initFragment2");
                transaction.hide(leftFrgment);
            }
            Fragment rightFrgment = getSupportFragmentManager().findFragmentByTag("right");
            if (rightFrgment != null) {
                Log.d("lwp","initFragment3");
                transaction.hide(rightFrgment);
            }
            Fragment centerFragment = getSupportFragmentManager().findFragmentByTag("center");
            if (centerFragment != null){
                Log.d("lwp","initFragment4");
                transaction.show(centerFragment);}
            else {
                centerFragment = new NearJiXieFragment();
                Bundle build = new Bundle();
                Log.d("lwp","initFragment5");
                build.putString("type", mType);
                centerFragment.setArguments(build);
                transaction.add(R.id.fl_content, centerFragment, "center");
            }

        } else {
            Fragment leftFrgment = getSupportFragmentManager().findFragmentByTag("left");
            Fragment centerFragment = getSupportFragmentManager().findFragmentByTag("center");
            if (leftFrgment != null) {
                transaction.hide(leftFrgment);
            }
            if (centerFragment != null)
                transaction.hide(centerFragment);
            Fragment rightFragment = getSupportFragmentManager().findFragmentByTag("right");
            if (rightFragment != null) {
                transaction.show(rightFragment);
            } else {
                if (mType.equals(MECHANICAL)) {
                    rightFragment = new JixieZhulinFragment();
                } else {
                    rightFragment = new BeanTeamFragment();
                }
                Bundle build = new Bundle();
                build.putString("type", mType);
                rightFragment.setArguments(build);
                transaction.add(R.id.fl_content, rightFragment, "right");
            }
        }
        transaction.commitNowAllowingStateLoss();
    }

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.ib_back, R.id.tv_center})
    void click(View v) {
        switch (v.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.tv_left:
                initFragment(true, false);
                break;
            case R.id.tv_right:
                initFragment(false, false);
                break;
            case R.id.tv_center:
                initFragment(false, true);
                break;
        }
    }
}
