package com.jlkg.jzg.jzg_android.utils;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.jlkg.jzg.baselibrary.utils.HttpErrorBean;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;
import com.lzy.okgo.request.base.Request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor zcs
 * @time 2017/8/10
 * @describe 网络请求工具类, okGo
 */

public class HttpUtils<T> {
    private static HttpUtils sUtils;

    private HttpUtils() {

    }

    public static HttpUtils getInstance() {
        if (sUtils == null)
            sUtils = new HttpUtils();
        return sUtils;
    }

    public void get(String url, Map<String, String> map, Class<T> clazz, OnCallBack<T> callBack) {
        OkGo.<String>get(url)
                .cacheKey(url)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params(map)
                .tag(url)
                .execute(new StringCallBack(callBack, url));
    }

    public void post(String url, Map<String, Object> map, OnCallBack<T> callBack) {
        System.out.println("=========url=" + url);
        PostRequest request = OkGo.<String>post(url)
//                .isMultipart(true)
                .headers("ob-token", MyApplication.token)
                .cacheKey(url);
        if (map != null && map.size() > 0) {
            for (String o : map.keySet()) {
                if (map.get(o) instanceof File) {
                    request.params(o, (File) map.get(o));
                } else {
                    request.params(o, (String) map.get(o));
                }
            }
        }
        request.cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .tag(url)
                .execute(new StringCallBack(callBack, url));
    }




    public void post(String url, Map<String, Object> map, Object tag, OnCallBack<T> callBack) {
        System.out.println("=========url=" + url);
        PostRequest request = OkGo.<String>post(url).tag(tag)
//                .isMultipart(true)
                .headers("ob-token", MyApplication.token)
                .cacheKey(url);
        if (map != null && map.size() > 0) {
            for (String o : map.keySet()) {
                if (map.get(o) instanceof File) {
                    request.params(o, (File) map.get(o));
                } else {
                    request.params(o, (String) map.get(o));
                }
            }
        }
        request.cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .tag(url)
                .execute(new StringCallBack(callBack, url));
    }

    public void postParm(String url, HashMap<String, String> params, Map<String, Object> map, Object tag, OnCallBack<T> callBack) {
        String param = url;
        if (params != null && params.size() > 0) {
            for (String msg : params.keySet()) {
                param += msg + "=" + params.get(msg) + "&";
            }
            param = param.substring(0, param.length() - 1);
        }
        System.out.println("===========url=" + param);
        PostRequest request = OkGo.<String>post(param).tag(tag)
//                .isMultipart(true)
                .headers("ob-token", MyApplication.token)
                .cacheKey(url);
        if (map != null && map.size() > 0) {
            for (String o : map.keySet()) {
                if (map.get(o) instanceof File) {
                    request.params(o, (File) map.get(o));
                } else {
                    request.params(o, (String) map.get(o));
                }
            }
        }
        request.cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .tag(url)
                .execute(new StringCallBack(callBack, url));
    }

    public void postWithToken(String url, Map<String, Object> map, OnCallBack<T> callBack) {
        PostRequest request = OkGo.<String>post(url)
//                .isMultipart(true)
                .cacheKey(url);
        if (map != null && map.size() > 0) {
            for (String o : map.keySet()) {
                if (map.get(o) instanceof File) {
                    request.params(o, (File) map.get(o));
                } else {
                    request.params(o, (String) map.get(o));
                }
            }
        }
        request.cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .tag(url)
                .execute(new StringCallBack(callBack, url));
    }

    public void upLoad(String url, Map<String, File> map, OnCallBack<T> callBack) {
        Log.e("okhttp", "upload:-->" + url + map);
        PostRequest request = OkGo.<String>post(url)
                .isMultipart(true)
                .tag(url)
                .cacheKey(url);
        for (String str : map.keySet()) {
            request.params(str, map.get(str));
        }
        request.execute(new StringCallBack(callBack, url));
    }

    private class StringCallBack extends StringCallback {
        private Class<T> mClass;
        private OnCallBack<T> mCallBack;
        private String url;

        public StringCallBack(OnCallBack<T> callBack, String url) {
            mCallBack = callBack;
            this.url = url;
        }

        @Override
        public void onStart(Request<String, ? extends Request> request) {
            super.onStart(request);
        }

        @Override
        public void onSuccess(Response<String> response) {
//            List<T> list = JSON.parseArray(response.body(), mClass);
            String obToken = response.getRawResponse().header("ob-token");
            if (!TextUtils.isEmpty(obToken)) {
                MyApplication.token = obToken;
            }
            try {
                HttpErrorBean bean = JSON.parseObject(response.body(), HttpErrorBean.class);
                if (bean == null || bean.getStatus() == 0 || bean.getStatus() == 200||bean.getStatus() == 1)
                    mCallBack.success(response.body());
                else
                    mCallBack.onError(bean.getMessage());
            } catch (JSONException e) {
                mCallBack.success(response.body());
            }catch (Exception e) {
                mCallBack.success(response.body());
            }
        }

        @Override
        public void onError(com.lzy.okgo.model.Response<String> response) {
            super.onError(response);
            //   Log.e("Tag", response.body());
            try {
                HttpErrorBean bean = JSON.parseObject(response.body(), HttpErrorBean.class);
                if (bean == null)
                    mCallBack.onError("请检查网络状态");
                else
                    mCallBack.onError(bean.getMessage());
            } catch (JSONException e) {
                mCallBack.onError("请检查网络状态");
            } catch (Exception e) {

            }
        }

        @Override
        public void onFinish() {
            super.onFinish();
        }
    }

    public interface OnCallBack<T> {
        void success(String response);

        void onError(String msg);
    }
}
