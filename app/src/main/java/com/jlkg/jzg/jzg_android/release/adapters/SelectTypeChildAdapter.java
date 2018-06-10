package com.jlkg.jzg.jzg_android.release.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.release.activitys.NeedActivity;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/2/27.
 *
 * @describe:
 */

public class SelectTypeChildAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<SelectTypeBean.SelectTypeChildBean> mList;
    private OnItemClickListener mListener;
    private int mType;
    private SelectTypeAdapter typeAdapter;

    public SelectTypeChildAdapter(Context context, List<SelectTypeBean.SelectTypeChildBean> list, OnItemClickListener listener, int type, SelectTypeAdapter adapter) {
        mContext = context;
        mList = list;
        mType = type;
        mListener = listener;
        typeAdapter = adapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_select_type_child_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder viewHolder = (ItemViewHolder) holder;
        final SelectTypeBean.SelectTypeChildBean bean = mList.get(position);
        viewHolder.mTvType.setSelected(bean.isSelect);
        viewHolder.mTvType.setText(bean.type);
        viewHolder.mTvType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mType == NeedActivity.JIXIENEED && typeAdapter.getmSelectList().size() > 0 && !bean.isSelect) {
                    ToastUtils.showShort("最多选择一种类型");
                    return;
                }
                viewHolder.mTvType.setSelected(!viewHolder.mTvType.isSelected());
                bean.isSelect = viewHolder.mTvType.isSelected();
                mListener.itemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type)
        TextView mTvType;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
