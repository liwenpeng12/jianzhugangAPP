package com.jlkg.jzg.jzg_android.contract.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
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

public class ContractAdapter extends RecyclerAdapter<ProjectApplictionBean.ContentBean, ContractAdapter.ViewHolder> {


    private int type;
    private OnItemClickListener mListener;
    private List<ProjectApplictionBean.ContentBean> mList;
    private OnConfimApplyListener mApplyListener;

    public ContractAdapter(Context context, List<ProjectApplictionBean.ContentBean> data, int type, OnItemClickListener listener) {
        super(context, data);
        this.type = type;
        mList = data;
        mListener = listener;
    }

    public ContractAdapter(Context context, List<ProjectApplictionBean.ContentBean> data, int type, OnItemClickListener listener, OnConfimApplyListener applyListener) {
        super(context, data);
        this.type = type;
        mList = data;
        mListener = listener;
        mApplyListener = applyListener;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_application, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ClickUtils.setPos(holder.tvLeft, position);
        ClickUtils.setPos(holder.tvRight, position);
        ClickUtils.setPos(holder.mTvLook, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.itemClickListener(position);
            }
        });
        ProjectApplictionBean.ContentBean contentBean = mList.get(position);
        switch (type) {
            case 0:
                //申请
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_green);
                holder.tvStatus.setText("申请");
                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null
                        || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                    holder.viewLine.setVisibility(View.GONE);
                    holder.llButton.setVisibility(View.GONE);
                } else {
                    holder.viewLine.setVisibility(View.VISIBLE);
                    holder.llButton.setVisibility(View.VISIBLE);
                    holder.tvLeft.setText("取消");
                    holder.tvRight.setText("确认签约");
                }

                /*if (MyApplication.isCompany) {
                    holder.viewLine.setVisibility(View.VISIBLE);
                    holder.llButton.setVisibility(View.VISIBLE);
                    holder.tvLeft.setText("取消");
                    holder.tvRight.setText("确认");
                } else {
                    holder.viewLine.setVisibility(View.GONE);
                    holder.llButton.setVisibility(View.GONE);
                }*/
                break;
            case 1:
                //签约
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_orange);
                holder.tvStatus.setText("签约");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.GONE);
                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null
                        || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                    holder.tvLeft.setText("终止合约");
                    holder.tvRight.setText("完成合约");
                    holder.viewLine.setVisibility(View.VISIBLE);
                    holder.tvLeft.setVisibility(View.VISIBLE);
                    holder.llButton.setVisibility(View.VISIBLE);
                } else if ((MyApplication.isCompany && (contentBean.getApplyCompany() != null
                        && contentBean.getApplyCompany().getId() == MyApplication.sCompanyLoginBean.getId()))) {
                    holder.viewLine.setVisibility(View.GONE);
                    holder.llButton.setVisibility(View.GONE);
                } else {
                    holder.viewLine.setVisibility(View.VISIBLE);
                    holder.llButton.setVisibility(View.VISIBLE);
                    holder.tvLeft.setVisibility(View.GONE);
//                    holder.tvLeft.setText("取消");
                    holder.tvRight.setText("申请付款");
                }
                break;
            case 2:
                //付款申请
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_red);
                holder.tvStatus.setText("待付款");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.VISIBLE);
                holder.mTvLook.setVisibility(View.VISIBLE);
                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null ||
                        contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                    holder.tvRight.setText("完成合约");
                    holder.tvLeft.setText("终止合同");
                } else {
                    holder.tvRight.setText("申请付款");
                    holder.tvLeft.setVisibility(View.GONE);
                }
                break;
            case 3:
                //已完成
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_blue);
                holder.tvStatus.setText("已完成");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.GONE);
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("查看合约");
                holder.tvLeft.setText("评价");
                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null
                        || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                    holder.llButton.setVisibility(View.VISIBLE);
                    holder.tvRight.setVisibility(View.VISIBLE);
                    holder.tvLeft.setVisibility(View.VISIBLE);
                }
                break;
            case 4:
                holder.tvStatus.setBackgroundResource(R.drawable.shape_angle_grey);
                holder.tvStatus.setText("已终止");
                holder.viewLine.setVisibility(View.GONE);
                holder.llButton.setVisibility(View.GONE);
                holder.tvLeft.setVisibility(View.GONE);
                holder.tvRight.setText("查看合约");
                holder.tvLeft.setText("评价");
                if ((MyApplication.isCompany && (contentBean.getApplyCompany() == null
                        || contentBean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
                    holder.llButton.setVisibility(View.VISIBLE);
                    holder.tvRight.setVisibility(View.VISIBLE);
                    holder.tvLeft.setVisibility(View.VISIBLE);
                }
                break;
        }

        holder.tvTitle.setText(contentBean.getTitle());
        if (contentBean.getProjectApply() != null)
            holder.tvTime.setText(contentBean.getProjectApply().getApplyDate());
        else holder.tvTime.setText("");
        if (contentBean.getProjectApply() == null || (contentBean.getProjectApply().getTeam() == null && contentBean.getProjectApply().getApplyCompany() == null)) {
            return;
        }
        StringBuilder applyNameBuilder = new StringBuilder();
        if (contentBean.getApplyCompany() == null) {
            if (contentBean.getTeam() != null) {
                applyNameBuilder.append(contentBean.getTeam().getTitle());
                if (contentBean.getTeam().getTeamType() != null) {
                    applyNameBuilder.append("（").append(contentBean.getTeam().getTeamType().getTitle()).append("）");
                }
            }
        } else {
            applyNameBuilder.append(contentBean.getApplyCompany().getTitle());
            if (contentBean.getApplyCompany().getCompanyType() != null) {
                applyNameBuilder.append("（").append(contentBean.getApplyCompany().getCompanyType().getText()).append("）");
            }
        }
        TextUtils.setText(holder.tvPersonName, applyNameBuilder.toString());
       /* TextUtils.setText(holder.tvPersonName,applyNameBuilder.toString());
        if (contentBean.getProjectApply() != null && contentBean.getProjectApply().getProjectHire() != null && contentBean.getProjectApply().getProjectHire().getType() != null) {
            holder.tvPersonName.setText(contentBean.getProjectApply().getProjectHire().getType().getText());
        } else {
            holder.tvPersonName.setText("");
        }*/
        if (contentBean.getProject() == null) {
            holder.viewLine.setVisibility(View.GONE);
            holder.llButton.setVisibility(View.GONE);
        }
        if (contentBean.isLookOrder()) {
            holder.mRecyclerView.setVisibility(View.VISIBLE);
            holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            holder.mRecyclerView.setAdapter(new OrderListAdapter(context, contentBean.getOrderBean(), new OnItemClickListener() {
                @Override
                public void itemClickListener(int i) {
                    mApplyListener.itemClickListener(i, position);
                }
            }));
        } else {
            holder.mRecyclerView.setVisibility(View.GONE);
        }
    }

    public interface OnConfimApplyListener {
        void itemClickListener(int position, int i);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_status)
        TextView tvStatus;
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
        @BindView(R.id.tv_look)
        TextView mTvLook;
        @BindView(R.id.ll_button)
        LinearLayout llButton;
        @BindView(R.id.rv_order)
        RecyclerView mRecyclerView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvLeft, getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvRight, getOnClickListener(), AppConstants.CLICK_02);
            ClickUtils.addClickTo(mTvLook, getOnClickListener(), AppConstants.CLICK_03);

        }
    }
}
