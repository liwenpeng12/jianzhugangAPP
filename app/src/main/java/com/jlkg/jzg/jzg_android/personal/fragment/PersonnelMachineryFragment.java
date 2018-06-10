package com.jlkg.jzg.jzg_android.personal.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.personal.activity.SelectPersonnelActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.DispatchAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.DispatchMachineryBean;
import com.jlkg.jzg.jzg_android.personal.bean.PersonnelMachineryBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import drawthink.expandablerecyclerview.bean.RecyclerViewData;
import drawthink.expandablerecyclerview.listener.OnRecyclerViewListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonnelMachineryFragment extends BaseFragment {


    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    Unbinder unbinder;
    private List<RecyclerViewData> listData = new ArrayList<>();
    private DispatchAdapter dispatchAdapter;
    //0：人员 1：机械
    private int type;
    private String companyId;
    private List<PersonnelMachineryBean> personnelMachineryBeanList=new ArrayList<>();
    private List<DispatchMachineryBean> dispatchMachineryBeanList=new ArrayList<>();
    //人员
    private ArrayList<String> arrayList01 = new ArrayList<>();
    private ArrayList<String> arrayListData01 = new ArrayList<>();
    private ArrayList<String> arrayListType01=new ArrayList<>();
    private int count01;
    private ArrayList<String> arrayList02 = new ArrayList<>();
    private ArrayList<String> arrayListData02 = new ArrayList<>();
    private ArrayList<String> arrayListType02=new ArrayList<>();

    private int count02;
    private ArrayList<String> arrayList03 = new ArrayList<>();
    private ArrayList<String> arrayListData03 = new ArrayList<>();
    private ArrayList<String> arrayListType03=new ArrayList<>();

    private int count03;
    private ArrayList<String> arrayList04 = new ArrayList<>();
    private ArrayList<String> arrayListData04 = new ArrayList<>();
    private ArrayList<String> arrayListType04=new ArrayList<>();

    private int count04;

    public static PersonnelMachineryFragment getInstance(int type){
        PersonnelMachineryFragment personnelMachineryFragment=new PersonnelMachineryFragment();
        personnelMachineryFragment.type=type;
        return personnelMachineryFragment;
    }
    public PersonnelMachineryFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personnel_machinery;
    }

    @Override
    protected void initView() {
        super.initView();
        companyId=this.getActivity().getIntent().getExtras().getString("companyId");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        switch (type){
            //人员
            case 0:
                tvTitle.setText("施工总人数（0）");

                listData.add(new RecyclerViewData("管理(0)", arrayList01, false));
                listData.add(new RecyclerViewData("土建(0)", arrayList02, false));
                listData.add(new RecyclerViewData("安装(0)", arrayList03, false));
                listData.add(new RecyclerViewData("其他(0)", arrayList04, false));
                break;

            //机械
            case 1:
                tvTitle.setText("施工机械数（0）");
                listData.add(new RecyclerViewData("主要机械(0)", arrayList01, false));
                listData.add(new RecyclerViewData("其他机械(0)", arrayList02, false));
                break;
        }

        dispatchAdapter = new DispatchAdapter(this.getActivity(), listData);
        dispatchAdapter.setOnLeftOrRightListener(new DispatchAdapter.OnLeftOrRightListener() {
            @Override
            public void clickLeft(int groupPosition, int childPosition) {
                if(type!=0){
                    return;
                }
                Bundle bundle=new Bundle();
                switch (groupPosition){
                    case 0:
                        bundle.putString("typeId",arrayListType01.get(childPosition*2));
                        bundle.putString("title",arrayList01.get(childPosition*2));

                        break;
                    case 1:
                        bundle.putString("typeId",arrayListType02.get(childPosition*2));
                        bundle.putString("title",arrayList02.get(childPosition*2));

                        break;
                    case 2:
                        bundle.putString("typeId",arrayListType03.get(childPosition*2));
                        bundle.putString("title",arrayList03.get(childPosition*2));

                        break;
                    case 3:
                        bundle.putString("typeId",arrayListType04.get(childPosition*2));
                        bundle.putString("title",arrayList04.get(childPosition*2));

                        break;
                }
                bundle.putString("companyId",companyId);
                openActivity(SelectPersonnelActivity.class,bundle);

            }

            @Override
            public void clickRight(int groupPosition, int childPosition) {
                if(type!=0){
                    return;
                }
                Bundle bundle=new Bundle();
                switch (groupPosition){
                    case 0:
                        bundle.putString("typeId",arrayListType01.get(childPosition*2+1));
                        bundle.putString("title",arrayList01.get(childPosition*2+1));
                        break;
                    case 1:
                        bundle.putString("typeId",arrayListType02.get(childPosition*2+1));
                        bundle.putString("title",arrayList02.get(childPosition*2+1));

                        break;
                    case 2:
                        bundle.putString("typeId",arrayListType03.get(childPosition*2+1));
                        bundle.putString("title",arrayList03.get(childPosition*2+1));

                        break;
                    case 3:
                        bundle.putString("typeId",arrayListType04.get(childPosition*2+1));
                        bundle.putString("title",arrayList04.get(childPosition*2+1));

                        break;
                }
                bundle.putString("companyId",companyId);
                openActivity(SelectPersonnelActivity.class,bundle);

            }
        });
        listContent.setAdapter(dispatchAdapter);
        dispatchAdapter.setOnItemClickListener(new OnRecyclerViewListener.OnItemClickListener() {
            @Override
            public void onGroupItemClick(int position, int groupPosition, View view) {

                System.out.println("=========setExpandPosi="+listData.get(groupPosition).getGroupItem().isExpand());
                if(!listData.get(groupPosition).getGroupItem().isExpand()){
                    dispatchAdapter.setExpandPosi(groupPosition);
                }else{
                    dispatchAdapter.setExpandPosi(-1);
                }
            }

            @Override
            public void onChildItemClick(int position, int groupPosition, int childPosition, View view) {

                //openActivity(SelectPersonnelActivity.class);
            }
        });
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    //获取数据--人员
    public void getData(){
        HashMap<String,String> hashMap=new HashMap<>();
       // hashMap.put("projectId",projectId);
        //hashMap.put("accountId", MyApplication.sCompanyLoginBean.getId()+"");
        hashMap.put("accountId",companyId);

        hashMap.put("districtId","0");
        hashMap.put("cityId","0");
        hashMap.put("provinceId","0");
        if(type==0) {
            ApiManager.centerPeoplesQuery(hashMap, this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    try {
                        personnelMachineryBeanList = JSON.parseArray(response, PersonnelMachineryBean.class);
                        dispatchData(personnelMachineryBeanList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(String msg) {

                }
            });
        }else {

            ApiManager.getMachine(hashMap, this, new HttpUtils.OnCallBack() {
                @Override
                public void success(String response) {
                    try {
                        dispatchMachineryBeanList = JSON.parseArray(response, DispatchMachineryBean.class);
                        dispatchData02(dispatchMachineryBeanList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }

    //人员的数据处理
    public void dispatchData(List<PersonnelMachineryBean> personnelMachineryBeans){
        arrayList01.clear();
        arrayList02.clear();
        arrayList03.clear();
        arrayList04.clear();
        new MyAnsync().execute(personnelMachineryBeans);
    }

    //机械的数据处理
    public void dispatchData02(List<DispatchMachineryBean> dispatchMachineryBeans){
        arrayList01.clear();
        arrayList02.clear();

        new MyAnsync02().execute(dispatchMachineryBeans);
    }


    public class MyAnsync extends AsyncTask<List<PersonnelMachineryBean> ,String,String>{

        @Override
        protected String doInBackground(List<PersonnelMachineryBean>[] lists) {
            List<PersonnelMachineryBean> personnelMachineryBeans=lists[0];
            for(int i=0;i<personnelMachineryBeans.size();i++){

                PersonnelMachineryBean personnelMachineryBean=personnelMachineryBeans.get(i);
                switch (personnelMachineryBean.getTeamCategoryId()){
                    case "GUANLI":
                        arrayList01.add(personnelMachineryBean.getTeamTypeTitle()+" （"+personnelMachineryBean.getPeopleAmount()+"）");
                        arrayListType01.add(personnelMachineryBean.getTeamTypeId()+"");
                        count01+=personnelMachineryBean.getPeopleAmount();
                        break;

                    case "TUJIAN":
                        arrayList02.add(personnelMachineryBean.getTeamTypeTitle()+"（"+personnelMachineryBean.getPeopleAmount()+"）");
                        count02+=personnelMachineryBean.getPeopleAmount();
                        arrayListType02.add(personnelMachineryBean.getTeamTypeId()+"");
                        break;

                    case "ANZHUANG":
                        arrayList03.add(personnelMachineryBean.getTeamTypeTitle()+"（"+personnelMachineryBean.getPeopleAmount()+"）");
                        count03+=personnelMachineryBean.getPeopleAmount();
                        arrayListType03.add(personnelMachineryBean.getTeamTypeId()+"");
                        break;

                    case "QITA":
                        arrayList04.add(personnelMachineryBean.getTeamTypeTitle()+"（"+personnelMachineryBean.getPeopleAmount()+"）");
                        count04+=personnelMachineryBean.getPeopleAmount();
                        arrayListType04.add(personnelMachineryBean.getTeamTypeId()+"");
                        break;
                }
            }
            System.out.println("================arrayList01.size="+arrayList01.size());
            for(int i=0;i<arrayList01.size();i+=2){
                System.out.println("==========i="+i);
                if(i+1<arrayList01.size()) {
                    arrayListData01.add(arrayList01.get(i) + "&JZG&" + arrayList01.get(i + 1));
                }else{
                    arrayListData01.add(arrayList01.get(i));
                }
            }

            for(int i=0;i<(arrayList02.size());i+=2){
                if(i+1<arrayList02.size()) {
                    arrayListData02.add(arrayList02.get(i) + "&JZG&" + arrayList02.get(i + 1));
                }else{
                    arrayListData02.add(arrayList02.get(i));
                }
            }

            for(int i=0;i<(arrayList03.size());i+=2){
                if(i+1<arrayList03.size()) {
                    arrayListData03.add(arrayList03.get(i) + "&JZG&" + arrayList03.get(i + 1));
                }else{
                    arrayListData03.add(arrayList03.get(i));
                }
            }

            for(int i=0;i<(arrayList04.size());i+=2){
                if(i+1<arrayList04.size()) {
                    arrayListData04.add(arrayList04.get(i) + "&JZG&" + arrayList04.get(i + 1));
                }else{
                    arrayListData04.add(arrayList04.get(i));
                }
            }

            return "success";
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listData.clear();
            System.out.println("==========sss======"+count01);
            tvTitle.setText("施工总人数（"+(count01+count02+count03+count04)+"）");
            listData.add(new RecyclerViewData("管理("+count01+")", arrayListData01, false));
            listData.add(new RecyclerViewData("土建("+count02+")", arrayListData02, false));
            listData.add(new RecyclerViewData("安装("+count03+")", arrayListData03, false));
            listData.add(new RecyclerViewData("其他("+count04+")", arrayListData04, false));
            dispatchAdapter.setListDatas(listData);

        }
    }


    public class MyAnsync02 extends AsyncTask<List<DispatchMachineryBean> ,String,String>{

        @Override
        protected String doInBackground(List<DispatchMachineryBean>[] lists) {
            List<DispatchMachineryBean> dispatchMachineryBeans=lists[0];
            for(int i=0;i<dispatchMachineryBeans.size();i++){
                DispatchMachineryBean personnelMachineryBean=dispatchMachineryBeans.get(i);
                switch (personnelMachineryBean.getMachineTypeGroup()){
                    case "主要机械":
                        arrayList01.add(personnelMachineryBean.getMachineTypeTitle()+"（"+personnelMachineryBean.getMachineAmount()+"）");
                        count01+=personnelMachineryBean.getMachineAmount();
                        arrayListType01.add(personnelMachineryBean.getMachineTypeId()+"");
                        break;
                    case "其它机械":
                        arrayList02.add(personnelMachineryBean.getMachineTypeTitle()+"（"+personnelMachineryBean.getMachineAmount()+"）");
                        count02+=personnelMachineryBean.getMachineAmount();
                        arrayListType02.add(personnelMachineryBean.getMachineTypeId()+"");

                        break;
                }
            }

            for(int i=0;i<(arrayList01.size());i+=2){
                System.out.println("==========i="+i);
                if(i+1<arrayList01.size()) {
                    arrayListData01.add(arrayList01.get(i) + "&JZG&" + arrayList01.get(i + 1));
                }else{
                    arrayListData01.add(arrayList01.get(i));
                }
            }

            for(int i=0;i<(arrayList02.size());i+=2){
                System.out.println("==========i="+i);
                if(i+1<arrayList02.size()) {
                    arrayListData02.add(arrayList02.get(i) + "&JZG&" + arrayList02.get(i + 1));
                }else{
                    arrayListData02.add(arrayList02.get(i));
                }
            }


            return "success";
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listData.clear();
            System.out.println("==========sss======"+count01);

            tvTitle.setText("施工机械数（"+(count01+count02)+"）");
            listData.add(new RecyclerViewData("主要机械("+count01+")", arrayListData01, false));
            listData.add(new RecyclerViewData("其它机械("+count02+")", arrayListData02, false));
            dispatchAdapter.setListDatas(listData);

        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
