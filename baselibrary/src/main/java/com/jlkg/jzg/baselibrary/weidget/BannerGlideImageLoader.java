package com.jlkg.jzg.baselibrary.weidget;

import android.content.Context;
import android.widget.ImageView;

import com.jlkg.jzg.baselibrary.R;
import com.youth.banner.loader.ImageLoader;


/**
 * @autor zcs
 * @time 2017/11/24
 * @describe
 */

public class BannerGlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideApp.with(context).load(path).centerInside()./*error(R.drawable.img_load_or_failed).*//*placeholder(R.drawable.img_load_or_failed).*/into(imageView);
    }
}
