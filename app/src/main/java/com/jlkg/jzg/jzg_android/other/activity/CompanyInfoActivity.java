package com.jlkg.jzg.jzg_android.other.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.jlkg.jzg.baselibrary.utils.EditTextInPutUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.home.beans.CompanyTypeListBean;
import com.jlkg.jzg.jzg_android.other.bean.CompanyLoginBean;
import com.jlkg.jzg.jzg_android.other.bean.ImageLoadBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.release.activitys.SelectAddressActivity;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PhoneCodeUtils;
import com.jlkg.jzg.jzg_android.utils.PictureSelectorUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.luck.picture.lib.config.PictureConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CompanyInfoActivity extends TextWatcherBaseActivity {


    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.et_company_name)
    EditText mEtCompanyName;
    @BindView(R.id.tv_company_type)
    TextView mTvCompanyType;
    @BindView(R.id.tv_company_address)
    TextView mTvCompanyAddress;
    @BindView(R.id.et_contact_name)
    EditText mEtContactName;
    @BindView(R.id.et_contact_phone)
    EditText mEtContactPhone;
    @BindView(R.id.et_company_remark)
    EditText mEtCompanyRemark;
    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.iv_img_del)
    ImageView mIvImgDel;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private String imgPath;
    private String[] mCompanyTypes;
    private List<CompanyTypeListBean> listBeans = new ArrayList<>();
    private String companyTypeID;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_info;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mCompanyTypes = getResources().getStringArray(R.array.companyType);
        EditTextInPutUtils.setMaxLengthEditTextInhibitInputSpace(mEtCompanyName, 16);
        EditTextInPutUtils.setMaxLengthEditTextInhibitInputSpace(mEtContactName, 19);
        mEtCompanyName.addTextChangedListener(this);
        mEtContactName.addTextChangedListener(this);
        mEtContactPhone.addTextChangedListener(this);
        mTvCompanyType.addTextChangedListener(this);
        mTvCompanyAddress.addTextChangedListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        ApiManager.getCompanyType(this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                List<CompanyTypeListBean> list = JSON.parseArray(response, CompanyTypeListBean.class);
                listBeans.addAll(list);
            }

            @Override
            public void onError(String msg) {
            }
        });
    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        mBtnCommit.setEnabled(!TextUtils.isEmpty(mEtCompanyName.getText().toString())
                && !TextUtils.isEmpty(mTvCompanyType.getText().toString())
                && !TextUtils.isEmpty(mTvCompanyAddress.getText().toString())
                && !TextUtils.isEmpty(mEtContactName.getText().toString())
                && PhoneCodeUtils.isMobile(mEtContactPhone.getText().toString())/*&&!TextUtils.isEmpty(imgPath)*/);
    }

    @OnClick(R.id.iv_img)
    void selectImg() {
        hideSoftKeyboard();
        PictureSelectorUtils.open(this, 1, 1);
    }

    @OnClick(R.id.iv_img_del)
    void imgDel() {
        mIvImg.setImageResource(R.mipmap.bg_icon_upload);
        imgPath = "";
        mIvImgDel.setVisibility(View.GONE);
    }

    @OnClick(R.id.tv_company_type)
    void selectType() {
        hideSoftKeyboard();
        OptionsPickerView view = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                mTvCompanyType.setText(listBeans.get(options1).getPickerViewText());
                companyTypeID = listBeans.get(options1).getId();
            }
        }).build();
        view.setPicker(listBeans, null, null);
        view.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PictureConfig.CHOOSE_REQUEST) {
            if (data != null) {
                imgPath = PictureSelectorUtils.getCompressPath(data).get(0);
                Glide.with(this).load(imgPath).into(mIvImg);
                mIvImgDel.setVisibility(View.VISIBLE);
                mBtnCommit.setEnabled(!TextUtils.isEmpty(mEtCompanyName.getText().toString())
                        && !TextUtils.isEmpty(mTvCompanyType.getText().toString())
                        && !TextUtils.isEmpty(mTvCompanyAddress.getText().toString())
                        && !TextUtils.isEmpty(mEtContactName.getText().toString())
                        && PhoneCodeUtils.isMobile(mEtContactPhone.getText().toString()) && !TextUtils.isEmpty(imgPath));
            }
        } else if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            mTvCompanyAddress.setText(data.getStringExtra("address"));
        }
    }

    @OnClick(R.id.btn_commit)
    void commit() {
        setLoading(true);
        if (TextUtils.isEmpty(imgPath)) {
            saveInfo(0);
        } else {
            upDataImg();
        }

    }

    private void upDataImg() {
        ApiManager.imageUpload(new File(imgPath), this,new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                ImageLoadBean bean = JSON.parseObject(response, ImageLoadBean.class);
                saveInfo(bean.getId());
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                showToast(msg);
            }
        });
    }

    private void saveInfo(int imgId) {
        ApiManager.companyInfoSave(mEtCompanyName.getText().toString().trim(), companyTypeID,
                mEtContactName.getText().toString().trim(), mEtContactPhone.getText().toString().trim(),
                mEtCompanyRemark.getText().toString().trim(), MyApplication.sCompanyLoginBean.getId(),
                imgId, mTvCompanyAddress.getText().toString(),this, new HttpUtils.OnCallBack() {
                    @Override
                    public void success(String response) {
                        MyApplication.sCompanyLoginBean = JSON.parseObject(response, CompanyLoginBean.class);
                        setLoading(false);
                        finish();
                    }

                    @Override
                    public void onError(String msg) {
                        setLoading(false);
                        showToast(msg);
                    }
                });
    }

    @OnClick(R.id.tv_company_address)
    void selectAddress() {
        openActivityForResult(SelectAddressActivity.class, 1);
    }
}
