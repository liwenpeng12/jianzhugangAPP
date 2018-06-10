package com.jlkg.jzg.jzg_android.home.activitys;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.TeamTypeDetailBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import butterknife.BindView;

/**
 * 文案说明界面
 */
public class InstructionActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.web_view)
    WebView mWebView;
    private String mType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_instruction;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.getSettings().setBlockNetworkImage(false);
        mType = getIntent().getType();
        switch (mType) {
            case "1":
                mMyToolbar.setTitleText("操作规范");
                break;
            case "2":
                mMyToolbar.setTitleText("工艺规范");
                break;
            case "3":
                mMyToolbar.setTitleText("质量规范");
                break;
            case "4":
                mMyToolbar.setTitleText("申请入驻");
                return;
//                break;
        }
        getInfo();
    }

    private void getInfo() {
        setLoading(true);
        ApiManager.teamTypesDetail(getIntent().getStringExtra("id"), this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                TeamTypeDetailBean bean = JSON.parseObject(response, TeamTypeDetailBean.class);
                switch (mType) {
                    case "1":
                        if (!android.text.TextUtils.isEmpty(bean.getRegulation())) {
                            mWebView.loadDataWithBaseURL(null, bean.getRegulation(), "text/html", "UTF-8", null);
                        }
//                        TextUtils.setText(mTvContent, Html.fromHtml(bean.getRegulation()).toString());
                        break;
                    case "2":
                        if (!android.text.TextUtils.isEmpty(bean.getCrafts())) {
                            mWebView.loadDataWithBaseURL(null, bean.getCrafts(), "text/html", "UTF-8", null);
                        }
//                        TextUtils.setText(mTvContent, bean.getCrafts());
                        break;
                    case "3":
                        if (!android.text.TextUtils.isEmpty(bean.getQuality())) {
                            mWebView.loadDataWithBaseURL(null, bean.getQuality(), "text/html", "UTF-8", null);
                        }
//                        TextUtils.setText(mTvContent, bean.getQuality());
                        break;
                    case "4":
                        mMyToolbar.setTitleText("申请入驻");
                        break;
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }


}
