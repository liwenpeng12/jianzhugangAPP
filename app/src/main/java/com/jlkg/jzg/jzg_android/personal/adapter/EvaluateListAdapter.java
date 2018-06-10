package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.home.beans.TeamRateReviewBean;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/4/26
 */

public class EvaluateListAdapter extends RecyclerAdapter<String, RecyclerView.ViewHolder> {

    private RecyclerView.ViewHolder viewHOlder;
    private List<TeamRateReviewBean> teamRateReviewBeans;

    public void setTeamRateReviewBeans(List<TeamRateReviewBean> teamRateReviewBeans) {
        this.teamRateReviewBeans = teamRateReviewBeans;
        notifyDataSetChanged();
    }

    public void setViewHOlder(RecyclerView.ViewHolder viewHOlder) {
        this.viewHOlder = viewHOlder;
    }

    public EvaluateListAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        return teamRateReviewBeans != null ? teamRateReviewBeans.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return viewHOlder;
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_team_evaluation_layout, viewGroup, false);
            return new ViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof ViewHolder){
            ViewHolder viewHolder1= (ViewHolder) viewHolder;
            TeamRateReviewBean bean = teamRateReviewBeans.get(i-1);
            GlideUtils.LoadImgCircleCrop(context,bean.getImurl(),viewHolder1.ivHeard);
            TextUtils.setText(viewHolder1.tvName, bean.getName());
            TextUtils.setText(viewHolder1.tvContent, bean.getReview());
            TextUtils.setText(viewHolder1.tvTime, bean.getReviewDate());
            int score = bean.getCreditRating() + bean.getProgressRating() + bean.getQualityRating() + bean.getSafeRating();
            viewHolder1.ratingBar.setRating(score / 4);
        }
    }

     class ViewHolder extends RecyclerHolder {
        @BindView(R.id.iv_heard)
        ImageView ivHeard;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.lin_content)
        LinearLayout linContent;
        @BindView(R.id.line)
        View line;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
