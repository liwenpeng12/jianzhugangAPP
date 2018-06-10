package com.jlkg.jzg.jzg_android.home.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/6.
 *
 * @describe:
 */

public class MallListBean {


    /**
     * status : 200
     * message : success
     * data : {"page_now":"1","page_count":46,"store_list":[{"store_id":"2870","store_name":"阳江市森步工贸有限公司","store_address":"西平北路247号"},{"store_id":"2869","store_name":"东莞市瑞宝五金有限公司","store_address":"西平北路247号"},{"store_id":"2867","store_name":"正鑫铝模锥形管安装工具","store_address":"龙岗大道坪地段"},{"store_id":"2859","store_name":"深圳市宝安区沙井恒泰五金行","store_address":"沙井恒泰五金行"},{"store_id":"2858","store_name":"深圳汇业建筑材料有限公司","store_address":"深圳市罗湖区银湖路金湖一街38号C栋西单元101"},{"store_id":"2855","store_name":"深圳市广鹏城机电有限公司","store_address":"平湖镇平龙东路88号"},{"store_id":"2854","store_name":"深圳市德克诺电子有限公司","store_address":"振兴路华美大厦510室"},{"store_id":"2853","store_name":"中山市南头镇金蛋五金工具商行","store_address":"南头镇同乐中路145号"},{"store_id":"2851","store_name":"深圳市凯越真空设备有限公司","store_address":"平湖街道凤凰社区平龙东路196号--20"},{"store_id":"2850","store_name":"深圳小金蛋贸易有限公司","store_address":"西丽街道丽山路平山村19栋302"}]}
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
         * page_now : 1
         * page_count : 46
         * store_list : [{"store_id":"2870","store_name":"阳江市森步工贸有限公司","store_address":"西平北路247号"},{"store_id":"2869","store_name":"东莞市瑞宝五金有限公司","store_address":"西平北路247号"},{"store_id":"2867","store_name":"正鑫铝模锥形管安装工具","store_address":"龙岗大道坪地段"},{"store_id":"2859","store_name":"深圳市宝安区沙井恒泰五金行","store_address":"沙井恒泰五金行"},{"store_id":"2858","store_name":"深圳汇业建筑材料有限公司","store_address":"深圳市罗湖区银湖路金湖一街38号C栋西单元101"},{"store_id":"2855","store_name":"深圳市广鹏城机电有限公司","store_address":"平湖镇平龙东路88号"},{"store_id":"2854","store_name":"深圳市德克诺电子有限公司","store_address":"振兴路华美大厦510室"},{"store_id":"2853","store_name":"中山市南头镇金蛋五金工具商行","store_address":"南头镇同乐中路145号"},{"store_id":"2851","store_name":"深圳市凯越真空设备有限公司","store_address":"平湖街道凤凰社区平龙东路196号--20"},{"store_id":"2850","store_name":"深圳小金蛋贸易有限公司","store_address":"西丽街道丽山路平山村19栋302"}]
         */

        private int page_now;
        private int page_count;
        private List<StoreListBean> store_list;

        public int getPage_now() {
            return page_now;
        }

        public void setPage_now(int page_now) {
            this.page_now = page_now;
        }

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<StoreListBean> getStore_list() {
            return store_list;
        }

        public void setStore_list(List<StoreListBean> store_list) {
            this.store_list = store_list;
        }

        public static class StoreListBean {
            /**
             * store_id : 2870
             * store_name : 阳江市森步工贸有限公司
             * store_address : 西平北路247号
             */

            private String store_id;
            private String store_name;
            private String store_address;

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

            public String getStore_address() {
                return store_address;
            }

            public void setStore_address(String store_address) {
                this.store_address = store_address;
            }
        }
    }
}
