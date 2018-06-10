package com.jlkg.jzg.jzg_android.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.OiStringUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindCardActivity extends BaseActivity implements TextWatcher{


    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.edt_cardNumber)
    EditText edtCardNumber;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_card;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tvBank.addTextChangedListener(this);
        edtCardNumber.addTextChangedListener(this);

        if(MyApplication.isCompany){
            if(!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getCardNo())
                    &&!"null".equals(MyApplication.sCompanyLoginBean.getCardNo())) {
                tvBank.setText(MyApplication.sCompanyLoginBean.getCardInfo() + "");
                edtCardNumber.setText(MyApplication.sCompanyLoginBean.getCardNo());
            }
        }else{
            if(!TextUtils.isEmpty(MyApplication.sTeamLoginBean.getBankCardNo())
                    &&!"null".equals(MyApplication.sTeamLoginBean.getBankCardNo())) {
                tvBank.setText(MyApplication.sTeamLoginBean.getBankInfo() + "");
                edtCardNumber.setText(MyApplication.sTeamLoginBean.getBankCardNo());
            }
        }
    }

    @OnClick({R.id.tv_bank, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_bank:
                openActivityForResult(SelectCardActivity.class,1001);
                break;
            case R.id.tv_confirm:
                String cardNumber=edtCardNumber.getText().toString();
                if(OiStringUtils.isBankCard(cardNumber)){
                    HashMap<String,String> hashMap=new HashMap<>();
                    hashMap.put("cardInfo",tvBank.getText().toString());
                    hashMap.put("cardNo",edtCardNumber.getText().toString());
                    if(MyApplication.isCompany){
                        ApiManager.bindCardInfoCompany(hashMap, this, new HttpUtils.OnCallBack() {
                            @Override
                            public void success(String response) {
                                MyApplication.sCompanyLoginBean.setCardNo(edtCardNumber.getText().toString());
                                MyApplication.sCompanyLoginBean.setCardInfo(tvBank.getText().toString());
                                finish();
                            }

                            @Override
                            public void onError(String msg) {
                                toast(msg);
                            }
                        });
                    }else {
                        ApiManager.bindCardInfo(hashMap, this, new HttpUtils.OnCallBack() {
                            @Override
                            public void success(String response) {
                                MyApplication.sTeamLoginBean.setBankCardNo(edtCardNumber.getText().toString());
                                MyApplication.sTeamLoginBean.setBankInfo(tvBank.getText().toString());
                                finish();
                            }

                            @Override
                            public void onError(String msg) {
                                toast(msg);
                            }
                        });
                    }
                }else{
                    showToast("请输入正确的银行卡号！");
                }
                break;
        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
    @Override
    public void afterTextChanged(Editable s) {
        if(!TextUtils.isEmpty(tvBank.getText().toString())
                &&!TextUtils.isEmpty(edtCardNumber.getText().toString())){
            tvConfirm.setEnabled(true);
        }else{
            tvConfirm.setEnabled(false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null){
            return;
        }

        if(requestCode==1001){
            tvBank.setText(data.getStringExtra("bank"));
        }
    }
}
