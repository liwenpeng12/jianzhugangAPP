package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.jlkg.jzg.jzg_android.other.utils.TimeUtils;
import com.jlkg.jzg.jzg_android.other.widget.MyDatePopupWindow;
import com.jlkg.jzg.jzg_android.personal.bean.OrganizationBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.io.Serializable;
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

public class ProjectDetailsActivity extends BaseActivity {


    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_person)
    EditText edtPerson;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_describe)
    EditText edtDescribe;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_startTime)
    TextView tvStartTime;
    @BindView(R.id.tv_endTime)
    TextView tvEndTime;
    private ArrayList<String> listStatus = new ArrayList<>();
    private MyDatePopupWindow myDatePopupWindow;
    private OrganizationBean organizationBean;
    private org.json.JSONArray jsonArrayAddress;
    private AddressPicker addressPicker;
    private String districtId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_project_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
        initCityList();
    }


    //设置城市数据
    private void initCityList() {
        ApiManager.getAllList(this,new HttpUtils.OnCallBack<List<CityBean1>>() {
            @Override
            public void success(String str) {
                try {
                    jsonArrayAddress=new org.json.JSONArray(str);
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


    public void initView() {
        listStatus.add("未完工");
        listStatus.add("建设中");
        listStatus.add("已完工");


        Serializable serializable = getIntent().getExtras().getSerializable("data");
        if (serializable == null) {
            return;
        }

        organizationBean = (OrganizationBean) serializable;
        if(organizationBean.district!=null){
            districtId=organizationBean.district.id+"";
        }
        myToolbar.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edtName.getText().toString()) && !TextUtils.isEmpty(tvLocation.getText().toString())
                        && !TextUtils.isEmpty(edtAddress.getText().toString()) && !TextUtils.isEmpty(tvStatus.getText().toString())) {
                    System.out.println("=========="+TimeUtils.getTimeLong(tvStartTime.getText().toString()+" 23:59:59")+"=========="+TimeUtils.getTimeLong(tvEndTime.getText().toString()+" 23:59:59"));
                    if(!TextUtils.isEmpty(tvStartTime.getText().toString())&&!TextUtils.isEmpty(tvEndTime.getText().toString())){
                        if(TimeUtils.getTimeLong(tvStartTime.getText().toString()+" 23:59:59")>TimeUtils.getTimeLong(tvEndTime.getText().toString()+" 23:59:59")){
                            toast("结束时间必须在开始时间之后！");
                            return;
                        }
                    }

                    HashMap<String,String> hashMap=new HashMap<>();
                    hashMap.put("id",organizationBean.id+"");
                    switch (tvStatus.getText().toString()) {
                        case "未完工":
                            hashMap.put("buildingStatus.id", "PROJECT_CONSTRUCT");
                            break;
                        case "建设中":
                            hashMap.put("buildingStatus.id","PROJECT_BUILDING");
                            break;
                        case "已完工":
                            hashMap.put("buildingStatus.id","PROJECT_COMPLETED");
                            break;
                    }
                    if(!TextUtils.isEmpty(tvStartTime.getText().toString())) {
                        hashMap.put("startTime", tvStartTime.getText().toString() + " 00:00:00");
                    }

                    if(!TextUtils.isEmpty(tvEndTime.getText().toString())) {
                        hashMap.put("endTime", tvEndTime.getText().toString() + " 00:00:00");
                    }

                    hashMap.put("contacts",edtPerson.getText().toString());
                    hashMap.put("contactsPhone",edtPhone.getText().toString());
//                    hashMap.put("updateTime","");
//                    hashMap.put("createTime","");
                    hashMap.put("name",edtName.getText().toString());
                    hashMap.put("company.id", MyApplication.sCompanyLoginBean.getId()+"");
                    hashMap.put("description",edtDescribe.getText().toString());
                    hashMap.put("streetAddress",edtAddress.getText().toString());
                    hashMap.put("district.id",districtId);
                    ApiManager.uploadProjectsInfo(hashMap,this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            AddProjectEvent addProjectEvent=new AddProjectEvent();
                            EventBus.getDefault().post(addProjectEvent);
                            finish();
                        }

                        @Override
                        public void onError(String msg) {
                            toast(msg);
                        }
                    });
                } else {
                    toast("请填写完整信息！");
                }
            }
        });
        edtName.setText(organizationBean.name);
        edtPerson.setText(organizationBean.contacts);
        edtPhone.setText(organizationBean.contactsPhone);
        edtDescribe.setText(organizationBean.description);
        if(organizationBean.buildingStatus!=null) {
            switch (organizationBean.buildingStatus.id) {
                case "PROJECT_CONSTRUCT":
                    tvStatus.setText("未完工");
                    break;
                case "PROJECT_BUILDING":
                    tvStatus.setText("建设中");
                    break;
                case "PROJECT_COMPLETED":
                    tvStatus.setText("已完工");
                    break;
            }
        }
        if(!TextUtils.isEmpty(organizationBean.startTime)) {
            tvStartTime.setText(organizationBean.startTime.split(" ")[0]);
        }else{
            tvEndTime.setText("");
        }
        if(!TextUtils.isEmpty(organizationBean.endTime)) {
            tvEndTime.setText(organizationBean.endTime.split(" ")[0]);
        }else{
            tvEndTime.setText("");
        }
        if (organizationBean.district != null) {
            String location = "";
            location = organizationBean.district.title;
            if (organizationBean.district.parent != null) {
                location = organizationBean.district.parent.title + location;
                if (organizationBean.district.parent.parent != null) {
                    location = organizationBean.district.parent.parent.title + location;
                }
            }

            tvLocation.setText(location);
        }
        // tvLocation.setText(organizationBean.displayAddress);
        edtAddress.setText(organizationBean.streetAddress);
    }


    @OnClick({R.id.tv_location,R.id.tv_status, R.id.tv_startTime, R.id.tv_endTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                if(jsonArrayAddress==null){
                    toast("获取城市中！");
                    return;
                }
                if(addressPicker==null) {
                    addressPicker = DialogUtils.getAddressDialog(this,jsonArrayAddress, new AddressPicker.OnAddressPickListener() {
                        @Override
                        public void onAddressPicked(Province province, City city, County county) {
                            //tvLocation.setText(province.getAreaName() + city.getAreaName()+county.getAreaName());
                            tvLocation.setText(province.getAreaName() + city.getAreaName());

                            districtId=city.getAreaId();
                            System.out.println("=========city.getAreaId()="+city.getAreaId());
                            if(county!=null){
                                System.out.println("=========county.getAreaId()="+county.getAreaId());
                                districtId=county.getAreaId();
                            }

                        }
                    });
                }else{
                    addressPicker.show();
                }
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
}
