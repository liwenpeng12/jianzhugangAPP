package com.jlkg.jzg.jzg_android.home.beans;

/**
 * Created by zcs on 2018/3/10.
 */

public class ProjectBean {

    /**
     * id : 7
     * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
     * startTime : 2016-03-07 00:00:00
     * endTime : 2016-03-30 00:00:00
     * updateTime : null
     * createTime : null
     * name : 深圳蛇口邮轮中心项目
     * company : {"id":5007,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13111115007","title":"中铁建工集团承包总公司","logo":null,"organizationCode":null,"contacts":"王先生","phone":"13111115007","fax":"25311464","email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":"2015-12-02 17:54:44","accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":false,"notes":null}
     * description : 面议
     * memo : null
     * dcenterDesc : null
     * district : {"id":11771,"title":"南山区","type":"DISTRICT","parent":{"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100},"hotCity":null,"orderIndex":null}
     * longitude : null
     * latitude : null
     * jianSheDW : null
     * gongchengMC : null
     * gongchengDZ : null
     * shigongXKZ : null
     * shigongDW : null
     * jianliDW : null
     * shejiDW : null
     * contacts : null
     * contactsPosition : null
     * contactsPhone : null
     * contactsEmail : null
     * videoUrl : null
     * yztProjectId : null
     * displayAddress : 广东省深圳市南山区南山区蛇口港湾大道南侧
     * streetAddress : 南山区蛇口港湾大道南侧
     */

    private int id;
    private StatusBean status;
    private String startTime;
    private String endTime;
    private Object updateTime;
    private Object createTime;
    private String name;
    private CompanyBean company;
    private String description;
    private Object memo;
    private Object dcenterDesc;
    private DistrictBean district;
    private Object longitude;
    private Object latitude;
    private Object jianSheDW;
    private Object gongchengMC;
    private Object gongchengDZ;
    private Object shigongXKZ;
    private Object shigongDW;
    private Object jianliDW;
    private Object shejiDW;
    private Object contacts;
    private Object contactsPosition;
    private Object contactsPhone;
    private Object contactsEmail;
    private Object videoUrl;
    private Object yztProjectId;
    private String displayAddress;
    private String streetAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getMemo() {
        return memo;
    }

    public void setMemo(Object memo) {
        this.memo = memo;
    }

    public Object getDcenterDesc() {
        return dcenterDesc;
    }

    public void setDcenterDesc(Object dcenterDesc) {
        this.dcenterDesc = dcenterDesc;
    }

    public DistrictBean getDistrict() {
        return district;
    }

