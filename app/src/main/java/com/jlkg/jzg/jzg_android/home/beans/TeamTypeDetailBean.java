package com.jlkg.jzg.jzg_android.home.beans;

/**
 * Created by zcs on 2018/4/21.
 */

public class TeamTypeDetailBean {

    /**
     * id : 20265
     * title : 测量员
     * regulation : null
     * crafts : null
     * quality : null
     * category : {"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1}
     * szTypeId : null
     * msgIndex : 0
     * libraryCount : 0
     * status : 1
     */

    private int id;
    private String title;
    private String regulation;
    private String crafts;
    private String quality;
    private CategoryBean category;
    private String szTypeId;
    private int msgIndex;
    private int libraryCount;
    private int status;

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

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public String getCrafts() {
        return crafts;
    }

    public void setCrafts(String crafts) {
        this.crafts = crafts;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public String getSzTypeId() {
        return szTypeId;
    }

    public void setSzTypeId(String szTypeId) {
        this.szTypeId = szTypeId;
    }

    public int getMsgIndex() {
        return msgIndex;
    }

    public void setMsgIndex(int msgIndex) {
        this.msgIndex = msgIndex;
    }

    public int getLibraryCount() {
        return libraryCount;
    }

    public void setLibraryCount(int libraryCount) {
        this.libraryCount = libraryCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class CategoryBean {
        /**
         * id : GUANLI
         * text : 管理
         * category : TEAM_CATEGORY
         * groupTitle : null
         * system : true
         * orderIndex : 1
         */

        private String id;
        private String text;
        private String category;
        private Object groupTitle;
        private boolean system;
        private int orderIndex;

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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getGroupTitle() {
            return groupTitle;
        }

        public void setGroupTitle(Object groupTitle) {
            this.groupTitle = groupTitle;
        }

        public boolean isSystem() {
            return system;
        }

        public void setSystem(boolean system) {
            this.system = system;
        }

        public int getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(int orderIndex) {
            this.orderIndex = orderIndex;
        }
    }
}
