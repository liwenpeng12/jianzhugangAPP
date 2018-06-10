package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffBean;
import com.jlkg.jzg.jzg_android.personal.bean.PayoffBean02;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/24
 */

public class TradingRecordAdapter extends RecyclerAdapter<String,TradingRecordAdapter.ViewHolder> {

    private List<PayoffBean> payoffBeanList=new ArrayList<>();

    public void setPayoffBeanList(List<PayoffBean> payoffBeanList) {
        this.payoffBeanList = payoffBeanList;
        notifyDataSetChanged();
    }


    private PayoffBean02 payoffBean02;

    public void setPayoffBean02(PayoffBean02 payoffBean02) {
        this.payoffBean02 = payoffBean02;
        notifyDataSetChanged();
    }

    public TradingRecordAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        //return payoffBeanList!=null?payoffBeanList.size():0;
        return payoffBean02!=null&&payoffBean02.getContent()!=null?
                payoffBean02.getContent().size():0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trading_record, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.tvMore,position);
        if(position%2==0){
            holder.ll.setBackgroundResource(R.drawable.shape_white_4_grey);
        }else{
            holder.ll.setBackgroundResource(R.drawable.shape_white_4_f4f9fd);
        }
//        PayoffBean payoffBean=payoffBeanList.get(position);
//        holder.tvOrderNumber.setText("支付单号："+payoffBean.getAuditNO());
//        holder.tvCompany.setText(payoffBean.getTeamName()+"班组申请付款已到账");
//        holder.tvPrice.setText("￥"+payoffBean.getApplyAmount());
//        if(!TextUtils.isEmpty(payoffBean.getApplyDate())){
//            String[] times=payoffBean.getApplyDate().split(" ");
//            String data01="";
//            String dataHM="";
//            if(times!=null&&times.length>0) {
//                data01= times[0];
//                if(times.length>1){
//                    String data02=times[1];
//                    if(!TextUtils.isEmpty(data02)){
//                        String[] hm=data02.split(":");
//                        if(hm!=null&&hm.length>1){
//                            dataHM=hm[0]+":"+hm[1];
//                        }
//                    }
//                }
//                holder.tvDate.setText(data01+" "+dataHM);
//            }else{
//                holder.tvDate.setText("");
//            }
//        }else{
//            holder.tvDate.setText("");
//        }

        PayoffBean02.ContentEntity contentEntity=payoffBean02.getContent().get(position);
        holder.tvOrderNumber.setText("支付单号："+contentEntity.getAuditNo());
        String title="";
        if(contentEntity.getContract()!=null) {
            if(contentEntity.getContract().getCompany()!=null) {
                title = contentEntity.getContract().getCompany().getTitle();
            }
            if(contentEntity.getContract().getProject()!=null){
                title+=contentEntity.getContract().getProject().getName()+"付款已到账";
            }
            holder.tvCompany.setText(title);
        }
        holder.tvPrice.setText("￥"+contentEntity.getApplyAmount());
        if(!TextUtils.isEmpty(contentEntity.getApplyDate())){
            String[] times=contentEntity.getApplyDate().split(" ");
            String data01="";
            String dataHM="";
            if(times!=null&&times.length>0) {
                data01= times[0];
                if(times.length>1){
                    String data02=times[1];
                    if(!TextUtils.isEmpty(data02)){
                        String[] hm=data02.split(":");
                        if(hm!=null&&hm.length>1){
                            dataHM=hm[0]+":"+hm[1];
                        }
                    }
                }
                holder.tvDate.setText(data01+" "+dataHM);
            }else{
                holder.tvDate.setText("");
            }
        }else{
            holder.tvDate.setText("");
        }

    }

     class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_orderNumber)
        TextView tvOrderNumber;
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_more)
        TextView tvMore;
        @BindView(R.id.ll_item)
        LinearLayout ll;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvMore,getOnClickListener(), AppConstants.CLICK_01);
        }
    }
}
