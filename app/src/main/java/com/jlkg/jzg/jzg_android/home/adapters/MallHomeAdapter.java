package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.baselibrary.utils.ScreenUrils;
import com.jlkg.jzg.baselibrary.utils.SizeUtils;
import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.CommonGoodsBean;
import com.jlkg.jzg.jzg_android.home.beans.MainGoodsBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/26.
 *
 * @describe:
 */

public class MallHomeAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<MainGoodsBean.DataBean> mList;
    private OnItemClickListener mListener;
    private int mType;//1:Grid布局 2：Lin布局
    private List<CommonGoodsBean.DataBean.GoodsListBean> mCommonList;

    public MallHomeAdapter(Context context, List<MainGoodsBean.DataBean> list, List<CommonGoodsBean.DataBean.GoodsListBean> commonList, int type, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
        mType = type;
        mCommonList = commonList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1)
            return new GridItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mall_grid_layout, parent, false));
        return new LinItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mall_home_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 1) {
            MainGoodsBean.DataBean bean = mList.get(position);
            GridItemViewHolder gridItemViewHolder = (GridItemViewHolder) holder;
            GlideApp.with(mContext).load(bean.getGoods_image()).into(gridItemViewHolder.mIvImg);
            TextUtils.setText(gridItemViewHolder.mTvProductName, bean.getGoods_name());
            TextUtils.setText(gridItemViewHolder.mTvPrice, "￥" + bean.getGoods_price());
            gridItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) mListener.itemClickListener(position);
                }
            });
        } else {
            CommonGoodsBean.DataBean.GoodsListBean bean = mCommonList.get(position);
            LinItemViewHolder linItemViewHolder = (LinItemViewHolder) holder;
            TextUtils.setText(linItemViewHolder.mTvName, bean.getGoods_name());
            TextUtils.setText(linItemViewHolder.mTvPrice, "￥" + bean.getGoods_price());
            linItemViewHolder.mLine.setVisibility(getItemCount() - 1 == position ? View.GONE : View.VISIBLE);
            linItemViewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.color.white : R.color.color_f4f9fd);
            linItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) mListener.itemClickListener(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mType == 2) return mCommonList.size();
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }

    class GridItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView mIvImg;
        @BindView(R.id.tv_product_name)
        TextView mTvProductName;
        @BindView(R.id.tv_price)
        TextView mTvPrice;

        public GridItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            int width = ScreenUrils.getScreenWidth(mContext);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mIvImg.getLayoutParams();
            params.height = (width - SizeUtils.dp2px(40)) / 2;
            mIvImg.setLayoutParams(params);
        }
    }

    static class LinItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_price)
        TextView mTvPrice;
        @BindView(R.id.line)
        View mLine;

        public LinItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
