package com.allynav.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;


public class BaiduMapActivity extends AppCompatActivity {
    private MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        BaiduMapOptions options = new BaiduMapOptions();
//        options.mapType(BaiduMap.MAP_TYPE_SATELLITE);
        BaiduMap mBaiduMap = mMapView.getMap();
//普通地图 ,mBaiduMap是地图控制器对象

//设定中心点坐标
        LatLng cenpt = new LatLng(47.24845571,132.62545573);
//定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(18)
                .build();
//定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
//改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);

        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
    }
}
