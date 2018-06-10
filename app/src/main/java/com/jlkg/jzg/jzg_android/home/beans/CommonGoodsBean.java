package com.jlkg.jzg.jzg_android.home.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/22.
 */

public class CommonGoodsBean {

    /**
     * status : 200
     * message : success
     * data : {"page_now":"1","page_count":6,"goods_list":[{"goods_id":"25945","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"1.80","goods_memo":""},{"goods_id":"25946","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"0.02","goods_memo":"<p style=\"margin-bottom: 0px; padding: 0px; line-height: 1.5; clear: both; color: rgb(51, 51, 51); f"},{"goods_id":"25947","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"3.90","goods_memo":"<br style=\"color: rgb(51, 51, 51); font-family: 'Hiragino Sans GB', Tahoma, Arial, 宋体, sans-serif; f"},{"goods_id":"25948","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"1.32","goods_memo":"<p style=\"margin-bottom: 0px; padding: 0px; line-height: 1.5; clear: both; color: rgb(51, 51, 51); f"},{"goods_id":"30346","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"E06-1无机富锌底漆（A）","goods_spec":"规格:18kg","goods_price":"28.00","goods_memo":""},{"goods_id":"30347","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"E06-2无机硅酸锌车间底漆（A）","goods_spec":"规格:18kg","goods_price":"19.00","goods_memo":""},{"goods_id":"30348","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"环氧封闭底漆（A）","goods_spec":"规格:12kg","goods_price":"23.00","goods_memo":""},{"goods_id":"30349","goods_class":"五金","goods_class2":"电气","goods_class3":"其它","brand_name":"","goods_name":"LED吸顶灯  260大灯盘","goods_spec":"规格:12W,18W","goods_price":"38.40","goods_memo":""},{"goods_id":"30351","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"铁灰环氧防腐漆","goods_spec":"规格:19kg","goods_price":"43.50","goods_memo":""},{"goods_id":"30352","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"J615厚浆铝粉氯化橡胶防锈漆","goods_spec":"规格:20kg","goods_price":"19.00","goods_memo":""}]}
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
         * page_count : 6
         * goods_list : [{"goods_id":"25945","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"1.80","goods_memo":""},{"goods_id":"25946","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"0.02","goods_memo":"<p style=\"margin-bottom: 0px; padding: 0px; line-height: 1.5; clear: both; color: rgb(51, 51, 51); f"},{"goods_id":"25947","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"3.90","goods_memo":"<br style=\"color: rgb(51, 51, 51); font-family: 'Hiragino Sans GB', Tahoma, Arial, 宋体, sans-serif; f"},{"goods_id":"25948","goods_class":"五金","goods_class2":"装饰","goods_class3":"其它","brand_name":"","goods_name":"盛元建材五金","goods_spec":"","goods_price":"1.32","goods_memo":"<p style=\"margin-bottom: 0px; padding: 0px; line-height: 1.5; clear: both; color: rgb(51, 51, 51); f"},{"goods_id":"30346","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"E06-1无机富锌底漆（A）","goods_spec":"规格:18kg","goods_price":"28.00","goods_memo":""},{"goods_id":"30347","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"E06-2无机硅酸锌车间底漆（A）","goods_spec":"规格:18kg","goods_price":"19.00","goods_memo":""},{"goods_id":"30348","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"环氧封闭底漆（A）","goods_spec":"规格:12kg","goods_price":"23.00","goods_memo":""},{"goods_id":"30349","goods_class":"五金","goods_class2":"电气","goods_class3":"其它","brand_name":"","goods_name":"LED吸顶灯  260大灯盘","goods_spec":"规格:12W,18W","goods_price":"38.40","goods_memo":""},{"goods_id":"30351","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"铁灰环氧防腐漆","goods_spec":"规格:19kg","goods_price":"43.50","goods_memo":""},{"goods_id":"30352","goods_class":"五金","goods_class2":"装饰","goods_class3":"油漆","brand_name":"","goods_name":"J615厚浆铝粉氯化橡胶防锈漆","goods_spec":"规格:20kg","goods_price":"19.00","goods_memo":""}]
         */

        private String page_now;
        private int page_count;
        private List<GoodsListBean> goods_list;

        public String getPage_now() {
            return page_now;
        }

        public void setPage_now(String page_now) {
            this.page_now = page_now;
        }

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            /**
             * goods_id : 25945
             * goods_class : 五金
             * goods_class2 : 装饰
             * goods_class3 : 其它
             * brand_name :
             * goods_name : 盛元建材五金
             * goods_spec :
             * goods_price : 1.80
             * goods_memo :
             */

            private String goods_id;
            private String goods_class;
            private String goods_class2;
            private String goods_class3;
            private String brand_name;
            private String goods_name;
            private String goods_spec;
            private String goods_price;
            private String goods_memo;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_class() {
                return goods_class;
            }

            public void setGoods_class(String goods_class) {
                this.goods_class = goods_class;
            }

            public String getGoods_class2() {
                return goods_class2;
            }

            public void setGoods_class2(String goods_class2) {
                this.goods_class2 = goods_class2;
            }

            public String getGoods_class3() {
                return goods_class3;
            }

            public void setGoods_class3(String goods_class3) {
                this.goods_class3 = goods_class3;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_spec() {
                return goods_spec;
            }

            public void setGoods_spec(String goods_spec) {
                this.goods_spec = goods_spec;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_memo() {
                return goods_memo;
            }

            public void setGoods_memo(String goods_memo) {
                this.goods_memo = goods_memo;
            }
        }
    }
}
