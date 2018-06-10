package com.jlkg.jzg.jzg_android.home.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/16.
 */

public class JIXieZulinBean {

    /**
     * content : [{"id":83948,"title":null,"type":{"id":"MACHINE_CATEGORY_1_5","text":"---自卸车","category":"MACHINE_CATEGORY","groupTitle":"(NULL)","system":false,"orderIndex":6},"spec":null,"amount":1,"district":{"id":11053,"title":"海沧区","type":"DISTRICT","parent":{"id":1116,"title":"厦门市","type":"CITY","parent":{"id":13,"title":"福建省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"streetAddress":"12号","buyTime":null,"machine":{"id":1,"userName":"15919817240","password":"123456","title":"12","ownerName":"123","image":{"id":2,"host":"http://jianzhugang.xzgapp.com","name":"144799424263315976881135.png","url":"http://jianzhugang.xzgapp.com/144799424263315976881135.png"},"phone":"1","district":{"id":2,"title":"天津市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"streetAddress":"1","createTime":"2017-08-08 10:43:17","accountType":"MACHINE","displayAddress":""},"image":null,"price":null,"available":false,"createDate":"2018-03-15 14:48:24","displayAddress":"福建省厦门市海沧区12号","memo":"求租备注","shuoming":"求租信息","mobile":"13123456789","contacts":null},{"id":83942,"title":null,"type":{"id":"MACHINE_CATEGORY_1_2","text":"---推土机","category":"MACHINE_CATEGORY","groupTitle":"(NULL)","system":false,"orderIndex":3},"spec":null,"amount":12,"district":{"id":11858,"title":"榕城区","type":"DISTRICT","parent":{"id":1216,"title":"揭阳市","type":"CITY","parent":{"id":19,"title":"广东省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"streetAddress":"24","buyTime":null,"machine":{"id":1,"userName":"15919817240","password":"123456","title":"12","ownerName":"123","image":{"id":2,"host":"http://jianzhugang.xzgapp.com","name":"144799424263315976881135.png","url":"http://jianzhugang.xzgapp.com/144799424263315976881135.png"},"phone":"1","district":{"id":2,"title":"天津市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"streetAddress":"1","createTime":"2017-08-08 10:43:17","accountType":"MACHINE","displayAddress":""},"image":null,"price":null,"available":false,"createDate":"2018-03-14 16:33:00","displayAddress":"广东省揭阳市榕城区24","memo":"测试","shuoming":"测试","mobile":"13010102020","contacts":null}]
     * last : true
     * totalElements : 2
     * totalPages : 1
     * size : 10
     * number : 0
     * sort : [{"direction":"DESC","property":"createDate","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * first : true
     * numberOfElements : 2
     */

