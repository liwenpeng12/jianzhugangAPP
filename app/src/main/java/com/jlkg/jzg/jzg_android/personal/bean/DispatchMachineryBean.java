package com.jlkg.jzg.jzg_android.personal.bean;

/**
 * Created by yangxiaolong on 2018/3/21.
 */

public class DispatchMachineryBean {

    /**
     * machineAmount : 5
     * machineTypeId : DCENTER_JIXIE_1
     * machineTypeGroup : 主要机械
     * machineTypeTitle : 塔式起重机
     */

    private int machineAmount;
    private String machineTypeId;
    private String machineTypeGroup;
    private String machineTypeTitle;

    public int getMachineAmount() {
        return machineAmount;
    }

    public void setMachineAmount(int machineAmount) {
        this.machineAmount = machineAmount;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineTypeGroup() {
        return machineTypeGroup;
    }

    public void setMachineTypeGroup(String machineTypeGroup) {
        this.machineTypeGroup = machineTypeGroup;
    }

    public String getMachineTypeTitle() {
        return machineTypeTitle;
    }

    public void setMachineTypeTitle(String machineTypeTitle) {
        this.machineTypeTitle = machineTypeTitle;
    }
}
