package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.bean.TeamLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.widget.CircleImageView;
import com.jlkg.jzg.jzg_android.personal.activity.ApproveActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class ClassMineInfoActivity extends BaseActivity {


    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_approve)
    TextView tvApprove;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_complete)
    TextView tvComplete;
    private ArrayList<String> mFrontList = new ArrayList<>();
    private ArrayList<String> mBackList = new ArrayList<>();
    private RxPermissions rxPermissions;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_mine_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
    }

    public void initView(){
        tvName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(android.text.TextUtils.isEmpty(tvName.getText().toString())){
                    tvComplete.setEnabled(false);
                }else{
                    tvComplete.setEnabled(true);
                }
            }
        });
        tvName.setText(MyApplication.sTeamLoginBean.getTitle());
        /*if(!TextUtils.isEmpty(MyApplication.sTeamLoginBean.getPhone())) {
            tvPhone.setText(MyApplication.sTeamLoginBean.getPhone());
        }*/
        tvPhone.setText(MyApplication.sTeamLoginBean.getUserName());

        if(MyApplication.sTeamLoginBean.getTeamType()!=null) {
            tvCompany.setText(MyApplication.sTeamLoginBean.getTeamType().getTitle());
            tvApprove.setText("已认证");
        }else {
            tvApprove.setText("未认证");

        }

        if(!TextUtils.isEmpty(MyApplication.sTeamLoginBean.getGender())) {
            tvSex.setText(MyApplication.sTeamLoginBean.getGender() + "");
        }
        if(MyApplication.sTeamLoginBean.getPhoto()!=null){
            if(!android.text.TextUtils.isEmpty(MyApplication.sTeamLoginBean.getPhoto().getUrl())){
                Glide.with(this).load(MyApplication.sTeamLoginBean.getPhoto().getUrl()).into(imgAvatar);
            }
        }

    }

    @OnClick({R.id.img_avatar, R.id.tv_sex, R.id.tv_approve, R.id.tv_company, R.id.tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_avatar:
                DialogUtils.showUploadDialog(this, new DialogUtils.onChoosePicListener() {
                    @Override
                    public void onChooseCamera() {

                        //拍照

                        requestRxPermissions(Manifest.permission.CAMERA);
                    }

                    @Override
                    public void onChoosePhone() {
                        //从相册选择
                        takePic(0x002);
                    }
                });
                break;
            case R.id.tv_sex:
                DialogUtils.showSexDialog(this, new DialogUtils.onChoosePicListener() {
                    @Override
                    public void onChooseCamera() {
                        tvSex.setText("男");
                    }

                    @Override
                    public void onChoosePhone() {
                        tvSex.setText("女");
                    }
                });
                break;
            case R.id.tv_approve:
                if(MyApplication.sTeamLoginBean.getTeamType()!=null) {
                    openActivity(ApproveActivity.class);
                }else{
                    DialogUtils.showInvitedDia(this,true);
                }
               // openActivity(ApproveActivity.class);
                break;
            case R.id.tv_company:
               // openActivity(MineCompanyInfoActivity.class);
                break;
            case R.id.tv_complete:
                setLoading(true);
                if(mBackList!=null&&mBackList.size()>0) {

                    File file=new File(mBackList.get(mBackList.size()-1));
                    ApiManager.imageUpload(file,ClassMineInfoActivity.this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            try {
                                JSONObject json= JSON.parseObject(response);
                                String id=json.getString("id");
                                update(id);
                            }catch (Exception e){
                                setLoading(false);
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(String msg) {
                            setLoading(false);
                            toast("头像上传失败，请重试！");
                        }
                    });

                }else{
                    update("");
                }
                break;
        }
    }


    public void update(String pictureId){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("id",MyApplication.sTeamLoginBean.getId()+"");
        hashMap.put("name",tvName.getText().toString());
//        hashMap.put("ID_number",MyApplication.sTeamLoginBean.getIdNumber());
//        hashMap.put("idFrontId",MyApplication.sTeamLoginBean.getIdFront()+"");
//        hashMap.put("cardFrontId",MyApplication.sTeamLoginBean.getCardFront()+"");
//        hashMap.put("teamTypeId",MyApplication.sTeamLoginBean.getTeamType().getId()+"");
//        hashMap.put("address",MyApplication.sTeamLoginBean.getAddress()+"");
//        hashMap.put("streetAddress",MyApplication.sTeamLoginBean.getStreetAddress()+"");
//        hashMap.put("notes",MyApplication.sTeamLoginBean.getNotes()+"");
        if(!android.text.TextUtils.isEmpty(pictureId)) {
            hashMap.put("photoId", pictureId);
        }
//        if(!android.text.TextUtils.isEmpty(tvSex.getText().toString())) {
//            if("女".equals(tvSex.getText().toString())) {
//                hashMap.put("gender","2");
//            }else{
//                hashMap.put("gender","1");
//            }
//        }
        hashMap.put("gender",tvSex.getText().toString());
        ApiManager.updateTeam(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {


                ApiManager.getTeamInfo(MyApplication.sTeamLoginBean.getId()+"", ClassMineInfoActivity.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        TeamLoginBean bean = JSON.parseObject(response, TeamLoginBean.class);
                        MyApplication.sTeamLoginBean = bean;
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
            public void onError(String msg) {
                setLoading(false);
                toast(msg);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //从相册中选择
        if (resultCode == 0x002 && data != null) {
            if (requestCode == 0x001) {
                mFrontList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                if (mFrontList != null && mFrontList.size() > 0) {
                    Glide.with(this).load(mFrontList.get(0)).into(imgAvatar);
                }

            } else if (requestCode == 0x002) {
                mBackList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                if (mBackList != null && mBackList.size() > 0) {
                    Glide.with(this).load(mBackList.get(0)).into(imgAvatar);
                }
            }

        }
        //拍照
        if (resultCode == Activity.RESULT_OK && data != null) {

            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.i("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }
            String name = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
            FileOutputStream b = null;
            File file = new File("/sdcard/myImage/");
            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/myImage/" + name;
            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (b != null) {
                        b.flush();
                        b.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (requestCode == 0x001) {
                mFrontList.clear();
                mFrontList.add(fileName);
                if (mFrontList != null && mFrontList.size() > 0) {
                    Glide.with(this).load(mFrontList.get(0)).into(imgAvatar);
                }


            } else if (requestCode == 0x002) {
                mBackList.clear();
                mBackList.add(fileName);
                if (mBackList != null && mBackList.size() > 0) {
                    Glide.with(this).load(mBackList.get(0)).into(imgAvatar);
                }

            }
        }
    }


    private void takePic(int requestCode) {
        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                // 是否多选
                .multiSelect(false)
                // 确定按钮文字颜色
                .btnTextColor(getResources().getColor(R.color.white))
                // 返回图标ResId
                .backResId(R.mipmap.nav_icon_back)
                .title("相册")
                .titleColor(getResources().getColor(R.color.white))
                .titleBgColor(getResources().getColor(R.color.color_039aff))
                .cropSize(1, 1, 200, 200)
                .needCrop(false)
                // 第一个是否显示相机
                .needCamera(true)
                // 最大选择图片数量
                .maxNum(1)
                .build();
        ImgSelActivity.startActivity(this, config, requestCode);
    }

    private ImageLoader loader = new ImageLoader() {

        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };


    //请求权限
    private void requestRxPermissions(final String... permissions) {
        rxPermissions = new RxPermissions(this);
        rxPermissions.request(permissions).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(@NonNull Boolean granted) throws Exception {
                if (granted) {
                    //DebugUtils.prinlnLog("已获取权限");
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0x002);
                } else {
                    showToast("未同意权限");
                }
            }
        });
    }
}
