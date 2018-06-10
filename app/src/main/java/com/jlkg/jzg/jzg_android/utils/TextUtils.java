package com.jlkg.jzg.jzg_android.utils;

import android.widget.TextView;

/**
 * Created by zcs on 2018/3/9.
 */

public class TextUtils {
    public static void setText(TextView view, String text) {
        if (android.text.TextUtils.isEmpty(text))
            view.setText("");
        else
            view.setText(text);
    }
}
