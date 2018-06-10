package com.jlkg.jzg.jzg_android.release.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.release.activitys.NeedActivity;
import com.jlkg.jzg.jzg_android.release.beans.NeedBean;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcs on 2018/2/27.
 *
 * @describe:招工/租赁需求适配器
 */

public class NeedAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<SelectTypeBean.SelectTypeChildBean> mList;
    private int mtype;

    public NeedAdapter(Context context, List<SelectTypeBean.SelectTypeChildBean> list, int type) {
        this.mContext = context;
        mList = list;
        mtype = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_need_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        final ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.mLine.setVisibility(getItemCount() - 1 == position ? View.GONE : View.VISIBLE);
        viewHolder.itemView.setBackgroundResource(position % 2 == 1 ? R.color.color_f4f9fd : R.color.transparent);
        final SelectTypeBean.SelectTypeChildBean bean = mList.get(position);
        viewHolder.mTvType.setText(bean.type);
        viewHolder.mEtContent.setText(bean.content);
        viewHolder.mEtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bean.content = viewHolder.mEtContent.getText().toString();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type)
        TextView mTvType;
        @BindView(R.id.et_content)
        EditText mEtContent;
        @BindView(R.id.line)
        View mLine;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            if (mtype == NeedActivity.PERSONNEED) {
                mEtContent.setInputType(InputType.TYPE_CLASS_NUMBER);
                InputFilter filter = new InputFilter.LengthFilter(10);
                mEtContent.setFilters(new InputFilter[]{filter});
            } else {
                InputFilter filter = new InputFilter.LengthFilter(10);
                mEtContent.setFilters(new InputFilter[]{filter});
                mEtContent.setHint("请填写型号");
            }
        }
    }
}
