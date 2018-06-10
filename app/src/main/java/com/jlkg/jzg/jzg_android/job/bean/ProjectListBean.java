package com.jlkg.jzg.jzg_android.job.bean;

import java.util.List;

/**
 * Created by zcs on 2018/3/9.
 */

public class ProjectListBean {

    /**
     * content : [{"id":276478,"publishedTime":"2018-03-09 10:53:12","title":null,"closeTime":null,"teamRequire":null,"memo":"需要大量小工，只要45岁以下的！干长期的！速速来人！回民勿扰！详情电话联系！","price":null,"hireEnded":false,"project":{"id":276477,"status":{"id":"AUDITED","text":"已审核","groupTitle":null},"startTime":"2018-03-09 10:53:12","endTime":null,"updateTime":null,"createTime":null,"name":"广东深圳中建一局项目-招普工","company":null,"description":null,"memo":null,"dcenterDesc":null,"district":{"id":1199,"title":"深圳市"},"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"广东深圳"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","groupTitle":null},"salary":"面议","userDeleted":false,"phone":"15889430709","status":{"id":"HIRE_TYPE_AUDITED","text":"正在招聘","groupTitle":null},"company":null,"source":"林启都","hireId":37070,"smsNum":0,"teamNeeds":[{"id":276479,"teamType":{"id":20692,"title":"普工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null},"szTypeId":144046,"msgIndex":2642,"libraryCount":8058},"peopleNumber":15,"memo":null}],"contacts":"何女士"}]
     * last : false
     * totalPages : 20634
     * totalElements : 20634
     * sort : [{"direction":"DESC","property":"publishedTime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * first : false
     * numberOfElements : 1
     * size : 1
     * number : 1
     */

    private boolean last;
    private int totalPages;
    private int totalElements;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    private List<ContentBean> content;
    private List<SortBean> sort;

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public List<SortBean> getSort() {
        return sort;
    }

    public void setSort(List<SortBean> sort) {
        this.sort = sort;
    }

    public static class ContentBean {
        /**
         * id : 276478
         * publishedTime : 2018-03-09 10:53:12
         * title : null
         * closeTime : null
         * teamRequire : null
         * memo : 需要大量小工，只要45岁以下的！干长期的！速速来人！回民勿扰！详情电话联系！
         * price : null
         * hireEnded : false
         * project : {"id":276477,"status":{"id":"AUDITED","text":"已审核","groupTitle":null},"startTime":"2018-03-09 10:53:12","endTime":null,"updateTime":null,"createTime":null,"name":"广东深圳中建一局项目-招普工","company":null,"description":null,"memo":null,"dcenterDesc":null,"district":{"id":1199,"title":"深圳市"},"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"广东深圳"}
         * type : {"id":"PROJECT_TYPE_WORKER","text":"班组","groupTitle":null}
         * salary : 面议
         * userDeleted : false
         * phone : 15889430709
         * status : {"id":"HIRE_TYPE_AUDITED","text":"正在招聘","groupTitle":null}
         * company : null
         * source : 林启都
         * hireId : 37070
         * smsNum : 0
         * teamNeeds : [{"id":276479,"teamType":{"id":20692,"title":"普工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null},"szTypeId":144046,"msgIndex":2642,"libraryCount":8058},"peopleNumber":15,"memo":null}]
         * contacts : 何女士
         */

        private int id;
        private String publishedTime;
        private String title;
        private Object closeTime;
        private Object teamRequire;
        private String memo;
        private String price;
        private boolean hireEnded;
        private ProjectBean project;
        private TypeBean type;
        private String salary;
        private boolean userDeleted;
        private String phone;
        private StatusBeanX status;
        private Object company;
        private String source;
        private int hireId;
        private int smsNum;
        private String contacts;
        private List<TeamNeedsBean> teamNeeds;
        private int cityId;

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
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

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getHireId() {
            return hireId;
        }

        public void setHireId(int hireId) {
            this.hireId = hireId;
        }

        public int getSmsNum() {
            return smsNum;
        }

