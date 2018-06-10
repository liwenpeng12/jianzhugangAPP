package com.jlkg.jzg.jzg_android.personal.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.baselibrary.utils.PrefUtils;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.PreFiled;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePasswordActivity extends BaseActivity implements TextWatcher {


    @BindView(R.id.et_old_password)
    EditText etOldPassword;
    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @BindView(R.id.tv_hint_content)
    TextView tvHintContent;
    @BindView(R.id.ll_hint)
    LinearLayout llHint;
    @BindView(R.id.tv_complete)
    TextView tvComplete;

    private Timer timer;
    private TimerTask timerTask;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    llHint.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        etOldPassword.addTextChangedListener(this);
        etOldPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etConfirmPassword.addTextChangedListener(this);
        etConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etNewPassword.addTextChangedListener(this);
        etNewPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.tv_complete)
    public void onViewClicked() {

        if(etOldPassword.getText().toString().length()<6){
            llHint.setVisibility(View.VISIBLE);
            tvHintContent.setText("密码长度为6-18位");
            stopTimer();
            startTimer();
            etConfirmPassword.setSelection(0);
            return;
        }else if(etNewPassword.getText().toString().length()<6){
            llHint.setVisibility(View.VISIBLE);
            tvHintContent.setText("密码长度为6-18位");
            stopTimer();
            startTimer();
            return;
        }else if(etConfirmPassword.getText().toString().length()<6){
            llHint.setVisibility(View.VISIBLE);
            tvHintContent.setText("密码长度为6-18位");
            stopTimer();
            startTimer();
            return;
        }else if(!etNewPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
            llHint.setVisibility(View.VISIBLE);
            tvHintContent.setText("两次输入的密码不一致");
            stopTimer();
            startTimer();
            return;
        }
        setLoading(true);
        ApiManager.modifyPassword( MyApplication.isCompany, etOldPassword.getText().toString(), etNewPassword.getText().toString(),this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                try {

                    toast("修改成功");
                    PrefUtils.setString(mContext, PreFiled.COMPANYPWD,etNewPassword.getText().toString());

                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    setLoading(false);
                }
            }

            @Override
            public void onError(String msg) {
                toast(msg);
                setLoading(false);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(TextUtils.isEmpty(etOldPassword.getText().toString())){
            tvComplete.setEnabled(false);

            return;
        }else if(TextUtils.isEmpty(etNewPassword.getText().toString())){
            tvComplete.setEnabled(false);
            return;
        }else if(TextUtils.isEmpty(etConfirmPassword.getText().toString())){
            tvComplete.setEnabled(false);
            return;
        }else {
            tvComplete.setEnabled(true);
        }
    }

    //提醒，计时
    public void startTimer(){
        if(timer==null) {
            timer = new Timer();
            timerTask=new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            };
            timer.schedule(timerTask,4000);
        }
    }

    public void stopTimer(){
        if(timer!=null){
            timer.cancel();
            timerTask.cancel();
            timer=null;
            timerTask=null;
        }
    }
}
