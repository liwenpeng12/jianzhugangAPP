package com.jlkg.jzg.jzg_android.home.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/15.
 */

public class MainGoodsBean {

    /**
     * status : 200
     * message : success
     * data : [{"goods_id":"82951","goods_name":"博世电动螺丝刀充电式迷你起子机锂电螺丝批3.6V电动工具Bosch GO BOSCH GO","goods_price":"224.00","goods_image":"http://mall.jianzhugang.com/data/upload/shop/store/goods/2869/2018/03/15/2869_05744421537022409_240.jpg","goods_url":"http://mall.jianzhugang.com/shop/index.php?act=goods&op=index&goods_id=82951"},{"goods_id":"82922","goods_name":"博世木材切割片 专业超薄木工锯片4/7/9/10/12寸手提台锯电圆锯片 4寸*40齿","goods_price":"60.00","goods_image":"http://mall.jianzhugang.com/data/upload/shop/store/goods/2869/2018/03/15/2869_05744413336120847_240.jpg","goods_url":"http://mall.jianzhugang.com/shop/index.php?act=goods&op=index&goods_id=82922"},{"goods_id":"82918","goods_name":"博世吸尘器 干湿吹家用电器工业多功能电动工具集尘器GAS15PS GAS15PS","goods_price":"899.00","goods_image":"http://mall.jianzhugang.com/data/upload/shop/store/goods/2869/2018/03/15/2869_05744409706660442_240.jpg","goods_url":"http://mall.jianzhugang.com/shop/index.php?act=goods&op=index&goods_id=82918"},{"goods_id":"82915","goods_name":"批发博世正品670W角磨机GWS6-125 5寸125MM手磨机打磨切割手砂轮 GWS6-125","goods_price":"365.00","goods_image":"http://mall.jianzhugang.com/data/upload/shop/store/goods/2869/2018/03/15/2869_05744407311528977_240.jpg","goods_url":"http://mall.jianzhugang.com/shop/index.php?act=goods&op=index&goods_id=82915"}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods_id : 82951
         * goods_name : 博世电动螺丝刀充电式迷你起子机锂电螺丝批3.6V电动工具Bosch GO BOSCH GO
         * goods_price : 224.00
         * goods_image : http://mall.jianzhugang.com/data/upload/shop/store/goods/2869/2018/03/15/2869_05744421537022409_240.jpg
         * goods_url : http://mall.jianzhugang.com/shop/index.php?act=goods&op=index&goods_id=82951
         */

        private String goods_id;
        private String goods_name;
        private String goods_price;
        private String goods_image;
        private String goods_url;

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public String getGoods_url() {
            return goods_url;
        }

        public void setGoods_url(String goods_url) {
            this.goods_url = goods_url;
        }
    }
}
