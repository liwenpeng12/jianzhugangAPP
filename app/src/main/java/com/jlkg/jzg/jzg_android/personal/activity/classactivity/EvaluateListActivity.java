package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.beans.TeamRateReviewBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.personal.adapter.EvaluateListAdapter;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EvaluateListActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;

    private EvaluateListAdapter evaluateListAdapter;
    private ViewHolder viewHolder;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_evaluate_list;
    }

    @Override
    protected void initViews() {
        super.initViews();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);

        View view = LayoutInflater.from(this).inflate(R.layout.evaluate_heard, listContent, false);
        viewHolder=new ViewHolder(view);
        viewHolder.ratingIntegrity.setRating(5f);
        viewHolder.ratingQuality.setRating(5f);
        viewHolder.ratingSafety.setRating(5f);
        viewHolder.ratingSchedule.setRating(5f);
        evaluateListAdapter=new EvaluateListAdapter(this,new ArrayList<String>());
        evaluateListAdapter.setViewHOlder(viewHolder);
        listContent.setAdapter(evaluateListAdapter);
        getData();
    }

    public void getData(){
        setLoading(true);
        ApiManager.teamRateStar(MyApplication.sTeamLoginBean.getId()+"", this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                try {
                    JSONObject jsonObject=JSON.parseObject(response);
                    viewHolder.ratingSafety.setRating(jsonObject.getFloat("safeRating"));
                    viewHolder.ratingSchedule.setRating(jsonObject.getFloat("progressRating"));
                    viewHolder.ratingQuality.setRating(jsonObject.getFloat("qualityRating"));
                    viewHolder.ratingIntegrity.setRating(jsonObject.getFloat("creditRating"));
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String msg) {

            }
        });

        ApiManager.teamRateReview(MyApplication.sTeamLoginBean.getId(),this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<TeamRateReviewBean> list = JSON.parseArray(response, TeamRateReviewBean.class);
                evaluateListAdapter.setTeamRateReviewBeans(list);
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                toast(msg);
                setLoading(false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rating_schedule)
        android.widget.RatingBar ratingSchedule;
        @BindView(R.id.rating_quality)
        android.widget.RatingBar ratingQuality;
        @BindView(R.id.rating_safety)
        android.widget.RatingBar ratingSafety;
        @BindView(R.id.rating_integrity)
        android.widget.RatingBar ratingIntegrity;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
