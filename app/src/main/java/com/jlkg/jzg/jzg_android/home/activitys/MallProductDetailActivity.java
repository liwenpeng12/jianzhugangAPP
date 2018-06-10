package com.jlkg.jzg.jzg_android.home.activitys;

import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.baselibrary.utils.ScreenUrils;
import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.OnClick;

public class MallProductDetailActivity extends BaseActivity {

    @BindView(R.id.fl_server)
    FrameLayout mFlServer;
    @BindView(R.id.fl_buy)
    FrameLayout mFlBuy;
    @BindView(R.id.lin_bottom)
    LinearLayout mLinBottom;
    @BindView(R.id.line_bottom)
    View mLineBottom;
    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.tv_danwei)
    TextView mTvDanwei;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_old_price)
    TextView mTvOldPrice;
    @BindView(R.id.tv_min_num)
    TextView mTvMinNum;
    @BindView(R.id.tv_size)
    TextView mTvSize;
    @BindView(R.id.tv_brand)
    TextView mTvBrand;
    @BindView(R.id.tv_remark)
    TextView mTvRemark;
    RxPermissions rxPermissions;
    private String mPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mall_product_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null)
            mPhone = getIntent().getExtras().getString("phone");
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mIvImg.getLayoutParams();
        params.height = ScreenUrils.getScreenWidth(this);
        mIvImg.setLayoutParams(params);
        mTvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        rxPermissions = new RxPermissions(this); // where this is an Activity instance
        GlideApp.with(this).load(getIntent().getExtras().getString("img")).error(R.mipmap.logo).into(mIvImg);
        TextUtils.setText(mTvContent, getIntent().getExtras().getString("name"));
        TextUtils.setText(mTvPrice, "￥" + getIntent().getExtras().getString("price"));
//        if (getIntent() != null && getIntent().getExtras() != null)
//            webView.loadUrl(getIntent().getExtras().getString("url"));
    }

    @OnClick(R.id.fl_server)
    void callServer() {
        DialogUtils.showCallPhoneDialog(this, mPhone, "拨打", new DialogUtils.onCommitListener() {
            @Override
            public void onCommit() {
                OutAppIntentUtils.openCall(MallProductDetailActivity.this, mPhone);
            }
        });
    }

    @OnClick(R.id.fl_buy)
    void buy() {
        showToast("请前往" + /*getIntent().getExtras().getString("url")*/"mall.jianzhugang.com" + "进行购买");
    }

}
