package com.jlkg.jzg.jzg_android.personal.bean;

import java.util.List;

/**
 * Created by yangxiaolong on 2018/3/21.
 */

public class LetMachineBean {


    /**
     * content : [{"id":84476,"title":"测试招蛀","type":{"id":"MACHINE_CATEGORY_2_2","text":"---压路机","category":"MACHINE_CATEGORY","groupTitle":"(NULL)","system":false,"orderIndex":11},"spec":null,"amount":12,"district":null,"streetAddress":"广东省深圳市宝安区固戍航城大道航空路银丰工业园c栋2楼","buyTime":null,"machine":null,"team":null,"image":null,"price":"2588","available":false,"createDate":"2018-03-26 14:52:05","displayAddress":"","memo":"测试","shuoming":"巧克力","mobile":"18565860212","contacts":"世界纪录","teamId":82450,"companyId":null,"status":{"id":"ASK_DONE","text":"已完成","category":"MACHINE_ASK_STATUS","groupTitle":null,"system":true,"orderIndex":null}}]
     * last : true
     * totalPages : 1
     * totalElements : 1
     * sort : [{"direction":"DESC","property":"createDate","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 1
     * first : true
     * size : 10
     * number : 0
     */

    private boolean last;
    private int totalPages;
    private int totalElements;
    private int numberOfElements;
    private boolean first;
    private int size;
    private int number;
    private List<ContentEntity> content;
    private List<SortEntity> sort;

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

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
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

    public List<ContentEntity> getContent() {
        return content;
    }

    public void setContent(List<ContentEntity> content) {
        this.content = content;
    }

    public List<SortEntity> getSort() {
        return sort;
    }

    public void setSort(List<SortEntity> sort) {
        this.sort = sort;
    }

    public static class ContentEntity {
        /**
         * id : 84476
         * title : 测试招蛀
         * type : {"id":"MACHINE_CATEGORY_2_2","text":"---压路机","category":"MACHINE_CATEGORY","groupTitle":"(NULL)","system":false,"orderIndex":11}
         * spec : null
         * amount : 12
         * district : null
         * streetAddress : 广东省深圳市宝安区固戍航城大道航空路银丰工业园c栋2楼
         * buyTime : null
         * machine : null
         * team : null
         * image : null
         * price : 2588
         * available : false
         * createDate : 2018-03-26 14:52:05
         * displayAddress :
         * memo : 测试
         * shuoming : 巧克力
         * mobile : 18565860212
         * contacts : 世界纪录
         * teamId : 82450
         * companyId : null
         * status : {"id":"ASK_DONE","text":"已完成","category":"MACHINE_ASK_STATUS","groupTitle":null,"system":true,"orderIndex":null}
         */

        private int id;
        private String title;
        private TypeEntity type;
        private Object spec;
        private int amount;
        private Object district;
        private String streetAddress;
        private Object buyTime;
        private Object machine;
        private Object team;
        private Object image;
        private String price;
        private boolean available;
        private String createDate;
        private String displayAddress;
        private String memo;
        private String shuoming;
        private String mobile;
        private String contacts;
        private int teamId;
        private Object companyId;
        private StatusEntity status;

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

        public TypeEntity getType() {
            return type;
        }

        public void setType(TypeEntity type) {
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

        public Object getDistrict() {
            return district;
        }

        public void setDistrict(Object district) {
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

        public Object getMachine() {
            return machine;
        }

        public void setMachine(Object machine) {
            this.machine = machine;
        }

        public Object getTeam() {
            return team;
        }

        public void setTeam(Object team) {
            this.team = team;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
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

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public Object getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Object companyId) {
            this.companyId = companyId;
        }

        public StatusEntity getStatus() {
            return status;
        }

        public void setStatus(StatusEntity status) {
            this.status = status;
        }

        public static class TypeEntity {
            /**
             * id : MACHINE_CATEGORY_2_2
             * text : ---压路机
             * category : MACHINE_CATEGORY
             * groupTitle : (NULL)
             * system : false
             * orderIndex : 11
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

        public static class StatusEntity {
            /**
             * id : ASK_DONE
             * text : 已完成
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

    public static class SortEntity {
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
