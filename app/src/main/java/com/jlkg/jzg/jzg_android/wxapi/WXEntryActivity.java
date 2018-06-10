package com.jlkg.jzg.jzg_android.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.other.utils.WxUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    private IWXAPI api;
    private WXinfoBean mBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, WxUtils.APP_ID, false);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
// baseresp.getType 1:第三方授权， 2:分享
//        Toast.makeText(this, "baseresp.getType = " + baseResp.getType(), Toast.LENGTH_SHORT).show();
        Log.e("tag", JSON.toJSONString(baseResp));
        int result = 0;
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
//                result = R.string.errcode_success;//发送成功
                String code = ((SendAuth.Resp) baseResp).code;
                WxUtils.getAccessToken(this, code, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        mBean = JSON.parseObject(response.body(), WXEntryActivity.WXinfoBean.class);
                        EventBus.getDefault().post(mBean);
                        finish();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        ToastUtils.showShort("授权失败");
                        finish();
                    }
                });
                return;
            case BaseResp.ErrCode.ERR_USER_CANCEL://发送取消
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://发送被拒绝
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
//                result = R.string.errcode_unsupported;//不支持错误
                break;
            default:
//                result = R.string.errcode_unknown;//发送返回
                break;
        }
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        api.unregisterApp();
    }

    public static class WXinfoBean {

        /**
         * access_token : ACCESS_TOKEN
         * expires_in : 7200
         * refresh_token : REFRESH_TOKEN
         * openid : OPENID
         * scope : SCOPE
         * unionid : o6_bmasdasdsad6_2sgVt7hMZOPfL
         */

        private String access_token;
        private int expires_in;
        private String refresh_token;
        private String openid;
        private String scope;
        private String unionid;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }

}
