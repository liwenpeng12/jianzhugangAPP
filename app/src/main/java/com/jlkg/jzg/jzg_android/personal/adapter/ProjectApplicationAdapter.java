package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.ProjectApplictionBean;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/26
 */

public class ProjectApplicationAdapter extends RecyclerAdapter<String,ProjectApplicationAdapter.ViewHolder> {

    private int type;
    private ProjectApplictionBean projectApplictionBean;

    public void setProjectApplictionBean(ProjectApplictionBean projectApplictionBean) {
        this.projectApplictionBean = projectApplictionBean;
        notifyDataSetChanged();
    }

    public ProjectApplicationAdapter(Context context, List<String> data, int type) {
        super(context, data);
        this.type = type;
    }

    @Override
    public int getItemCount() {
        return projectApplictionBean!=null&&projectApplictionBean.getContent()!=null?projectApplictionBean.getContent().size():0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_application, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.tvLeft,position);
        ClickUtils.setPos(holder.tvRight,position);
        switch (type){
            case 0:
//                switch (position){
//                    case 0:
//                        //申请
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_green);
//                        holder.tvStatus.setText("申请");
//                        holder.viewLine.setVisibility(View.GONE);
//                        holder.llButton.setVisibility(View.GONE);
//                        break;
//                    case 1:
                       // 签约
                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_orange);
                        holder.tvStatus.setText("签约");
                        holder.viewLine.setVisibility(View.VISIBLE);
                        holder.llButton.setVisibility(View.VISIBLE);
                        holder.tvLeft.setText("取消");
                        holder.tvRight.setText("确认签约");
                        break;
//                    case 2:
//                        //付款申请
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
//                        holder.tvStatus.setText("付款申请");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("申请付款");
//                        break;
//                    case 3:
//                        //付款确认
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
//                        holder.tvStatus.setText("付款确认");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("确认付款");
//                        break;
//                    case 4:
//                        //平台付款
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
//                        holder.tvStatus.setText("平台付款");
//
//                        holder.viewLine.setVisibility(View.GONE);
//                        holder.llButton.setVisibility(View.GONE);
//                        break;
//                    case 5:
//                        //付款到账
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
//                        holder.tvStatus.setText("付款到账");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("确认到账");
//                        break;
//                    case 6:
//                        //已完成
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_blue);
//                        holder.tvStatus.setText("已完成");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("删除");
//                        break;
//                    case 7:
//                        //已终止
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_grey);
//                        holder.tvStatus.setText("已终止");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("删除");
//                        break;
//                    default:
//                        holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_grey);
//                        holder.tvStatus.setText("已终止");
//                        holder.viewLine.setVisibility(View.VISIBLE);
//                        holder.llButton.setVisibility(View.VISIBLE);
//                        holder.tvLeft.setVisibility(View.GONE);
//                        holder.tvRight.setText("删除");
//                        break;
//                }
//                break;
            case 1:
                //已签约
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
                holder.tvStatus.setText("付款申请");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.GONE);
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("申请付款");

                break;
            case 2:
                //待付款
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
                holder.tvStatus.setText("待付款");
                holder.viewLine.setVisibility(View.VISIBLE);
                holder.llButton.setVisibility(View.VISIBLE);
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("确认完成");

//                //签约
//                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_orange);
//                holder.tvStatus.setText("签约");
//                holder.viewLine.setVisibility(View.VISIBLE);
//                holder.llButton.setVisibility(View.VISIBLE);
//                holder.tvLeft.setText("取消");
//                holder.tvRight.setText("确认签约");
                break;
            case 3:
                //付款确认
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_blue);
                holder.tvStatus.setText("已完成");
                holder.viewLine.setVisibility(View.VISIBLE);
                holder.llButton.setVisibility(View.VISIBLE);
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("删除");
                break;

            case 4:
                //付款确认
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_grey);
                holder.tvStatus.setText("已终止");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.GONE);

                holder.tvRight.setText("删除");
                break;
        }
        ProjectApplictionBean.ContentBean contentBean=projectApplictionBean.getContent().get(position);
        holder.tvTitle.setText(contentBean.getTitle());
        if(contentBean.getProjectApply()==null||contentBean.getProjectApply().getTeam()==null){
            return;
        }
        holder.tvTime.setText(contentBean.getProjectApply().getTeam().getTitle());
        String timeStr=contentBean.getProjectApply().getTeam().getStartTime();
        if(!android.text.TextUtils.isEmpty(timeStr)){
            timeStr=timeStr.split(" ")[0];
            if(!android.text.TextUtils.isEmpty(timeStr)){
                holder.tvTime.setText(timeStr.replace("-","/"));
            }
        }

    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_type)
        LinearLayout tvType;
        @BindView(R.id.tv_personName)
        TextView tvPersonName;
        @BindView(R.id.view_line)
        View viewLine;
        @BindView(R.id.tv_left)
        TextView tvLeft;
        @BindView(R.id.tv_right)
        TextView tvRight;
        @BindView(R.id.ll_button)
        LinearLayout llButton;
        @BindView(R.id.tv_status)
        TextView tvStatus;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvLeft,getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvRight,getOnClickListener(),AppConstants.CLICK_02);
        }
    }
}
