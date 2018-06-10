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
import com.jlkg.jzg.jzg_android.personal.bean.ClassBeforeObjectBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/2/27
 */

public class ClassBeforeObjectAdapter extends RecyclerAdapter<String, ClassBeforeObjectAdapter.ViewHolder> {
    private List<ClassBeforeObjectBean> classBeforeObjectBeans=new ArrayList<>();

    public void setClassBeforeObjectBeans(List<ClassBeforeObjectBean> classBeforeObjectBeans) {
        this.classBeforeObjectBeans = classBeforeObjectBeans;
        notifyDataSetChanged();
    }

    public ClassBeforeObjectAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        return classBeforeObjectBeans!=null?classBeforeObjectBeans.size():0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_before_object, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.itemView,position);
        if(position%2==0){
            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_grey);
        }else{
            holder.llItem.setBackgroundResource(R.drawable.shape_white_4_f4f9fd);
        }
        ClassBeforeObjectBean classBeforeObjectBean=classBeforeObjectBeans.get(position);
        holder.tvTitle.setText(classBeforeObjectBean.getTitle());
        if(classBeforeObjectBean.getCompanyName()!=null){
            holder.tvCompany.setText(classBeforeObjectBean.getCompanyName());
        }
        String startTime=classBeforeObjectBean.getProjectDate();
        if(!TextUtils.isEmpty(startTime)){
            holder.tvTime.setText(startTime.split(" ")[0]);
        }
    }

     class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(itemView,getOnClickListener(), AppConstants.CLICK_ITEM);
        }
    }
}
