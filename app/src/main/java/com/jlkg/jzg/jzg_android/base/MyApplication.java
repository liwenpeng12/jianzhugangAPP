package com.jlkg.jzg.jzg_android.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

import com.jlkg.jzg.baselibrary.utils.Utils;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.bean.TeamLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ShareUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/**
 * @autor zcs
 * @time 2017/11/22
 * @describe
 */

public class MyApplication extends Application {

    private static Context sContext;
    public static String token;
    public static CompanyLoginBean sCompanyLoginBean;
    public static TeamLoginBean sTeamLoginBean;
    /**
     * 是否已选择过角色，
     */
    public static boolean hasSelectRole;

    /**
     * 角色类型，全局使用，在选中角色时修改 true:公司角色；false:班组角色
     */
    public static boolean isCompany;

    /**
     * 获取用户登录状态及认证状态
     *
     * @return 1:未登录
     */
    public static int getAccountStatus() {
        if (isCompany) {
            if (sCompanyLoginBean == null) return 1;
        } else {
            if (sTeamLoginBean == null) return 1;
        }
        return 0;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Utils.init(this);
        initOkgo();
        ShareUtils.getInstance().init(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

//        getSignature(this);
    }

    public void getSignature(Context con) {
        Log.e("Tag", "start");
        try {
            String pkgname = con.getPackageName();
            PackageManager manager = getPackageManager();
            /** 通过包管理器获得指定包名包含签名的包信息 **/
            PackageInfo packageInfo = manager.getPackageInfo(pkgname, PackageManager.GET_SIGNATURES);
            /******* 通过返回的包信息获得签名数组 *******/
            Signature[] signatures = packageInfo.signatures;
            /************** 得到应用签名 **************/
            String signature = signatures[0].toCharsString();

            /************** 请将signature的值即应用签名 反馈给我 谢谢 **************/
            int size = signature.length() / 1024 + (signature.length() % 1024 > 0 ? 1 : 0);
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    Log.i("tag", signature.substring(i * 1024, signature.length()));
                } else {
                    Log.i("tag", signature.substring(i * 1024, (i + 1) * 1024));
                }
            }
            Log.i("tag", "-------------");
        } catch (Exception e) {
            Log.i("tag", "error");
            e.printStackTrace();
        }
    }

    public static Context getContext() {
        return sContext;
    }

    static {//static 代码段可以防止内存泄露

        ClassicsHeader.REFRESH_HEADER_PULLDOWN = "下拉可以刷新";
        ClassicsHeader.REFRESH_HEADER_REFRESHING = "正在刷新...";
        ClassicsHeader.REFRESH_HEADER_LOADING = "正在加载...";
        ClassicsHeader.REFRESH_HEADER_RELEASE = "释放立即刷新";
        ClassicsHeader.REFRESH_HEADER_FINISH = "刷新完成";
        ClassicsHeader.REFRESH_HEADER_FAILED = "刷新失败";
        ClassicsHeader.REFRESH_HEADER_LASTTIME = "上次更新 M-d HH:mm";

        ClassicsFooter.REFRESH_FOOTER_PULLUP = "上拉加载更多";
        ClassicsFooter.REFRESH_FOOTER_RELEASE = "释放立即加载";
        ClassicsFooter.REFRESH_FOOTER_REFRESHING = "正在刷新...";
        ClassicsFooter.REFRESH_FOOTER_LOADING = "正在加载...";
        ClassicsFooter.REFRESH_FOOTER_FINISH = "加载完成";
        ClassicsFooter.REFRESH_FOOTER_FAILED = "加载失败";
        ClassicsFooter.REFRESH_FOOTER_ALLLOADED = "全部加载完成";


        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(android.R.color.darker_gray, R.color.c_444444);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
//                layout.setPrimaryColorsId(R.color.c_f6f6f6, R.color.c_444444);//全局设置主题颜色
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }

    private void initOkgo() {
        OkGo.getInstance().init(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));
        builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("okhttp");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        //全局的读取超时时间
        builder.readTimeout(30000, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(30000, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

        HttpHeaders headers = new HttpHeaders();
        headers.put("ob-token", MyApplication.token);    //header不支持中文，不允许有特殊字符

        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())
                //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                //添加请求头
                .addCommonHeaders(headers)
                //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .setRetryCount(3);
    }
}
