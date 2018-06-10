package com.jlkg.jzg.jzg_android.other.widget;

import android.widget.GridView;

/**
 * Created by Administrator on 2016/9/29.
 */
public class GridViewForScrollView extends GridView {
    public GridViewForScrollView(android.content.Context context,
                                 android.util.AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
