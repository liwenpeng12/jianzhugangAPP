package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;

import drawthink.expandablerecyclerview.holder.BaseViewHolder;


/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/24
 */

public class DispatchHolder extends BaseViewHolder {
    public TextView tvTitle,tvLeft,tvRight;
    public ImageView tvImg;
    public LinearLayout llItem;
    public RelativeLayout rlGroupItme;
    public TextView tv_line;
    public DispatchHolder(Context ctx, View itemView, int viewType) {
        super(ctx, itemView, viewType);
        tvTitle=itemView.findViewById(R.id.tv_title);
        img_orientation=tvImg=itemView.findViewById(R.id.tv_img);

        tvLeft=itemView.findViewById(R.id.tv_left);
        tvRight=itemView.findViewById(R.id.tv_right);
        llItem=itemView.findViewById(R.id.ll_child_item);
        rlGroupItme=itemView.findViewById(R.id.rl_group_itme);
        tv_line=itemView.findViewById(R.id.tv_line);
    }

    /**
     * return ChildView root layout id
     */
    @Override
    public int getChildViewResId() {
        return R.id.ll_child;
    }

    /**
     * return GroupView root layout id
     */
    @Override
    public int getGroupViewResId() {
        return R.id.ll_group;
    }
}
