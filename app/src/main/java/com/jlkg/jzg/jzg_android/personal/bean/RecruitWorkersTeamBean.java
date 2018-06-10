package com.jlkg.jzg.jzg_android.personal.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangxiaolong on 2018/3/18.
 */

public class RecruitWorkersTeamBean implements Serializable {


    /**
     * id : 74401
     * publishedTime : 2016-09-21 10:20:31
     * title : null
     * closeTime : 2016-09-30 00:00:00
     * teamRequire : null
     * memo : 需招多名预算员，有5年以上工作经验，可独立进行预算，联系人：叶总
     * price : null
     * hireEnded : false
     * project : {"id":74400,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":null,"startTime":"2016-09-21 10:20:31","endTime":"2016-09-30 00:00:00","updateTime":null,"createTime":null,"name":"广东省汕头-某项目-招预算员","company":null,"description":null,"memo":null,"dcenterDesc":null,"district":{"id":11778,"title":"龙湖区","type":"DISTRICT","parent":{"id":1201,"title":"汕头市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"广东省汕头市龙湖区汕头","streetAddress":"汕头"}
     * type : {"id":"PROJECT_TYPE_DIAN_GONG","text":"点工","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null}
     * salary : 面议
     * userDeleted : false
     * phone : 13760484001
     * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
     * company : null
     * source : null
     * hireId : null
     * smsNum : 0
     * teamNeeds : []
     * contacts : null
     * provinceId : 19
     * cityId : 1201
     * districtId : 11778
     * teamNeedStr : null
     */

    private int id;
    private String publishedTime;
    private Object title;
    private String closeTime;
    private Object teamRequire;
    private String memo;
    private Object price;
    private boolean hireEnded;
    private ProjectBean project;
    private TypeBean type;
    private String salary;
    private boolean userDeleted;
    private String phone;
    private StatusBeanX status;
    private Object company;
    private Object source;
    private Object hireId;
    private int smsNum;
    private Object contacts;
    private int provinceId;
    private int cityId;
    private int districtId;
    private Object teamNeedStr;
    private List<TeamNeedsBean> teamNeeds;

    public class TeamNeedsBean implements Serializable{
        public int id;
        public String memo;
        public int peopleNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Object getTeamRequire() {
        return teamRequire;
    }

    public void setTeamRequire(Object teamRequire) {
        this.teamRequire = teamRequire;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public boolean isHireEnded() {
        return hireEnded;
    }

    public void setHireEnded(boolean hireEnded) {
        this.hireEnded = hireEnded;
    }

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public TypeBean getType() {
        return type;
    }

    public void setType(TypeBean type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(boolean userDeleted) {
        this.userDeleted = userDeleted;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StatusBeanX getStatus() {
        return status;
    }

    public void setStatus(StatusBeanX status) {
        this.status = status;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getHireId() {
        return hireId;
    }

    public void setHireId(Object hireId) {
        this.hireId = hireId;
    }

    public int getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(int smsNum) {
        this.smsNum = smsNum;
    }

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public Object getTeamNeedStr() {
        return teamNeedStr;
    }

    public void setTeamNeedStr(Object teamNeedStr) {
        this.teamNeedStr = teamNeedStr;
    }

    public List<TeamNeedsBean> getTeamNeeds() {
        return teamNeeds;
    }

    public void setTeamNeeds(List<TeamNeedsBean> teamNeeds) {
        this.teamNeeds = teamNeeds;
    }

    public static class ProjectBean implements Serializable {
        /**
         * id : 74400
         * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         * buildingStatus : null
         * startTime : 2016-09-21 10:20:31
         * endTime : 2016-09-30 00:00:00
         * updateTime : null
         * createTime : null
         * name : 广东省汕头-某项目-招预算员
         * company : null
         * description : null
         * memo : null
         * dcenterDesc : null
         * district : {"id":11778,"title":"龙湖区","type":"DISTRICT","parent":{"id":1201,"title":"汕头市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
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
         * displayAddress : 广东省汕头市龙湖区汕头
         * streetAddress : 汕头
         */

        private int id;
        private StatusBean status;
        private Object buildingStatus;
        private String startTime;
        private String endTime;
        private Object updateTime;
        private Object createTime;
        private String name;
        private Object company;
        private Object description;
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

        public Object getBuildingStatus() {
            return buildingStatus;
        }

        public void setBuildingStatus(Object buildingStatus) {
            this.buildingStatus = buildingStatus;
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

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
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

        public static class StatusBean implements Serializable {
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

        public static class DistrictBean implements Serializable {
            /**
             * id : 11778
             * title : 龙湖区
             * type : DISTRICT
             * parent : {"id":1201,"title":"汕头市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
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

            public static class ParentBeanX implements Serializable {
                /**
                 * id : 1201
                 * title : 汕头市
                 * type : CITY
                 * parent : {"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
                 * hotCity : null
                 * orderIndex : null
                 */

                private int id;
                private String title;
                private String type;
                private ParentBean parent;
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

                public ParentBean getParent() {
                    return parent;
                }

                public void setParent(ParentBean parent) {
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

                public static class ParentBean implements Serializable {
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

    public static class TypeBean implements Serializable {
        /**
         * id : PROJECT_TYPE_DIAN_GONG
         * text : 点工
         * category : PROJECT_TYPE
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

    public static class StatusBeanX implements Serializable{
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
}
