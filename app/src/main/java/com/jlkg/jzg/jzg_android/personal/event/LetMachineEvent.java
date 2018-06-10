package com.jlkg.jzg.jzg_android.personal.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangxiaolong on 2018/3/21.
 */

public class LetMachineEvent {

    private List<Integer> positionList=new ArrayList<>();

    public void addList(int pos){
        positionList.add(pos);
    }

    public boolean isPosition(int pos){
        return positionList.contains(pos);
    }
}
