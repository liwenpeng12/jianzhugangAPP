package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.CompanyTypeListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.event.LabourRefreshEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddLabourActivity extends BaseActivity implements TextWatcher {


    @BindView(R.id.edt_companyName)
    EditText edtCompanyName;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_describe)
    EditText edtDescribe;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_companyType)
    TextView tvCompanyType;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;
    @BindView(R.id.edt_userName)
    EditText edtUserName;
    @BindView(R.id.edt_psw)
    EditText edtPsw;

    private List<String> stringList = new ArrayList<>();
    private List<String> stringCompanyId=new ArrayList<>();
    private List<CompanyTypeListBean> list;
    private String selectCompanyId;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_labour;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        edtCompanyName.addTextChangedListener(this);
        edtName.addTextChangedListener(this);
        edtPhone.addTextChangedListener(this);
        tvCompanyType.addTextChangedListener(this);
        edtUserName.addTextChangedListener(this);
        bundle = getIntent().getExtras();
        final int type = bundle.getInt("type");
        setLoading(true);
        ApiManager.getCompanyType(this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                list = JSON.parseArray(response, CompanyTypeListBean.class);
                if(list!=null){
                    for(int i=0;i<list.size();i++){
                        if(type==3) {
                            if("COMPANY_TYPE_2".equals(list.get(i).getId())){
                                continue;
                            }
                        }
                            stringList.add(list.get(i).getTitle());
                            stringCompanyId.add(list.get(i).getId());

                    }
                }
            }

            @Override
            public void onError(String msg) {
                setLoading(false);

            }
        });
        if (type == 1) {
            //添加子公司 可以添加劳务公司
        }else if(type==3){
            //不能添加劳务公司
            myToolbar.setTitleText("添加子公司");

        }  else{
            //添加劳务公司
            tvCompanyType.setEnabled(false);
            tvCompanyType.setText("劳务公司");
            myToolbar.setTitleText("添加劳务公司");
            selectCompanyId="COMPANY_TYPE_2";
        }

    }


    public void addLabour() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title", edtCompanyName.getText().toString());
//        hashMap.put("contacts", edtName.getText().toString());
//        hashMap.put("phone", edtPhone.getText().toString());
        hashMap.put("userName", edtUserName.getText().toString());
        if(!TextUtils.isEmpty(edtPsw.getText().toString())){
            if(edtPsw.getText().toString().length()>=6){
                hashMap.put("password", edtPsw.getText().toString());
            }else {
                toast("密码长度是6~18位");
                return;
            }
        }
//        if ("建筑公司".equals(tvCompanyType.getText().toString())) {
//            hashMap.put("companyType.id", "COMPANY_TYPE_1");
//        } else {
//            hashMap.put("companyType.id", "COMPANY_TYPE_2");
//        }
        hashMap.put("companyType.id",selectCompanyId);

        hashMap.put("parentCompany.id",bundle.getString("companyId"));
       // hashMap.put("notes", edtDescribe.getText().toString());
        setLoading(true);
        ApiManager.addLabour(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                LabourRefreshEvent labourRefreshEvent = new LabourRefreshEvent();
                EventBus.getDefault().post(labourRefreshEvent);
                finish();
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                toast(msg);
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    @Override
    public void afterTextChanged(Editable s) {
        if (!TextUtils.isEmpty(edtCompanyName.getText().toString())
                && !TextUtils.isEmpty(tvCompanyType.getText().toString())
                && !TextUtils.isEmpty(edtUserName.getText().toString())) {
            tvSave.setEnabled(true);
        } else {
            tvSave.setEnabled(false);
        }
    }

    @OnClick({R.id.tv_companyType, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_companyType:
                if(stringList!=null&&stringList.size()>0) {
                    DialogUtils.showReasonDialog(this, stringList, new DialogUtils.OnReasonListener01() {
                        @Override
                        public void onReason(String str) {
                            tvCompanyType.setText(str);
                        }

                        @Override
                        public void onReasonPos(int pos) {
                            selectCompanyId=stringCompanyId.get(pos);
                        }
                    });
                }else{
                    toast("未获取到公司列表");
                }
                break;
            case R.id.tv_save:
                addLabour();
//
//                if (OiStringUtils.isMobile(edtPhone.getText().toString())) {
//                    //finish();
//                   // addLabour();
//                } else {
//                    showToast("请输入正确的手机号！");
//                }
                break;
        }
    }


}
