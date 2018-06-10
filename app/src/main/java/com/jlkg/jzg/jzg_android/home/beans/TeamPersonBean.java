package com.jlkg.jzg.jzg_android.home.beans;

/**
 * Created by zcs on 2018/3/10.
 * 团队成员
 */

public class TeamPersonBean {

    /**
     * id : 1
     * phone : null
     * bankName : null
     * cardNumber : null
     * title : 颜杏
     * gender : null
     * nation : null
     * birthday : null
     * nativePlace : null
     * idNumber : null
     * position : null
     * teamType : null
     * certificate : null
     * safe : false
     * xueli : null
     * gangqianPX : false
     * idCardInfo : null
     * shiduan : null
     * peopleType : null
     * workType : null
     * haveContract : false
     * idAgency : null
     * idValiddate : null
     * idphotoScan : null
     * idPhoto : null
     * facephoto : null
     * idFront : null
     * cardFront : null
     * updateTime : null
     * createTime : null
     * status : {"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
     */

    private int id;
    private Object phone;
    private Object bankName;
    private Object cardNumber;
    private String title;
    private Object gender;
    private Object nation;
    private Object birthday;
    private Object nativePlace;
    private Object idNumber;
    private Object position;
    private Object teamType;
    private Object certificate;
    private boolean safe;
    private Object xueli;
    private boolean gangqianPX;
    private Object idCardInfo;
    private Object shiduan;
    private Object peopleType;
    private Object workType;
    private boolean haveContract;
    private Object idAgency;
    private Object idValiddate;
    private Object idphotoScan;
    private Object idPhoto;
    private Object facephoto;
    private Object idFront;
    private Object cardFront;
    private Object updateTime;
    private Object createTime;
    private StatusBean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    public Object getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Object cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getNation() {
        return nation;
    }

    public void setNation(Object nation) {
        this.nation = nation;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Object nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Object getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Object idNumber) {
        this.idNumber = idNumber;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public Object getTeamType() {
        return teamType;
    }

    public void setTeamType(Object teamType) {
        this.teamType = teamType;
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

    public Object getXueli() {
        return xueli;
    }

    public void setXueli(Object xueli) {
        this.xueli = xueli;
    }

    public boolean isGangqianPX() {
        return gangqianPX;
    }

    public void setGangqianPX(boolean gangqianPX) {
        this.gangqianPX = gangqianPX;
    }

    public Object getIdCardInfo() {
        return idCardInfo;
    }

    public void setIdCardInfo(Object idCardInfo) {
        this.idCardInfo = idCardInfo;
    }

    public Object getShiduan() {
        return shiduan;
    }

    public void setShiduan(Object shiduan) {
        this.shiduan = shiduan;
    }

    public Object getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(Object peopleType) {
        this.peopleType = peopleType;
    }

    public Object getWorkType() {
        return workType;
    }

    public void setWorkType(Object workType) {
        this.workType = workType;
    }

    public boolean isHaveContract() {
        return haveContract;
    }

    public void setHaveContract(boolean haveContract) {
        this.haveContract = haveContract;
    }

    public Object getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(Object idAgency) {
        this.idAgency = idAgency;
    }

    public Object getIdValiddate() {
        return idValiddate;
    }

    public void setIdValiddate(Object idValiddate) {
        this.idValiddate = idValiddate;
    }

    public Object getIdphotoScan() {
        return idphotoScan;
    }

    public void setIdphotoScan(Object idphotoScan) {
        this.idphotoScan = idphotoScan;
    }

    public Object getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Object idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Object getFacephoto() {
        return facephoto;
    }

    public void setFacephoto(Object facephoto) {
        this.facephoto = facephoto;
    }

    public Object getIdFront() {
        return idFront;
    }

    public void setIdFront(Object idFront) {
        this.idFront = idFront;
    }

    public Object getCardFront() {
        return cardFront;
    }

    public void setCardFront(Object cardFront) {
        this.cardFront = cardFront;
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

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public static class StatusBean {
        /**
         * id : MEMBER_SHOW
         * text : 已添加
         * category : MEMBER_STATUS
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
