package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.MsgListBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/1/27.
 *
 * @describe:
 */

public class MessageListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<MsgListBean.ContentBean> mList;
    private OnItemClickListener mListener;

    public MessageListAdapter(Context context, List<MsgListBean.ContentBean> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_message_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.drawable.d_select_role_bg : R.drawable.d_select_role_blue_bg);
        MsgListBean.ContentBean bean = mList.get(position);
        TextUtils.setText(viewHolder.mTvMsgTitle, bean.getTitle());
        TextUtils.setText(viewHolder.mTvTime, bean.getNoteDate());
        viewHolder.mTvContent.setText(Html.fromHtml(bean.getNotes()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.itemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_msg_title)
        TextView mTvMsgTitle;
        @BindView(R.id.iv_unread)
        ImageView mIvUnread;
        @BindView(R.id.tv_content)
        TextView mTvContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
