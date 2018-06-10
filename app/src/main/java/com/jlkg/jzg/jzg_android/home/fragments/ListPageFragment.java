package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.activitys.ClassActivity;
import com.jlkg.jzg.jzg_android.home.activitys.TeamListActivity;
import com.jlkg.jzg.jzg_android.home.adapters.CompanyListAdapter;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.release.beans.SelectTypeBean;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPageFragment extends BaseFragment implements OnItemClickListener {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private List<SelectTypeBean.SelectTypeChildBean> mList;

    public ListPageFragment() {
    }

    public void setList(List<SelectTypeBean.SelectTypeChildBean> list) {
        mList = list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_page;
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
        if (mRecycleView != null) {
            mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecycleView.setAdapter(new CompanyListAdapter(getActivity(), mList, this));
        }
    }

    @Override
    public void itemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("type", getArguments().getString("type"));
        bundle.putString("id", mList.get(position).getId());
        if (getArguments().getString("type").equals(ClassActivity.TEAMPAGE))
            openActivity(TeamListActivity.class, bundle);
        else openActivity(TeamListActivity.class, bundle);
    }
}
