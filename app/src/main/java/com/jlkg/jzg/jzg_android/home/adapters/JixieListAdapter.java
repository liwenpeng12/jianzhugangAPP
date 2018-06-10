package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.KeyboardUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.activitys.InstructionActivity;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.inter.OnSearchListener;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zcs on 2018/1/24.
 *
 * @describe:
 */

public class JixieListAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<JIXieZulinBean.ContentBean> mList;
    private OnItemClickListener mListener;
    private OnSearchListener mSearchListener;

    public JixieListAdapter(Context context, List<JIXieZulinBean.ContentBean> list, OnItemClickListener listener, OnSearchListener searchListener) {
        mContext = context;
        mList = list;
        mSearchListener = searchListener;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1)
            return new TopViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_team_list_top_layout, parent, false));
        else
            return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_team_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 2) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            JIXieZulinBean.ContentBean bean = mList.get(position - 1);
            if (bean.getMachine() != null) {
                if (bean.getMachine().getImage() != null)
                    GlideUtils.LoadImgCircleCrop(mContext, bean.getMachine().getImage(), viewHolder.mIvHeard);
            }
            TextUtils.setText(viewHolder.mTvName, bean.getTitle());
            TextUtils.setText(viewHolder.mTvScore, "5");
            viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.color.color_f4f9fd : R.color.white);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(position);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        return 2;
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_search)
        EditText mEtSearch;
        @BindView(R.id.fl_caozuo)
        FrameLayout mFlCaozuo;
        @BindView(R.id.fl_gongyi)
        FrameLayout mFlGongyi;
        @BindView(R.id.fl_zhiliang)
        FrameLayout mFlZhiliang;
        @BindView(R.id.lin_caozuo)
        LinearLayout mLinCaozuo;
        @BindView(R.id.tv_type)
        TextView mTvType;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            KeyboardUtils.hideSoftInput(mEtSearch);
            mEtSearch.setHint("搜索机械");
            mLinCaozuo.setVisibility(View.GONE);
            mTvType.setText("机械负责人");
            mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_NONE) {
                        KeyboardUtils.hideSoftInput(mEtSearch);
                        mSearchListener.seacherListener(mEtSearch.getText().toString().trim());
                    }
                    return false;
                }
            });
        }

        @OnClick({R.id.fl_caozuo, R.id.fl_gongyi, R.id.fl_zhiliang})
        void click(View v) {
            Intent intent = new Intent(mContext, InstructionActivity.class);
            switch (v.getId()) {
                case R.id.fl_caozuo:
                    intent.setType("1");
                    break;
                case R.id.fl_gongyi:
                    intent.setType("2");
                    break;
                case R.id.fl_zhiliang:
                    intent.setType("3");
                    break;
            }
            mContext.startActivity(intent);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_heard)
        ImageView mIvHeard;
        @BindView(R.id.tv_score)
        TextView mTvScore;
        @BindView(R.id.tv_name)
        TextView mTvName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
