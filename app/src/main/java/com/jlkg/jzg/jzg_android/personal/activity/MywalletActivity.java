package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MywalletActivity extends BaseActivity {


    @BindView(R.id.ll_tradingRecord)
    LinearLayout llTradingRecord;
    @BindView(R.id.ll_wallet)
    LinearLayout llWallet;
    @BindView(R.id.ll_balance)
    LinearLayout llBalance;
    @BindView(R.id.ll_blanCard)
    LinearLayout llBlanCard;
    @BindView(R.id.tv_bindCard)
    TextView tvBindCard;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mywallet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        if (MyApplication.isCompany) {
            //if(MyApplication.sCompanyLoginBean.get)
            if (!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getCardNo())) {
                if (!"null".equals(MyApplication.sCompanyLoginBean.getCardNo())) {
                    tvBindCard.setText("已绑定");
                }
            }
        } else {

            if (!TextUtils.isEmpty(MyApplication.sTeamLoginBean.getBankCardNo())) {
                if (!"null".equals(MyApplication.sTeamLoginBean.getBankCardNo())) {
                    tvBindCard.setText("已绑定");
                }
            }

        }
    }

    @OnClick({R.id.ll_balance, R.id.ll_blanCard, R.id.ll_tradingRecord, R.id.ll_wallet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_balance:
                openActivity(BalanceActivity.class);
                break;
            case R.id.ll_blanCard:
                openActivity(BindCardActivity.class);
                break;
            case R.id.ll_tradingRecord:
                openActivity(TradingRecordActivity.class);
                break;
            case R.id.ll_wallet:
                break;
        }
    }
}
