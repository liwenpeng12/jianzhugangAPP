package com.jlkg.jzg.jzg_android.contract.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.contract.beans.OrderDetailBean;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/4/18.
 *
 * @describe:
 */

public class OrderDetailAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<OrderDetailBean.ContentBean> mList;

    public OrderDetailAdapter(Context context, List<OrderDetailBean.ContentBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_detail_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        OrderDetailBean.ContentBean bean = mList.get(i);
        TextUtils.setText(holder.mTvName, bean.getWorkerName());
        TextUtils.setText(holder.mTvMoney, "￥" + bean.getSalary());
        TextUtils.setText(holder.mTvBankName, bean.getBankName());
        TextUtils.setText(holder.mTvPhone, bean.getMobile());
        holder.itemView.setBackgroundResource(i % 2 == 0 ? R.drawable.d_select_role_bg : R.drawable.d_select_role_blue_bg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_money)
        TextView mTvMoney;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_phone)
        TextView mTvPhone;
        @BindView(R.id.tv_bank_name)
        TextView mTvBankName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
