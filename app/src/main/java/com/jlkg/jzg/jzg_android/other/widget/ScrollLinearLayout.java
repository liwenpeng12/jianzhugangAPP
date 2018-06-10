package com.jlkg.jzg.jzg_android.other.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/5/21
 */

public class ScrollLinearLayout extends LinearLayout {
    public ScrollLinearLayout(Context context) {
        this(context,null);
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
