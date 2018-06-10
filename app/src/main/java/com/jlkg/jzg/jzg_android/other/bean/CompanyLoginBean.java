package com.jlkg.jzg.jzg_android.other.bean;

/**
 * Created by zcs on 2018/3/7.
 *
 * @describe:
 */

public class CompanyLoginBean {

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

    private int id;
    private CompanyTypeBean companyType;
    private String userName;
    private String title;
    private Object logo;
    private String organizationCode;
    private String contacts;
    private String phone;
    private String fax;
    private String email;
    private String website;
    private StatusBean status;
    private Object createTime;
    private String accountType;
    private Object parentCompany;
    private Object superviseCompany;
    private boolean topCompany;
    private boolean adminCompany;
    private String notes;
    public Touxiang touxiang;
    public String streetAddress;
    private String cardInfo;
    private String cardNo;
    private DistrictBean district;

    public DistrictBean getDistrict() {
        return district;
    }

    public void setDistrict(DistrictBean district) {
        this.district = district;
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
        private TeamLoginBean.DistrictBean.ParentBeanX parent;
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

        public TeamLoginBean.DistrictBean.ParentBeanX getParent() {
            return parent;
        }

        public void setParent(TeamLoginBean.DistrictBean.ParentBeanX parent) {
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
            private TeamLoginBean.DistrictBean.ParentBeanX.ParentBean parent;
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

            public TeamLoginBean.DistrictBean.ParentBeanX.ParentBean getParent() {
                return parent;
            }

            public void setParent(TeamLoginBean.DistrictBean.ParentBeanX.ParentBean parent) {
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


    public String getCardInfo() {
        return cardInfo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public class Touxiang{

        /**
         * id : 84162
         * host : http://jianzhugang.xzgapp.com
         * name : b8d4c584-3061-4a7f-95aa-74c42b312ae0.jpg
         * url : http://jianzhugang.xzgapp.com/b8d4c584-3061-4a7f-95aa-74c42b312ae0.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

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

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
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

    public static class StatusBean {
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
