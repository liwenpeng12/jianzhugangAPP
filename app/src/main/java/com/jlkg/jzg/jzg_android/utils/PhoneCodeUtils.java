package com.jlkg.jzg.jzg_android.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor zcs
 * @time 2017/9/26
 * @describe 手机验证码工具类
 */

public class PhoneCodeUtils {
    private TextView[] tvs = new TextView[6];
    private static PhoneCodeUtils sUtils;
    private TextView[] ets = new TextView[6];
    private boolean[] flags = new boolean[6];

    protected ProgressDialog waitDialog;

    private PhoneCodeUtils() {

    }

    public static PhoneCodeUtils getInstance() {
        if (sUtils == null) {
            sUtils = new PhoneCodeUtils();
        }
        return sUtils;
    }

    public void setText(int position, TextView tv, EditText et) {
        tvs[position] = tv;
        ets[position] = et;
        flags[position] = false;
    }

    public void setLoading(boolean isLoading, Context context) {
        try {
            if (isLoading) {
                if (waitDialog == null || !waitDialog.isShowing()) {
                    waitDialog = new ProgressDialog(context, R.style.MyDialogStyleBottom);
                    waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    waitDialog.setCanceledOnTouchOutside(false);
                    ImageView view = new ImageView(context);
                    view.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    Animation loadAnimation = AnimationUtils.loadAnimation(
                            context, R.anim.rotate);
                    view.startAnimation(loadAnimation);
                    loadAnimation.start();
                    view.setImageResource(R.mipmap.loading);
                    waitDialog.show();
                    waitDialog.setContentView(view);
                }
            } else {
                if (waitDialog != null && waitDialog.isShowing()) {
                    waitDialog.dismiss();
                    waitDialog = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void requestCode(final int position, final Activity activity) {
        flags[position] = true;
        if (activity == null) {
            setDownTime(60, position);
            return;
        }
        setLoading(true, activity);
        ApiManager.sendVerifyCode(ets[position].getText().toString().trim(),activity, new HttpUtils.OnCallBack<Object>() {

            @Override
            public void success(String o) {
                setLoading(false, activity);
                ToastUtils.showShort("发送成功");
                flags[position] = true;
                setDownTime(60, position);
            }

            @Override
            public void onError(String msg) {
                setLoading(false, activity);
                ToastUtils.showShort(msg);
            }
        });
    }
    public void requestCodeForRegist(final int position, final Activity activity) {
        flags[position] = true;
        if (activity == null) {
            setDownTime(60, position);
            return;
        }
        setLoading(true, activity);
        ApiManager.sendVerifyCodeAndCheckUserName(ets[position].getText().toString().trim(), activity,new HttpUtils.OnCallBack<Object>() {

            @Override
            public void success(String o) {
                setLoading(false, activity);
                ToastUtils.showShort("发送成功");
                flags[position] = true;
                setDownTime(60, position);
            }

            @Override
            public void onError(String msg) {
                setLoading(false, activity);
                ToastUtils.showShort(msg);
            }
        });
    }

    public void requestCodeForRest(final int position, final Activity activity) {
        flags[position] = true;
        if (activity == null) {
            setDownTime(60, position);
            return;
        }
        setLoading(true, activity);
        ApiManager.sendVerifyCodeForRest(ets[position].getText().toString().trim(),activity, new HttpUtils.OnCallBack<Object>() {

            @Override
            public void success(String o) {
                setLoading(false, activity);
                ToastUtils.showShort("发送成功");
                flags[position] = true;
                setDownTime(60, position);
            }

            @Override
            public void onError(String msg) {
                setLoading(false, activity);
                ToastUtils.showShort(msg);
            }
        });
    }

    /**
     * 请求验证码
     */
    public void requestCode(int position) {
        requestCode(position, null);
    }

    /**
     * 倒计时
     *
     * @param time
     */
    private void setDownTime(int time, final int position) {
        if (!flags[position]) return;
        time = time - 1;
        final int time1 = time;
        tvs[position].setEnabled(false);
        tvs[position].postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!flags[position]) return;
                if (time1 != 0) {
                    setDownTime(time1, position);
                    tvs[position].setText("重新获取" + time1 + "s");
                } else {
                    tvs[position].setText("重新获取");
                }
                tvs[position].setEnabled(time1 == 0 && ets[position].getText().toString().length() == 11);
            }
        }, 1000);
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String regex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        Pattern p = Pattern.compile(regex);

        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num)/* || m.matches()*/;
        }
    }

    /**
     * 判断字符是否是邮箱
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        String regex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if (TextUtils.isEmpty(str))
            return false;
        else {
            return m.matches();
        }
    }

    public static boolean isPhoneOrEmail(String str) {
        return isMobile(str) || isEmail(str);
    }
}
