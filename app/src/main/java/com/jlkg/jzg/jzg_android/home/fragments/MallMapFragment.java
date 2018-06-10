package com.jlkg.jzg.jzg_android.home.fragments;


import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseFragment;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.activitys.MallHomeActivity;
import com.jlkg.jzg.jzg_android.home.beans.MallListBean;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 商城--地图
 */
public class MallMapFragment extends BaseFragment implements MapUtils.OnLocationResultListener {


    @BindView(R.id.map_view)
    MapView mMapView;
    private List<MallListBean.DataBean.StoreListBean> mList = new ArrayList<>();

    public MallMapFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mall_map;
    }

    @Override
    protected void initView() {
        super.initView();
        loadData();
        MapUtils.getInstance().startLocation(MyApplication.getContext(), this);
        mMapView.getMap().setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                MallListBean.DataBean.StoreListBean contentBean = mList.get(marker.getZIndex());
                Bundle bundle = new Bundle();
                bundle.putString("id", contentBean.getStore_id());
                openActivity(MallHomeActivity.class, bundle);
                return false;
            }
        });
        mMapView.getMap().setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    private void loadData() {
        setLoading(true);
        ApiManager.shopsQuery(1 + "",getActivity(), new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                MallListBean bean = JSON.parseObject(response, MallListBean.class);
                mList.addAll(bean.getData().getStore_list());
                int size = mList.size();
                for (int i = 0; i < size; i++) {
                    MallListBean.DataBean.StoreListBean contentBean = mList.get(i);
                    /*MapUtils.getInstance().setCoderSearch(i, "深圳", contentBean.getStore_address(), mMapView.getMap(), new MapUtils.OnMarkerListener() {
                        @Override
                        public void makerListener(int position, GeoCodeResult result) {
                            Log.e("tag", result.getAddress());
                            MapUtils.getInstance().addMarker(mContext, mMapView.getMap(), result, "").setZIndex(position);
                        }
                    });*/
                    MapUtils.getInstance().setCoderSearch(mContext, i, "深圳", contentBean.getStore_address(), contentBean.getStore_name(), mMapView.getMap()).setName(contentBean.getStore_name());
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
    public void locationResultListener(BDLocation location, int errorCode) {
        MapUtils.getInstance().setLocationMap(mMapView.getMap());
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
}
