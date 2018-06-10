package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/27.
 *
 * @describe:
 */

public class JixieZulinListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<JIXieZulinBean.ContentBean> mList;
    private OnItemClickListener mListener;

    public JixieZulinListAdapter(Context context, List<JIXieZulinBean.ContentBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_jixie_zulin_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        JIXieZulinBean.ContentBean bean = mList.get(position);
        viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.drawable.d_select_role_bg : R.drawable.d_select_role_blue_bg);
        TextUtils.setText(viewHolder.mTvProjectName, bean.getTitle());
        if (bean.getType() != null) {
            TextUtils.setText(viewHolder.mTvPersonNum, bean.getType().getText() + bean.getShuoming());
        } else {
            TextUtils.setText(viewHolder.mTvPersonNum, bean.getShuoming());
        }

        TextUtils.setText(viewHolder.mTvType, "机械");
        TextUtils.setText(viewHolder.mTvTime, bean.getCreateDate());
        if (bean.getStatus() != null && bean.getStatus().getId() != null) {
            if (bean.getStatus().getId().equals("HIRE_TYPE_AUDITED")) {
                TextUtils.setText(viewHolder.mTvStatus, "正在招租");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_green);
            } else if (bean.getStatus().getId().equals("HIRE_TYPE_CLOSE")||bean.getStatus().getId().equals("ASK_DONE")) {
                TextUtils.setText(viewHolder.mTvStatus, "招租截止");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_orange);
            } else {
                TextUtils.setText(viewHolder.mTvStatus, "正在招租");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_green);
            }
//            TextUtils.setText(viewHolder.mTvStatus, bean.getStatus().getText());
        }else{
            TextUtils.setText(viewHolder.mTvStatus, "正在招租");
            viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_green);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.itemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_project_name)
        TextView mTvProjectName;
        @BindView(R.id.tv_person_num)
        TextView mTvPersonNum;
        @BindView(R.id.tv_type)
        TextView mTvType;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_status)
        TextView mTvStatus;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
