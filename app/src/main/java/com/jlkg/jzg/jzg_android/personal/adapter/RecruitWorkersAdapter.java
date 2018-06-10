package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.RecruitWorkersBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/26
 */

public class RecruitWorkersAdapter extends RecyclerAdapter<String, RecruitWorkersAdapter.ViewHolder> {


    private int type;
    List<RecruitWorkersBean> recruitWorkersTeamBeans;

    public void setRecruitWorkersBean(List<RecruitWorkersBean> recruitWorkersTeamBeans) {
        this.recruitWorkersTeamBeans = recruitWorkersTeamBeans;
        notifyDataSetChanged();
    }

    public RecruitWorkersAdapter(Context context, List<String> data, int type) {
        super(context, data);
        this.type = type;
    }

    @Override
    public int getItemCount() {
        return recruitWorkersTeamBeans != null ? recruitWorkersTeamBeans.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recruit_workers, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.itemView, position);
        ClickUtils.setPos(holder.tvLeft, position);
        ClickUtils.setPos(holder.tvRight, position);
        ClickUtils.setPos(holder.mTvEdit, position);

        RecruitWorkersBean recruitWorkersTeamBean = this.recruitWorkersTeamBeans.get(position);
        switch (type) {
            case 0:
                if ("HIRE_TYPE_AUDITED".equals(recruitWorkersTeamBean.getStatus().getId())) {
                    holder.tvStatus.setText("招聘中");
                    holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_039aff));
                    holder.tvLeft.setVisibility(View.VISIBLE);
                    holder.tvLeft.setText("删除");
                    holder.tvRight.setText("确认完成");
                } else if ("HIRE_TYPE_PUBLISH".equals(recruitWorkersTeamBean.getStatus().getId())) {
                    holder.tvStatus.setText("已发布");
                    holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_039aff));
                    holder.tvLeft.setVisibility(View.VISIBLE);
                    holder.tvLeft.setText("删除");
                    holder.tvLeft.setVisibility(View.GONE);
                    holder.tvRight.setText("删除");
                } else {
                    holder.tvStatus.setText("已完成");
                    holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_a5a5a5));
                    holder.tvLeft.setVisibility(View.GONE);
                    holder.tvRight.setText("删除");
                }
                break;
            case 1:
                break;
            case 2:
                holder.tvStatus.setText("已完成");
                holder.tvStatus.setTextColor(context.getResources().getColor(R.color.color_a5a5a5));
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("删除");
                break;
        }

        holder.mTvEdit.setVisibility(View.VISIBLE);
//
//        if(contentEntity==null){
//            return;
//        }
        if (recruitWorkersTeamBean.getProject() != null) {
            holder.tvTitle.setText(recruitWorkersTeamBean.getProject().getName());
        }
        //      holder.tvTitle.setText(recruitWorkersTeamBean.getTitle()+"");

        if (!TextUtils.isEmpty(recruitWorkersTeamBean.getPublishedTime())) {
            String time = recruitWorkersTeamBean.getPublishedTime().split(" ")[0];
            if (!TextUtils.isEmpty(time)) {
                holder.tvTime.setText(time.replace("-", "/"));
            }
        }
//
        if (recruitWorkersTeamBean.getType() != null) {
            holder.tvType.setText(recruitWorkersTeamBean.getType().getText());
        }

        if (recruitWorkersTeamBean.getTeamNeeds() != null) {
            String count = "";
            for (int i = 0; i < recruitWorkersTeamBean.getTeamNeeds().size(); i++) {
                RecruitWorkersBean.TeamNeedsEntity teamNeedsBean = recruitWorkersTeamBean.getTeamNeeds().get(i);
                count += teamNeedsBean.getTeamType().getTitle() + teamNeedsBean.getPeopleNumber() + "人 ";
            }
            holder.tvCount.setText(count);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_left)
        TextView tvLeft;
        @BindView(R.id.tv_right)
        TextView tvRight;
        @BindView(R.id.tv_edit)
        TextView mTvEdit;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(itemView, getOnClickListener(), AppConstants.CLICK_ITEM);
            ClickUtils.addClickTo(tvLeft, getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvRight, getOnClickListener(), AppConstants.CLICK_02);
            ClickUtils.addClickTo(mTvEdit, getOnClickListener(), AppConstants.CLICK_03);
        }
    }
}
