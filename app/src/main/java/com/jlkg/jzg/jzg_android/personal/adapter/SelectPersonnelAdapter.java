package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.widget.CircleImageView;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.personal.bean.SelectPersonnelBean;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/25
 */

public class SelectPersonnelAdapter extends RecyclerAdapter<String ,SelectPersonnelAdapter.ViewHolder> {

    private List<SelectPersonnelBean> selectPersonnelBeans=new ArrayList<>();

    public void setSelectPersonnelBeans(List<SelectPersonnelBean> selectPersonnelBeans) {
        this.selectPersonnelBeans = selectPersonnelBeans;
        notifyDataSetChanged();
    }

    public SelectPersonnelAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        return selectPersonnelBeans!=null?selectPersonnelBeans.size():0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_personnel, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.itemView,position);
        if(position%2==0){
            holder.itemView.setBackgroundResource(R.color.white);
        }else{
            holder.itemView.setBackgroundResource(R.color.color_f4f9fd);
        }
      //  ClassMemberBean classMemberBean=selectPersonnelBeans.get(position);
        SelectPersonnelBean.TeamBean teamBean=selectPersonnelBeans.get(position).getTeam();
        if(teamBean==null){
            return;
        }
        holder.tvName.setText(teamBean.getTitle());
        holder.tvStart.setText(teamBean.getStarsLevel()+"");
        if(!android.text.TextUtils.isEmpty(teamBean.getPhoto())){
            Glide.with(context).load(teamBean.getPhoto().toString()).into(holder.imgPicture);
        }else{
            holder.imgPicture.setImageResource(R.mipmap.content_icon_group);
        }
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_picture)
        CircleImageView imgPicture;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_start)
        TextView tvStart;
        @BindView(R.id.view_line)
        View viewLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(itemView,getOnClickListener(), AppConstants.CLICK_ITEM);
        }
    }
}
