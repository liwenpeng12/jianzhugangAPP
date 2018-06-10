package com.jlkg.jzg.jzg_android.other.utils;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.jpush.android.api.JPushInterface;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2017/7/14
 */

public class MyMessageReceiver extends BroadcastReceiver {

    private NotificationManager nm;

    @Override
    public void onReceive(Context context, Intent intent) {
            if (nm==null) {
                nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            }
            Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {


        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {

            //收到自定义消息传给消息列表
            String title = bundle.getString(JPushInterface.EXTRA_TITLE);
            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            System.out.println("======自定义===message="+message);
//            try {
//                JSONObject jsonObject=new JSONObject(message);
//                    if(jsonObject.getInt("type")==4){
//                        //禁用用户
//                        RongIM.getInstance().logout();
//                        AppState.getInstance().putUser(null);
//                        if(AppManager.isActivity(MainActivity.class)) {
//                            Intent intent1=new Intent(context, LoginActivity.class);
//                            context.startActivity(intent1);
//                            AppManager.logout();
//                        }
////                        OrderEvent orderEvent=new OrderEvent(jsonObject.getInt("status"),jsonObject.getString("orderId"));
////                        EventBus.getDefault().post(orderEvent);
//                    }else if(jsonObject.getInt("type")==1){
//                        if(jsonObject.getInt("status")==8) {
//                            OrderEvent orderEvent = new OrderEvent(jsonObject.getInt("status"), jsonObject.getString("orderId"));
//                            EventBus.getDefault().post(orderEvent);
//                        }
//                    }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
           // DebugUtils.prinlnLog("接受到推送下来的通知");
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String message = bundle.getString(JPushInterface.EXTRA_ALERT);
//            if(!AppManager.isActivity(MessageActivity.class)) {
//                AppConstants.ISPUSHMESAGE = true;
//                MessageEvent messageEvent=new MessageEvent();
//                EventBus.getDefault().post(messageEvent);
//            }else{
//                AppConstants.ISPUSHMESAGE = false;
//            }

        }else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {

        }
    }
}

