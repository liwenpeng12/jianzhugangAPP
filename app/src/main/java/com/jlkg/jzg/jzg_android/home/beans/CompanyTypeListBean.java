package com.jlkg.jzg.jzg_android.home.beans;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * Created by zcs on 2018/3/10.
 */

public class CompanyTypeListBean implements IPickerViewData {

    /**
     * id : COMPANY_TYPE_1
     * title : 建筑公司
     */

    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getPickerViewText() {
        return title;
    }
}