        public void setSmsNum(int smsNum) {
            this.smsNum = smsNum;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public List<TeamNeedsBean> getTeamNeeds() {
            return teamNeeds;
        }

        public void setTeamNeeds(List<TeamNeedsBean> teamNeeds) {
            this.teamNeeds = teamNeeds;
        }

        public static class ProjectBean {
            /**
             * id : 276477
             * status : {"id":"AUDITED","text":"已审核","groupTitle":null}
             * startTime : 2018-03-09 10:53:12
             * endTime : null
             * updateTime : null
             * createTime : null
             * name : 广东深圳中建一局项目-招普工
             * company : null
             * description : null
             * memo : null
             * dcenterDesc : null
             * district : {"id":1199,"title":"深圳市"}
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
             * streetAddress : 广东深圳
             */

            private int id;
            private StatusBean status;
            private String startTime;
            private Object endTime;
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
                 * groupTitle : null
                 */

                private String id;
                private String text;
                private Object groupTitle;

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

                public Object getGroupTitle() {
                    return groupTitle;
                }

                public void setGroupTitle(Object groupTitle) {
                    this.groupTitle = groupTitle;
                }
            }

            public static class DistrictBean {
                /**
                 * id : 1199
                 * title : 深圳市
                 */

                private int id;
                private String title;

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
            }
        }

        public static class TypeBean {
            /**
             * id : PROJECT_TYPE_WORKER
             * text : 班组
             * groupTitle : null
             */

            private String id;
            private String text;
            private Object groupTitle;

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

            public Object getGroupTitle() {
                return groupTitle;
            }

            public void setGroupTitle(Object groupTitle) {
                this.groupTitle = groupTitle;
            }
        }

        public static class StatusBeanX {
            /**
             * id : HIRE_TYPE_AUDITED
             * text : 正在招聘
             * groupTitle : null
             */

            private String id;
            private String text;
            private Object groupTitle;

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

            public Object getGroupTitle() {
                return groupTitle;
            }

            public void setGroupTitle(Object groupTitle) {
                this.groupTitle = groupTitle;
            }
        }

        public static class TeamNeedsBean {
            /**
             * id : 276479
             * teamType : {"id":20692,"title":"普工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null},"szTypeId":144046,"msgIndex":2642,"libraryCount":8058}
             * peopleNumber : 15
             * memo : null
             */

            private int id;
            private TeamTypeBean teamType;
            private int peopleNumber;
            private Object memo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public TeamTypeBean getTeamType() {
                return teamType;
            }

            public void setTeamType(TeamTypeBean teamType) {
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

            public static class TeamTypeBean {
                /**
                 * id : 20692
                 * title : 普工班
                 * category : {"id":"TUJIAN","text":"土建","groupTitle":null}
                 * szTypeId : 144046
                 * msgIndex : 2642
                 * libraryCount : 8058
                 */

                private int id;
                private String title;
                private CategoryBean category;
                private int szTypeId;
                private int msgIndex;
                private int libraryCount;

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

                public CategoryBean getCategory() {
                    return category;
                }

                public void setCategory(CategoryBean category) {
                    this.category = category;
                }

                public int getSzTypeId() {
                    return szTypeId;
                }

                public void setSzTypeId(int szTypeId) {
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

                public static class CategoryBean {
                    /**
                     * id : TUJIAN
                     * text : 土建
                     * groupTitle : null
                     */

                    private String id;
                    private String text;
                    private Object groupTitle;

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

                    public Object getGroupTitle() {
                        return groupTitle;
                    }

                    public void setGroupTitle(Object groupTitle) {
                        this.groupTitle = groupTitle;
                    }
                }
            }
        }
    }

    public static class SortBean {
        /**
         * direction : DESC
         * property : publishedTime
         * ignoreCase : false
         * nullHandling : NATIVE
         * ascending : false
         */

        private String direction;
        private String property;
        private boolean ignoreCase;
        private String nullHandling;
        private boolean ascending;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        public void setIgnoreCase(boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public String getNullHandling() {
            return nullHandling;
        }

        public void setNullHandling(String nullHandling) {
            this.nullHandling = nullHandling;
        }

        public boolean isAscending() {
            return ascending;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }
    }
}
