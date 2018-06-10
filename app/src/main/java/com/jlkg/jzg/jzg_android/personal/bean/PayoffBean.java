package com.jlkg.jzg.jzg_android.personal.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangxiaolong on 2018/3/20.
 */

public class PayoffBean {


    /**
     * teamName : 汪世建
     * workerList : [{"mobile":"13600176556","bankName":"邮政储蓄","workerName":"汪世平","idNumber":"510625197106102796","salary":5000,"cardNumber":"6217995840049520661"},{"mobile":"15012864665","bankName":"邮政储蓄","workerName":"邓万清","idNumber":"512222195612266138","salary":5000,"cardNumber":"62174995840049520653"},{"mobile":"13686829431","bankName":"邮政储蓄","workerName":"汪世建","idNumber":"510625197408012796","salary":5000,"cardNumber":"6217995840049520679"},{"mobile":"186181009576","bankName":"邮政储蓄","workerName":"张如军","idNumber":"512222196910095095","salary":15000,"cardNumber":"6217995840049520646"}]
     * auditNO : 20161129TG
     * projectName : 深圳市嘉长源半山总部基地（二期）
     * applyDate : 2016-11-29 18:06:33.0
     * applyAmount : 30000
     */

    private String teamName;
    private String auditNO;
    private String projectName;
    private String applyDate;
    private String applyAmount;
    private List<WorkerListBean> workerList;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAuditNO() {
        return auditNO;
    }

    public void setAuditNO(String auditNO) {
        this.auditNO = auditNO;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(String applyAmount) {
        this.applyAmount = applyAmount;
    }

    public List<WorkerListBean> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<WorkerListBean> workerList) {
        this.workerList = workerList;
    }

    public static class WorkerListBean implements Serializable{
        /**
         * mobile : 13600176556
         * bankName : 邮政储蓄
         * workerName : 汪世平
         * idNumber : 510625197106102796
         * salary : 5000
         * cardNumber : 6217995840049520661
         */

        private String mobile;
        private String bankName;
        private String workerName;
        private String idNumber;
        private String salary;
        private String cardNumber;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getWorkerName() {
            return workerName;
        }

        public void setWorkerName(String workerName) {
            this.workerName = workerName;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }
    }
}
