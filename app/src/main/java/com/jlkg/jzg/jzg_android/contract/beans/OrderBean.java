package com.jlkg.jzg.jzg_android.contract.beans;

/**
 * Created by zcs on 2018/4/18.
 *
 * @describe:
 */

public class OrderBean {

    /**
     * id : 85850
     * applyAmount : 30
     * status : {"id":"ORDER_STATUS_SUBMITED","text":"已提交","groupTitle":null,"orderIndex":null}
     * team : {"id":84091,"teamType":{"id":20696,"title":"造价员","category":{"id":"GUANLI","text":"管理","groupTitle":null,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null}
     * applyDate : 2018-04-18 16:02:33
     * paidDate : null
     * platformPaidDate : null
     * teamComfirmDate : null
     * auditNo : S2018033006022303384091
     * remarks : null
     */

    private int id;
    private int applyAmount;
    private StatusBean status;
    private TeamBean team;
    private String applyDate;
    private String paidDate;
    private String platformPaidDate;
    private String teamComfirmDate;
    private String auditNo;
    private Object remarks;
//    private ContractDetailBean contract;
//
//    public ContractDetailBean getContract() {
//        return contract;
//    }
//
//    public void setContract(ContractDetailBean contract) {
//        this.contract = contract;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(int applyAmount) {
        this.applyAmount = applyAmount;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public TeamBean getTeam() {
        return team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getPlatformPaidDate() {
        return platformPaidDate;
    }

    public void setPlatformPaidDate(String platformPaidDate) {
        this.platformPaidDate = platformPaidDate;
    }

    public String getTeamComfirmDate() {
        return teamComfirmDate;
    }

    public void setTeamComfirmDate(String teamComfirmDate) {
        this.teamComfirmDate = teamComfirmDate;
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    public static class StatusBean {
        /**
         * id : ORDER_STATUS_SUBMITED
         * text : 已提交
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

    public static class TeamBean {
        /**
         * id : 84091
         * teamType : {"id":20696,"title":"造价员","category":{"id":"GUANLI","text":"管理","groupTitle":null,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
         * userName : 13071010127
         * photo : {"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"}
         * title : 熊大
         * idNumber : 412825198905112011
         * idFront : {"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"}
         * skill : null
         * phone : 13071010127
         * address : 深圳福田
         * bankInfo : null
         * bankCardNo : null
         * notes : asdasd
         * nativePlace : null
         * nation : null
         * sinceTime : null
         * gender : 男
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
         * cardFront : {"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"}
         * startTime : null
         * emergencyContacts : null
         * emergencyPhone : null
         * starsLevel : null
         * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null}
         * district : null
         * streetAddress : sadasd
         * createTime : 2018-03-20 15:06:31
         * bankAccount : null
         * accountType : TEAM
         * displayAddress :
         * membersCount : 3
         * viewPoint : null
         * suid : null
         */

        private int id;
        private TeamTypeBean teamType;
        private String userName;
        private PhotoBean photo;
        private String title;
        private String idNumber;
        private IdFrontBean idFront;
        private Object skill;
        private String phone;
        private String address;
        private Object bankInfo;
        private Object bankCardNo;
        private String notes;
        private Object nativePlace;
        private Object nation;
        private Object sinceTime;
        private String gender;
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
        private CardFrontBean cardFront;
        private Object startTime;
        private Object emergencyContacts;
        private Object emergencyPhone;
        private Object starsLevel;
        private StatusBeanX status;
        private Object district;
        private String streetAddress;
        private String createTime;
        private Object bankAccount;
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

        public PhotoBean getPhoto() {
            return photo;
        }

        public void setPhoto(PhotoBean photo) {
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
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

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
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

        public CardFrontBean getCardFront() {
            return cardFront;
        }

        public void setCardFront(CardFrontBean cardFront) {
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

        public Object getStarsLevel() {
            return starsLevel;
        }

        public void setStarsLevel(Object starsLevel) {
            this.starsLevel = starsLevel;
        }

        public StatusBeanX getStatus() {
            return status;
        }

        public void setStatus(StatusBeanX status) {
            this.status = status;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(Object bankAccount) {
            this.bankAccount = bankAccount;
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
             * id : 20696
             * title : 造价员
             * category : {"id":"GUANLI","text":"管理","groupTitle":null,"orderIndex":1}
             * szTypeId : null
             * msgIndex : 0
             * libraryCount : 0
             * status : 1
             */

            private int id;
            private String title;
            private CategoryBean category;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public static class CategoryBean {
                /**
                 * id : GUANLI
                 * text : 管理
                 * groupTitle : null
                 * orderIndex : 1
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

        public static class PhotoBean {
            /**
             * id : 85766
             * host : http://jianzhugang.xzgapp.com
             * name : 3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
             * url : http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
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

        public static class IdFrontBean {
            /**
             * id : 84095
             * host : http://jianzhugang.xzgapp.com
             * name : 1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
             * url : http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
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

        public static class CardFrontBean {
            /**
             * id : 84096
             * host : http://jianzhugang.xzgapp.com
             * name : 5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
             * url : http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
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

        public static class StatusBeanX {
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
    }
}
