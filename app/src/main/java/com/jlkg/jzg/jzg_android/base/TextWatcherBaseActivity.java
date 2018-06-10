package com.jlkg.jzg.jzg_android.base;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @autor zcs
 * @time 2017/11/23
 * @describe
 */

public abstract class TextWatcherBaseActivity extends BaseActivity implements TextWatcher {


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
