package com.jlkg.jzg.jzg_android.personal.bean;

/**
 * Created by yangxiaolong on 2018/3/24.
 */

public class SelectPersonnelBean {


    /**
     * projectTitle : 深圳市宝城22区旧城改造项目
     * team : {"id":48901,"teamType":{"id":2,"title":"木工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2},"szTypeId":null,"msgIndex":3,"libraryCount":3},"userName":"13590249881","photo":null,"title":"彭天","idNumber":"442445199108220883","idFront":{"id":61128,"host":"http://jianzhugang.xzgapp.com","name":"1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg","url":"http://jianzhugang.xzgapp.com/1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg"},"skill":null,"phone":null,"address":"广东省深圳市南山区西丽","bankInfo":null,"bankCardNo":null,"notes":null,"nativePlace":null,"nation":null,"sinceTime":null,"gender":null,"skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":null,"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"starsLevel":2,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"district":{"id":11771,"title":"南山区"},"streetAddress":"西丽","createTime":"2016-03-31 09:55:12","accountType":"TEAM","displayAddress":"广东省深圳市南山区西丽","membersCount":8,"viewPoint":null,"suid":null}
     */

    private String projectTitle;
    private TeamBean team;

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public TeamBean getTeam() {
        return team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public static class TeamBean {
        /**
         * id : 48901
         * teamType : {"id":2,"title":"木工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2},"szTypeId":null,"msgIndex":3,"libraryCount":3}
         * userName : 13590249881
         * photo : null
         * title : 彭天
         * idNumber : 442445199108220883
         * idFront : {"id":61128,"host":"http://jianzhugang.xzgapp.com","name":"1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg","url":"http://jianzhugang.xzgapp.com/1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg"}
         * skill : null
         * phone : null
         * address : 广东省深圳市南山区西丽
         * bankInfo : null
         * bankCardNo : null
         * notes : null
         * nativePlace : null
         * nation : null
         * sinceTime : null
         * gender : null
         * skillCertificate : null
         * education : null
         * birthday : null
         * position : null
         * certificate : null
         * safe : false
         * companyName : null
         * capital : null
         * legalPerson : null
         * companyAddress : null
         * xinyongCode : null
         * cardFront : null
         * startTime : null
         * emergencyContacts : null
         * emergencyPhone : null
         * starsLevel : 2
         * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null}
         * district : {"id":11771,"title":"南山区"}
         * streetAddress : 西丽
         * createTime : 2016-03-31 09:55:12
         * accountType : TEAM
         * displayAddress : 广东省深圳市南山区西丽
         * membersCount : 8
         * viewPoint : null
         * suid : null
         */

        private int id;
        private TeamTypeBean teamType;
        private String userName;
        private String photo;
        private String title;
        private String idNumber;
        private IdFrontBean idFront;
        private Object skill;
        private Object phone;
        private String address;
        private Object bankInfo;
        private Object bankCardNo;
        private Object notes;
        private Object nativePlace;
        private Object nation;
        private Object sinceTime;
        private Object gender;
        private Object skillCertificate;
        private Object education;
        private Object birthday;
        private Object position;
        private Object certificate;
        private boolean safe;
        private Object companyName;
        private Object capital;
        private Object legalPerson;
        private Object companyAddress;
        private Object xinyongCode;
        private Object cardFront;
        private Object startTime;
        private Object emergencyContacts;
        private Object emergencyPhone;
        private int starsLevel;
        private StatusBean status;
        private DistrictBean district;
        private String streetAddress;
        private String createTime;
        private String accountType;
        private String displayAddress;
        private int membersCount;
        private Object viewPoint;
        private Object suid;

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public IdFrontBean getIdFront() {
            return idFront;
        }

        public void setIdFront(IdFrontBean idFront) {
            this.idFront = idFront;
        }

        public Object getSkill() {
            return skill;
        }

        public void setSkill(Object skill) {
            this.skill = skill;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getBankInfo() {
            return bankInfo;
        }

        public void setBankInfo(Object bankInfo) {
            this.bankInfo = bankInfo;
        }

        public Object getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(Object bankCardNo) {
            this.bankCardNo = bankCardNo;
        }

        public Object getNotes() {
            return notes;
        }

        public void setNotes(Object notes) {
            this.notes = notes;
        }

        public Object getNativePlace() {
            return nativePlace;
        }

        public void setNativePlace(Object nativePlace) {
            this.nativePlace = nativePlace;
        }

        public Object getNation() {
            return nation;
        }

        public void setNation(Object nation) {
            this.nation = nation;
        }

        public Object getSinceTime() {
            return sinceTime;
        }

        public void setSinceTime(Object sinceTime) {
            this.sinceTime = sinceTime;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getSkillCertificate() {
            return skillCertificate;
        }

        public void setSkillCertificate(Object skillCertificate) {
            this.skillCertificate = skillCertificate;
        }

        public Object getEducation() {
            return education;
        }

        public void setEducation(Object education) {
            this.education = education;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }

        public Object getCertificate() {
            return certificate;
        }

        public void setCertificate(Object certificate) {
            this.certificate = certificate;
        }

        public boolean isSafe() {
            return safe;
        }

        public void setSafe(boolean safe) {
            this.safe = safe;
        }

        public Object getCompanyName() {
            return companyName;
        }

        public void setCompanyName(Object companyName) {
            this.companyName = companyName;
        }

        public Object getCapital() {
            return capital;
        }

        public void setCapital(Object capital) {
            this.capital = capital;
        }

        public Object getLegalPerson() {
            return legalPerson;
        }

        public void setLegalPerson(Object legalPerson) {
            this.legalPerson = legalPerson;
        }

        public Object getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(Object companyAddress) {
            this.companyAddress = companyAddress;
        }

        public Object getXinyongCode() {
            return xinyongCode;
        }

        public void setXinyongCode(Object xinyongCode) {
            this.xinyongCode = xinyongCode;
        }

        public Object getCardFront() {
            return cardFront;
        }

        public void setCardFront(Object cardFront) {
            this.cardFront = cardFront;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEmergencyContacts() {
            return emergencyContacts;
        }

        public void setEmergencyContacts(Object emergencyContacts) {
            this.emergencyContacts = emergencyContacts;
        }

        public Object getEmergencyPhone() {
            return emergencyPhone;
        }

        public void setEmergencyPhone(Object emergencyPhone) {
            this.emergencyPhone = emergencyPhone;
        }

        public int getStarsLevel() {
            return starsLevel;
        }

        public void setStarsLevel(int starsLevel) {
            this.starsLevel = starsLevel;
        }

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
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

        public int getMembersCount() {
            return membersCount;
        }

        public void setMembersCount(int membersCount) {
            this.membersCount = membersCount;
        }

        public Object getViewPoint() {
            return viewPoint;
        }

        public void setViewPoint(Object viewPoint) {
            this.viewPoint = viewPoint;
        }

        public Object getSuid() {
            return suid;
        }

        public void setSuid(Object suid) {
            this.suid = suid;
        }

        public static class TeamTypeBean {
            /**
             * id : 2
             * title : 木工班
             * category : {"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2}
             * szTypeId : null
             * msgIndex : 3
             * libraryCount : 3
             */

            private int id;
            private String title;
            private CategoryBean category;
            private Object szTypeId;
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

            public static class CategoryBean {
                /**
                 * id : TUJIAN
                 * text : 土建
                 * groupTitle : null
                 * orderIndex : 2
                 */

                private String id;
                private String text;
                private Object groupTitle;
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

                public Object getGroupTitle() {
                    return groupTitle;
                }

                public void setGroupTitle(Object groupTitle) {
                    this.groupTitle = groupTitle;
                }

                public int getOrderIndex() {
                    return orderIndex;
                }

                public void setOrderIndex(int orderIndex) {
                    this.orderIndex = orderIndex;
                }
            }
        }

        public static class IdFrontBean {
            /**
             * id : 61128
             * host : http://jianzhugang.xzgapp.com
             * name : 1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg
             * url : http://jianzhugang.xzgapp.com/1c8aabe8-00b4-44d7-a87f-50de57adddc4.jpg
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

        public static class StatusBean {
            /**
             * id : TEAM_STATUS_NORMAL
             * text : 正常
             * groupTitle : null
             * orderIndex : null
             */

            private String id;
            private String text;
            private Object groupTitle;
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

            public Object getGroupTitle() {
                return groupTitle;
            }

            public void setGroupTitle(Object groupTitle) {
                this.groupTitle = groupTitle;
            }

            public Object getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(Object orderIndex) {
                this.orderIndex = orderIndex;
            }
        }

        public static class DistrictBean {
            /**
             * id : 11771
             * title : 南山区
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
}
