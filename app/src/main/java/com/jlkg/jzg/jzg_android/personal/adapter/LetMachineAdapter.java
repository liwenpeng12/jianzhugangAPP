package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.LetMachineBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/26
 */

public class LetMachineAdapter extends RecyclerAdapter<String,LetMachineAdapter.ViewHolder> {


    private int type;
    private LetMachineBean letMachineBean;

    public void setLetMachineBean(LetMachineBean letMachineBean) {
        this.letMachineBean = letMachineBean;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return letMachineBean!=null&&letMachineBean.getContent()!=null?letMachineBean.getContent().size():0;
    }

    public LetMachineAdapter(Context context, List<String> data, int type) {
        super(context, data);
        this.type = type;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_let_machine, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.tvLeft,position);
        ClickUtils.setPos(holder.tvRight,position);
        ClickUtils.setPos(holder.itemView,position);
        ClickUtils.setPos(holder.mTvEdit, position);
        LetMachineBean.ContentEntity contentBean=letMachineBean.getContent().get(position);

        switch (type){
            case 0:
                if(contentBean.getStatus()!=null){
                    System.out.println("=======status======="+contentBean.getStatus().getId());
                    if("ASK_DONE".equals(contentBean.getStatus().getId())){
                        holder.tvStatus.setText("已完成");
                        holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_a5a5a5));
                        holder.tvLeft.setVisibility(View.GONE);
                        holder.tvRight.setText("删除");
                    }else{
                        holder.tvStatus.setText("招租中");
                        holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_039aff));
                        holder.tvLeft.setVisibility(View.VISIBLE);
                        holder.tvRight.setText("确认完成");
                    }
                }else {
                    holder.tvStatus.setText("招租中");
                    holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_039aff));
                    holder.tvLeft.setVisibility(View.VISIBLE);
                    holder.tvRight.setText("确认完成");
                }
                break;
            case 1:
                holder.tvStatus.setText("招租中");
                holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_039aff));
                holder.tvLeft.setVisibility(View.VISIBLE);
                holder.tvRight.setText("确认完成");
                break;
            case 2:
                holder.tvStatus.setText("已完成");
                holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_a5a5a5));
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("删除");
                break;
        }

        holder.mTvEdit.setVisibility(View.VISIBLE);

        if(!android.text.TextUtils.isEmpty(contentBean.getTitle())) {
            holder.tvTitle.setText(contentBean.getTitle() );
        }else{
            holder.tvTitle.setText("");
        }
        holder.tvCount.setText(contentBean.getShuoming());
        if(!android.text.TextUtils.isEmpty(contentBean.getCreateDate())){
            String[] times=contentBean.getCreateDate().split(" ");
            if(times!=null&&times.length>0){
                String time=times[0].replace("-","/");
                holder.tvTime.setText(time);
            }else {
                holder.tvTime.setText("");
            }

        }else{
            holder.tvTime.setText("");
        }

    }

     class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_type)
        LinearLayout tvType;
        @BindView(R.id.tv_left)
        TextView tvLeft;
        @BindView(R.id.tv_right)
        TextView tvRight;
         @BindView(R.id.tv_edit)
         TextView mTvEdit;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvLeft,getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvRight,getOnClickListener(),AppConstants.CLICK_02);
            ClickUtils.addClickTo(itemView,getOnClickListener(),AppConstants.CLICK_ITEM);
            ClickUtils.addClickTo(mTvEdit, getOnClickListener(), AppConstants.CLICK_03);
        }
    }
}
