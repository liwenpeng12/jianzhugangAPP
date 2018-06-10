package com.jlkg.jzg.jzg_android.release.beans;

import com.bigkoo.pickerview.model.IPickerViewData;

import java.util.List;

/**
 * Created by zcs on 2018/3/8.
 * 班组列表
 */

public class TeamListBean implements IPickerViewData {

    /**
     * id : ZULING
     * text :
     * titles : [{"id":23,"title":"铲车"},{"id":34,"title":"塔吊"},{"id":24,"title":"推土机"},{"id":35,"title":"汽车吊"},{"id":25,"title":"自卸车"},{"id":36,"title":"履带吊"},{"id":26,"title":"平地机"},{"id":37,"title":"泵车"},{"id":27,"title":"单钢轮"},{"id":38,"title":"搅拌车"},{"id":28,"title":"双钢轮"},{"id":39,"title":"旋挖钻机"},{"id":29,"title":"胶轮"},{"id":30,"title":"摊铺机"},{"id":31,"title":"冲击压路机"},{"id":32,"title":"路拌机"},{"id":33,"title":"铁刨机"},{"id":22,"title":"挖掘机"}]
     */

    private String id;
    private String text;
    private List<TitlesBean> titles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TitlesBean> getTitles() {
        return titles;
    }

    public void setTitles(List<TitlesBean> titles) {
        this.titles = titles;
    }

    @Override
    public String getPickerViewText() {
        return text;
    }

    public static class TitlesBean implements IPickerViewData {
        /**
         * id : 23
         * title : 铲车
         */

        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String getPickerViewText() {
            if (title == null) return "";
            return title;
        }
    }
}
