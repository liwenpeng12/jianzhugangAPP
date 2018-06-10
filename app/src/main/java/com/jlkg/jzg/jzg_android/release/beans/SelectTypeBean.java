package com.jlkg.jzg.jzg_android.release.beans;

import com.jlkg.jzg.jzg_android.other.inter.StringDataInterface;

import java.util.List;

/**
 * Created by zcs on 2018/2/27.
 *
 * @describe:
 */

public class SelectTypeBean extends StringDataInterface<SelectTypeBean.SelectTypeChildBean> {
    public SelectTypeBean(String str, List<SelectTypeChildBean> childBeans,String id) {
        this.type = str;
        this.id = id;
        this.mChildBeans = childBeans;
    }
    public String id;
    public String type;
    public List<SelectTypeChildBean> mChildBeans;
    public boolean isSelect;
    @Override
    public List<SelectTypeBean.SelectTypeChildBean> getList() {
        return mChildBeans;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public boolean isSelect() {
        return isSelect;
    }

    @Override
    public void isSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    @Override
    public String getText() {
        return type;
    }
    public static class SelectTypeChildBean  extends StringDataInterface<StringDataInterface> {
        public SelectTypeChildBean(String type, boolean isSelect,String id) {
            this.type = type;
            this.isSelect = isSelect;
            this.id = id;
        }

        public String type;
        public boolean isSelect;
        public String id;
        public String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String getText() {
            return type;
        }

        @Override
        public List<StringDataInterface> getList() {
            return null;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public boolean isSelect() {
            return isSelect;
        }

        @Override
        public void isSelect(boolean isSelect) {
            this.isSelect = isSelect;
        }
    }
}