    private boolean last;
    private int totalElements;
    private int totalPages;
    private int size;
    private int number;
    private boolean first;
    private int numberOfElements;
    private List<ContentBean> content;
    private List<SortBean> sort;

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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
         * id : 83948
         * title : null
         * type : {"id":"MACHINE_CATEGORY_1_5","text":"---自卸车","category":"MACHINE_CATEGORY","groupTitle":"(NULL)","system":false,"orderIndex":6}
         * spec : null
         * amount : 1
         * district : {"id":11053,"title":"海沧区","type":"DISTRICT","parent":{"id":1116,"title":"厦门市","type":"CITY","parent":{"id":13,"title":"福建省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
         * streetAddress : 12号
         * buyTime : null
         * machine : {"id":1,"userName":"15919817240","password":"123456","title":"12","ownerName":"123","image":{"id":2,"host":"http://jianzhugang.xzgapp.com","name":"144799424263315976881135.png","url":"http://jianzhugang.xzgapp.com/144799424263315976881135.png"},"phone":"1","district":{"id":2,"title":"天津市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"streetAddress":"1","createTime":"2017-08-08 10:43:17","accountType":"MACHINE","displayAddress":""}
         * image : null
         * price : null
         * available : false
         * createDate : 2018-03-15 14:48:24
         * displayAddress : 福建省厦门市海沧区12号
         * memo : 求租备注
         * shuoming : 求租信息
         * mobile : 13123456789
         * contacts : null
         */

        private int id;
        private String title;
        private TypeBean type;
        private Object spec;
        private int amount;
        private DistrictBean district;
        private String streetAddress;
        private Object buyTime;
        private MachineBean machine;
        private String image;
        private String price;
        private boolean available;
        private String createDate;
        private String displayAddress;
        private String memo;
        private String shuoming;
        private String mobile;
        private String contacts;
        private int projectId;

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        /**
         * spec : null
         * district : null
         * buyTime : null
         * machine : null
         * team : null
         * image : null
         * teamId : null
         * companyId : null
         * status : {"id":"ASK_LETING","text":"招租中","category":"MACHINE_ASK_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         */

        private StatusBean status;

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

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public Object getSpec() {
            return spec;
        }

        public void setSpec(Object spec) {
            this.spec = spec;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public DistrictBean getDistrict() {
            return district;
        }

        public void setDistrict(DistrictBean district) {
            this.district = district;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public Object getBuyTime() {
            return buyTime;
        }

        public void setBuyTime(Object buyTime) {
            this.buyTime = buyTime;
        }

        public MachineBean getMachine() {
            return machine;
        }

        public void setMachine(MachineBean machine) {
            this.machine = machine;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getDisplayAddress() {
            return displayAddress;
        }

        public void setDisplayAddress(String displayAddress) {
            this.displayAddress = displayAddress;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getShuoming() {
            return shuoming;
        }

        public void setShuoming(String shuoming) {
            this.shuoming = shuoming;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
        }

        public static class TypeBean {
            /**
             * id : MACHINE_CATEGORY_1_5
             * text : ---自卸车
             * category : MACHINE_CATEGORY
             * groupTitle : (NULL)
             * system : false
             * orderIndex : 6
             */

            private String id;
            private String text;
            private String category;
            private String groupTitle;
            private boolean system;
            private int orderIndex;

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

            public String getGroupTitle() {
                return groupTitle;
            }

            public void setGroupTitle(String groupTitle) {
                this.groupTitle = groupTitle;
            }

            public boolean isSystem() {
                return system;
            }

            public void setSystem(boolean system) {
                this.system = system;
            }

            public int getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(int orderIndex) {
                this.orderIndex = orderIndex;
            }
        }

        public static class DistrictBean {
            /**
             * id : 11053
             * title : 海沧区
             * type : DISTRICT
             * parent : {"id":1116,"title":"厦门市","type":"CITY","parent":{"id":13,"title":"福建省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
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
                 * id : 1116
                 * title : 厦门市
                 * type : CITY
                 * parent : {"id":13,"title":"福建省","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
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

                public static class ParentBean {
                    /**
                     * id : 13
                     * title : 福建省
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

        public static class MachineBean {
            /**
             * id : 1
             * userName : 15919817240
             * password : 123456
             * title : 12
             * ownerName : 123
             * image : {"id":2,"host":"http://jianzhugang.xzgapp.com","name":"144799424263315976881135.png","url":"http://jianzhugang.xzgapp.com/144799424263315976881135.png"}
             * phone : 1
             * district : {"id":2,"title":"天津市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
             * streetAddress : 1
             * createTime : 2017-08-08 10:43:17
             * accountType : MACHINE
             * displayAddress :
             */

            private int id;
            private String userName;
            private String password;
            private String title;
            private String ownerName;
            private ImageBean image;
            private String phone;
            private DistrictBeanX district;
            private String streetAddress;
            private String createTime;
            private String accountType;
            private String displayAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public ImageBean getImage() {
                return image;
            }

            public void setImage(ImageBean image) {
                this.image = image;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public DistrictBeanX getDistrict() {
                return district;
            }

            public void setDistrict(DistrictBeanX district) {
                this.district = district;
            }

            public String getStreetAddress() {
                return streetAddress;
            }

            public void setStreetAddress(String streetAddress) {
                this.streetAddress = streetAddress;
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

            public String getDisplayAddress() {
                return displayAddress;
            }

            public void setDisplayAddress(String displayAddress) {
                this.displayAddress = displayAddress;
            }

            public static class ImageBean {
                /**
                 * id : 2
                 * host : http://jianzhugang.xzgapp.com
                 * name : 144799424263315976881135.png
                 * url : http://jianzhugang.xzgapp.com/144799424263315976881135.png
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

            public static class DistrictBeanX {
                /**
                 * id : 2
                 * title : 天津市
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

        public static class StatusBean {
            /**
             * id : ASK_LETING
             * text : 招租中
             * category : MACHINE_ASK_STATUS
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
                return this.id;
            }

            public void setId(String idX) {
                this.id = idX;
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

    public static class SortBean {
        /**
         * direction : DESC
         * property : createDate
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
