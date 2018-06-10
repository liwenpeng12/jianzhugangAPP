package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.MallListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:
 */

public class MallListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<MallListBean.DataBean.StoreListBean> mList;
    private OnItemClickListener mListener;

    public MallListAdapter(Context context, List<MallListBean.DataBean.StoreListBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mall_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
//        viewHolder.mLine.setVisibility(getItemCount() - 1 == position ? View.GONE : View.VISIBLE);
        viewHolder.mRlItem.setBackgroundResource(position % 2 == 0 ? R.color.transparent : R.color.color_f4f9fd);
        MallListBean.DataBean.StoreListBean bean = mList.get(position);
//        GlideApp.with(mContext).load(bean.getImage().getUrl()).into(viewHolder.mIvHeard);
        viewHolder.mTvName.setText(bean.getStore_name());
        viewHolder.mTvAddress.setText(bean.getStore_address());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.itemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_heard)
        ImageView mIvHeard;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_address)
        TextView mTvAddress;
        @BindView(R.id.rl_item)
        RelativeLayout mRlItem;
        @BindView(R.id.line)
        View mLine;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
