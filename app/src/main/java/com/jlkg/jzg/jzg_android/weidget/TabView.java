package com.jlkg.jzg.jzg_android.weidget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @autor zcs
 * @time 2017/9/7
 * @describe
 */

public class TabView extends FrameLayout {
    @BindView(R.id.iv_tab)
    ImageView mIvTab;
    @BindView(R.id.tv_tab)
    TextView mTvTab;

    public TabView(@NonNull Context context) {
        this(context, null);
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View v = LayoutInflater.from(context).inflate(R.layout.home_tab_layout, this, false);
        addView(v);
        ButterKnife.bind(this, v);
    }

    public void setView(int res, String str) {
        mIvTab.setImageResource(res);
        mTvTab.setText(str);
    }
}