    public void setDistrict(DistrictBean district) {
        this.district = district;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getJianSheDW() {
        return jianSheDW;
    }

    public void setJianSheDW(Object jianSheDW) {
        this.jianSheDW = jianSheDW;
    }

    public Object getGongchengMC() {
        return gongchengMC;
    }

    public void setGongchengMC(Object gongchengMC) {
        this.gongchengMC = gongchengMC;
    }

    public Object getGongchengDZ() {
        return gongchengDZ;
    }

    public void setGongchengDZ(Object gongchengDZ) {
        this.gongchengDZ = gongchengDZ;
    }

    public Object getShigongXKZ() {
        return shigongXKZ;
    }

    public void setShigongXKZ(Object shigongXKZ) {
        this.shigongXKZ = shigongXKZ;
    }

    public Object getShigongDW() {
        return shigongDW;
    }

    public void setShigongDW(Object shigongDW) {
        this.shigongDW = shigongDW;
    }

    public Object getJianliDW() {
        return jianliDW;
    }

    public void setJianliDW(Object jianliDW) {
        this.jianliDW = jianliDW;
    }

    public Object getShejiDW() {
        return shejiDW;
    }

    public void setShejiDW(Object shejiDW) {
        this.shejiDW = shejiDW;
    }

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    public Object getContactsPosition() {
        return contactsPosition;
    }

    public void setContactsPosition(Object contactsPosition) {
        this.contactsPosition = contactsPosition;
    }

    public Object getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(Object contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public Object getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(Object contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public Object getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Object getYztProjectId() {
        return yztProjectId;
    }

    public void setYztProjectId(Object yztProjectId) {
        this.yztProjectId = yztProjectId;
    }

    public String getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(String displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public static class StatusBean {
        /**
         * id : AUDITED
         * text : 已审核
         * category : PROJECT_STATUS
         * groupTitle : null
         * system : true
         * orderIndex : null
         */

        private String id;
        private String text;
        private String category;
        private Object groupTitle;
        private boolean system;
        private Object orderIndex;

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

        public Object getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(Object orderIndex) {
            this.orderIndex = orderIndex;
        }
    }

    public static class CompanyBean {
        /**
         * id : 5007
         * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
         * userName : 13111115007
         * title : 中铁建工集团承包总公司
         * logo : null
         * organizationCode : null
         * contacts : 王先生
         * phone : 13111115007
         * fax : 25311464
         * email : null
         * website : null
         * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         * createTime : 2015-12-02 17:54:44
         * accountType : COMPANY
         * parentCompany : null
         * superviseCompany : null
         * topCompany : false
         * adminCompany : false
         * notes : null
         */

        private int id;
        private CompanyTypeBean companyType;
        private String userName;
        private String title;
        private Object logo;
        private Object organizationCode;
        private String contacts;
        private String phone;
        private String fax;
        private Object email;
        private Object website;
        private StatusBeanX status;
        private String createTime;
        private String accountType;
        private Object parentCompany;
        private Object superviseCompany;
        private boolean topCompany;
        private boolean adminCompany;
        private Object notes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public CompanyTypeBean getCompanyType() {
            return companyType;
        }

        public void setCompanyType(CompanyTypeBean companyType) {
            this.companyType = companyType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getLogo() {
            return logo;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }

        public Object getOrganizationCode() {
            return organizationCode;
        }

        public void setOrganizationCode(Object organizationCode) {
            this.organizationCode = organizationCode;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getWebsite() {
            return website;
        }

        public void setWebsite(Object website) {
            this.website = website;
        }

        public StatusBeanX getStatus() {
            return status;
        }

        public void setStatus(StatusBeanX status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public Object getParentCompany() {
            return parentCompany;
        }

        public void setParentCompany(Object parentCompany) {
            this.parentCompany = parentCompany;
        }

        public Object getSuperviseCompany() {
            return superviseCompany;
        }

        public void setSuperviseCompany(Object superviseCompany) {
            this.superviseCompany = superviseCompany;
        }

        public boolean isTopCompany() {
            return topCompany;
        }

        public void setTopCompany(boolean topCompany) {
            this.topCompany = topCompany;
        }

        public boolean isAdminCompany() {
            return adminCompany;
        }

        public void setAdminCompany(boolean adminCompany) {
            this.adminCompany = adminCompany;
        }

        public Object getNotes() {
            return notes;
        }

        public void setNotes(Object notes) {
            this.notes = notes;
        }

        public static class CompanyTypeBean {
            /**
             * id : COMPANY_TYPE_1
             * text : 建筑公司
             * category : COMPANY_TYPE
             * groupTitle : null
             * system : true
             * orderIndex : null
             */

            private String id;
            private String text;
            private String category;
            private Object groupTitle;
            private boolean system;
            private Object orderIndex;

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

            public Object getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(Object orderIndex) {
                this.orderIndex = orderIndex;
            }
        }

        public static class StatusBeanX {
            /**
             * id : COMPANY_STATUS_NORMAL
             * text : 正常
             * category : COMPANY_STATUS
             * groupTitle : null
             * system : true
             * orderIndex : null
             */

            private String id;
            private String text;
            private String category;
            private Object groupTitle;
            private boolean system;
            private Object orderIndex;

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

            public Object getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(Object orderIndex) {
                this.orderIndex = orderIndex;
            }
        }
    }

    public static class DistrictBean {
        /**
         * id : 11771
         * title : 南山区
         * type : DISTRICT
         * parent : {"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100}
         * hotCity : null
         * orderIndex : null
         */

        private int id;
        private String title;
        private String type;
        private ParentBeanX parent;
        private Object hotCity;
        private Object orderIndex;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ParentBeanX getParent() {
            return parent;
        }

        public void setParent(ParentBeanX parent) {
            this.parent = parent;
        }

        public Object getHotCity() {
            return hotCity;
        }

        public void setHotCity(Object hotCity) {
            this.hotCity = hotCity;
        }

        public Object getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(Object orderIndex) {
            this.orderIndex = orderIndex;
        }

        public static class ParentBeanX {
            /**
             * id : 1199
             * title : 深圳市
             * type : CITY
             * parent : {"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
             * hotCity : true
             * orderIndex : 100
             */

            private int id;
            private String title;
            private String type;
            private ParentBean parent;
            private boolean hotCity;
            private int orderIndex;

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ParentBean getParent() {
                return parent;
            }

            public void setParent(ParentBean parent) {
                this.parent = parent;
            }

            public boolean isHotCity() {
                return hotCity;
            }

            public void setHotCity(boolean hotCity) {
                this.hotCity = hotCity;
            }

            public int getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(int orderIndex) {
                this.orderIndex = orderIndex;
            }

            public static class ParentBean {
                /**
                 * id : 19
                 * title : 广东省
                 * type : PROVINCE
                 * parent : null
                 * hotCity : null
                 * orderIndex : null
                 */

                private int id;
                private String title;
                private String type;
                private Object parent;
                private Object hotCity;
                private Object orderIndex;

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

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Object getParent() {
                    return parent;
                }

                public void setParent(Object parent) {
                    this.parent = parent;
                }

                public Object getHotCity() {
                    return hotCity;
                }

                public void setHotCity(Object hotCity) {
                    this.hotCity = hotCity;
                }

                public Object getOrderIndex() {
                    return orderIndex;
                }

                public void setOrderIndex(Object orderIndex) {
                    this.orderIndex = orderIndex;
                }
            }
        }
    }
}
