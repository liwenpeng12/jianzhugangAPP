package com.jlkg.jzg.jzg_android.other.bean;

/**
 * Created by zcs on 2018/4/20.
 *
 * @describe:
 */

public class LoginBean {
    private CompanyLoginBean company;
    private TeamLoginBean team;

    public CompanyLoginBean getCompany() {
        return company;
    }

    public void setCompany(CompanyLoginBean company) {
        this.company = company;
    }

    public TeamLoginBean getTeam() {
        return team;
    }

    public void setTeam(TeamLoginBean team) {
        this.team = team;
    }
}
