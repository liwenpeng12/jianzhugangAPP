package com.jlkg.jzg.jzg_android.weidget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.utils.PreFiled;
import com.jlkg.jzg.jzg_android.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @autor zcs
 * @time 2017/11/22
 * @describe
 */

public class MyToolbar extends FrameLayout {
    @BindView(R.id.ib_back)
    ImageButton mIbBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.ib_right)
    ImageButton mIbRight;
    @BindView(R.id.btn_right)
    Button mBtnRight;
    @BindView(R.id.fl_title)
    FrameLayout mFlTitle;
    @BindView(R.id.fl_padding)
    FrameLayout mFlPadding;
    private Context mContext;

    public MyToolbar(Context context) {
        this(context, null);
    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View v = LayoutInflater.from(context).inflate(R.layout.title_layout, this, false);
        addView(v);
        ButterKnife.bind(this, v);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyToolbar);
        int leftImg = ta.getResourceId(R.styleable.MyToolbar_leftImg, 0);
        setLeftDrawable(leftImg);
        int rightImg = ta.getResourceId(R.styleable.MyToolbar_rightImg, 0);
        setRightDrawable(rightImg);
        String title = ta.getString(R.styleable.MyToolbar_titleText);
        setTitleText(title);
        String rightText = ta.getString(R.styleable.MyToolbar_RightText);
        setRightText(rightText);
        int color = ta.getResourceId(R.styleable.MyToolbar_backColor, 0);
        setBackground(color);
        boolean fitsystem = ta.getBoolean(R.styleable.MyToolbar_fitsystem, false);
//        mFlPadding.setPadding(0, fitsystem ? 0 : 15, 0, 0);
    }

    public void setLeftDrawable(@DrawableRes int resId) {
        if (resId == 0) {
            mIbBack.setVisibility(INVISIBLE);
        } else {
            mIbBack.setVisibility(VISIBLE);
            mIbBack.setImageResource(resId);
        }
    }

    public void setRightDrawable(@DrawableRes int resId) {
        if (resId == 0) {
            mIbRight.setVisibility(INVISIBLE);
        } else {
            mIbRight.setVisibility(VISIBLE);
            mIbRight.setImageResource(resId);
        }
    }

    public void setRightVisible(boolean visible) {
        mIbRight.setVisibility(visible ? VISIBLE : INVISIBLE);
        mBtnRight.setVisibility(visible ? VISIBLE : INVISIBLE);
    }

    public void setTitleText(CharSequence c) {
        if (c != null) {
            mTvTitle.setText(c);
            mTvTitle.setSelected(true);
        }
    }

    public void setRightText(CharSequence c) {
        if (c != null) {
            //只有当是本人才能显示编辑
            Log.d("lwp","name:"+PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT,"")+"usernmae :"+SharedPreferencesUtils.getParam(mContext,"isusername",""));
          if (PrefUtils.getBoolean(mContext,"mPhoneNum",false)){
              mBtnRight.setText(c);
              mBtnRight.setVisibility(VISIBLE);
          }else {
              mBtnRight.setVisibility(GONE);
          }


        } else {
            mBtnRight.setVisibility(GONE);
        }
    }
    public Boolean Checkname(String name){
        return PrefUtils.getString(mContext, PreFiled.COMPANYACCOUNT,"").equals(name);

    }

    public void setBackground(@ColorRes int color) {
        if (color != 0) {
            mFlTitle.setBackgroundResource(color);
        }
    }

    @OnClick(R.id.ib_back)
    void back() {
        if (mContext instanceof Activity)
            ((Activity) mContext).onBackPressed();
    }

    public void setClickListener(OnClickListener listener) {
//        if (mIbRight.getVisibility() == VISIBLE) {
        mIbRight.setOnClickListener(listener);
//        } else if (mBtnRight.getVisibility() == VISIBLE) {
        mBtnRight.setOnClickListener(listener);
//        }
    }


}
