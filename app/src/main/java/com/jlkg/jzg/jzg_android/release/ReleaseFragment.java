package com.jlkg.jzg.jzg_android.release;


import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;

import butterknife.BindView;

/**
 * 发布
 */
public class ReleaseFragment extends BaseFragment {


    @BindView(R.id.tv_fabu_zhaogong)
    TextView mTvFabuZhaogong;
    @BindView(R.id.tv_fabu_zhaozhu)
    TextView mTvFabuZhaozhu;
    @BindView(R.id.iv_button)
    ImageView mIvButton;

    public ReleaseFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_release;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (getView() == null) return;
        if (hidden) {
            mIvButton.setImageResource(R.mipmap.tab_icon_fabu);
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fabu_ratate_close);
            mIvButton.setAnimation(animation);
        } else {
            mIvButton.setImageResource(R.mipmap.tab_icon_fabu);
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fabu_ratate_close);
            mIvButton.setAnimation(animation);
        }
        super.onHiddenChanged(hidden);
    }
}
