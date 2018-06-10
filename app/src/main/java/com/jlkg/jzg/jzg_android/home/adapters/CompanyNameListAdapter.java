package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.CompanyListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/23.
 *
 * @describe:
 */

public class CompanyNameListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<CompanyListBean.ContentBean> mList;
    private OnItemClickListener mListener;

    public CompanyNameListAdapter(Context context, List<CompanyListBean.ContentBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_company_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.mLine.setVisibility(getItemCount() - 1 == position ? View.GONE : View.VISIBLE);
        viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.color.transparent : R.color.color_f4f9fd);
        if (mList != null) {
            TextUtils.setText(viewHolder.mTvCompanyName,mList.get(position).getTitle());
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.itemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 5;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_company_name)
        TextView mTvCompanyName;
        @BindView(R.id.line)
        View mLine;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
