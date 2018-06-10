package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffBean;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffDetailsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/25
 */

public class PayoffDetailsAdapter extends RecyclerAdapter<String, PayoffDetailsAdapter.ViewHolder> {

    private List<PayoffBean.WorkerListBean> workerListBeanList = new ArrayList<>();

    public void setWorkerListBeanList(List<PayoffBean.WorkerListBean> workerListBeanList) {
        this.workerListBeanList = workerListBeanList;
        notifyDataSetChanged();
    }

    private PayoffDetailsBean payoffDetailsBean;

    public void setPayoffDetailsBean(PayoffDetailsBean payoffDetailsBean) {
        this.payoffDetailsBean = payoffDetailsBean;
        notifyDataSetChanged();
    }

    public PayoffDetailsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        //return workerListBeanList != null ? workerListBeanList.size() : 0;
        return payoffDetailsBean!=null&&payoffDetailsBean.getContent()!=null?
                payoffDetailsBean.getContent().size():0;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payoff_details, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        if (position % 2 == 0) {
//            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_grey);
//        } else {
//            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_f4f9fd);
//        }
//        PayoffBean.WorkerListBean workerListBean = workerListBeanList.get(position);
//        holder.tvName.setText(workerListBean.getWorkerName());
//        holder.tvPhone.setText(workerListBean.getMobile());
//        holder.tvIdNumber.setText(workerListBean.getIdNumber());
//        holder.tvCardNumber.setText(workerListBean.getBankName()+" "+workerListBean.getCardNumber());
//        holder.tvPrice.setText("￥"+workerListBean.getSalary());

        if (position % 2 == 0) {
            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_grey);
        } else {
            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_f4f9fd);
        }
        PayoffDetailsBean.ContentEntity contentEntity=payoffDetailsBean.getContent().get(position);
        holder.tvName.setText(contentEntity.getWorkerName());
        holder.tvPhone.setText(contentEntity.getMobile());
        holder.tvIdNumber.setText(contentEntity.getIdNumber());
        holder.tvCardNumber.setText(contentEntity.getBankName()+" "+contentEntity.getCardNumber());
        holder.tvPrice.setText("￥"+contentEntity.getSalary());
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_idNumber)
        TextView tvIdNumber;
        @BindView(R.id.tv_cardNumber)
        TextView tvCardNumber;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
