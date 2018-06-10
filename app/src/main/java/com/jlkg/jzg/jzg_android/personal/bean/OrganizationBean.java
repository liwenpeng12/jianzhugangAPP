package com.jlkg.jzg.jzg_android.personal.bean;

import java.io.Serializable;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/3/14
 */

public class OrganizationBean implements Serializable {


    /**
     * id : 83937
     * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
     * startTime : 2018-03-14 00:00:00
     * endTime : 2018-06-22 00:00:00
     * updateTime : 2018-03-14 16:02:48
     * createTime : null
     * name : 极联测试数据
     * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"广东中凯建设工程有限公司","logo":null,"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":false,"notes":null}
     * description : 联系人邮箱
     * memo : null
     * dcenterDesc : null
     * district : {"id":11771,"title":"南山区","type":"DISTRICT","parent":{"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100},"hotCity":null,"orderIndex":null}
     * longitude : null
     * latitude : null
     * jianSheDW : 建设单位
     * gongchengMC : 工程名称
     * gongchengDZ : 工程地址
     * shigongXKZ : 施工许可批准文号
     * shigongDW : 施工单位
     * jianliDW : 监理单位
     * shejiDW : 设计单位
     * contacts : 联系人姓名
     * contactsPosition : 联系人职务
     * contactsPhone : 联系人电话
     * contactsEmail : 联系人邮箱
     * videoUrl : null
     * yztProjectId : null
     * displayAddress : 广东省深圳市南山区科技园
     * streetAddress : 科技园
     */

    public int id;
    public StatusEntity buildingStatus;
    public String startTime;
    public String endTime;
    public String updateTime;
    public Object createTime;
    public String name;
    public CompanyEntity company;
    public String description;
    public Object memo;
    public Object dcenterDesc;
    public DistrictEntity district;
    public Object longitude;
    public Object latitude;
    public String jianSheDW;
    public String gongchengMC;
    public String gongchengDZ;
    public String shigongXKZ;
    public String shigongDW;
    public String jianliDW;
    public String shejiDW;
    public String contacts;
    public String contactsPosition;
    public String contactsPhone;
    public String contactsEmail;
    public Object videoUrl;
    public Object yztProjectId;
    public String displayAddress;
    public String streetAddress;

    public static class StatusEntity implements Serializable{
        /**
         * id : AUDITED
         * text : 已审核
         * category : PROJECT_STATUS
         * groupTitle : null
         * system : true
         * orderIndex : null
         */

        public String id;
        public String text;
        public String category;
        public Object groupTitle;
        public boolean system;
        public Object orderIndex;
    }

    public static class CompanyEntity implements Serializable {
        /**
         * id : 3120
         * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
         * userName : 13426599742
         * title : 广东中凯建设工程有限公司
         * logo : null
         * organizationCode : 791202564
         * contacts : 吕佳伟
         * phone : 13426599742
         * fax : null
         * email : null
         * website : null
         * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         * createTime : null
         * accountType : COMPANY
         * parentCompany : null
         * superviseCompany : null
         * topCompany : false
         * adminCompany : false
         * notes : null
         */

        public int id;
        public CompanyTypeEntity companyType;
        public String userName;
        public String title;
        public Object logo;
        public String organizationCode;
        public String contacts;
        public String phone;
        public Object fax;
        public Object email;
        public Object website;
        public StatusEntityX status;
        public Object createTime;
        public String accountType;
        public Object parentCompany;
        public Object superviseCompany;
        public boolean topCompany;
        public boolean adminCompany;
        public Object notes;

        public static class CompanyTypeEntity implements Serializable {
            /**
             * id : COMPANY_TYPE_1
             * text : 建筑公司
             * category : COMPANY_TYPE
             * groupTitle : null
             * system : true
             * orderIndex : null
             */

            public String id;
            public String text;
            public String category;
            public Object groupTitle;
            public boolean system;
            public Object orderIndex;
        }

        public static class StatusEntityX implements Serializable {
            /**
             * id : COMPANY_STATUS_NORMAL
             * text : 正常
             * category : COMPANY_STATUS
             * groupTitle : null
             * system : true
             * orderIndex : null
             */

            public String id;
            public String text;
            public String category;
            public Object groupTitle;
            public boolean system;
            public Object orderIndex;
        }
    }

    public static class DistrictEntity implements Serializable{
        /**
         * id : 11771
         * title : 南山区
         * type : DISTRICT
         * parent : {"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100}
         * hotCity : null
         * orderIndex : null
         */

        public int id;
        public String title;
        public String type;
        public ParentEntityX parent;
        public Object hotCity;
        public Object orderIndex;

        public static class ParentEntityX implements Serializable {
            /**
             * id : 1199
             * title : 深圳市
             * type : CITY
             * parent : {"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
             * hotCity : true
             * orderIndex : 100
             */

            public int id;
            public String title;
            public String type;
            public ParentEntity parent;
            public boolean hotCity;
            public int orderIndex;

            public static class ParentEntity implements Serializable{
                /**
                 * id : 19
                 * title : 广东省
                 * type : PROVINCE
                 * parent : null
                 * hotCity : null
                 * orderIndex : null
                 */

                public int id;
                public String title;
                public String type;
                public Object parent;
                public Object hotCity;
                public Object orderIndex;
            }
        }
    }
}
