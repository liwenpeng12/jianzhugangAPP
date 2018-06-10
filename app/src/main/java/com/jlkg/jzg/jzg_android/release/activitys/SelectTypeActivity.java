package com.jlkg.jzg.jzg_android.release.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.JixieListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.release.adapters.SelectTypeAdapter;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;
import com.jlkg.jzg.jzg_android.release.beans.TeamListBean;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jlkg.jzg.jzg_android.release.activitys.NeedActivity.PERSONNEED;

/**
 * 招工/租赁选择需求界面
 */
public class SelectTypeActivity extends BaseActivity implements SelectTypeAdapter.OnSelectResult {
    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private int mType;
    private List<SelectTypeBean> mList;
    private List<SelectTypeBean.SelectTypeChildBean> mSelectTypeChildBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_type;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mSelectTypeChildBeanList = NeedActivity.mList;
        mType = getIntent().getExtras().getInt("type");
        mMyToolbar.setTitleText(mType == PERSONNEED ? "选择班组" : "选择分类");
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
    }

    @Override
    protected void initData() {
        super.initData();
        setLoading(true);
        if (mType == PERSONNEED) {
            ApiManager.teamTypesGetList(this,new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    List<TeamListBean> teamListBeans = JSON.parseArray(response, TeamListBean.class);
                    int size = teamListBeans.size();
                    for (int i = 0; i < size; i++) {
                        List<TeamListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                        List<SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                        int childSize = titles.size();
                        for (int j = 0; j < childSize; j++) {
                            SelectTypeBean.SelectTypeChildBean bean = new SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                            if (mSelectTypeChildBeanList != null) {
                                int selectSize = mSelectTypeChildBeanList.size();
                                for (int k = 0; k < selectSize; k++) {
                                    if (Integer.parseInt(bean.getId()) == Integer.parseInt(mSelectTypeChildBeanList.get(k).getId())) {
                                        bean.content = mSelectTypeChildBeanList.get(k).getContent();
                                        bean.isSelect(true);
                                    }
                                }
                            }
                            list.add(bean);
                        }
                        mList.add(new SelectTypeBean(teamListBeans.get(i).getText(), list, teamListBeans.get(i).getId()));
                    }
                    mRecycleView.setAdapter(new SelectTypeAdapter(SelectTypeActivity.this, mList, SelectTypeActivity.this));
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                    showToast(msg);
                }
            });
        } else {
            ApiManager.getDictsCategory(this,new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    List<JixieListBean> teamListBeans = JSON.parseArray(response, JixieListBean.class);
                    int size = teamListBeans.size();
                    for (int i = 0; i < size; i++) {
                        List<JixieListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                        List<SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                        int childSize = titles.size();
                        for (int j = 0; j < childSize; j++) {
                            SelectTypeBean.SelectTypeChildBean bean = new SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                            if (mSelectTypeChildBeanList != null) {
                                int selectSize = mSelectTypeChildBeanList.size();
                                for (int k = 0; k < selectSize; k++) {
                                    if (bean.getId().equals(mSelectTypeChildBeanList.get(k).getId())) {
                                        bean.content = mSelectTypeChildBeanList.get(k).getContent();
                                        bean.isSelect(true);
                                        continue;
                                    }
                                }
                            }
                            list.add(bean);
                        }
                        mList.add(new SelectTypeBean(teamListBeans.get(i).getCategroy(), list, teamListBeans.get(i).getId()));
                    }
                    mRecycleView.setAdapter(new SelectTypeAdapter(SelectTypeActivity.this, mList, SelectTypeActivity.this, NeedActivity.JIXIENEED));
                    setLoading(false);
                }

                @Override
                public void onError(String msg) {
                    setLoading(false);
                    showToast(msg);
                }
            });
        }
    }

    @Override
    public void selectResult(List<SelectTypeBean.SelectTypeChildBean> list) {
        mSelectTypeChildBeanList = list;
        mBtnBottom.setEnabled(list.size() > 0);
    }

    @OnClick(R.id.btn_bottom)
    void commit() {
        NeedActivity.mList = mSelectTypeChildBeanList;
        finish();
    }
}
