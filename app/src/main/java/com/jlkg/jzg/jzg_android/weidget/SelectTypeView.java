package com.jlkg.jzg.jzg_android.weidget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.jlkg.jzg.baselibrary.utils.SizeUtils;
import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.home.beans.CityBean1;
import com.jlkg.jzg.jzg_android.home.beans.JixieListBean;
import com.jlkg.jzg.jzg_android.home.beans.SelectTypeBean;
import com.jlkg.jzg.jzg_android.other.inter.StringDataInterface;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.release.beans.TeamListBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:类型选中，其中包含对popupwindow的操作
 */

public class SelectTypeView extends FrameLayout implements View.OnClickListener, MapUtils.OnLocationResultListener {
    @BindView(R.id.fl_1)
    FrameLayout mFl1;
    @BindView(R.id.fl_2)
    FrameLayout mFl2;
    @BindView(R.id.fl_3)
    FrameLayout mFl3;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.tv_3)
    TextView mTv3;
    @BindView(R.id.line)
    View mLine;
    private PopupWindow mWindow;
    private TextView mNowSelectTextView;
    private Context mContext;
    private List<StringDataInterface> mLeftList, mRightList;
    private RecyclerView mLeftRecycleView, mRightRecycleView;
    private List<StringDataInterface> mAllType;
    private List<StringDataInterface> mScoreList;
    private List<StringDataInterface> mProvincesBeans;
    private String locationCity;
    private OnSelectResultListener mListener;
    private int mType;
    private int popupWidth;
    private int popupHeight;

    public SelectTypeView(@NonNull Context context) {
        this(context, null);
    }

    public SelectTypeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectTypeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
