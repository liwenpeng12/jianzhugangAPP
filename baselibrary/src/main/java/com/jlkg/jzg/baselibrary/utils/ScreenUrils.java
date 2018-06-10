package com.jlkg.jzg.baselibrary.utils;

import android.content.Context;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/**
 * @autor zcs
 * @time 2017/9/7
 * @describe 屏幕相关工具类
 */

public class ScreenUrils {
    private ScreenUrils() {
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }
}
