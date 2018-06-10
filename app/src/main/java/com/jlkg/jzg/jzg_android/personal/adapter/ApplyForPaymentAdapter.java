package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.RecyclerAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/1/29
 */

public class ApplyForPaymentAdapter extends RecyclerAdapter<ClassMemberBean, ApplyForPaymentAdapter.ViewHolder> {

    private ApplyForPaymentListener applyForPaymentListener;
    private List<ClassMemberBean> mSelectList = new ArrayList<>();

    public void setApplyForPaymentListener(ApplyForPaymentListener applyForPaymentListener) {
        this.applyForPaymentListener = applyForPaymentListener;
        notifyDataSetChanged();
    }

    public interface ApplyForPaymentListener {
        void isAllEnter(boolean isEnter);
    }

    public List<ClassMemberBean> getSelectList() {
        return mSelectList;
    }

    public ApplyForPaymentAdapter(Context context, List<ClassMemberBean> data) {
        super(context, data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_applyfor_payment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ClassMemberBean bean = data.get(position);
        if (position == getItemCount() - 1) {
            holder.viewLine.setVisibility(View.INVISIBLE);
        } else {
            holder.viewLine.setVisibility(View.VISIBLE);
        }

        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.white);
        } else {
            holder.itemView.setBackgroundResource(R.color.color_f4f9fd);
        }
        holder.etMoney.setTag(position);
        holder.etMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (android.text.TextUtils.isEmpty(holder.etMoney.getText().toString().trim()) && mSelectList.contains(bean)) {
                    mSelectList.remove(bean);
                } else if (!mSelectList.contains(bean)) {
                    mSelectList.add(bean);
                }
                applyForPaymentListener.isAllEnter(mSelectList.size() == getItemCount());
                bean.setMoney(holder.etMoney.getText().toString().trim());
            }
        });

        TextUtils.setText(holder.tvName, bean.getTitle());
        TextUtils.setText(holder.etMoney, bean.getMoney());

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.et_money)
        EditText etMoney;
        @BindView(R.id.view_line)
        View viewLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