//        initList();
        View v = LayoutInflater.from(context).inflate(R.layout.view_select_type_layout, this, false);
        addView(v);
        ButterKnife.bind(this, v);
        Activity activity = (Activity) context;
        activity.getWindow().getDecorView().getRootView().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWindow == null && mWindow.isShowing()) {
                    mWindow.dismiss();
                }
            }
        });
    }

    @SuppressLint("ResourceType")
    public void setType(int type, OnSelectResultListener listener) {
        mListener = listener;
        mType = type;
        if (type == 1) {
            MapUtils.getInstance().startLocation(mContext, this);
        } else if (type == 2) {
            mTv1.setText("机械分类");
            MapUtils.getInstance().startLocation(mContext, this);
        } else if (type == 3) {
            mFl2.setVisibility(INVISIBLE);
            mFl3.setVisibility(INVISIBLE);
            mTv1.setText("全部分类");
            LayoutParams params = (LayoutParams) mTv1.getLayoutParams();
            params.gravity = Gravity.LEFT;
            params.leftMargin = SizeUtils.dp2px(15);
            mTv1.setLayoutParams(params);
        } else if (type == 4) {
            mFl1.setVisibility(GONE);
            mTv3.setText("全部分类");
        } else if (type == 5) {
            mFl1.setVisibility(GONE);
            mTv3.setText("全部分类");
        } else if (type == 6) {
            mFl1.setVisibility(GONE);
            mFl3.setVisibility(GONE);
            mLine.setVisibility(GONE);
            getChildAt(0).setBackgroundResource(getResources().getColor(R.color.transparent));
            MapUtils.getInstance().startLocation(mContext, this);
        }
        initList();
    }

    private void initList() {
        if (mType == 1) {
            initTeamList();
            initScoreList();
            initCityList();
        } else if (mType == 2) {
            initJiXieList();
            initScoreList();
            initCityList();
        } else if (mType == 3) {
            initJiXieList();
            mFl2.setVisibility(INVISIBLE);
            mFl3.setVisibility(INVISIBLE);
            mTv1.setText("全部分类");
            LayoutParams params = (LayoutParams) mTv1.getLayoutParams();
            params.gravity = Gravity.LEFT;
            params.leftMargin = SizeUtils.dp2px(15);
            mTv1.setLayoutParams(params);
        } else if (mType == 4) {
            initCityList();
            initTeamList();
            mFl1.setVisibility(GONE);
            mTv3.setText("全部分类");
        } else if (mType == 5) {
            initJiXieList();
            initCityList();
            mFl1.setVisibility(GONE);
            mTv3.setText("全部分类");
        } else if (mType == 6) {
            initCityList();
        } else {
            initTeamList();
            initCityList();
            initScoreList();
        }
    }

    private void initJiXieList() {
        mAllType = new ArrayList<>();
        ApiManager.getDictsCategory(mContext,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<JixieListBean> teamListBeans = JSON.parseArray(response, JixieListBean.class);
                int size = teamListBeans.size();
                for (int i = 0; i < size; i++) {
                    List<JixieListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                    List<com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                    int childSize = titles.size();
                    for (int j = 0; j < childSize; j++) {
                        com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean bean = new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                        list.add(bean);
                    }
                    mAllType.add(new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean(teamListBeans.get(i).getCategroy(), list, teamListBeans.get(i).getId()));
                }
                mAllType.get(0).isSelect(true);
            }

            @Override
            public void onError(String msg) {
            }
        });
    }


    //设置城市数据
    private void initCityList() {
        ApiManager.getAllList(mContext,new HttpUtils.OnCallBack<List<CityBean1>>() {
            @Override
            public void success(String str) {
                List<CityBean1> list = JSON.parseArray(str, CityBean1.class);
                mProvincesBeans = new ArrayList<>();
                if (mType != 6) {
                    CityBean1 bean1 = new CityBean1();
                    bean1.setProvince("全部");
                    bean1.setId("");
                    mProvincesBeans.add(bean1);
                }
                mProvincesBeans.addAll(list);
                mProvincesBeans.get(0).isSelect(true);
                if (mType == 6 || mType == 1 || mType == 2)
                    getLocationCityInfo();
            }

            @Override
            public void onError(String msg) {
                ToastUtils.showShort("获取城市信息失败");
            }
        });
    }

    //设置星级数据
    private void initScoreList() {
        mScoreList = new ArrayList<>();
        String scores[] = mContext.getResources().getStringArray(R.array.scorStrings);
        for (int i = 0; i < scores.length; i++) {
            if (i == 0)
                mScoreList.add(new SelectTypeBean(scores[i], "", null));
            else
                mScoreList.add(new SelectTypeBean(scores[i], 6-i + "", null));
            mScoreList.get(0).isSelect(true);
        }
    }


    //设置班组全部类型
    private void initTeamList() {
        mAllType = new ArrayList<>();
        ApiManager.teamTypesGetList(mContext,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<TeamListBean> teamListBeans = JSON.parseArray(response, TeamListBean.class);
                if (mType == 4) {
                    List<com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean> list1 = new ArrayList<>();
                    list1.add(new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean("全部", false, ""));
                    com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean bean1 = new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean("全部", list1, "");
                    mAllType.add(bean1);
                }
                int size = teamListBeans.size();
                for (int i = 0; i < size; i++) {
                    List<TeamListBean.TitlesBean> titles = teamListBeans.get(i).getTitles();
                    List<com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean> list = new ArrayList<>();
                    int childSize = titles.size();
                    for (int j = 0; j < childSize; j++) {
                        com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean bean = new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean.SelectTypeChildBean(titles.get(j).getTitle(), false, titles.get(j).getId() + "");
                        list.add(bean);
                    }
                    mAllType.add(new com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean(teamListBeans.get(i).getText(), list, teamListBeans.get(i).getId()));
                }
                mAllType.get(0).isSelect(true);
            }

            @Override
            public void onError(String msg) {
            }
        });
    }

    @OnClick({R.id.fl_1, R.id.fl_2, R.id.fl_3})
    void click(View v) {
        switch (v.getId()) {
            case R.id.fl_1:
                if (mNowSelectTextView == mTv1) break;
                mNowSelectTextView = mTv1;
                mLeftList = mAllType;
                mRightList = mAllType.get(0).getList();
                break;
            case R.id.fl_2:
                if (mNowSelectTextView == mTv2) break;
                mNowSelectTextView = mTv2;
                mLeftList = mProvincesBeans;
                mRightList = mLeftList.get(0).getList();
                break;
            case R.id.fl_3:
                if (mNowSelectTextView == mTv3) break;
                if (mType == 4 || mType == 5) {
                    mLeftList = mAllType;
                    mRightList = mAllType.get(0).getList();
                } else {
                    mRightList = mScoreList;
                }
                mNowSelectTextView = mTv3;
                break;
        }
        if (!mNowSelectTextView.isSelected()) {
            if (mWindow == null) {
                setPopupWindow(mContext);
            }
            if (mWindow.isShowing()) {
                mWindow.dismiss();
            } else {
                /*//获取自身的长宽高
                int[] location = new int[2];
                v.getLocationOnScreen(location);
                //在控件上方显示
                mWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0]) - popupWidth / 2, location[1] - popupHeight);*/
                if (Build.VERSION.SDK_INT != 24) {
                    //只有24这个版本有问题，好像是源码的问题
                    mWindow.showAsDropDown(this);
                } else {
                    //7.0 showAsDropDown没卵子用 得这么写
                    int[] location = new int[2];
                    this.getLocationOnScreen(location);
                    int x = location[0];
                    int y = location[1];
                    mWindow.showAtLocation(this, Gravity.NO_GRAVITY, 0, y + this.getHeight());
                }
            }
            mLeftRecycleView.setVisibility(v.getId() == R.id.fl_1 || v.getId() == R.id.fl_2 || mType == 4 || mType == 5 ? VISIBLE : GONE);
            mLeftRecycleView.getAdapter().notifyDataSetChanged();
            mRightRecycleView.getAdapter().notifyDataSetChanged();
        } else {
            mWindow.dismiss();
        }
        mNowSelectTextView.setSelected(!mNowSelectTextView.isSelected());
    }

    private void setPopupWindow(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.pop_select_type_layout, null, false);
        mLeftRecycleView = v.findViewById(R.id.recycle_view_left);
        mRightRecycleView = v.findViewById(R.id.recycle_view_right);
        mLeftRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        mRightRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        mLeftRecycleView.setAdapter(new LeftAdapter());
        mRightRecycleView.setAdapter(new RightAdapter());
        mWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.findViewById(R.id.view).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindow.dismiss();
            }
        });
        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mNowSelectTextView.setSelected(false);
            }
        });
        mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mWindow.setOutsideTouchable(true);
        mWindow.setFocusable(true);
        v.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupHeight = v.getMeasuredHeight();
        popupWidth = v.getMeasuredWidth();
