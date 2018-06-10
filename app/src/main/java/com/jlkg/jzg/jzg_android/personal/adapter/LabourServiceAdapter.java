package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.LabourServiceBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/26
 */

public class LabourServiceAdapter extends RecyclerAdapter<String, LabourServiceAdapter.ViewHolder> {
    private boolean isDetails=true;

    public void setDetails(boolean details) {
        isDetails = details;
        notifyDataSetChanged();
    }

    public LabourServiceAdapter(Context context, List<String> data) {
        super(context, data);
    }

    public List<LabourServiceBean> labourServiceBeanList=new ArrayList<>();

    public void setLabourServiceBeanList(List<LabourServiceBean> labourServiceBeanList) {
        this.labourServiceBeanList = labourServiceBeanList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_labour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return labourServiceBeanList!=null?labourServiceBeanList.size():0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.itemView,position);
        ClickUtils.setPos(holder.tvDispatch,position);
//        if(position==getItemCount()-1){
//            holder.viewLine.setVisibility(View.GONE);
//        }else{
//            holder.viewLine.setVisibility(View.VISIBLE);
//        }

        if(isDetails){
            holder.imgDetails.setVisibility(View.VISIBLE);
        }else{
            holder.imgDetails.setVisibility(View.VISIBLE);
        }

//        if(position%2==0){
//            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_grey);
//        }else{
//            holder.llItem.setBackgroundResource(R.drawable.shape_4dp_blue);
//        }
        LabourServiceBean labourServiceBean=labourServiceBeanList.get(position);
        holder.tvContent.setText(labourServiceBean.name);

    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.view_line)
        View viewLine;
        @BindView(R.id.ll_item)
        LinearLayout llItem;
        @BindView(R.id.img_details)
        ImageView imgDetails;
        @BindView(R.id.tv_dispatch)
        TextView tvDispatch;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(itemView,getOnClickListener(), AppConstants.CLICK_ITEM);
            ClickUtils.addClickTo(tvDispatch,getOnClickListener(),AppConstants.CLICK_01);
        }
    }
}
