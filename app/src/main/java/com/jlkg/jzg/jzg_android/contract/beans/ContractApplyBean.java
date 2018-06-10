package com.jlkg.jzg.jzg_android.contract.beans;

import java.util.List;

/**
 * Created by zcs on 2018/3/30.
 *
 * @describe:
 */

public class ContractApplyBean {

    /**
     * id : 83974
     * contractNumber : null
     * team : {"id":70271,"teamType":{"id":1,"title":"瓦工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2},"szTypeId":82878,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13189038693","photo":{"id":84375,"host":"http://jianzhugang.xzgapp.com","name":"3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg","url":"http://jianzhugang.xzgapp.com/3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg"},"title":"盛雨杰","idNumber":"445512001212121214","idFront":null,"skill":null,"phone":null,"address":"广东省中山市","bankInfo":"农业银行","bankCardNo":"6228480402564890018","notes":"测试","nativePlace":"深圳","nation":"汉","sinceTime":"1970-01-01 08:00:00","gender":"男","skillCertificate":null,"education":"高中","birthday":"1980-0102","position":"测试","certificate":null,"safe":true,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":null,"startTime":"2018-03-01 00:00:00","emergencyContacts":null,"emergencyPhone":null,"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"district":{"id":12863,"title":"莞城区"},"streetAddress":null,"createTime":"2016-05-24 00:00:00","bankAccount":null,"accountType":"TEAM","displayAddress":"广东省东莞市莞城区","membersCount":2,"viewPoint":null,"suid":null}
     * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","groupTitle":null,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
     * applyCompany : null
     * projectHire : {"id":83972,"publishedTime":"2018-03-16 17:32:29","title":null,"closeTime":null,"teamRequire":"测","memo":"测试","price":null,"hireEnded":false,"project":{"id":83937,"status":null,"buildingStatus":null,"startTime":"2018-03-14 00:00:00","endTime":"2018-06-22 00:00:00","updateTime":null,"createTime":null,"name":"极联","company":null,"description":"联系人邮箱","memo":null,"dcenterDesc":null,"district":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"广东省深圳市南山区科技园"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","groupTitle":null,"orderIndex":null},"salary":"900","userDeleted":true,"phone":"12410102020","status":{"id":"HIRE_TYPE_AUDITED","text":"正在招聘","groupTitle":null,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","groupTitle":null,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":83973,"teamType":{"id":39,"title":"旋挖钻机","category":{"id":"ZULING","text":"租赁","groupTitle":null,"orderIndex":null},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":0},"peopleNumber":1,"memo":null}],"contacts":"测试003","provinceId":19,"cityId":1199,"districtId":11771,"teamNeedStr":"G39Z"}
     * status : {"id":"CONFIRMED","text":"已确认","groupTitle":null,"orderIndex":null}
     * applyDate : 2018-03-16 17:33:05
     * confirmDate : 2018-03-16 17:34:41
     * signDate : 2018-03-16 17:34:41
     * endDate : null
     */

    private int id;
    private Object contractNumber;
    private TeamBean team;
    private CompanyBean company;
    private ApplyCompanyBean applyCompany;
    private ProjectHireBean projectHire;
    private StatusBeanXXXX status;
    private String applyDate;
    private String confirmDate;
    private String signDate;
    private Object endDate;
    private int machineAskId;
    private ProjectHireBean.ProjectBean project;

