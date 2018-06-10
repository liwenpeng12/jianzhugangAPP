package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.base.RecyclerHolder;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DuoNuo on 2017/5/22
 */

public class OptionAdapter extends RecyclerAdapter<String, OptionAdapter.CommonHolder> {

    public OptionAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommonHolder(createView(R.layout.item_option, parent));
    }

    @Override
    public void onBindViewHolder(CommonHolder holder, final int position) {
        ClickUtils.setPos(holder.itemView, position);
        if (position == data.size() - 1) {
            holder.mViewLine.setVisibility(View.GONE);
        } else {
            holder.mViewLine.setVisibility(View.VISIBLE);
        }
        holder.mTvReason.setText(data.get(position));
    }

    class CommonHolder extends RecyclerHolder {

        @BindView(R.id.view_line)
        View mViewLine;
        @BindView(R.id.tv_reason)
        TextView mTvReason;

        public CommonHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ClickUtils.addClickTo(itemView, getOnClickListener(), AppConstants.CLICK_ITEM);
        }
    }
}
