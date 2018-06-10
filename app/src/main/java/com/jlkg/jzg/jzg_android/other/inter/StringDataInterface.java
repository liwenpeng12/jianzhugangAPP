package com.jlkg.jzg.jzg_android.other.inter;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:
 */

public abstract class StringDataInterface<T extends StringDataInterface> {
    public abstract String getText();

    public abstract List<T> getList();
    public abstract String getId();
    public abstract boolean isSelect();

    public abstract void isSelect(boolean isSelect);
}
