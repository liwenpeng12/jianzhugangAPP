package com.jlkg.jzg.jzg_android.job.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.job.bean.ProjectListBean;
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

public class JobListAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<ProjectListBean.ContentBean> mList;
    private OnItemClickListener mListener;

    public JobListAdapter(Context context, List<ProjectListBean.ContentBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_job_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        ProjectListBean.ContentBean bean = mList.get(position);
        if (bean.getProject() != null)
            TextUtils.setText(viewHolder.mTvProjectName, bean.getProject().getName());
        if (bean.getType() != null)
            TextUtils.setText(viewHolder.mTvType, bean.getType().getText());
        TextUtils.setText(viewHolder.mTvTime, bean.getPublishedTime());
        int size = bean.getTeamNeeds().size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                        .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人");
            else
                builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle())
                        .append(bean.getTeamNeeds().get(i).getPeopleNumber()).append("人").append(",");
        }
        /*for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle());
            } else
                builder.append(bean.getTeamNeeds().get(i).getTeamType().getTitle()).append("");
        }*/
        if (bean.getStatus() != null && bean.getStatus().getId() != null) {
            if (bean.getStatus().getId().equals("HIRE_TYPE_AUDITED")) {
                TextUtils.setText(viewHolder.mTvStatus, "正在招聘");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_green);
            } else if (bean.getStatus().getId().equals("HIRE_TYPE_CLOSE") || bean.getStatus().getId().equals("HIRE_TYPE_FULL")) {
                TextUtils.setText(viewHolder.mTvStatus, "招聘截止");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_orange);
            } else {
                TextUtils.setText(viewHolder.mTvStatus, "正在招聘");
                viewHolder.mTvStatus.setBackgroundResource(R.drawable.shape_angle_green);
            }
//            TextUtils.setText(viewHolder.mTvStatus, bean.getStatus().getText());
        }
        TextUtils.setText(viewHolder.mTvPersonNum, builder.toString());
        viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.drawable.d_select_role_bg : R.drawable.d_select_role_blue_bg);
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
