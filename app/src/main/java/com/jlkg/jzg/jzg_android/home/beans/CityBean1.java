package com.jlkg.jzg.jzg_android.home.beans;

import com.jlkg.jzg.jzg_android.other.inter.StringDataInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcs on 2018/3/5.
 *
 * @describe:
 */

public class CityBean1 extends StringDataInterface<CityBean1.CitysBean> {


    /**
     * province : 北京市
     * id : 1
     * citys : [{"city":"北京市","id":1001}]
     */

    private String province;
    private String id;
    private List<CitysBean> citys;
    private boolean isSelect;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CitysBean> getCitys() {
        return citys;
    }

    public void setCitys(List<CitysBean> citys) {
        this.citys = citys;
    }

    @Override
    public String getText() {
        return province;
    }

    @Override
    public List<CitysBean> getList() {
        if (citys == null) {
            citys = new ArrayList<>();
            CitysBean bean = new CitysBean();
            bean.setCity("全部");
            bean.setId("");
            citys.add(bean);
        }
        return citys;
    }

    @Override
    public boolean isSelect() {
        return isSelect;
    }

    @Override
    public void isSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public static class CitysBean extends StringDataInterface<StringDataInterface> {
        /**
         * city : 北京市
         * id : 1001
         */

        private String city;
        private String id;
        private boolean isSelect;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String getText() {
            return city;
        }

        @Override
        public List<StringDataInterface> getList() {
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
