package com.jlkg.jzg.jzg_android.home.activitys;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.MsgListBean;
import com.jlkg.jzg.jzg_android.utils.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageDetailActivity extends BaseActivity {

    @BindView(R.id.tv_msg_title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private MsgListBean.ContentBean bean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            bean = getIntent().getExtras().getParcelable("bean");
        }
        TextUtils.setText(tvTitle, bean.getTitle());
        TextUtils.setText(tvTime, bean.getNoteDate());
        tvContent.setText(Html.fromHtml(bean.getNotes()));
    }


}
