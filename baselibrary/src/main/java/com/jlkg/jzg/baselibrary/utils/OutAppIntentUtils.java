package com.jlkg.jzg.baselibrary.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.function.Consumer;


/**
 * Created by zcs on 2018/1/27.
 *
 * @describe:打开第三方应用工具类
 */

public class OutAppIntentUtils {
    public static void openCall(final Activity activity, final String phone) {
        RxPermissions rxPermissions = new RxPermissions(activity); // where this is an Activity instance;
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            rxPermissions
                    .request(Manifest.permission.CALL_PHONE)
                    .subscribe(new io.reactivex.functions.Consumer<Boolean>() {
                        @Override
                        public void accept(Boolean aBoolean) throws Exception {
                            if (aBoolean) {
                                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ToastUtils.showShort("您没有允许拨打电话的权限");
                                    return;
                                }

                            } else {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                                activity.startActivity(intent);
                            }
                        }
                    });
            return;
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            activity.startActivity(intent);
        }
    }

}
