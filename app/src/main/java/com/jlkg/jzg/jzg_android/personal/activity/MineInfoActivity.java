package com.jlkg.jzg.jzg_android.personal.activity;

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
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.other.widget.CircleImageView;
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

public class MineInfoActivity extends BaseActivity {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_approve)
    TextView tvApprove;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_complete)
    TextView tvComplete;
    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    private ArrayList<String> mFrontList=new ArrayList<>();
    private ArrayList<String> mBackList=new ArrayList<>();
    private RxPermissions rxPermissions;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_info;
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

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvName.setText(MyApplication.sCompanyLoginBean.getTitle());
        if(!android.text.TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getPhone())) {
            tvPhone.setText(MyApplication.sCompanyLoginBean.getPhone());
        }
        tvUsername.setText(MyApplication.sCompanyLoginBean.getUserName());
        tvCompany.setText(MyApplication.sCompanyLoginBean.getTitle());
        if(MyApplication.sCompanyLoginBean.getCompanyType()!=null){
            tvApprove.setText("已认证");
        }else{
            tvApprove.setText("未认证");
        }
        if(MyApplication.sCompanyLoginBean.touxiang!=null){
            //  if(!TextUtils.isEmpty(MyApplication.sCompanyLoginBean.getLog))
            if(!android.text.TextUtils.isEmpty(MyApplication.sCompanyLoginBean.touxiang.getUrl())){
                GlideApp.with(this).load(MyApplication.sCompanyLoginBean.touxiang.getUrl()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgAvatar);
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
                if(MyApplication.sCompanyLoginBean.getCompanyType()!=null) {
                    openActivity(ApproveActivity.class);
                }else{
                    DialogUtils.showInvitedDia(this,true);
                }
                break;
            case R.id.tv_company:
                openActivity(MineCompanyInfoActivity.class);
                break;
            case R.id.tv_complete:
                setLoading(true);

                if(mBackList!=null&&mBackList.size()>0) {
                    File file=new File(mBackList.get(mBackList.size()-1));
                    ApiManager.imageUpload(file,MineInfoActivity.this, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            try {
                                JSONObject json=JSON.parseObject(response);
                                String id=json.getString("id");
                                update( id);
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

    public void update(String id){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("id",MyApplication.sCompanyLoginBean.getId()+"");
        hashMap.put("name",tvName.getText().toString());
        if(!android.text.TextUtils.isEmpty(id)) {
            hashMap.put("touxiang", id);
        }
       // hashMap.put("companyTypeId",MyApplication.sCompanyLoginBean.getCompanyType().getId());

       // hashMap.put("contacts",MyApplication.sCompanyLoginBean.getContacts());
       // hashMap.put("phone",tvPhone.getText().toString());
       // hashMap.put("notes",MyApplication.sCompanyLoginBean.getNotes()+"");
      //  hashMap.put("streetAddress",MyApplication.sCompanyLoginBean)
        ApiManager.updeateCompany(hashMap, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {

                ApiManager.getCompanyInfo(MyApplication.sCompanyLoginBean.getId()+"", MineInfoActivity.this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        setLoading(false);
                        CompanyLoginBean bean = JSON.parseObject(response, CompanyLoginBean.class);
                        MyApplication.sCompanyLoginBean = bean;
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
                Log.d("lwp","mFrontList1——onActivityResult:"+mFrontList.toString());
                mFrontList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                if (mFrontList != null && mFrontList.size() > 0) {
                   // Glide.with(this).load(mFrontList.get(0)).into(imgAvatar);
                    GlideApp.with(this).load(mFrontList.get(0)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgAvatar);

                }

            } else if (requestCode == 0x002) {
                mBackList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                Log.d("lwp","mBackList1——onActivityResult:"+mBackList.get(0));
                if (mBackList != null && mBackList.size() > 0) {
                   // Glide.with(this).load(mBackList.get(0)).into(imgAvatar);
               //     imgAvatar.setImageBitmap(mBackList.get(0));
                    GlideApp.with(this).load(mBackList.get(0)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgAvatar);

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
                    //Glide.with(this).load(mFrontList.get(0)).into(imgAvatar);
                    Log.d("lwp","mFrontList2——onActivityResult:"+mFrontList.toString());
                    GlideApp.with(this).load(mFrontList.get(0)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgAvatar);
                }


            } else if (requestCode == 0x002) {
                mBackList.clear();
                mBackList.add(fileName);
                if (mBackList != null && mBackList.size() > 0) {
                    Log.d("lwp","mBackList2——onActivityResult:"+mFrontList.toString());
                    //Glide.with(this).load(mBackList.get(0)).into(imgAvatar);
                    GlideApp.with(this).load(mBackList.get(0)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgAvatar);
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
            //Glide.with(context).load(path).into(imageView);
            GlideApp.with(context).load(path).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);


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
