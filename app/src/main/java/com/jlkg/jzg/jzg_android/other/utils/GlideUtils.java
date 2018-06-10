package com.jlkg.jzg.jzg_android.other.utils;

import android.content.Context;
import android.widget.ImageView;

import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;

/**
 * Created by zcs on 2018/3/25.
 */

public class GlideUtils {
    public static void LoadImg(Context context, Object args, ImageView view) {
        GlideApp.with(context).load(args).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(view);
    }

    public static void LoadImgCircleCrop(Context context, Object args, ImageView view) {
        GlideApp.with(context).load(args).placeholder(R.mipmap.logo).error(R.mipmap.logo).circleCrop().into(view);
    }

    public static void LoadImgCenterCrop(Context context, Object args, ImageView view) {
        GlideApp.with(context).load(args).placeholder(R.mipmap.logo).error(R.mipmap.logo).centerCrop().into(view);
    }

    public static void LoadImgCenterInside(Context context, Object args, ImageView view) {
        GlideApp.with(context).load(args).placeholder(R.mipmap.logo).error(R.mipmap.logo).centerInside().into(view);
    }

    public static void LoadImgFitCenter(Context context, Object args, ImageView view) {
        GlideApp.with(context).load(args).placeholder(R.mipmap.logo).error(R.mipmap.logo).fitCenter().into(view);
    }
}
