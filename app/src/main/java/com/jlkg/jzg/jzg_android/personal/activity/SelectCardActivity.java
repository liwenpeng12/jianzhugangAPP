package com.jlkg.jzg.jzg_android.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jlkg.jzg.jzg_android.AppConstants;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.personal.adapter.SelectCardAdatper;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import com.jlkg.jzg.jzg_android.utils.TextUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCardActivity extends BaseActivity {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;


    private SelectCardAdatper selectCardAdatper;
    private  String[] responseArray;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_card;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        selectCardAdatper=new SelectCardAdatper(this,new ArrayList());
        listContent.setAdapter(selectCardAdatper);
        selectCardAdatper.setOnClickListener(new ClickUtils.OnClickListener() {
            @Override
            public void onClick(View v, int type, int pos, int child) {
                switch (type){
                    case AppConstants.CLICK_ITEM:
                        //selectCardAdatper.setSelectPosition(pos);
                        Intent intent=new Intent();
                        intent.putExtra("bank",responseArray[pos]);
                        setResult(1001,intent);
                        finish();
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        ApiManager.getBankName(this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                if(!android.text.TextUtils.isEmpty(response)) {
                    //response = response.replace("[", "").replace("]", "");
                    responseArray= response.split(",");
                    selectCardAdatper.setBankArray(responseArray);
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
