package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/24
 */

public class OrganizationAdapter extends RecyclerAdapter<OrganizationBean,OrganizationAdapter.ViewHolder> {

    private List<OrganizationBean> organizationBeanList;

    public void setOrganizationBeanList(List<OrganizationBean> organizationBeanList) {
        this.organizationBeanList = organizationBeanList;
        notifyDataSetChanged();
    }

    public OrganizationAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public int getItemCount() {
        return organizationBeanList!=null?organizationBeanList.size():0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_organization, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClickUtils.setPos(holder.tvDispatch,position);
        ClickUtils.setPos(holder.tvLabour,position);
        ClickUtils.setPos(holder.llItem,position);

        OrganizationBean organizationBean=organizationBeanList.get(position);
        holder.tvTitle.setText(organizationBean.name);
        holder.tvIntroduce.setText(organizationBean.description);

    }

     class ViewHolder extends RecyclerHolder {
        @BindView(R.id.tv_introduce)
        TextView tvIntroduce;
        @BindView(R.id.tv_dispatch)
        TextView tvDispatch;
        @BindView(R.id.tv_labour)
        TextView tvLabour;
        @BindView(R.id.ll_item)
        LinearLayout llItem;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ClickUtils.addClickTo(tvDispatch,getOnClickListener(), AppConstants.CLICK_01);
            ClickUtils.addClickTo(tvLabour,getOnClickListener(), AppConstants.CLICK_02);
            ClickUtils.addClickTo(llItem,getOnClickListener(),AppConstants.CLICK_ITEM);
        }
    }
}
