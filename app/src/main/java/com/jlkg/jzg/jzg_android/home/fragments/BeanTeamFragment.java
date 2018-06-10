package com.jlkg.jzg.jzg_android.home.fragments;


import android.support.design.widget.BottomSheetBehavior;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.home.beans.TeamInfoListBean;
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
public class BeanTeamFragment extends BaseFragment implements MapUtils.OnLocationResultListener, SelectTypeView.OnSelectResultListener {

    BottomSheetBehavior behavior;
    @BindView(R.id.team_bottom_view)
    TeamOrJiXieBottomView mTeamBottomView;
    @BindView(R.id.select_type_view)
    SelectTypeView mSelectTypeView;
    @BindView(R.id.map_view)
    MapView mMapView;
    @BindView(R.id.design_bottom_sheet)
    RelativeLayout mDesignBottomSheet;
    private String districtId = "", typeId = "", startLevel = "";
    private List<TeamInfoListBean.ContentBean> mTeamList = new ArrayList<>();

    public BeanTeamFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bean_team;
    }

    @Override
    protected void initView() {
        super.initView();
        mTeamBottomView.setType(1);
//        MapUtils.getInstance().startLocation(MyApplication.getContext(), this);
//        mTeamBottomView.setVisibility(View.VISIBLE);
        mSelectTypeView.setType(1, this);
        mMapView.getMap().setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                TeamInfoListBean.ContentBean contentBean = mTeamList.get(marker.getZIndex());
                mTeamBottomView.setTeamBean(contentBean);
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
//        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(14.0f);
//        mMapView.getMap().setMapStatus(msu);

        ApiManager.getTeamListForMap(districtId, typeId, startLevel, getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                mTeamList.clear();
                TeamInfoListBean bean = JSON.parseObject(response, TeamInfoListBean.class);
                mTeamList.addAll(bean.getContent());
                int size = mTeamList.size();
                for (int i = 0; i < size; i++) {
                    TeamInfoListBean.ContentBean contentBean = mTeamList.get(i);
                    /*MapUtils.getInstance().setCoderSearch(i, contentBean.getAddress(), contentBean.getStreetAddress(), mMapView.getMap(), new MapUtils.OnMarkerListener() {
                        @Override
                        public void makerListener(int position, GeoCodeResult result) {
                            MapUtils.getInstance().addMarker(mContext, mMapView.getMap(), result, mTeamList.get(position).getPhoto()).setZIndex(position);
                        }
                    });*/
                    String photo = "";
                    if (mTeamList.get(i).getPhoto() != null)
                        photo = mTeamList.get(i).getPhoto().getUrl();
                    if (mMapView != null)
                        MapUtils.getInstance().setCoderSearch(mContext, i, contentBean.getAddress(), contentBean.getDisplayAddress(), photo, mMapView.getMap());
                }
                setLoading(false);
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
            }
        });
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

    private boolean isFirst;

    @Override
    public void onSelectResultListener(int type, String str) {
        Log.e("myloc", str);
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
    public void onDestroy() {
        super.onDestroy();

    }
}
