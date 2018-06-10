package com.jlkg.jzg.jzg_android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Geocoder;
import android.location.Location;
import android.os.Parcelable;
import android.text.*;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.GlideUtils;

/**
 * Created by zcs on 2018/1/30.
 *
 * @describe:
 */

public class MapUtils {
    private MyLocationListener myListener = new MyLocationListener();
    private LocationClient mLocationClient = null;
    private static MapUtils sMapUtils;
    private BDLocation mLocation;
    private OnLocationResultListener mListener;

    private MapUtils() {

    }

    public static MapUtils getInstance() {
        if (sMapUtils == null) sMapUtils = new MapUtils();
        return sMapUtils;
    }

    /**
     * 开始定位
     */
    public void startLocation(Context context, OnLocationResultListener listener) {
        mListener = listener;
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        mLocationClient = new LocationClient(context);
        mLocationClient.setLocOption(option);
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        mLocationClient.start();
    }

    public String getLocationCity() {
        if (mLocation != null)
            return mLocation.getCity();
        else return "深圳市";
    }

    public void setMapShowCity(String city, final BaiduMap map) {
        if (TextUtils.isEmpty(city))
            city = "北京";
        if (coderResultListener == null)
            coderResultListener = new MyGetGeoCoderResultListener();
        if (coderSearch == null)
            coderSearch = GeoCoder.newInstance();
        coderSearch.setOnGetGeoCodeResultListener(coderResultListener);
        coderResultListener.setListener(new OnGetGeoCodeListener() {
            @Override
            public void result(GeoCodeResult result) {

                map.setMyLocationEnabled(false);
//        baiduMap.setMaxAndMinZoomLevel(17,17);
                MyLocationData locData = new MyLocationData.Builder()
//                        .accuracy(mLocation.getRadius())
                        // 此处设置开发者获取到的方向信息，顺时针0-360
                        .direction(0).latitude(result.getLocation().latitude)
                        .longitude(result.getLocation().longitude).build();

                // 设置定位数据
//                map.setMyLocationData(locData);
                /*map.setMyLocationConfiguration(new MyLocationConfiguration(
                        MyLocationConfiguration.LocationMode.NORMAL, true, null,
                        0x00FFFFff, 0x00ffFFff));*/
                MapStatus.Builder mapStatusBuilder = new MapStatus.Builder();
                LatLng ll = result.getLocation();
                mapStatusBuilder.target(ll);
                mapStatusBuilder.zoom(13.0f);
                //mapStatusBuilder.zoom(18.0f);

                MapStatus mapStatus = mapStatusBuilder.build();
                MapStatusUpdate mapUpdate = MapStatusUpdateFactory
                        .newMapStatus(mapStatus);
                map.animateMapStatus(mapUpdate);
            }
        });
        coderSearch.geocode(new GeoCodeOption().city(city).address("政府"));
    }

    /**
     * 地图显示定位位置
     */
    public void setLocationMap(BaiduMap baiduMap) {
        // 构造定位数据
       /* LatLng latLng = new LatLng(mLocation.getLatitude(),mLocation.getLongitude());
        CoordinateConverter converter = new CoordinateConverter();
        converter.coord(latLng);
        converter.from(CoordinateConverter.CoordType.COMMON);
        LatLng convertLatLng = converter.convert();
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(convertLatLng, 17.0f);
        baiduMap.animateMapStatus(u);*/
        baiduMap.setMyLocationEnabled(true);
//        baiduMap.setMaxAndMinZoomLevel(17,17);
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(mLocation.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(0).latitude(mLocation.getLatitude())
                .longitude(mLocation.getLongitude()).build();

        // 设置定位数据
        baiduMap.setMyLocationData(locData);
        baiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.NORMAL, true, BitmapDescriptorFactory.fromResource(R.mipmap.map_icon_location),
                0x00FFFFff, 0x00ffFFff));
        MapStatus.Builder mapStatusBuilder = new MapStatus.Builder();
        LatLng ll = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
        mapStatusBuilder.target(ll);
        mapStatusBuilder.zoom(17.0f);
        //mapStatusBuilder.zoom(18.0f);

