package com.jlkg.jzg.jzg_android.home.activitys;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.baselibrary.utils.SizeUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.adapters.MallHomeAdapter;
import com.jlkg.jzg.jzg_android.home.beans.CommonGoodsBean;
import com.jlkg.jzg.jzg_android.home.beans.MainGoodsBean;
import com.jlkg.jzg.jzg_android.home.beans.MallDetailBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView.OnSelectResultListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 门店主页
 */
public class MallHomeActivity extends BaseActivity implements OnSelectResultListener, OnItemClickListener {

    @BindView(R.id.iv_heard)
    ImageView mIvHeard;
    @BindView(R.id.tv_mall_name)
    TextView mTvMallName;
    @BindView(R.id.tv_score)
    TextView mTvScore;
    @BindView(R.id.tv_person_name)
    TextView mTvPersonName;
    @BindView(R.id.tv_call_number)
    TextView mTvCallNumber;
    @BindView(R.id.tv_business_content)
    TextView mTvBusinessContent;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.recycle_view_grid)
    RecyclerView mRecycleViewGrid;
    @BindView(R.id.tv_select_type)
    TextView mTvSelectType;
    @BindView(R.id.lin_select_catalog)
    LinearLayout mLinSelectCatalog;
    @BindView(R.id.recycle_view_lin)
    RecyclerView mRecycleViewLin;
    @BindView(R.id.nsv_View)
    NestedScrollView mNsvView;
    @BindView(R.id.tv_select_type_top)
    TextView mTvSelectTypeTop;
    @BindView(R.id.lin_select_catalog_top)
    LinearLayout mLinSelectCatalogTop;
    @BindView(R.id.fl_scroll)
    FrameLayout mFlScroll;
    @BindView(R.id.lines)
    View mLines;
    @BindView(R.id.select_type_view)
    SelectTypeView mSelectTypeView;

    int catalogHeight;
    private String mId;
    private List<CommonGoodsBean.DataBean> mList = new ArrayList<>();
    private int page = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mall_home;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mId = getIntent().getExtras().getString("id");
        }
        mSelectTypeView.setType(3, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        mTvAddress.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mRecycleViewLin.setLayoutManager(layoutManager);
        mRecycleViewLin.setHasFixedSize(true);
        mRecycleViewLin.setNestedScrollingEnabled(false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        gridLayoutManager.setAutoMeasureEnabled(true);
        mRecycleViewGrid.setLayoutManager(gridLayoutManager);
        mRecycleViewGrid.setHasFixedSize(true);
        mRecycleViewGrid.setNestedScrollingEnabled(false);
        mNsvView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (catalogHeight != 0 && scrollY >= catalogHeight && mLinSelectCatalogTop.getVisibility() == View.GONE) {
                    mLinSelectCatalogTop.setVisibility(View.VISIBLE);
                } else if (catalogHeight != 0 && scrollY < catalogHeight && mLinSelectCatalogTop.getVisibility() == View.VISIBLE) {
                    mLinSelectCatalogTop.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        ApiManager.storeDetails(mId, this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                MallDetailBean bean = JSON.parseObject(response, MallDetailBean.class);
                if (bean.getData() == null) {
                    onError(bean.getMessage());
                    return;
                }
                MallDetailBean.DataBean dataBean = bean.getData();
                TextUtils.setText(mTvMallName, dataBean.getStore_name());
//                GlideApp.with(mContext).load(dataBean.getStore_url()).into(mIvHeard);
                TextUtils.setText(mTvAddress, dataBean.getStore_address());
                TextUtils.setText(mTvBusinessContent, "经营范围：" + dataBean.getStore_class_names());
                TextUtils.setText(mTvCallNumber, dataBean.getContacts_phone());
                TextUtils.setText(mTvPersonName, dataBean.getContacts_name());
//            TextUtils.setText(mTvScore,dataBean.get);
            }

            @Override
            public void onError(String msg) {

            }
        });
        ApiManager.getMainGoods(mId + "",this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                final MainGoodsBean bean = JSON.parseObject(response, MainGoodsBean.class);
                mRecycleViewGrid.setAdapter(new MallHomeAdapter(mContext, bean.getData(), null, 1, new OnItemClickListener() {
                    @Override
                    public void itemClickListener(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", bean.getData().get(position).getGoods_id());
                        bundle.putString("url", bean.getData().get(position).getGoods_url());
                        bundle.putString("img", bean.getData().get(position).getGoods_image());
                        bundle.putString("name", bean.getData().get(position).getGoods_name());
                        bundle.putString("price", bean.getData().get(position).getGoods_price());
                        bundle.putString("phone", mTvCallNumber.getText().toString().trim());
                        openActivity(MallProductDetailActivity.class, bundle);
                    }
                }));
                onWindowFocusChanged(true);
            }

            @Override
            public void onError(String msg) {

            }
        });
        ApiManager.getCommonGoods(mId + "", 1,this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                final CommonGoodsBean bean = JSON.parseObject(response, CommonGoodsBean.class);
                mRecycleViewLin.setAdapter(new MallHomeAdapter(MallHomeActivity.this, new ArrayList<MainGoodsBean.DataBean>(),
                        bean.getData().getGoods_list(), 2, new OnItemClickListener() {
                    @Override
                    public void itemClickListener(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", bean.getData().getGoods_list().get(position).getGoods_id());
                        bundle.putString("phone", mTvCallNumber.getText().toString().trim());
                        bundle.putString("img", null);
                        bundle.putString("name", bean.getData().getGoods_list().get(position).getGoods_name());
                        bundle.putString("price", bean.getData().getGoods_list().get(position).getGoods_price());
                        openActivity(MallProductDetailActivity.class, bundle);
                    }
                }));
                onWindowFocusChanged(true);
            }

            @Override
            public void onError(String msg) {

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus) return;
        /*if (mLines != null && mSelectTypeView.getWindow() == null) {
            int height = mLines.getTop() + SizeUtils.dp2px(1);
            mLinSelectCatalog.setMinimumHeight(height);
            catalogHeight = mLinSelectCatalog.getTop();
            mNsvView.scrollTo(0, 0);
        }*/
    }

    @OnClick(R.id.tv_select_type)
    void seletType() {
        mNsvView.scrollTo(0, catalogHeight);
    }

    @OnClick(R.id.select_type_view)
    void seletTypeTop() {

    }

    @Override
    public void onSelectResultListener(int type, String str) {
        mTvSelectType.setText(mSelectTypeView.getFistTextString());
    }

    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", mTvCallNumber.getText().toString().trim());
        openActivity(MallProductDetailActivity.class, bundle);
    }

    @OnClick(R.id.tv_call_number)
    void callPhone() {
        if (!android.text.TextUtils.isEmpty(mTvCallNumber.getText().toString().trim()))
            DialogUtils.showCallPhoneDialog(this, mTvCallNumber.getText().toString().trim(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall(MallHomeActivity.this, mTvCallNumber.getText().toString().trim());
                }
            });
    }
}
