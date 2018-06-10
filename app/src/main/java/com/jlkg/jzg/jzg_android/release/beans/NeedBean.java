package com.jlkg.jzg.jzg_android.release.beans;

/**
 * Created by zcs on 2018/2/27.
 *
 * @describe:需求实体类
 */

public class NeedBean {
    public NeedBean(String type, String content, String id) {
        this.type = type;
        this.content = content;
        this.id = id;
    }

    public String type;
    public String content;
    public String id;
}
