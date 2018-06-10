package com.jlkg.jzg.jzg_android.home.fragments;


import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.beans.JIXieZulinBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.MapUtils;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView;
import com.jlkg.jzg.jzg_android.weidget.TeamOrJiXieBottomView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 附近班组
 */
public class NearJiXieFragment extends BaseFragment implements SelectTypeView.OnSelectResultListener, MapUtils.OnLocationResultListener {

    @BindView(R.id.team_bottom_view)
    TeamOrJiXieBottomView mTeamBottomView;
    @BindView(R.id.select_type_view)
    SelectTypeView mSelectTypeView;
    @BindView(R.id.design_bottom_sheet)
    RelativeLayout mDesignBottomSheet;
    @BindView(R.id.map_view)
    MapView mMapView;
    private String districtId = "", typeId = "", startLevel = "";
    private List<JIXieZulinBean.ContentBean> mList = new ArrayList<>();

    public NearJiXieFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bean_team;
    }

    @Override
    protected void initView() {
        super.initView();
        mTeamBottomView.setType(2);
        mSelectTypeView.setType(2, this);
//        MapUtils.getInstance().startLocation(MyApplication.getContext(), this);
//        mTeamBottomView.setVisibility(View.VISIBLE);
        mMapView.getMap().setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                JIXieZulinBean.ContentBean contentBean = mList.get(marker.getZIndex());
                mTeamBottomView.setJixieBean(contentBean);
                mTeamBottomView.setVisibility(mTeamBottomView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                return false;
            }
        });
        mMapView.getMap().setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (mTeamBottomView.getVisibility() == View.VISIBLE) {
                    mTeamBottomView.setVisibility(View.GONE);
                }
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    private void loadData() {
        setLoading(true);
        ApiManager.machineAsksQueryForMap(districtId, typeId, startLevel, getActivity(),new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                mList.clear();
                JIXieZulinBean bean = JSON.parseObject(response, JIXieZulinBean.class);
                mList.addAll(bean.getContent());
                int size = mList.size();
                for (int i = 0; i < size; i++) {
                    JIXieZulinBean.ContentBean contentBean = mList.get(i);
                    if (contentBean.getDistrict() != null && contentBean.getDistrict().getParent() != null && contentBean.getDistrict().getParent().getTitle() != null)
                        /*MapUtils.getInstance().setCoderSearch(i, contentBean.getDistrict().getParent().getTitle(), contentBean.getDisplayAddress(), mMapView.getMap(), new MapUtils.OnMarkerListener() {
                            @Override
                            public void makerListener(int position, GeoCodeResult result) {
                                Log.e("tag", result.getAddress());
                                MapUtils.getInstance().addMarker(mContext, mMapView.getMap(), result, mList.get(position).getImage()).setZIndex(position);
                            }
                        });*/
                        MapUtils.getInstance().setCoderSearch(mContext, i, contentBean.getDistrict().getParent().getTitle(), contentBean.getStreetAddress(), mList.get(i).getImage(), mMapView.getMap());
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
            }
        });
    }

    private boolean isFirst;

    @Override
    public void onSelectResultListener(int type, String str) {
        if (type == 1) {
            typeId = str;
            mMapView.getMap().clear();
        } else if (type == 2) {
            if (!isFirst || TextUtils.isEmpty(str))
                MapUtils.getInstance().setLocationMap(mMapView.getMap());
            else {
                MapUtils.getInstance().setMapShowCity(mSelectTypeView.getSelectCity(), mMapView.getMap());
            }
            isFirst = true;
            districtId = str;
            mMapView.getMap().clear();
        } else {
            startLevel = str;
            mMapView.getMap().clear();
        }
        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onDestroyView() {
        mMapView.onDestroy();
        MapUtils.getInstance().distoryCoderSearch();
        super.onDestroyView();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void locationResultListener(BDLocation location, int errorCode) {
//        MapUtils.getInstance().setLocationMap(mMapView.getMap());
    }
}
