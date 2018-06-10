package com.jlkg.jzg.jzg_android.release.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.release.adapters.NeedAdapter;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 招工/招租需求
 */
public class NeedActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.btn)
    Button mBtn;
    public static final int PERSONNEED = 1;//人员需求
    public static final int JIXIENEED = 2;//机械需求
    private int mType;
    public static List<SelectTypeBean.SelectTypeChildBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_need;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mType = getIntent().getExtras().getInt("type");
        mMyToolbar.setTitleText(mType == PERSONNEED ? "人员需求" : "机械需求");
        mBtn.setText(mType == PERSONNEED ? "+选择班组" : "+选择分类");
        mBtn.setTextColor(mType == PERSONNEED ? getResources().getColor(R.color.text_blue_color) : getResources().getColor(R.color.text_green_color));
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        if (mList == null)
            mList = new ArrayList<>();
//        mRecycleView.setAdapter(new NeedAdapter(this, mList, mType));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecycleView.setAdapter(new NeedAdapter(this, mList, mType));
    }

    @OnClick(R.id.btn_bottom)
    void commit() {
        if (mList.size() < 1) {
            toast("请选择需求");
            return;
        }
        for (int i = 0; i < mList.size(); i++) {
            SelectTypeBean.SelectTypeChildBean bean = mList.get(i);
            if (TextUtils.isEmpty(bean.content)) {
                toast("信息未填写完整");
                return;
            }
        }
        StringBuilder builder = new StringBuilder();
        StringBuilder typeBuild = new StringBuilder();
        StringBuilder numBuild = new StringBuilder();
        for (int i = 0; i < mList.size(); i++) {
            SelectTypeBean.SelectTypeChildBean bean = mList.get(i);
            if (i == mList.size() - 1) {
                builder.append(bean.type).append(bean.content);
                typeBuild.append(bean.id);
                numBuild.append(bean.content);
                if (mType == NeedActivity.PERSONNEED) builder.append("人");
                break;
            }
            builder.append(bean.type).append(bean.content);
            typeBuild.append(bean.id).append(",");
            numBuild.append(bean.content).append(",");
            if (mType == NeedActivity.PERSONNEED) builder.append("人");
            builder.append(",");
        }
        Intent intent = new Intent();
        intent.putExtra("need", builder.toString());
        intent.putExtra("type", typeBuild.toString());
        intent.putExtra("num", numBuild.toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @OnClick(R.id.btn)
    void select() {
        Bundle bundle = new Bundle();
        bundle.putInt("type", mType);
        openActivity(SelectTypeActivity.class, bundle);
    }
}
