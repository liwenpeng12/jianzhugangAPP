package com.jlkg.jzg.jzg_android.release.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/2/27.
 *
 * @describe:
 */

public class SelectTypeAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<SelectTypeBean> mList;
    private OnSelectResult mResult;
    private List<SelectTypeBean.SelectTypeChildBean> mSelectList = new ArrayList<>();
    private int mType;

    public SelectTypeAdapter(Context context, List<SelectTypeBean> list, OnSelectResult result) {
        mContext = context;
        mList = list;
        mResult = result;
        int size = mList.size();
        for (int i = 0; i < size; i++) {
            List<SelectTypeBean.SelectTypeChildBean> beanList = mList.get(i).getList();
            int childSize = beanList.size();
            for (int j = 0; j < childSize; j++) {
                if (beanList.get(j).isSelect) {
                    mSelectList.add(beanList.get(j));
                }
            }
        }
        mResult.selectResult(mSelectList);
    }

    public SelectTypeAdapter(Context context, List<SelectTypeBean> list, OnSelectResult result, int type) {
        mContext = context;
        mList = list;
        mResult = result;
        mType = type;
        int size = mList.size();
        for (int i = 0; i < size; i++) {
            List<SelectTypeBean.SelectTypeChildBean> beanList = mList.get(i).getList();
            int childSize = beanList.size();
            for (int j = 0; j < childSize; j++) {
                if (beanList.get(j).isSelect) {
                    mSelectList.add(beanList.get(j));
                }
            }
        }
        mResult.selectResult(mSelectList);
    }

    public List<SelectTypeBean.SelectTypeChildBean> getmSelectList() {
        return mSelectList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_select_type_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.mRecycleView.setLayoutManager(new GridLayoutManager(mContext, 3));
        SelectTypeBean bean = mList.get(position);
        viewHolder.mTvType.setText(bean.type);
        viewHolder.mRecycleView.setAdapter(new SelectTypeChildAdapter(mContext, bean.mChildBeans, new OnItemClickListener() {
            @Override
            public void itemClickListener(int position1) {
                if (mList.get(position).mChildBeans.get(position1).isSelect) {

                    mSelectList.add(mList.get(position).mChildBeans.get(position1));
                } else {
                    mSelectList.remove(mList.get(position).mChildBeans.get(position1));
                }
                mResult.selectResult(mSelectList);
            }
        }, mType,this));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type)
        TextView mTvType;
        @BindView(R.id.recycle_view)
        RecyclerView mRecycleView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnSelectResult {
        void selectResult(List<SelectTypeBean.SelectTypeChildBean> list);
    }

}
