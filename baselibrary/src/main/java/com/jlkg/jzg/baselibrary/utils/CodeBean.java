package com.jlkg.jzg.baselibrary.utils;

/**
 * @autor zcs
 * @time 2017/12/6
 * @describe 获取验证码实体类
 */

public class CodeBean extends BaseBean {

    /**
     * data : {"sms_code":"2236"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sms_code : 2236
         */

        private String sms_code;

        public String getSms_code() {
            return sms_code;
        }

        public void setSms_code(String sms_code) {
            this.sms_code = sms_code;
        }
    }
}
