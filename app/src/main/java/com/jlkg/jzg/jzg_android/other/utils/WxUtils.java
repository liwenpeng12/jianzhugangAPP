package com.jlkg.jzg.jzg_android.other.utils;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.wxapi.WXEntryActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcs on 2018/4/19.
 *
 * @describe:微信工具类
 */

public class WxUtils {
    public static final String APP_ID = "wx7eac946ccea29535";
    public static final String APP_SECRET = "e77660718ed093fc0d788c650f5675a3";

    public static IWXAPI regToWx(Context context) {
        IWXAPI api = WXAPIFactory.createWXAPI(context, APP_ID, true);
        api.registerApp(APP_ID);
        return api;
    }

    /**
     * 调用微信登录
     */
    public static void wxLogin(IWXAPI api) {
        // send oauth request
        if (api.isWXAppInstalled()) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wx_login";
            api.sendReq(req);
        } else {
            ToastUtils.showShort("您没有安装微信。");
        }
    }

    public static void getAccessToken(Context context, String code,StringCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("appid", WxUtils.APP_ID);
        map.put("secret", WxUtils.APP_SECRET);
        map.put("code", code);
        map.put("grant_type", "authorization_code");
        OkGo.<String>post("https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code")
                .cacheKey("https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code")
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params(map)
                .tag(context)
                .execute(callback);
    }
}
