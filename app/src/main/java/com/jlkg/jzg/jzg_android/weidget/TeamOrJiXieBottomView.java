package com.jlkg.jzg.jzg_android.weidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.OutAppIntentUtils;
import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.activitys.TeamDetailActivity;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
import com.jlkg.jzg.jzg_android.job.activitys.JobDetailActivity;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:
 */

public class TeamOrJiXieBottomView extends FrameLayout {
    @BindView(R.id.iv_heard)
    ImageView mIvHeard;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_score)
    TextView mTvScore;
    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.iv_call)
    ImageView mIvCall;
    @BindView(R.id.tv_left_1)
    TextView mTvLeft1;
    @BindView(R.id.tv_right_1)
    TextView mTvRight1;
    @BindView(R.id.tv_left_2)
    TextView mTvLeft2;
    @BindView(R.id.tv_right_2)
    TextView mTvRight2;
    @BindView(R.id.tv_left_3)
    TextView mTvLeft3;
    @BindView(R.id.tv_right_3)
    TextView mTvRight3;
    private Context mContext;
    private int mType;
    private TeamInfoListBean.ContentBean contentBean;
    private JIXieZulinBean.ContentBean bean;

    public TeamOrJiXieBottomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TeamOrJiXieBottomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View v = LayoutInflater.from(mContext).inflate(R.layout.dia_nead_bottom_layout, this, false);
        addView(v);
        ButterKnife.bind(this, v);
    }

    public TeamOrJiXieBottomView(@NonNull Context context) {
        this(context, null);
    }

    public void setType(int type) {
        mType = type;
        if (mType == 2) {
            mTvLeft1.setText("机械地址：");
            mTvRight2.setText("挖掘机（200型）");
            mTvLeft3.setText("机械数量：");
            mTvRight3.setText("2台");
        }
    }

    public void setTeamBean(TeamInfoListBean.ContentBean contentBean) {
        this.contentBean = contentBean;
        String photo = "";
        if (contentBean.getPhoto() != null)
            photo = contentBean.getPhoto().getUrl();
        GlideUtils.LoadImgCircleCrop(mContext, photo, mIvHeard);
        Log.d("lwp","setTeamBean:"+contentBean.getMembersCount());
        TextUtils.setText(mTvName, contentBean.getTitle());
        TextUtils.setText(mTvScore, contentBean.getStarsLevel() + "");
        TextUtils.setText(mTvStatus, contentBean.getTeamType() == null ? "未认证" : "已认证");
        mIvCall.setClickable(false);
        TextUtils.setText(mTvRight1, contentBean.getDisplayAddress());
        TextUtils.setText(mTvRight2, contentBean.getTeamType() != null ? contentBean.getTeamType().getTitle() : "");
        TextUtils.setText(mTvRight3, contentBean.getMembersCount() + "");
    }

    public void setJixieBean(JIXieZulinBean.ContentBean bean) {
        this.bean = bean;
        GlideApp.with(mContext).load(bean.getImage()).into(mIvHeard);
        Log.d("lwp","setJixieBean:"+bean.getShuoming());
        TextUtils.setText(mTvName, bean.getTitle());
        TextUtils.setText(mTvScore, /*bean.getStarsLevel()*/"5");
        TextUtils.setText(mTvStatus, bean.getType() == null ? "未认证" : "已认证");
        TextUtils.setText(mTvRight1, bean.getStreetAddress());
        TextUtils.setText(mTvRight2, bean.getType() != null ? bean.getType().getText() : "");
        TextUtils.setText(mTvRight3, bean.getShuoming() + "");
    }

    @OnClick(R.id.iv_heard)
    void heardClick() {
        if (mType == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", contentBean.getId());
            Intent intent = new Intent(mContext, TeamDetailActivity.class);
            Log.d("lwp","heardClick:"+mType);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        } else if (mType == 2) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", bean.getId());
            Log.d("lwp","heardClick:"+mType);
            bundle.putInt("type", 1);
            Intent intent = new Intent(mContext, JobDetailActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }

    @OnClick(R.id.iv_call)
    void call() {
        if (mType == 1 && contentBean != null && contentBean.getUserName() != null)
            DialogUtils.showCallPhoneDialog(mContext, contentBean.getUserName(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall((Activity) mContext, contentBean.getUserName());
                }
            });
        else if (mType == 2 && bean != null && bean.getMobile() != null)
            DialogUtils.showCallPhoneDialog(mContext, bean.getMobile(), "拨打", new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    OutAppIntentUtils.openCall((Activity) mContext, bean.getMobile());
                }
            });
    }
}
