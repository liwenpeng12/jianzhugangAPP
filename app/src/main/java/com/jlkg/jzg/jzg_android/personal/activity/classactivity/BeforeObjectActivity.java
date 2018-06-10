package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.Ibase.ValueInterface;
import com.jlkg.jzg.jzg_android.personal.adapter.MySelectImageAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassBeforeObjectBean;
import com.jlkg.jzg.jzg_android.utils.SharedPreferencesUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeforeObjectActivity extends BaseActivity implements ValueInterface{


    @BindView(R.id.edt_name)
    TextView edtName;
    @BindView(R.id.edt_companyName)
    TextView edtCompanyName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.edt_address)
    TextView edtAddress;
    @BindView(R.id.grid_img)
    GridView gridImg;
    @BindView(R.id.myToolbar)
    MyToolbar myToolbar;

    private MySelectImageAdapter mySelectImageAdapter;
    private List<String> stringList = new ArrayList<>();
    private ClassBeforeObjectBean classBeforeObjectBean;
    boolean isfirst =false;
    private HashMap map;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_before_object;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        myToolbar.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();

                //bundle数据变化

                openActivity(AddBeforeObjectActivity.class, bundle);
                finish();
            }
        });



        classBeforeObjectBean = (ClassBeforeObjectBean) getIntent().getExtras().getSerializable("data");

        mySelectImageAdapter = new MySelectImageAdapter(this, this);

        mySelectImageAdapter.setAdd(false);

        gridImg.setAdapter(mySelectImageAdapter);
        Object sp = SharedPreferencesUtils.getParam(this, "sp", 0);
        if ((Integer) sp != 0) {
            map = (HashMap<String, String>) sp;

        }


        edtName.setText(classBeforeObjectBean.getTitle());
        edtCompanyName.setText(classBeforeObjectBean.getCompanyName());
        edtAddress.setText(classBeforeObjectBean.getResumeDesc());
        //if ((Boolean) SharedPreferencesUtils.getParam(this,"isfirstin",true)) {
            if (classBeforeObjectBean.getProjectDate() != null) {

                tvTime.setText(classBeforeObjectBean.getProjectDate().split(" ")[0]);
            }
            if (classBeforeObjectBean.getImage1() != null) {

                stringList.add(classBeforeObjectBean.getImage1().getUrl());


            }

            if (classBeforeObjectBean.getImage2() != null) {

                stringList.add(classBeforeObjectBean.getImage2().getUrl());


                System.out.println("==========stringList=" + stringList.size());
            }

            if (classBeforeObjectBean.getImage3() != null) {

                stringList.add(classBeforeObjectBean.getImage3().getUrl());
                System.out.println("==========stringList=" + stringList.size());

            }

            if (classBeforeObjectBean.getImage4() != null) {

                stringList.add(classBeforeObjectBean.getImage4().getUrl());

                System.out.println("==========stringList=" + stringList.size());
            }

            if (classBeforeObjectBean.getImage5() != null) {

                stringList.add(classBeforeObjectBean.getImage5().getUrl());

                System.out.println("==========stringList=" + stringList.size());
            }

            if (classBeforeObjectBean.getImage6() != null) {
                stringList.add(classBeforeObjectBean.getImage6().getUrl());
                System.out.println("==========stringList=" + stringList.size());
            }
            Log.d("lwp", "classBeforeObjectBean.getImage6():" + classBeforeObjectBean.getImage6());
            System.out.println("==========stringList=" + stringList.size());

            mySelectImageAdapter.setmPathList(stringList);

        }
  //  }


    @Override
    public void onValueChanged(int pos) {
        switch (pos){
            case 0:
                classBeforeObjectBean.setImage1(null);
                Log.d("onValueChanged","1");
                break;
            case 1:
                classBeforeObjectBean.setImage2(null);
                break;
            case 2:
                classBeforeObjectBean.setImage3(null);
                Log.d("onValueChanged","3");
                break;
            case 3:
                classBeforeObjectBean.setImage4(null);
                Log.d("onValueChanged","4");
                break;
            case 4:
                classBeforeObjectBean.setImage5(null);
                break;
            case 5:
                classBeforeObjectBean.setImage6(null);
                Log.d("onValueChanged","6");
                break;
        }

    }
}
