package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/2/11
 */

public class ClassHistoryMemberAdatper extends RecyclerAdapter<String,ClassHistoryMemberAdatper.ViewHolder> {


    private List<ClassMemberBean> classMemberBeanList=new ArrayList<>();

    public void setClassMemberBeanList(List<ClassMemberBean> classMemberBeanList) {
        this.classMemberBeanList = classMemberBeanList;
        notifyDataSetChanged();
    }

    public ClassHistoryMemberAdatper(Context context, List data) {
        super(context, data);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_history_member, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.tvRecover,position);

        if(position%2==0){
            holder.itemView.setBackgroundResource(R.color.white);
        }else{
            holder.itemView.setBackgroundResource(R.color.color_f4f9fd);
        }
        ClassMemberBean classMemberBean=classMemberBeanList.get(position);

        holder.tvName.setText(classMemberBean.getTitle());
        holder.tvPhone.setText(classMemberBean.getPhone());

    }

    @Override
    public int getItemCount() {
        return classMemberBeanList!=null?classMemberBeanList.size():0;
    }

    class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_recover)
        TextView tvRecover;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvRecover,getOnClickListener(), AppConstants.CLICK_01);
        }
    }
}
