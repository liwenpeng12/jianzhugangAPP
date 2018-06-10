package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/2/8
 */

public class SelectCardAdatper extends RecyclerAdapter<String,SelectCardAdatper.ViewHolder> {

    private String[] bankArray;

    public void setBankArray(String[] bankArray) {
        this.bankArray = bankArray;
        notifyDataSetChanged();
    }

    private int selectPosition;

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();
    }

    public SelectCardAdatper(Context context, List data) {
        super(context, data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return bankArray!=null?bankArray.length:0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.itemView,position);
        if(position%2==0){
            holder.itemView.setBackgroundResource(R.color.white);
        }else{
            holder.itemView.setBackgroundResource(R.color.color_f4f9fd);
        }

        if(position==getItemCount()-1){
            holder.viewLine.setVisibility(View.INVISIBLE);
        }else{
            holder.viewLine.setVisibility(View.VISIBLE);
        }

//        if(selectPosition==position){
//            holder.imgSelect.setVisibility(View.VISIBLE);
//        }else{
//            holder.imgSelect.setVisibility(View.INVISIBLE);
//        }
        holder.tvName.setText(bankArray[position]);
    }



    class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.img_select)
        ImageView imgSelect;
        @BindView(R.id.view_line)
        View viewLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(itemView,getOnClickListener(), AppConstants.CLICK_ITEM);
        }
    }
}
