package com.jlkg.jzg.jzg_android.other.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14
 */
public class SplashBean {


    /**
     * data : [{"id":64,"imgUrl":null,"optime":1501159123000,"type":1}]
     * code : 200
     * msg :
     * totalPage : null
     * totalRecord : null
     * pageNo : null
     */

    private int code;
    private String msg;
    private Object totalPage;
    private Object totalRecord;
    private Object pageNo;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Object totalPage) {
        this.totalPage = totalPage;
    }

    public Object getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Object totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Object getPageNo() {
        return pageNo;
    }

    public void setPageNo(Object pageNo) {
        this.pageNo = pageNo;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        /**
         * id : 64
         * picture : null
         * optime : 1501159123000
         * type : 1
         */

        private int id;
        private String picture;
        private long optime;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public long getOptime() {
            return optime;
        }

        public void setOptime(long optime) {
            this.optime = optime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
