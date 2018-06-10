package com.jlkg.jzg.jzg_android.other;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.baselibrary.utils.EditTextInPutUtils;
import com.jlkg.jzg.baselibrary.utils.OiStringUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.base.TextWatcherBaseActivity;
import com.jlkg.jzg.jzg_android.other.activity.CompanyInfoActivity;
import com.jlkg.jzg.jzg_android.other.activity.TeamInfoActivity;
import com.jlkg.jzg.jzg_android.utils.PictureSelectorUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.luck.picture.lib.config.PictureConfig;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class IdentityConfimActivity extends TextWatcherBaseActivity {

    @BindView(R.id.my_toolbar)
    MyToolbar mMyToolbar;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_card_code)
    EditText mEtCardCode;
    @BindView(R.id.iv_card_img1)
    ImageView mIvCardImg1;
    @BindView(R.id.iv_card_del1)
    ImageView mIvCardDel1;
    @BindView(R.id.iv_card_img2)
    ImageView mIvCardImg2;
    @BindView(R.id.iv_card_del2)
    ImageView mIvCardDel2;
    @BindView(R.id.btn_next)
    Button mBtnNext;
    private String cardImgPath1 = "", cardImgPath2 = "";
    boolean isSelectCardImg1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_identity_confim;
    }

    @Override
    protected void initViews() {
        super.initViews();
        EditTextInPutUtils.setMaxLengthEditTextInhibitInputSpace(mEtName, 16);
    }

    @OnClick(R.id.btn_next)
    void next() {
        try {
            if (!(!TextUtils.isEmpty(mEtName.getText().toString().trim()) && OiStringUtils.IDCardValidate(mEtCardCode.getText().toString().trim()) && !TextUtils.isEmpty(mEtCardCode.getText().toString().toString()))) {
                showToast("姓名或证件号码错误");
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            showToast("姓名或证件号码错误");
            return;
        }
        if (TextUtils.isEmpty(cardImgPath1) || TextUtils.isEmpty(cardImgPath2)) {
            showToast("请选择身份证照片");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("name", mEtName.getText().toString().trim());
        bundle.putString("IDcard", mEtCardCode.getText().toString().trim());
        bundle.putString("IDimg1", cardImgPath1);
        bundle.putString("IDimg2", cardImgPath2);
        openActivityForResult(MyApplication.isCompany ? CompanyInfoActivity.class : TeamInfoActivity.class, 1, bundle);
    }

    @OnClick({R.id.iv_card_img1, R.id.iv_card_img2, R.id.iv_card_del1, R.id.iv_card_del2})
    void click(View v) {
        switch (v.getId()) {
            case R.id.iv_card_img1:
                isSelectCardImg1 = true;
                PictureSelectorUtils.open(this, 1, 1);
                break;
            case R.id.iv_card_img2:
                isSelectCardImg1 = false;
                PictureSelectorUtils.open(this, 1, 1);
                break;
            case R.id.iv_card_del1:
                mIvCardImg1.setImageResource(R.mipmap.bg_icon_upload);
                cardImgPath1 = "";
                setImgDelVisibity();
                break;
            case R.id.iv_card_del2:
                mIvCardImg2.setImageResource(R.mipmap.bg_icon_upload);
                cardImgPath2 = "";
                setImgDelVisibity();
                break;
        }
    }

    private void setImgDelVisibity() {
        mIvCardDel1.setVisibility(TextUtils.isEmpty(cardImgPath1) ? View.GONE : View.VISIBLE);
        mIvCardDel2.setVisibility(TextUtils.isEmpty(cardImgPath2) ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PictureConfig.CHOOSE_REQUEST) {
            if (data != null) {
                if (isSelectCardImg1) {
//                    cardImgPath1 = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS).get(0);
                    cardImgPath1 = PictureSelectorUtils.getCompressPath(data).get(0);
                    Glide.with(this).load(cardImgPath1).into(mIvCardImg1);
                } else {
//                    cardImgPath2 = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS).get(0);
                    cardImgPath2 = PictureSelectorUtils.getCompressPath(data).get(0);
                    Glide.with(this).load(cardImgPath2).into(mIvCardImg2);
                }
                setImgDelVisibity();
            }
        } else if (resultCode == RESULT_OK && requestCode == 1) {
            setResult(Activity.RESULT_OK);
            finish();
        }
    }
}