        MapStatus mapStatus = mapStatusBuilder.build();
        MapStatusUpdate mapUpdate = MapStatusUpdateFactory
                .newMapStatus(mapStatus);
        baiduMap.animateMapStatus(mapUpdate);
//        baiduMap.setMyLocationEnabled(false);

//        LatLng latLng = new LatLng(mLocation.getLatitude(),mLocation.getLongitude());
//        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
    }


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            mLocation = location;
            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
            Log.e("Tag", location.getLocTypeDescription() + errorCode + "latitude" + latitude + "longitude" + longitude + location.getAddrStr());
            if (mListener != null) mListener.locationResultListener(location, errorCode);
        }
    }

    public interface OnLocationResultListener {
        void locationResultListener(BDLocation location, int errorCode);
    }

    private GeoCoder coderSearch;
    private MyGetGeoCoderResultListener coderResultListener;

    public void setCoderSearch(int position, String city, String address, BaiduMap map, final OnMarkerListener listener) {
        if (TextUtils.isEmpty(city))
            city = "深圳";
        if (TextUtils.isEmpty(address))
            address = "dsads";
//        if (coderResultListener == null)
        final MyGetGeoCoderResultListener coderResultListener = new MyGetGeoCoderResultListener();
        if (coderSearch == null)
            coderSearch = GeoCoder.newInstance();
        coderSearch.setOnGetGeoCodeResultListener(coderResultListener);
        coderResultListener.setmPosition(position);
        coderResultListener.setListener(new OnGetGeoCodeListener() {
            @Override
            public void result(GeoCodeResult result) {
                listener.makerListener(coderResultListener.getmPosition(), result);
            }
        });
        coderSearch.geocode(new GeoCodeOption().city(city).address(address));
    }

    public MyGetGeoCoderResultListener setCoderSearch(Context context, int position, String city, String address, String str, BaiduMap map) {
        if (TextUtils.isEmpty(city))
            city = "深圳";
        if (TextUtils.isEmpty(address))
            address = "dsads";
//        if (coderResultListener == null)
        final MyGetGeoCoderResultListener coderResultListener = new MyGetGeoCoderResultListener();
        coderResultListener.setMap(map, context, str);
        if (coderSearch == null)
            coderSearch = GeoCoder.newInstance();
        coderSearch.setOnGetGeoCodeResultListener(coderResultListener);
        coderResultListener.setmPosition(position);
        coderResultListener.setListener(new OnGetGeoCodeListener() {
            @Override
            public void result(GeoCodeResult result) {
//                listener.makerListener(coderResultListener.getmPosition(), result);
            }
        });
        coderSearch.geocode(new GeoCodeOption().city(city).address(address));
        return coderResultListener;
    }

    public Marker addMarker(Context context, BaiduMap map, GeoCodeResult result, String str/*, View.OnClickListener listener*/) {
        LatLng latLng = result.getLocation();
        View v = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.marker_view_layout, null);
        ImageView imageView = v.findViewById(R.id.iv);
        GlideUtils.LoadImgCircleCrop(context, str, imageView);
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromView(v);
//        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
        OverlayOptions option = new MarkerOptions()
                .position(latLng).animateType(MarkerOptions.MarkerAnimateType.grow)
                .period(10)
                .icon(bitmap);
        Marker marker = (Marker) map.addOverlay(option);
        return marker;
    }

    private Bitmap getBitmapFromView(View view) {
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.UNSPECIFIED);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }


    public void distoryCoderSearch() {
        if (coderSearch != null) coderSearch.destroy();
        coderSearch = null;
    }

    public static class MyGetGeoCoderResultListener implements OnGetGeoCoderResultListener {
        private int mPosition;
        private OnGetGeoCodeListener listener;
        private BaiduMap mMap;
        private Context mContext;
        private String mPhoto;
        private String mName;

        public void setListener(OnGetGeoCodeListener listener) {
            this.listener = listener;
        }

        public int getmPosition() {
            return mPosition;
        }

        public void setmPosition(int position) {
            this.mPosition = position;
        }

        public void setMap(BaiduMap map, Context context, String photo) {
            mMap = map;
            mContext = context;
            mPhoto = photo;
        }

        public void setName(String name) {
            mName = name;
        }

        /**
         * 获取地理编码结果
         *
         * @param geoCodeResult
         */
        @Override
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            if (geoCodeResult == null || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                Log.e("tag", "地图搜索失败");
                return;
            }
            if (mContext == null) {
                listener.result(geoCodeResult);
                return;
            }
            LatLng latLng = geoCodeResult.getLocation();
            View v = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.marker_view_layout, null);
            ImageView imageView = v.findViewById(R.id.iv);
            GlideUtils.LoadImgCircleCrop(mContext, mPhoto, imageView);
            TextView tvName = v.findViewById(R.id.tv_name);
            if (!TextUtils.isEmpty(mName)) {
                if (mName.length() > 8) {
                    tvName.setText(mName.substring(0, 8) + "…");
                } else
                    tvName.setText(mName);
                tvName.setVisibility(View.VISIBLE);
            } else {
                tvName.setVisibility(View.GONE);
            }
            BitmapDescriptor bitmap = BitmapDescriptorFactory.fromView(v);
//        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
            OverlayOptions option = new MarkerOptions()
                    .position(latLng).animateType(MarkerOptions.MarkerAnimateType.grow)
                    .period(10)
                    .zIndex(mPosition)
                    .icon(bitmap);
            Marker marker = (Marker) mMap.addOverlay(option);
        }

        /**
         * 获取反向地理地理编码结果
         *
         * @param reverseGeoCodeResult
         */
        @Override
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }
        }
    }

    public interface OnGetGeoCodeListener {
        void result(GeoCodeResult result);
    }

    public interface OnMarkerListener {
        void makerListener(int position, GeoCodeResult result);
    }
}
