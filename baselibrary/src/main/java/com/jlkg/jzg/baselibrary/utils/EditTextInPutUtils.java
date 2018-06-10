package com.jlkg.jzg.baselibrary.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/**
 * @autor zcs
 * @time 2017/10/13
 * @describe
 */

public class EditTextInPutUtils {
    public static void setEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    public static void setPhoneEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ") || dend > 10) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    public static void setPwdEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ") || dend > 17) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    public static void setMaxLengthEditTextInhibitInputSpace(EditText editText, final int maxLength) {
        InputFilter filter = new InputFilter.LengthFilter(maxLength) {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ") || dend > (maxLength - 1)) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

}
