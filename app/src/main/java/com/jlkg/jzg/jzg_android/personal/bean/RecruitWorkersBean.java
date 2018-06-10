package com.jlkg.jzg.jzg_android.personal.bean;

import java.util.List;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/3/14
 */

public class RecruitWorkersBean {

    /**
     * id : 84509
     * publishedTime : 2018-03-26 15:27:27
     * title : null
     * closeTime : null
     * teamRequire : null
     * memo : 测试
     * price : 288
     * hireEnded : false
     * project : {"id":84508,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":null,"startTime":"2018-03-26 15:27:26","endTime":null,"updateTime":null,"createTime":null,"name":"测试校门口","company":null,"description":null,"memo":null,"dcenterDesc":null,"district":{"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100},"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"广东省深圳市宝安区流塘路26"}
     * type : {"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null}
     * salary : null
     * userDeleted : false
     * phone : 18565860212
     * status : {"id":"HIRE_TYPE_AUDITED","text":"正在招聘","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null}
     * company : null
     * source : 未知
     * hireId : null
     * smsNum : 0
     * teamNeeds : [{"id":84510,"teamType":{"id":39,"title":"旋挖钻机","category":{"id":"ZULING","text":"","category":"","groupTitle":null,"system":false,"orderIndex":null},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":25,"memo":null}]
     * contacts : null
     * provinceId : 19
     * cityId : 1199
     * districtId : 1199
     * teamNeedStr : G39Z
     */

    private int id;
    private String publishedTime;
    private Object title;
    private Object closeTime;
    private Object teamRequire;
    private String memo;
    private String price;
    private boolean hireEnded;
    private ProjectEntity project;
    private TypeEntity type;
    private Object salary;
    private boolean userDeleted;
    private String phone;
    private StatusEntityX status;
    private Object company;
    private String source;
    private Object hireId;
    private int smsNum;
    private Object contacts;
    private int provinceId;
    private int cityId;
    private int districtId;
    private String teamNeedStr;
    private List<TeamNeedsEntity> teamNeeds;

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

    public Object getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Object closeTime) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isHireEnded() {
        return hireEnded;
    }

    public void setHireEnded(boolean hireEnded) {
        this.hireEnded = hireEnded;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public Object getSalary() {
        return salary;
    }

    public void setSalary(Object salary) {
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

    public StatusEntityX getStatus() {
        return status;
    }

    public void setStatus(StatusEntityX status) {
        this.status = status;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
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

    public String getTeamNeedStr() {
        return teamNeedStr;
    }

    public void setTeamNeedStr(String teamNeedStr) {
        this.teamNeedStr = teamNeedStr;
    }

    public List<TeamNeedsEntity> getTeamNeeds() {
        return teamNeeds;
    }

    public void setTeamNeeds(List<TeamNeedsEntity> teamNeeds) {
        this.teamNeeds = teamNeeds;
    }

    public static class ProjectEntity {
        /**
         * id : 84508
         * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         * buildingStatus : null
         * startTime : 2018-03-26 15:27:26
         * endTime : null
         * updateTime : null
         * createTime : null
         * name : 测试校门口
         * company : null
         * description : null
         * memo : null
         * dcenterDesc : null
         * district : {"id":1199,"title":"深圳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":true,"orderIndex":100}
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
         * displayAddress :
         * streetAddress : 广东省深圳市宝安区流塘路26
         */

        private int id;
        private StatusEntity status;
        private Object buildingStatus;
        private String startTime;
        private Object endTime;
        private Object updateTime;
        private Object createTime;
        private String name;
        private Object company;
        private Object description;
        private Object memo;
        private Object dcenterDesc;
        private DistrictEntity district;
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

        public StatusEntity getStatus() {
            return status;
        }

        public void setStatus(StatusEntity status) {
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

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
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

        public DistrictEntity getDistrict() {
            return district;
        }

        public void setDistrict(DistrictEntity district) {
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

        public static class StatusEntity {
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

        public static class DistrictEntity {
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
            private ParentEntity parent;
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

            public ParentEntity getParent() {
                return parent;
            }

            public void setParent(ParentEntity parent) {
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

            public static class ParentEntity {
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

    public static class TypeEntity {
        /**
         * id : PROJECT_TYPE_WORKER
         * text : 班组
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

    public static class StatusEntityX {
        /**
         * id : HIRE_TYPE_AUDITED
         * text : 正在招聘
         * category : PROJECT_HIRE_STATUS
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

    public static class TeamNeedsEntity {
        /**
         * id : 84510
         * teamType : {"id":39,"title":"旋挖钻机","category":{"id":"ZULING","text":"","category":"","groupTitle":null,"system":false,"orderIndex":null},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
         * peopleNumber : 25
         * memo : null
         */

        private int id;
        private TeamTypeEntity teamType;
        private int peopleNumber;
        private Object memo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public TeamTypeEntity getTeamType() {
            return teamType;
        }

        public void setTeamType(TeamTypeEntity teamType) {
            this.teamType = teamType;
        }

        public int getPeopleNumber() {
            return peopleNumber;
        }

        public void setPeopleNumber(int peopleNumber) {
            this.peopleNumber = peopleNumber;
        }

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
            this.memo = memo;
        }

        public static class TeamTypeEntity {
            /**
             * id : 39
             * title : 旋挖钻机
             * category : {"id":"ZULING","text":"","category":"","groupTitle":null,"system":false,"orderIndex":null}
             * szTypeId : null
             * msgIndex : 0
             * libraryCount : 0
             * status : 1
             */

            private int id;
            private String title;
            private CategoryEntity category;
            private Object szTypeId;
            private int msgIndex;
            private int libraryCount;
            private int status;

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

            public CategoryEntity getCategory() {
                return category;
            }

            public void setCategory(CategoryEntity category) {
                this.category = category;
            }

            public Object getSzTypeId() {
                return szTypeId;
            }

            public void setSzTypeId(Object szTypeId) {
                this.szTypeId = szTypeId;
            }

            public int getMsgIndex() {
                return msgIndex;
            }

            public void setMsgIndex(int msgIndex) {
                this.msgIndex = msgIndex;
            }

            public int getLibraryCount() {
                return libraryCount;
            }

            public void setLibraryCount(int libraryCount) {
                this.libraryCount = libraryCount;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public static class CategoryEntity {
                /**
                 * id : ZULING
                 * text :
                 * category :
                 * groupTitle : null
                 * system : false
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
    }
}
