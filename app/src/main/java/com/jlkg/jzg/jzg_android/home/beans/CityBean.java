package com.jlkg.jzg.jzg_android.home.beans;

import com.jlkg.jzg.jzg_android.other.inter.StringDataInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcs on 2018/1/25.
 *
 * @describe:
 */

public class CityBean extends StringDataInterface<StringDataInterface> {

    private List<ProvincesBean> provinces;
    private List<StringDataInterface> mDataInterfaces;

    public List<ProvincesBean> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProvincesBean> provinces) {
        this.provinces = provinces;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<StringDataInterface> getList() {
        mDataInterfaces.addAll(provinces);
        return mDataInterfaces;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isSelect() {
        return false;
    }

    @Override
    public void isSelect(boolean isSelect) {

    }

    public static class ProvincesBean extends StringDataInterface<ChildCityBean> {
        /**
         * name : 北京市
         * citys : ["东城区","西城区","崇文区","宣武区","朝阳区","海淀区","丰台区","石景山区","房山区","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","门头沟区","密云区","延庆区","其他"]
         */

        private String name;
        private List<String> citys;
        public boolean isSelect;
        private List<ChildCityBean> mChildCityBeans;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getCitys() {
            return citys;
        }

        public void setCitys(List<String> citys) {
            this.citys = citys;
        }

        @Override
        public String getText() {
            return name;
        }

        @Override
        public List<ChildCityBean> getList() {
            if (mChildCityBeans == null) {
                mChildCityBeans = new ArrayList<>();
                int size = citys.size();
                for (int i = 0; i < size; i++) {
                    mChildCityBeans.add(new ChildCityBean(citys.get(i)));
                }
            }
            return mChildCityBeans;
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

    public static class ChildCityBean extends StringDataInterface<StringDataInterface> {
        public String name;
        public boolean isSelect;

        public ChildCityBean(String name) {
            this.name = name;
        }

        @Override
        public String getText() {
            return name;
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
