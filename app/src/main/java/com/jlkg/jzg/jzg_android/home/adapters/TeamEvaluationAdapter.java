package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.TeamRateReviewBean;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/24.
 *
 * @describe: 班组信息--用户评价适配器
 */

public class TeamEvaluationAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TeamRateReviewBean> mList;

    public TeamEvaluationAdapter(Context context, List<TeamRateReviewBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).from(mContext).inflate(R.layout.item_team_evaluation_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        TeamRateReviewBean bean = mList.get(position);
        GlideUtils.LoadImgCircleCrop(mContext,bean.getImurl(),viewHolder.ivHeard);
        TextUtils.setText(viewHolder.tvName, bean.getName());
        TextUtils.setText(viewHolder.tvContent, bean.getReview());
        TextUtils.setText(viewHolder.tvTime, bean.getReviewDate());
        int score = bean.getCreditRating() + bean.getProgressRating() + bean.getQualityRating() + bean.getSafeRating();
        viewHolder.ratingBar.setRating(score / 4);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_heard)
        ImageView ivHeard;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.lin_content)
        LinearLayout linContent;
        @BindView(R.id.line)
        View line;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