//        mWindow.showAsDropDown(this, 0, 0);
    }

    @Override
    public void onClick(View v) {
        if (mWindow != null && mWindow.isShowing()) {
            mWindow.dismiss();
        }
    }

    public PopupWindow getWindow() {
        return mWindow;
    }

    @Override
    public void locationResultListener(BDLocation location, int errorCode) {
        locationCity = MapUtils.getInstance().getLocationCity();
        getLocationCityInfo();
    }

    public void getLocationCityInfo() {
        if (TextUtils.isEmpty(locationCity) || mProvincesBeans == null) {
            return;
        }
        int size = mProvincesBeans.size();
        for (int i = 0; i < size; i++) {
            List<StringDataInterface> list = mProvincesBeans.get(i).getList();
            if (list == null) continue;
            int childSize = list.size();
            for (int j = 0; j < childSize; j++) {
                if (list.get(j).getText().contains(locationCity)) {
                    list.get(j).isSelect(true);
                    mProvincesBeans.get(0).isSelect(false);
                    mProvincesBeans.get(i).isSelect(true);
                    mFistId = mProvincesBeans.get(i).getId();
                    if (mType == 6 || mType == 1 || mType == 2) mTv2.setText(list.get(j).getText());
                    if (mType == 1 || mType == 2)
                        mListener.onSelectResultListener(2, list.get(j).getId());
                    else
                        mListener.onSelectResultListener(1, list.get(j).getId());
                    return;
                }
            }
        }
    }

    public String getFistTextString() {
        return mTv1.getText().toString();
    }

    public String getSelectCity() {
        return mTv2.getText().toString();
    }

    private String mFistId = "";

    public String getFistId() {
        return mFistId;
    }

    class LeftAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_pop_select_type_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, final int position) {
            holder.mTvItem.setText(mLeftList.get(position).getText());
            holder.mLine.setVisibility(getItemCount() - 1 == position ? INVISIBLE : VISIBLE);
            holder.mTvItem.setSelected(mLeftList.get(position).isSelect());
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int size = mLeftList.size();
                    for (int i = 0; i < size; i++) {
                        mLeftList.get(i).isSelect(false);
                    }
                    mRightList = mLeftList.get(position).getList();
                    mLeftList.get(position).isSelect(true);
                    mFistId = mLeftList.get(position).getId();
                    notifyDataSetChanged();
                    mRightRecycleView.getAdapter().notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mLeftList.size();
        }
    }

    class RightAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        public StringDataInterface mInterface;

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_pop_select_type_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, final int position) {
            holder.mTvItem.setText(mRightList.get(position).getText());
            holder.mLine.setVisibility(getItemCount() - 1 == position ? INVISIBLE : VISIBLE);
            holder.mTvItem.setSelected(mRightList.get(position).isSelect());
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int size = mRightList.size();
                   /* for (int i = 0; i < size; i++) {
                        mRightList.get(i).isSelect(false);
                    }*/
                    if (mInterface != null) mInterface.isSelect(false);
                    mRightList.get(position).isSelect(true);
                    mInterface = mRightList.get(position);
                    notifyDataSetChanged();
                    if (mListener != null) {
                        mNowSelectTextView.setText(mRightList.get(position).getText());
                        if (mNowSelectTextView.getId() == R.id.tv_1)
                            mListener.onSelectResultListener(1, mRightList.get(position).getId());
                        else if (mNowSelectTextView.getId() == R.id.tv_2)
                            mListener.onSelectResultListener(2, mRightList.get(position).getId());
                        else if (mNowSelectTextView.getId() == R.id.tv_3)
                            mListener.onSelectResultListener(3, mRightList.get(position).getId());
                    }
                    postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mWindow.dismiss();
                        }
                    }, 100);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mRightList.size();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item)
        TextView mTvItem;
        @BindView(R.id.line)
        View mLine;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnSelectResultListener {
        void onSelectResultListener(int type, String str);
    }
}
