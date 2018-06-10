package com.jlkg.jzg.jzg_android.other.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.MainActivity;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.bean.SplashBean;


public class SplashActivity extends BaseActivity {

    RelativeLayout rlRoot;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏状态栏,全屏显示
        // 第一种：
        /*getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 第二种：（两种方法效果一样）
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
//        OkHttpUtils.getInstance().get(Http.SELECTPAGE("1"), this, new OnBaseDataListener<String>() {
//
//            @Override
//            public void onNewData(String data) {
//                try {
//                    JSONObject jsonObject = new JSONObject(data);
//                    if (jsonObject.getInt("code") != 200) {
//                        showToask(jsonObject.getString("msg"));
//                        return;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                SplashBean splashBean = new Gson().fromJson(data, SplashBean.class);
//                startAnim(splashBean);
//            }
//
//            @Override
//            public void onError(String code) {
//                startAnim(null);
//            }
//        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        super.initViews();
        rlRoot = findViewById(R.id.rl_root);
        ivSplash = findViewById(R.id.splash_iv);
        startAnim(null);
    }

    /**
     * 开启动画
     */
    private void startAnim(SplashBean splashBean) {

        if (splashBean == null) {
            ivSplash.setImageResource(R.mipmap.splash_img);
        } else {
            if (splashBean.getData().size() > 0) {
                String path = splashBean.getData().get(0).getPicture();
                //  DebugUtils.prinlnLog(path);
                //   Glide.with(SplashActivity.this.getApplication()).load(path).into(ivSplash);
            }
        }

        // 动画集合
        AnimationSet set = new AnimationSet(false);

        // 渐变动画
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(2000);// 动画时间
        alpha.setFillAfter(true);// 保持动画状态
        set.addAnimation(alpha);

        // 设置动画监听
        set.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            // 动画执行结束
            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();
            }
        });

        rlRoot.startAnimation(set);
    }

    /**
     * 跳转下一个页面
     */
    private void jumpNextPage() {
        // 判断之前有没有显示过新手引导
        boolean userGuide = PrefUtils.getBoolean(this, "is_user_guide_showed", false);
        if (!userGuide) {
            // 跳转到新手引导页
            //SetupWizardActivity
            startActivity(new Intent(SplashActivity.this, SetupWizardActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            /*if (PrefUtils.getBoolean(mContext, "isLogin", false)) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, SelectRoleActivity.class));
            }*/
        }
        finish();
    }
}
