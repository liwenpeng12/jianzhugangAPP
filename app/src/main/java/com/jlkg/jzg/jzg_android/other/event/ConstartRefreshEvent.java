package com.jlkg.jzg.jzg_android.other.event;

import java.util.ArrayList;

/**
 * Created by yangxiaolong on 2018/3/16.
 */

public class ConstartRefreshEvent {
    public ArrayList<Integer> arrayList=new ArrayList<>();
    public void addArrayList(int type){
        arrayList.add(type);
    }
    public boolean isContains(int type){
        return arrayList.contains(type);

    }
}
