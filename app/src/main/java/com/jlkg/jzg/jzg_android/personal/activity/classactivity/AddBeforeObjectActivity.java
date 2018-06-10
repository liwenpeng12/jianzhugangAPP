package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.Ibase.ValueInterface;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.event.RefreshBeforeObjectEvent;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.widget.MyBeforeDatePopupWindow;
import com.jlkg.jzg.jzg_android.personal.adapter.MySelectImageAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassBeforeObjectBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.luck.picture.lib.compress.Luban;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AddBeforeObjectActivity extends BaseActivity implements TextWatcher,ValueInterface {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_companyName)
    EditText edtCompanyName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.grid_img)
    GridView gridImg;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.myToolbar)
    MyToolbar myToolbar;
    private MyBeforeDatePopupWindow myDatePopupWindow;
    private MySelectImageAdapter mySelectImageAdapter;
    private List<String> mPathList = new ArrayList<>();
    //上传后的路径
    private List<String> pathList = new ArrayList<>();
    private List<String> pathListId=new ArrayList<>();
    private String timeStr;
    //是否有图片上传失败
    private boolean isSuccess = true;
    //编辑过往项目
    private boolean isEdit;
    private ClassBeforeObjectBean classBeforeObjectBean;
    private List<String> allListId=new ArrayList<>();

    private List<String> newImgList= new ArrayList<>();
    private boolean isfirstin = true;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_before_object;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        mySelectImageAdapter = new MySelectImageAdapter(this,this);
        edtName.addTextChangedListener(this);
        edtCompanyName.addTextChangedListener(this);
        tvTime.addTextChangedListener(this);
        if(getIntent().getExtras()!=null) {
            if( getIntent().getExtras().getSerializable("data")!=null && isfirstin) {

                isfirstin=false;
                myToolbar.setTitleText("编辑过往项目");
                classBeforeObjectBean = (ClassBeforeObjectBean) getIntent().getExtras().getSerializable("data");

                isEdit=true;
                edtName.setText(classBeforeObjectBean.getTitle());
                edtCompanyName.setText(classBeforeObjectBean.getCompanyName());
                edtAddress.setText(classBeforeObjectBean.getResumeDesc());
                if (classBeforeObjectBean.getProjectDate() != null) {
                    tvTime.setText(classBeforeObjectBean.getProjectDate().split(" ")[0]);
                    timeStr=classBeforeObjectBean.getProjectDate();
                }
                if (classBeforeObjectBean.getImage1() != null) {
                    pathListId.add(classBeforeObjectBean.getImage1().getId()+"");
                    pathList.add(classBeforeObjectBean.getImage1().getUrl());
                }

                if (classBeforeObjectBean.getImage2() != null) {
                    pathListId.add(classBeforeObjectBean.getImage2().getId()+"");
                    pathList.add(classBeforeObjectBean.getImage2().getUrl());
                }

                if (classBeforeObjectBean.getImage3() != null) {
                    pathListId.add(classBeforeObjectBean.getImage3().getId()+"");

                    pathList.add(classBeforeObjectBean.getImage3().getUrl());
                }

                if (classBeforeObjectBean.getImage4() != null) {
                    pathListId.add(classBeforeObjectBean.getImage4().getId()+"");

                    pathList.add(classBeforeObjectBean.getImage4().getUrl());
                }

                if (classBeforeObjectBean.getImage5() != null) {
                    pathListId.add(classBeforeObjectBean.getImage5().getId()+"");

                    pathList.add(classBeforeObjectBean.getImage5().getUrl());
                }

                if (classBeforeObjectBean.getImage6() != null) {
                    pathListId.add(classBeforeObjectBean.getImage6().getId()+"");

                    pathList.add(classBeforeObjectBean.getImage6().getUrl());
                }
                allListId.addAll(pathListId);
                mySelectImageAdapter.setUrlListId(pathListId);
                mySelectImageAdapter.setUrlList(pathList);
            }
        }

        gridImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mPathList.size()+pathList.size() < 6) {
                    takePic();
                }
            }
        });
        gridImg.setAdapter(mySelectImageAdapter);

    }


    ImgSelConfig config = null;
    private ImageLoader loader = new ImageLoader() {

        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };

    private void takePic() {
        config = new ImgSelConfig.Builder(loader)
                // 是否多选
                .multiSelect(true)
                // 确定按钮文字颜色
                .btnTextColor(getResources().getColor(R.color.white))
                // 返回图标ResId
                .backResId(R.mipmap.nav_icon_back)
                .title("相册")
                .titleColor(getResources().getColor(R.color.white))
                .titleBgColor(getResources().getColor(R.color.color_039aff))
                .cropSize(1, 1, 500, 500)
                .needCrop(false)
                // 第一个是否显示相机
                .needCamera(true)
                // 最大选择图片数量
                .maxNum(6 - mPathList.size()-pathList.size())
                .build();
        ImgSelActivity.startActivity(this, config, 0x001);
    }

    @OnClick({R.id.tv_time, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_time:
                hideSoftKeyboard();
                if (myDatePopupWindow == null) {
                    myDatePopupWindow = new MyBeforeDatePopupWindow(this, tvTime);
                    myDatePopupWindow.setOnSelectDateContent(new MyBeforeDatePopupWindow.OnSelectDateContent() {
                        @Override
                        public void getDate(String year, String month, String day) {
                            tvTime.setText(year + "-" + (month.length() >= 2 ? month : "0" + month) + "-" + (day.length() >= 2 ? day : "0" + day));
                            timeStr = year + "-" + month + "-" + day + " 00:00:00";
                        }
                    });
                } else {
                    myDatePopupWindow.showAtLocation(tvTime, Gravity.BOTTOM, 0, 0);
                }
                break;
            case R.id.tv_save:
                setLoading(true);
                adjustImgList();
                if (mPathList != null && mPathList.size() > 0) {
                    Log.d("lwp","mPathList_tv_save"+mPathList.size());
                    Flowable.just(mPathList)
                            .observeOn(Schedulers.io())
                            .map(new Function<List<String>, List<File>>() {

                                @Override
                                public List<File> apply(@NonNull List<String> list) throws Exception {
                                    // 同步方法直接返回压缩后的文件
                                    return Luban.with(AddBeforeObjectActivity.this).load(list).get();
                                }
                            })
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((new Consumer<List<File>>() {


                                @Override
                                public void accept(final List<File> files) throws Exception {
                                    allListId.clear();
                                    allListId.addAll(pathListId);
                                    for (int i = 0; i < files.size(); i++) {
                                        ApiManager.imageUpload(files.get(i),AddBeforeObjectActivity.this, new HttpUtils.OnCallBack() {
                                            @Override
                                            public void success(String response) {
                                                try {
                                                    JSONObject jsonObject = new JSONObject(response);
                                                    allListId.add(jsonObject.getString("id"));
                                                    if (allListId.size() ==pathListId.size()+files.size()) {
                                                        addBeforeObject();
                                                    }
                                                } catch (JSONException e) {
                                                    setLoading(false);
                                                    isSuccess = false;
                                                    e.printStackTrace();
                                                }
                                            }

                                            @Override
                                            public void onError(String msg) {
                                                setLoading(false);
                                                isSuccess = false;
                                                toast(msg);
                                            }
                                        });
                                        if (!isSuccess) {
                                            break;
                                        }
                                    }
                                }
                            }));
                } else {
                    Log.d("lwp","addBeforeObject");
                    addBeforeObject();
                }
                break;
        }
    }

    private void adjustImgList() {//mPathList=newImgList;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        //从相册中选择
        if (requestCode == 0x001 && resultCode == 0x002 && data != null) {
            List<String> list = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            if (list != null && list.size() > 0) {
                mPathList.addAll(list);
                for(String stringList : mPathList){
                    newImgList.add(stringList);
                }
                Log.d("lwp","newImgList:"+newImgList.size()+newImgList.toString());
                Log.d("lwp","mPathList:"+mPathList.size()+mPathList.toString());
                mySelectImageAdapter.setmPathList(mPathList);
            }
        }
    }

    public void addBeforeObject() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("companyName", edtCompanyName.getText().toString());
        hashMap.put("projectDate", timeStr);
        hashMap.put("resumeDesc", edtAddress.getText().toString());
        hashMap.put("title", edtName.getText().toString());
        hashMap.put("team.id", MyApplication.sTeamLoginBean.getId() + "");
        for (int i = 0; i < allListId.size(); i++) {
            hashMap.put("image" + (i + 1) + ".id", allListId.get(i));
        }
        if(isEdit){
            hashMap.put("id",classBeforeObjectBean.getId()+"");
        }
        ApiManager.beforeObjectSave(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                setLoading(false);
                RefreshBeforeObjectEvent refreshBeforeObjectEvent = new RefreshBeforeObjectEvent();
                EventBus.getDefault().post(refreshBeforeObjectEvent);
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
        if (!TextUtils.isEmpty(edtCompanyName.getText().toString()) &&
                !TextUtils.isEmpty(edtName.getText().toString()) &&
                !TextUtils.isEmpty(tvTime.getText().toString())) {
            tvSave.setEnabled(true);
        } else {
            tvSave.setEnabled(false);
        }
    }



    @Override
    public void onValueChanged(int pos) {
        Log.d("lwp","received");
     //   newImgList.remove(pos);
    }
}
