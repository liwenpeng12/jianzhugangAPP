package com.jlkg.jzg.jzg_android.home.beans;

import com.jlkg.jzg.jzg_android.other.inter.StringDataInterface;

import java.util.List;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:
 */

public class SelectTypeBean extends StringDataInterface<SelectTypeBean.ChildSelectTypeBean> {
    public SelectTypeBean(String name, String id,List<SelectTypeBean.ChildSelectTypeBean> strings) {
        this.name = name;
        this.mList = strings;
        this.id = id;
    }
    public String id;
    public String name;
    public List<SelectTypeBean.ChildSelectTypeBean> mList;
    public boolean isSelect;


    @Override
    public String getText() {
        return name;
    }

    @Override
    public List<SelectTypeBean.ChildSelectTypeBean> getList() {
        return mList;
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

    public static class ChildSelectTypeBean extends StringDataInterface<StringDataInterface> {
        public String mName;
        public boolean isSelect;

        public ChildSelectTypeBean(String name) {
            mName = name;
        }

        @Override
        public String getText() {
            return mName;
        }

        @Override
        public List<StringDataInterface> getList() {
            return null;
        }

        @Override
        public String getId() {
            return null;
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
