package com.jlkg.jzg.jzg_android.home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.KeyboardUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.activitys.InstructionActivity;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
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

public class TeamListAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<TeamInfoListBean.ContentBean> mList;
    private OnItemClickListener mListener;
    private OnSearchListener mSearchListener;
    private String mTeamTypeId;

    public TeamListAdapter(Context context, List<TeamInfoListBean.ContentBean> list, OnItemClickListener listener, OnSearchListener searchListener, String teamTypeId) {
        mContext = context;
        mList = list;
        mListener = listener;
        mSearchListener = searchListener;
        mTeamTypeId = teamTypeId;
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
            viewHolder.itemView.setBackgroundResource(position % 2 == 0 ? R.color.color_f4f9fd : R.color.white);
            TextUtils.setText(viewHolder.mTvName, mList.get(position - 1).getTitle());
            TextUtils.setText(viewHolder.mTvScore, mList.get(position - 1).getStarsLevel() + "");

            String photo = "";
            if (mList.get(position - 1).getPhoto() != null)
                photo = mList.get(position - 1).getPhoto().getUrl();
            GlideUtils.LoadImgCircleCrop(mContext, photo, viewHolder.mIvHeard);
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

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            KeyboardUtils.hideSoftInput(mEtSearch);
            mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == KeyEvent.KEYCODE_ENDCALL) {
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
            intent.putExtra("id", mTeamTypeId);
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
