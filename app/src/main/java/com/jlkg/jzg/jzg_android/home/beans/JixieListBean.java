package com.jlkg.jzg.jzg_android.home.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/9.
 */

public class JixieListBean {

    /**
     * categroy : 土石方系列
     * id : MACHINE_CATEGORY_1
     * titles : [{"id":"MACHINE_CATEGORY_1_1","title":"挖掘机"},{"id":"MACHINE_CATEGORY_1_2","title":"推土机"},{"id":"MACHINE_CATEGORY_1_3","title":"定向钻机"},{"id":"MACHINE_CATEGORY_1_4","title":"装载机"},{"id":"MACHINE_CATEGORY_1_5","title":"自卸车"},{"id":"MACHINE_CATEGORY_1_6","title":"挖掘装载机"},{"id":"MACHINE_CATEGORY_1_7","title":"其它"}]
     */

    private String categroy;
    private String id;
    private List<TitlesBean> titles;

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TitlesBean> getTitles() {
        return titles;
    }

    public void setTitles(List<TitlesBean> titles) {
        this.titles = titles;
    }

    public static class TitlesBean {
        /**
         * id : MACHINE_CATEGORY_1_1
         * title : 挖掘机
         */

        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
