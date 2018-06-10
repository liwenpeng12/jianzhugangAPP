package com.jlkg.jzg.jzg_android.home.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.adapters.TeamPersonListAdapter;
import com.jlkg.jzg.jzg_android.home.beans.TeamPersonBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamPersonsFragment extends BaseFragment {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private int mId;

    public TeamPersonsFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_team_persons;
    }

    @Override
    protected void initView() {
        super.initView();
        if (getArguments() != null) {
            mId = getArguments().getInt("id");
        }
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void loadHttpData() {
        super.loadHttpData();
        setLoading(true);
        ApiManager.getTeamPerson(mId, getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<TeamPersonBean> list = JSON.parseArray(response, TeamPersonBean.class);
                mRecycleView.setAdapter(new TeamPersonListAdapter(mContext, list, null));
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
            }
        });
    }
}
