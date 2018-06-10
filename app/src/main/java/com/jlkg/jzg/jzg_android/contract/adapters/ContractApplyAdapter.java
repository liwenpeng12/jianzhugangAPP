package com.jlkg.jzg.jzg_android.contract.adapters;

import android.content.Context;
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
import com.jlkg.jzg.jzg_android.contract.beans.ContractApplyBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
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

public class ContractApplyAdapter extends RecyclerAdapter<ContractApplyBean, ContractApplyAdapter.ViewHolder> {

    private OnItemClickListener mListener;
    private List<ContractApplyBean> mList;

    public ContractApplyAdapter(Context context, List<ContractApplyBean> data, OnItemClickListener listener) {
        super(context, data);
        mList = data;
        mListener = listener;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.itemClickListener(position);
            }
        });
        ContractApplyBean bean = mList.get(position);
        if (bean.getProjectHire() != null && bean.getProjectHire().getProject() != null)
            TextUtils.setText(holder.tvTitle, bean.getProjectHire().getProject().getName());
        else if (bean.getProject() != null) {
            TextUtils.setText(holder.tvTitle, bean.getProject().getName());
        } else {
            TextUtils.setText(holder.tvTitle, "");
        }
        TextUtils.setText(holder.tvTime, bean.getApplyDate());
//        if (bean.getProjectHire() != null && bean.getProjectHire().getType() != null)
//            TextUtils.setText(holder.tvPersonName, bean.getProjectHire().getType().getText());
        StringBuilder applyNameBuilder = new StringBuilder();
        if (bean.getApplyCompany() == null) {
            if (bean.getTeam() != null) {
                applyNameBuilder.append(bean.getTeam().getTitle());
                if (bean.getTeam().getTeamType() != null) {
                    applyNameBuilder.append("（").append(bean.getTeam().getTeamType().getTitle()).append("）");
                }
            }
        } else {
            applyNameBuilder.append(bean.getApplyCompany().getTitle());
            if (bean.getApplyCompany().getCompanyType() != null) {
                applyNameBuilder.append("（").append(bean.getApplyCompany().getCompanyType().getText()).append("）");
            }
        }
        TextUtils.setText(holder.tvPersonName, applyNameBuilder.toString());
        if (bean.getStatus() != null && bean.getStatus().getId().equals("APPLY") && (MyApplication.isCompany
                && (bean.getApplyCompany() == null || bean.getApplyCompany().getId() != MyApplication.sCompanyLoginBean.getId()))) {
            holder.tvLeft.setText("拒绝");
            holder.tvRight.setText("同意");
            holder.tvRight.setEnabled(true);
            holder.tvLeft.setEnabled(true);
            holder.tvLeft.setVisibility(View.VISIBLE);
        } else {
            holder.tvLeft.setVisibility(View.GONE);
            if (bean.getStatus() == null) {
                holder.tvRight.setText("");
            } else {
                TextUtils.setText(holder.tvRight, bean.getStatus().getText());
            }
            holder.tvRight.setEnabled(false);
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
            ClickUtils.addClickTo(tvLeft, getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvRight, getOnClickListener(), AppConstants.CLICK_02);
        }
    }
}
