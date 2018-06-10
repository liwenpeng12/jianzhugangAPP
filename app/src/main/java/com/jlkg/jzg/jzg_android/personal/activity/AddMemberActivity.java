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
import com.jlkg.jzg.jzg_android.personal.event.AddMemberRefreshEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMemberActivity extends BaseActivity implements TextWatcher {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_bankName)
    TextView tvBankName;
    @BindView(R.id.et_cardNumber)
    EditText etCardNumber;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.et_idNumber)
    EditText etIdNumber;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_member;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_bankName, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_bankName:
                openActivityForResult(SelectCardActivity.class, 1001);
                break;
            case R.id.tv_confirm:
                if (!OiStringUtils.isMobile(etPhone.getText().toString())) {
                    showToast("请输入正确的手机号！");
                }else if(etIdNumber.getText().toString().length()<18){
                    showToast("请输入正确的身份证！");
                } else if (!OiStringUtils.isBankCard(etCardNumber.getText().toString())) {
                    showToast("请输入正确的银行卡号！");
                } else {

                    HashMap<String, String> hashMap = new HashMap<>();
                    Bundle bundle=getIntent().getExtras();
                    if(bundle==null) {
                        hashMap.put("accountId", MyApplication.sTeamLoginBean.getId() + "");
                        hashMap.put("team.id", MyApplication.sTeamLoginBean.getId() + "");
                    }else{
                        hashMap.put("accountId", bundle.getString("teamId"));
                        hashMap.put("team.id",bundle.getString("teamId"));
                    }
                    hashMap.put("title", etName.getText().toString());
                    hashMap.put("phone", etPhone.getText().toString());
                    hashMap.put("bankName", tvBankName.getText().toString());
                    hashMap.put("cardNumber", etCardNumber.getText().toString());
                    hashMap.put("idNumber",etIdNumber.getText().toString());
                    ApiManager.addTeamMember(hashMap, this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            AddMemberRefreshEvent addMemberRefreshEvent = new AddMemberRefreshEvent();
                            EventBus.getDefault().post(addMemberRefreshEvent);
                            finish();
                        }

                        @Override
                        public void onError(String msg) {
                            toast(msg);
                        }
                    });
                    // finish();
                }
                break;
        }
    }


    @Override
    protected void initViews() {
        super.initViews();
        etName.addTextChangedListener(this);
        etPhone.addTextChangedListener(this);
        tvBankName.addTextChangedListener(this);
        etCardNumber.addTextChangedListener(this);
        etIdNumber.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    @Override
    public void afterTextChanged(Editable s) {
        if (!TextUtils.isEmpty(etName.getText().toString()) &&
                !TextUtils.isEmpty(etPhone.getText().toString()) &&
                !TextUtils.isEmpty(tvBankName.getText().toString()) &&
                !TextUtils.isEmpty(etCardNumber.getText().toString())&&
                !TextUtils.isEmpty(etIdNumber.getText().toString())) {
            tvConfirm.setEnabled(true);
        } else {
            tvConfirm.setEnabled(false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            tvBankName.setText(data.getStringExtra("bank"));
        }
    }
}
