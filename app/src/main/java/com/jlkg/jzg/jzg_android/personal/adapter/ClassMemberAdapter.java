package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
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

public class ClassMemberAdapter extends RecyclerAdapter<ClassMemberBean, ClassMemberAdapter.ViewHolder> {

    private List<ClassMemberBean> classMemberBeans = new ArrayList<>();
    private OnItemClickListener mListener;

    public void setClassMemberBeans(List<ClassMemberBean> classMemberBeans) {
        this.classMemberBeans = classMemberBeans;
        notifyDataSetChanged();
    }

    public ClassMemberAdapter(Context context, List data) {
        super(context, data);
    }

    public void setOnItemClockLisntener(OnItemClickListener lisntener) {
        mListener = lisntener;
    }


    @Override
    public int getItemCount() {
        return classMemberBeans != null ? classMemberBeans.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_member, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.white);
        } else {
            holder.itemView.setBackgroundResource(R.color.color_f4f9fd);
        }
        ClassMemberBean classMemberBean = classMemberBeans.get(position);
        holder.tvName.setText(classMemberBean.getTitle());
        holder.tvPhone.setText(classMemberBean.getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.itemClickListener(position);
                }
            }
        });
    }

    class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.view_line)
        View viewLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
