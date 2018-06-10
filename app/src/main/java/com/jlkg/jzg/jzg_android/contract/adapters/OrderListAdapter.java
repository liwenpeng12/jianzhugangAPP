package com.jlkg.jzg.jzg_android.contract.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.contract.activitys.OrderDetailActivity;
import com.jlkg.jzg.jzg_android.contract.beans.OrderBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/4/18.
 *
 * @describe:
 */

public class OrderListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<OrderBean> mList;
    private OnItemClickListener mListener;

    public OrderListAdapter(Context context, List<OrderBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_order_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        final OrderBean bean = mList.get(i);
        holder.tvOrderNo.setText("支付单号：" + bean.getAuditNo());
        holder.tvAllMoney.setText("￥" + bean.getApplyAmount());
        holder.mTvConfirmApply.setVisibility(View.GONE);
        holder.tvTime1.setText("");
        holder.tvTime2.setText("");
        holder.tvTime3.setText("");
        holder.tvTime4.setText("");
        if (bean.getStatus() == null) {
            holder.tvTime1.setVisibility(View.GONE);
            holder.tvTime2.setVisibility(View.GONE);
            holder.tvTime3.setVisibility(View.GONE);
            holder.tvTime4.setVisibility(View.GONE);
            holder.iv1.setSelected(false);
            holder.iv2.setSelected(false);
            holder.iv3.setSelected(false);
            holder.iv4.setSelected(false);
        } else {
            switch (bean.getStatus().getId()) {
                case "ORDER_STATUS_SAVE"://已保存
                    holder.tvTime1.setVisibility(View.GONE);
                    holder.tvTime2.setVisibility(View.GONE);
                    holder.tvTime3.setVisibility(View.GONE);
                    holder.tvTime4.setVisibility(View.GONE);
                    holder.iv1.setSelected(false);
                    holder.iv2.setSelected(false);
                    holder.iv3.setSelected(false);
                    holder.iv4.setSelected(false);
                    break;
                case "ORDER_STATUS_SUBMITED"://班组已提交
                    if (MyApplication.isCompany) {
                        holder.mTvConfirmApply.setVisibility(View.VISIBLE);
                    }
                    holder.tvTime1.setVisibility(View.VISIBLE);
                    holder.tvTime2.setVisibility(View.GONE);
                    holder.tvTime3.setVisibility(View.GONE);
                    holder.tvTime4.setVisibility(View.GONE);
                    holder.iv1.setSelected(true);
                    holder.iv2.setSelected(false);
                    holder.iv3.setSelected(false);
                    holder.iv4.setSelected(false);
                    if (!TextUtils.isEmpty(bean.getApplyDate()) && bean.getApplyDate().length() > 10)
                        holder.tvTime1.setText(bean.getApplyDate().substring(0, 10));
                    break;
                case "ORDER_STATUS_COMPANY_PAID"://公司付款
                case "ORDER_STATUS_PAY_REQUEST_RECEIVED"://公司确认付款请求
                    holder.tvTime1.setVisibility(View.VISIBLE);
                    holder.tvTime2.setVisibility(View.VISIBLE);
                    holder.tvTime3.setVisibility(View.GONE);
                    holder.tvTime4.setVisibility(View.GONE);
                    holder.iv1.setSelected(true);
                    holder.iv2.setSelected(true);
                    holder.iv3.setSelected(false);
                    holder.iv4.setSelected(false);
                    if (!TextUtils.isEmpty(bean.getApplyDate()) && bean.getApplyDate().length() > 10)
                        holder.tvTime1.setText(bean.getApplyDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getPaidDate()) && bean.getPaidDate().length() > 10)
                        holder.tvTime2.setText(bean.getPaidDate().substring(0, 10));
                    break;
                case "ORDER_STATUS_HX_HANDLE"://华兴银行处理中
                case "ORDER_STATUS_PLATFORM_SEND"://平台付款
                    holder.tvTime1.setVisibility(View.VISIBLE);
                    holder.tvTime2.setVisibility(View.VISIBLE);
                    holder.tvTime3.setVisibility(View.VISIBLE);
                    holder.tvTime4.setVisibility(View.GONE);
                    holder.iv1.setSelected(true);
                    holder.iv2.setSelected(true);
                    holder.iv3.setSelected(true);
                    holder.iv4.setSelected(false);
                    if (!TextUtils.isEmpty(bean.getApplyDate()) && bean.getApplyDate().length() > 10)
                        holder.tvTime1.setText(bean.getApplyDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getPaidDate()) && bean.getPaidDate().length() > 10)
                        holder.tvTime2.setText(bean.getPaidDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getPlatformPaidDate()) && bean.getPlatformPaidDate().length() > 10)
                        holder.tvTime3.setText(bean.getPlatformPaidDate().substring(0, 10));
                    break;
                case "ORDER_STATUS_TEAM_RECEIVED"://班组到账
                    holder.tvTime1.setVisibility(View.VISIBLE);
                    holder.tvTime2.setVisibility(View.VISIBLE);
                    holder.tvTime3.setVisibility(View.VISIBLE);
                    holder.tvTime4.setVisibility(View.VISIBLE);
                    holder.iv1.setSelected(true);
                    holder.iv2.setSelected(true);
                    holder.iv3.setSelected(true);
                    holder.iv4.setSelected(true);
                    if (!TextUtils.isEmpty(bean.getApplyDate()) && bean.getApplyDate().length() > 10)
                        holder.tvTime1.setText(bean.getApplyDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getPaidDate()) && bean.getPaidDate().length() > 10)
                        holder.tvTime2.setText(bean.getPaidDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getPlatformPaidDate()) && bean.getPlatformPaidDate().length() > 10)
                        holder.tvTime3.setText(bean.getPlatformPaidDate().substring(0, 10));
                    if (!TextUtils.isEmpty(bean.getTeamComfirmDate()) && bean.getTeamComfirmDate().length() > 10)
                        holder.tvTime4.setText(bean.getTeamComfirmDate().substring(0, 10));
                    break;
            }
        }
        holder.tvLookDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", bean.getId());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        holder.mTvConfirmApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.itemClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_all_money)
        TextView tvAllMoney;
        @BindView(R.id.tv_order_no)
        TextView tvOrderNo;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.tv_time_1)
        TextView tvTime1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.tv_time_2)
        TextView tvTime2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.tv_time_3)
        TextView tvTime3;
        @BindView(R.id.iv_4)
        ImageView iv4;
        @BindView(R.id.tv_time_4)
        TextView tvTime4;
        @BindView(R.id.tv_look_detail)
        TextView tvLookDetail;
        @BindView(R.id.tv_confirm_apply)
        TextView mTvConfirmApply;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
