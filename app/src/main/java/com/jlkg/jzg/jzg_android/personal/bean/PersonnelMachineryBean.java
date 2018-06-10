package com.jlkg.jzg.jzg_android.personal.bean;

/**
 * Created by yangxiaolong on 2018/3/21.
 */

public class PersonnelMachineryBean {


    /**
     * peopleAmount : 0
     * teamTypeTitle : 瓦工班
     * teamCategoryId : TUJIAN
     * teamTypeId : 1
     */

    private int peopleAmount;
    private String teamTypeTitle;
    private String teamCategoryId;
    private int teamTypeId;

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public String getTeamTypeTitle() {
        return teamTypeTitle;
    }

    public void setTeamTypeTitle(String teamTypeTitle) {
        this.teamTypeTitle = teamTypeTitle;
    }

    public String getTeamCategoryId() {
        return teamCategoryId;
    }

    public void setTeamCategoryId(String teamCategoryId) {
        this.teamCategoryId = teamCategoryId;
    }

    public int getTeamTypeId() {
        return teamTypeId;
    }

    public void setTeamTypeId(int teamTypeId) {
        this.teamTypeId = teamTypeId;
    }
}
