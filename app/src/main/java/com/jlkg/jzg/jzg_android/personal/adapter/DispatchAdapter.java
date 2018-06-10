package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jlkg.jzg.jzg_android.R;

import java.util.ArrayList;
import java.util.List;

import drawthink.expandablerecyclerview.adapter.BaseRecyclerViewAdapter;
import drawthink.expandablerecyclerview.bean.GroupItem;
import drawthink.expandablerecyclerview.bean.RecyclerViewData;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/24
 */

public class DispatchAdapter extends BaseRecyclerViewAdapter<String,String,DispatchHolder>{

    private ImageView imageView;
    private List<RecyclerViewData> listDatas=new ArrayList<>();
    private int expandPosi=-1;
    private OnLeftOrRightListener onLeftOrRightListener;

    public void setOnLeftOrRightListener(OnLeftOrRightListener onLeftOrRightListener) {
        this.onLeftOrRightListener = onLeftOrRightListener;
        notifyDataSetChanged();
    }



    public interface OnLeftOrRightListener{
        void clickLeft(int groupPosition,int childPosition);
        void clickRight(int groupPosition,int childPosition);
    }
    public void setExpandPosi(int expandPosi) {
        this.expandPosi = expandPosi;
       // notifyDataSetChanged();
    }

    public DispatchAdapter(Context ctx, List<RecyclerViewData> datas) {
        super(ctx, datas);
        this.listDatas=datas;
    }

    public void setListDatas(List<RecyclerViewData> listDatas) {
        this.listDatas = listDatas;
        notifyRecyclerViewData();
    }

    @Override
    public View getGroupView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dispatch_group,parent,false);
    }


    @Override
    public View getChildView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dispatch_child,parent,false);
    }


    @Override
    public DispatchHolder createRealViewHolder(Context ctx, View view, int viewType) {
        return new DispatchHolder(ctx,view,viewType);
    }


    @Override
    public void onBindGroupHolder(DispatchHolder holder, int groupPos, int position, String groupData) {
        switch (groupPos){
            case 0:
                holder.rlGroupItme.setBackgroundResource(R.drawable.shape_dispatch_group);
                break;
            case 1:
                holder.rlGroupItme.setBackgroundResource(R.drawable.shape_dispatch_group_ffb74d);

                break;
            case 2:
                holder.rlGroupItme.setBackgroundResource(R.drawable.shape_dispatch_group_63b5f6);

                break;
            case 3:
                holder.rlGroupItme.setBackgroundResource(R.drawable.shape_dispatch_group_4dcfe1);
                break;
        }
        holder.tvTitle.setText(groupData);
        if(groupPos==0){
            holder.tv_line.setVisibility(View.GONE);
        }else{
            holder.tv_line.setVisibility(View.VISIBLE);
        }
        System.out.println("========yxl===position="+position);
        if(getShowingDatas().get(position) instanceof GroupItem) {
            if (((GroupItem) getShowingDatas().get(position)).isExpand()) {
                System.out.println("====yxl=======01=========");
                holder.tvImg.setImageResource(R.mipmap.white_up);
            } else {
                System.out.println("====yxl=====02=======");
                holder.tvImg.setImageResource(R.mipmap.white_down);
            }
        }
    }


    @Override
    public void onBindChildpHolder(DispatchHolder holder, final int groupPos, final int childPos, int position, String childData) {
        System.out.println("========groupPos="+groupPos+"====childPos="+childPos+"=====postion="+position+"===childData="+childData);
        if(childPos%2==0){
            holder.llItem.setBackgroundResource(R.color.color_f4f9fd);
        }else{
            holder.llItem.setBackgroundResource(R.color.white);
        }
        String[] names=childData.split("&JZG&");
        if(names.length>0) {
            holder.tvLeft.setText(names[0]);
        }
        if(names.length>1) {
            holder.tvRight.setText(names[1]);
        }
        holder.tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("=========right==========");
                if(onLeftOrRightListener!=null){
                    onLeftOrRightListener.clickRight(groupPos,childPos);
                }
            }
        });
        holder.tvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("=======left========");
                if(onLeftOrRightListener!=null){
                    onLeftOrRightListener.clickLeft(groupPos,childPos);
                }
            }
        });

    }

    @Override
    public boolean canExpandAll() {
        return true;
    }
}