    public ProjectHireBean.ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectHireBean.ProjectBean project) {
        this.project = project;
    }

    public int getMachineAskId() {
        return machineAskId;
    }

    public void setMachineAskId(int machineAskId) {
        this.machineAskId = machineAskId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Object contractNumber) {
        this.contractNumber = contractNumber;
    }

    public TeamBean getTeam() {
        return team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public ApplyCompanyBean getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(ApplyCompanyBean applyCompany) {
        this.applyCompany = applyCompany;
    }

    public ProjectHireBean getProjectHire() {
        return projectHire;
    }

    public void setProjectHire(ProjectHireBean projectHire) {
        this.projectHire = projectHire;
    }

    public StatusBeanXXXX getStatus() {
        return status;
    }

    public void setStatus(StatusBeanXXXX status) {
        this.status = status;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }
    public static class TeamBean {
        /**
         * id : 70271
         * teamType : {"id":1,"title":"瓦工班","category":{"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2},"szTypeId":82878,"msgIndex":0,"libraryCount":0,"status":1}
         * userName : 13189038693
         * photo : {"id":84375,"host":"http://jianzhugang.xzgapp.com","name":"3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg","url":"http://jianzhugang.xzgapp.com/3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg"}
         * title : 盛雨杰
         * idNumber : 445512001212121214
         * idFront : null
         * skill : null
         * phone : null
         * address : 广东省中山市
         * bankInfo : 农业银行
         * bankCardNo : 6228480402564890018
         * notes : 测试
         * nativePlace : 深圳
         * nation : 汉
         * sinceTime : 1970-01-01 08:00:00
         * gender : 男
         * skillCertificate : null
         * education : 高中
         * birthday : 1980-0102
         * position : 测试
         * certificate : null
         * safe : true
         * companyName : null
         * capital : null
         * legalPerson : null
         * companyAddress : null
         * xinyongCode : null
         * cardFront : null
         * startTime : 2018-03-01 00:00:00
         * emergencyContacts : null
         * emergencyPhone : null
         * starsLevel : null
         * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null}
         * district : {"id":12863,"title":"莞城区"}
         * streetAddress : null
         * createTime : 2016-05-24 00:00:00
         * bankAccount : null
         * accountType : TEAM
         * displayAddress : 广东省东莞市莞城区
         * membersCount : 2
         * viewPoint : null
         * suid : null
         */

        private int id;
        private TeamTypeBean teamType;
        private String userName;
        private PhotoBean photo;
        private String title;
        private String idNumber;
        private Object idFront;
        private Object skill;
        private Object phone;
        private String address;
        private String bankInfo;
        private String bankCardNo;
        private String notes;
        private String nativePlace;
        private String nation;
        private String sinceTime;
        private String gender;
        private Object skillCertificate;
        private String education;
        private String birthday;
        private String position;
        private Object certificate;
        private boolean safe;
        private Object companyName;
        private Object capital;
        private Object legalPerson;
        private Object companyAddress;
        private Object xinyongCode;
        private Object cardFront;
        private String startTime;
        private Object emergencyContacts;
        private Object emergencyPhone;
        private Object starsLevel;
        private StatusBean status;
        private DistrictBean district;
        private Object streetAddress;
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

        public Object getIdFront() {
            return idFront;
        }

        public void setIdFront(Object idFront) {
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

        public String getBankInfo() {
            return bankInfo;
        }

        public void setBankInfo(String bankInfo) {
            this.bankInfo = bankInfo;
        }

        public String getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(String bankCardNo) {
            this.bankCardNo = bankCardNo;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public void setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getSinceTime() {
            return sinceTime;
        }

        public void setSinceTime(String sinceTime) {
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

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
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

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
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

        public Object getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(Object streetAddress) {
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
             * id : 1
             * title : 瓦工班
             * category : {"id":"TUJIAN","text":"土建","groupTitle":null,"orderIndex":2}
             * szTypeId : 82878
             * msgIndex : 0
             * libraryCount : 0
             * status : 1
             */

            private int id;
            private String title;
            private CategoryBean category;
            private int szTypeId;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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

        public static class PhotoBean {
            /**
             * id : 84375
             * host : http://jianzhugang.xzgapp.com
             * name : 3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg
             * url : http://jianzhugang.xzgapp.com/3ae595a9-50b9-41e6-9ce0-a4c15b4601de.jpg
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
             * id : 12863
             * title : 莞城区
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

    public static class CompanyBean {
        /**
         * id : 3120
         * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","groupTitle":null,"orderIndex":null}
         * userName : 13426599742
         * title : 凌峰
         * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
         * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
         * organizationCode : 791202564
         * contacts : 吕佳伟
         * phone : 13426599742
         * fax : null
         * email : null
         * website : null
         * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null}
         * createTime : null
         * accountType : COMPANY
         * parentCompany : null
         * superviseCompany : null
         * topCompany : false
         * adminCompany : true
         * notes : null
         * bankAccount : null
         * streetAddress : null
         */

        private int id;
        private CompanyTypeBean companyType;
        private String userName;
        private String title;
        private LogoBean logo;
        private TouxiangBean touxiang;
        private String organizationCode;
        private String contacts;
        private String phone;
        private Object fax;
        private Object email;
        private Object website;
        private StatusBeanX status;
        private Object createTime;
        private String accountType;
        private Object parentCompany;
        private Object superviseCompany;
        private boolean topCompany;
        private boolean adminCompany;
        private String notes;
        private Object bankAccount;
        private Object streetAddress;

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

        public LogoBean getLogo() {
            return logo;
        }

        public void setLogo(LogoBean logo) {
            this.logo = logo;
        }

        public TouxiangBean getTouxiang() {
            return touxiang;
        }

        public void setTouxiang(TouxiangBean touxiang) {
            this.touxiang = touxiang;
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

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
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

        public Object getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(Object bankAccount) {
            this.bankAccount = bankAccount;
        }

        public Object getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(Object streetAddress) {
            this.streetAddress = streetAddress;
        }

        public static class CompanyTypeBean {
            /**
             * id : COMPANY_TYPE_1
             * text : 建筑公司
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

        public static class LogoBean {
            /**
             * id : 84364
             * host : http://jianzhugang.xzgapp.com
             * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
             * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
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

        public static class TouxiangBean {
            /**
             * id : 84436
             * host : http://jianzhugang.xzgapp.com
             * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
             * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
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
             * id : COMPANY_STATUS_NORMAL
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

    public static class ProjectHireBean {
        /**
         * id : 83972
         * publishedTime : 2018-03-16 17:32:29
         * title : null
         * closeTime : null
         * teamRequire : 测
         * memo : 测试
         * price : null
         * hireEnded : false
         * project : {"id":83937,"status":null,"buildingStatus":null,"startTime":"2018-03-14 00:00:00","endTime":"2018-06-22 00:00:00","updateTime":null,"createTime":null,"name":"极联","company":null,"description":"联系人邮箱","memo":null,"dcenterDesc":null,"district":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":null,"contactsPosition":null,"contactsPhone":null,"contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"广东省深圳市南山区科技园"}
         * type : {"id":"PROJECT_TYPE_WORKER","text":"班组","groupTitle":null,"orderIndex":null}
         * salary : 900
         * userDeleted : true
         * phone : 12410102020
         * status : {"id":"HIRE_TYPE_AUDITED","text":"正在招聘","groupTitle":null,"orderIndex":null}
         * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","groupTitle":null,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
         * source : 注册公司
         * hireId : null
         * smsNum : 0
         * teamNeeds : [{"id":83973,"teamType":{"id":39,"title":"旋挖钻机","category":{"id":"ZULING","text":"租赁","groupTitle":null,"orderIndex":null},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":0},"peopleNumber":1,"memo":null}]
         * contacts : 测试003
         * provinceId : 19
         * cityId : 1199
         * districtId : 11771
         * teamNeedStr : G39Z
         */

        private int id;
        private String publishedTime;
        private Object title;
        private Object closeTime;
        private String teamRequire;
        private String memo;
        private Object price;
        private boolean hireEnded;
        private ProjectBean project;
        private TypeBean type;
        private String salary;
        private boolean userDeleted;
        private String phone;
        private StatusBeanXX status;
        private CompanyBeanX company;
        private String source;
        private Object hireId;
        private int smsNum;
        private String contacts;
        private int provinceId;
        private int cityId;
        private int districtId;
        private String teamNeedStr;
        private List<TeamNeedsBean> teamNeeds;

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

        public String getTeamRequire() {
            return teamRequire;
        }

        public void setTeamRequire(String teamRequire) {
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

        public StatusBeanXX getStatus() {
            return status;
        }

        public void setStatus(StatusBeanXX status) {
            this.status = status;
        }

        public CompanyBeanX getCompany() {
            return company;
        }

        public void setCompany(CompanyBeanX company) {
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

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
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

        public List<TeamNeedsBean> getTeamNeeds() {
            return teamNeeds;
        }

        public void setTeamNeeds(List<TeamNeedsBean> teamNeeds) {
            this.teamNeeds = teamNeeds;
        }

        public static class ProjectBean {
            /**
             * id : 83937
             * status : null
             * buildingStatus : null
             * startTime : 2018-03-14 00:00:00
             * endTime : 2018-06-22 00:00:00
             * updateTime : null
             * createTime : null
             * name : 极联
             * company : null
             * description : 联系人邮箱
             * memo : null
             * dcenterDesc : null
             * district : null
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
             * streetAddress : 广东省深圳市南山区科技园
             */

            private int id;
            private Object status;
            private Object buildingStatus;
            private String startTime;
            private String endTime;
            private Object updateTime;
            private Object createTime;
            private String name;
            private Object company;
            private String description;
            private Object memo;
            private Object dcenterDesc;
            private Object district;
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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
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

            public Object getDistrict() {
                return district;
            }

            public void setDistrict(Object district) {
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
        }

        public static class TypeBean {
            /**
             * id : PROJECT_TYPE_WORKER
             * text : 班组
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

        public static class StatusBeanXX {
            /**
             * id : HIRE_TYPE_AUDITED
             * text : 正在招聘
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

        public static class CompanyBeanX {
            /**
             * id : 3120
             * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","groupTitle":null,"orderIndex":null}
             * userName : 13426599742
             * title : 凌峰
             * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
             * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
             * organizationCode : 791202564
             * contacts : 吕佳伟
             * phone : 13426599742
             * fax : null
             * email : null
             * website : null
             * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","groupTitle":null,"orderIndex":null}
             * createTime : null
             * accountType : COMPANY
             * parentCompany : null
             * superviseCompany : null
             * topCompany : false
             * adminCompany : true
             * notes : null
             * bankAccount : null
             * streetAddress : null
             */

            private int id;
            private CompanyTypeBeanX companyType;
            private String userName;
            private String title;
            private LogoBeanX logo;
            private TouxiangBeanX touxiang;
            private String organizationCode;
            private String contacts;
            private String phone;
            private Object fax;
            private Object email;
            private Object website;
            private StatusBeanXXX status;
            private Object createTime;
            private String accountType;
            private Object parentCompany;
            private Object superviseCompany;
            private boolean topCompany;
            private boolean adminCompany;
            private String notes;
            private Object bankAccount;
            private Object streetAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public CompanyTypeBeanX getCompanyType() {
                return companyType;
            }

            public void setCompanyType(CompanyTypeBeanX companyType) {
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

            public LogoBeanX getLogo() {
                return logo;
            }

            public void setLogo(LogoBeanX logo) {
                this.logo = logo;
            }

            public TouxiangBeanX getTouxiang() {
                return touxiang;
            }

            public void setTouxiang(TouxiangBeanX touxiang) {
                this.touxiang = touxiang;
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

            public Object getFax() {
                return fax;
            }

            public void setFax(Object fax) {
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

            public StatusBeanXXX getStatus() {
                return status;
            }

            public void setStatus(StatusBeanXXX status) {
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

            public Object getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(Object bankAccount) {
                this.bankAccount = bankAccount;
            }

            public Object getStreetAddress() {
                return streetAddress;
            }

            public void setStreetAddress(Object streetAddress) {
                this.streetAddress = streetAddress;
            }

            public static class CompanyTypeBeanX {
                /**
                 * id : COMPANY_TYPE_1
                 * text : 建筑公司
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

            public static class LogoBeanX {
                /**
                 * id : 84364
                 * host : http://jianzhugang.xzgapp.com
                 * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                 * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
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

            public static class TouxiangBeanX {
                /**
                 * id : 84436
                 * host : http://jianzhugang.xzgapp.com
                 * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                 * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
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

            public static class StatusBeanXXX {
                /**
                 * id : COMPANY_STATUS_NORMAL
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

        public static class TeamNeedsBean {
            /**
             * id : 83973
             * teamType : {"id":39,"title":"旋挖钻机","category":{"id":"ZULING","text":"租赁","groupTitle":null,"orderIndex":null},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":0}
             * peopleNumber : 1
             * memo : null
             */

            private int id;
            private TeamTypeBeanX teamType;
            private int peopleNumber;
            private Object memo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public TeamTypeBeanX getTeamType() {
                return teamType;
            }

            public void setTeamType(TeamTypeBeanX teamType) {
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

            public static class TeamTypeBeanX {
                /**
                 * id : 39
                 * title : 旋挖钻机
                 * category : {"id":"ZULING","text":"租赁","groupTitle":null,"orderIndex":null}
                 * szTypeId : null
                 * msgIndex : 0
                 * libraryCount : 0
                 * status : 0
                 */

                private int id;
                private String title;
                private CategoryBeanX category;
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

                public CategoryBeanX getCategory() {
                    return category;
                }

                public void setCategory(CategoryBeanX category) {
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

                public static class CategoryBeanX {
                    /**
                     * id : ZULING
                     * text : 租赁
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
    }

    public static class StatusBeanXXXX {
        /**
         * id : CONFIRMED
         * text : 已确认
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
    public static class ApplyCompanyBean{

        /**
         * id : 86321
         * companyType : {"id":"COMPANY_TYPE_2","text":"劳务公司","groupTitle":null,"orderIndex":null}
         * userName : 15201333908
         * title : 阿毛
         * logo : {"id":86485,"host":"http://jianzhugang.xzgapp.com","name":"34099028-7ba6-4430-9f42-9661c5fe267c.jpg","url":"http://jianzhugang.xzgapp.com/34099028-7ba6-4430-9f42-9661c5fe267c.jpg"}
         * touxiang : {"id":86643,"host":"http://jianzhugang.xzgapp.com","name":"1f4313ca-2547-4298-b86e-66e43f6e5205.jpg","url":"http://jianzhugang.xzgapp.com/1f4313ca-2547-4298-b86e-66e43f6e5205.jpg"}
         * organizationCode : null
         * contacts : 毛毛
         * phone : 15201333908
         * fax : null
         * email : null
         * website : null
         * cardInfo : 建设银行
         * cardNo : 6212264100011335373
         * status : {"id":"COMPANY_STATUS_NOT_AUDIT","text":"待审核","groupTitle":null,"orderIndex":null}
         * createTime : null
         * accountType : COMPANY
         * parentCompany : null
         * superviseCompany : null
         * topCompany : false
         * adminCompany : false
         * notes : 123
         * bankAccount : null
         * streetAddress : 深圳市
         */

        private int id;
        private CompanyTypeBean companyType;
        private String userName;
        private String title;
        private LogoBean logo;
        private TouxiangBean touxiang;
        private Object organizationCode;
        private String contacts;
        private String phone;
        private Object fax;
        private Object email;
        private Object website;
        private String cardInfo;
        private String cardNo;
        private StatusBean status;
        private Object createTime;
        private String accountType;
        private Object parentCompany;
        private Object superviseCompany;
        private boolean topCompany;
        private boolean adminCompany;
        private String notes;
        private Object bankAccount;
        private String streetAddress;

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

        public LogoBean getLogo() {
            return logo;
        }

        public void setLogo(LogoBean logo) {
            this.logo = logo;
        }

        public TouxiangBean getTouxiang() {
            return touxiang;
        }

        public void setTouxiang(TouxiangBean touxiang) {
            this.touxiang = touxiang;
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

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
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

        public String getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(String cardInfo) {
            this.cardInfo = cardInfo;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
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

        public Object getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(Object bankAccount) {
            this.bankAccount = bankAccount;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public static class CompanyTypeBean {
            /**
             * id : COMPANY_TYPE_2
             * text : 劳务公司
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

        public static class LogoBean {
            /**
             * id : 86485
             * host : http://jianzhugang.xzgapp.com
             * name : 34099028-7ba6-4430-9f42-9661c5fe267c.jpg
             * url : http://jianzhugang.xzgapp.com/34099028-7ba6-4430-9f42-9661c5fe267c.jpg
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

        public static class TouxiangBean {
            /**
             * id : 86643
             * host : http://jianzhugang.xzgapp.com
             * name : 1f4313ca-2547-4298-b86e-66e43f6e5205.jpg
             * url : http://jianzhugang.xzgapp.com/1f4313ca-2547-4298-b86e-66e43f6e5205.jpg
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
             * id : COMPANY_STATUS_NOT_AUDIT
             * text : 待审核
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
