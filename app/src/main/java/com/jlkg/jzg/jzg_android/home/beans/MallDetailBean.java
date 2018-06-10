package com.jlkg.jzg.jzg_android.home.beans;

/**
 * Created by zcs on 2018/3/14.
 *
 * @describe:
 */

public class MallDetailBean {

    /**
     * status : 200
     * message : success
     * data : {"store_id":"2870","store_name":"阳江市森步工贸有限公司","contacts_name":"董荣伟","contacts_phone":"15819192323","store_class_names":"五金","store_address":"西平北路247号","store_url":"http://mall.jianzhugang.com/shop/index.php?act=show_store&op=index&store_id=2870"}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * store_id : 2870
         * store_name : 阳江市森步工贸有限公司
         * contacts_name : 董荣伟
         * contacts_phone : 15819192323
         * store_class_names : 五金
         * store_address : 西平北路247号
         * store_url : http://mall.jianzhugang.com/shop/index.php?act=show_store&op=index&store_id=2870
         */

        private String store_id;
        private String store_name;
        private String contacts_name;
        private String contacts_phone;
        private String store_class_names;
        private String store_address;
        private String store_url;

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getContacts_name() {
            return contacts_name;
        }

        public void setContacts_name(String contacts_name) {
            this.contacts_name = contacts_name;
        }

        public String getContacts_phone() {
            return contacts_phone;
        }

        public void setContacts_phone(String contacts_phone) {
            this.contacts_phone = contacts_phone;
        }

        public String getStore_class_names() {
            return store_class_names;
        }

        public void setStore_class_names(String store_class_names) {
            this.store_class_names = store_class_names;
        }

        public String getStore_address() {
            return store_address;
        }

        public void setStore_address(String store_address) {
            this.store_address = store_address;
        }

        public String getStore_url() {
            return store_url;
        }

        public void setStore_url(String store_url) {
            this.store_url = store_url;
        }
    }
}
