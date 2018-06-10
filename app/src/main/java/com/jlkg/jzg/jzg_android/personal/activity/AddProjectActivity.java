package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.beans.CityBean1;
import com.jlkg.jzg.jzg_android.other.event.AddProjectEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.widget.MyDatePopupWindow;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.AddressPicker;

public class AddProjectActivity extends BaseActivity implements TextWatcher {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_describe)
    EditText edtDescribe;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.edt_person)
    EditText edtPerson;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.tv_startTime)
    TextView tvStartTime;
    @BindView(R.id.tv_endTime)
    TextView tvEndTime;
    private AddressPicker addressPicker;
    private ArrayList<String> listStatus = new ArrayList<>();
    private JSONArray jsonArrayAddress;
    private String districtId;
    private MyDatePopupWindow myDatePopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_project;
    }

    @Override
    protected void initViews() {
        super.initViews();
        initCityList();
        edtName.addTextChangedListener(this);
        tvLocation.addTextChangedListener(this);
        edtAddress.addTextChangedListener(this);
        edtPerson.addTextChangedListener(this);
        edtPhone.addTextChangedListener(this);

        listStatus.add("未完工");
        listStatus.add("建设中");
        listStatus.add("已完工");

    }

    //设置城市数据
    private void initCityList() {
        ApiManager.getAllList(this,new HttpUtils.OnCallBack<List<CityBean1>>() {
            @Override
            public void success(String str) {
                try {
                    jsonArrayAddress = new JSONArray(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                ToastUtils.showShort("获取城市信息失败");
            }
        });
    }

    @OnClick({R.id.tv_location, R.id.tv_save, R.id.tv_status, R.id.tv_startTime, R.id.tv_endTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                if(jsonArrayAddress==null){
                    toast("正在获取城市");
                    return;
                }
                DialogUtils.getAddressDialog(this,jsonArrayAddress, new AddressPicker.OnAddressPickListener() {
                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
                        //tvLocation.setText(province.getAreaName() + city.getAreaName()+county.getAreaName());
                        tvLocation.setText(province.getAreaName() + city.getAreaName());

                        districtId = city.getAreaId();
                    }
                });
                break;
            case R.id.tv_save:
                HashMap<String, String> hashMap = new HashMap<>();
                //  hashMap.put("project.id","");
                switch (tvStatus.getText().toString()) {
                    case "未完工":
                        hashMap.put("buildingStatus.id", "PROJECT_CONSTRUCT");
                        break;
                    case "建设中":
                        hashMap.put("buildingStatus.id", "PROJECT_BUILDING");
                        break;
                    case "已完工":
                        hashMap.put("buildingStatus.id", "PROJECT_COMPLETED");
                        break;
                }

                hashMap.put("name", edtName.getText().toString());
                hashMap.put("company.id", MyApplication.sCompanyLoginBean.getId() + "");
                hashMap.put("description", edtDescribe.getText().toString());
                hashMap.put("streetAddress", edtAddress.getText().toString());
                hashMap.put("district.id", districtId);

                if(!TextUtils.isEmpty(tvStartTime.getText().toString())) {
                    hashMap.put("startTime", tvStartTime.getText().toString() + " 00:00:00");
                }

                if(!TextUtils.isEmpty(tvEndTime.getText().toString())) {
                    hashMap.put("endTime", tvEndTime.getText().toString() + " 00:00:00");
                }

                hashMap.put("contacts",edtPerson.getText().toString());
                hashMap.put("contactsPhone",edtPhone.getText().toString());

                ApiManager.addProjects(hashMap, this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        //刷新组织架构的项目
                        AddProjectEvent addProjectEvent = new AddProjectEvent();
                        EventBus.getDefault().post(addProjectEvent);
                        finish();
                    }

                    @Override
                    public void onError(String msg) {
                        toast(msg);
                    }
                });

                break;

            case R.id.tv_status:
                DialogUtils.showReasonDialog(this, listStatus, new DialogUtils.OnReasonListener01() {
                    @Override
                    public void onReason(String str) {
                        tvStatus.setText(str);
                    }

                    @Override
                    public void onReasonPos(int pos) {

                    }
                });
                break;
            case R.id.tv_startTime:
                if(myDatePopupWindow==null) {
                    myDatePopupWindow = new MyDatePopupWindow(this, tvEndTime);

                }else{
                    myDatePopupWindow.showAtLocation(tvEndTime, Gravity.BOTTOM, 0, 0);
                }

                myDatePopupWindow.setOnSelectDateContent(new MyDatePopupWindow.OnSelectDateContent() {
                    @Override
                    public void getDate(String year, String month, String day) {

                        tvStartTime.setText(year + "-" + month + "-" + day);
                    }
                });
                break;
            case R.id.tv_endTime:
                if(myDatePopupWindow==null) {
                    myDatePopupWindow = new MyDatePopupWindow(this, tvEndTime);

                }else{
                    myDatePopupWindow.showAtLocation(tvEndTime, Gravity.BOTTOM, 0, 0);
                }
                myDatePopupWindow.setOnSelectDateContent(new MyDatePopupWindow.OnSelectDateContent() {
                    @Override
                    public void getDate(String year, String month, String day) {

                        tvEndTime.setText(year + "-" + month + "-" + day);
                    }
                });
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
        if (!TextUtils.isEmpty(edtName.getText().toString()) && !TextUtils.isEmpty(tvLocation.getText().toString())
                && !TextUtils.isEmpty(edtAddress.getText().toString()) && !TextUtils.isEmpty(tvStatus.getText().toString())
                &&!TextUtils.isEmpty(edtPerson.getText().toString())&&!TextUtils.isEmpty(edtPhone.getText().toString())) {
            tvSave.setEnabled(true);
        } else {
            tvSave.setEnabled(false);
        }
    }
}
