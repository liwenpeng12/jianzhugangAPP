package com.jlkg.jzg.jzg_android.other.utils;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;


import com.jlkg.jzg.jzg_android.R;

import java.io.File;

/**
 * Created by wei.qt on 2017/3/8.
 */

public class ApplicationUpdateService extends Service {
    private String path = "http://gdown.baidu.com/data/wisegame/91319a5a1dfae322/baidu_16785426.apk";
    private String DOWNLOADPATH = "/apk/";//下载路径，如果不定义自己的路径，6.0的手机不自动安装
    /**
     * 安卓系统下载类
     **/
    private DownloadManager downloadManager;
    private long downloadId;
    /**
     * 接收下载完的广播
     **/
    private DownloadCompleteReceiver receiver;


    /**
     * 初始化下载器
     **/
    private void initDownManager(String url) {

// downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        receiver = new DownloadCompleteReceiver();

        //设置下载地址
        DownloadManager.Request request = new DownloadManager.Request(
                Uri.parse(url));
        Log.v("url:", url);
        // 设置允许使用的网络类型，这里是移动网络和wifi都可以
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE
                | DownloadManager.Request.NETWORK_WIFI);

        request.setMimeType("application/vnd.android.package-archive");

        // 下载时，通知栏显示途中
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);

        // 显示下载界面
        request.setVisibleInDownloadsUi(true);
        // 设置下载后文件存放的位置
        request.setDestinationInExternalPublicDir(DOWNLOADPATH, getPackageName()+".apk");
        //
        request.setTitle(getApplicationContext().getResources().getString(R.string.app_name));
        request.setDescription("新版本更新");

        // 将下载请求放入队列
        downloadId = downloadManager.enqueue(request);
        ShareUtils.getInstance().setCache("serviceProviderDownloadManagerId", downloadId);
        //注册下载广播
        registerReceiver(receiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //url是传过来的下载路径，如果想直接用，可以用上面的百度apk地址path代替
        String url = intent.getStringExtra("url");
        System.out.println("==========url="+url);
        if (url != null && !"".equals(url)) {
            if (isNeedDownloadAgain()) {
                Toast.makeText(getApplicationContext(), "开始下载...", Toast.LENGTH_SHORT).show();
                // 调用下载
                initDownManager(url);
            }
        }
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onDestroy() {

        // 注销下载广播
        if (receiver != null)
            unregisterReceiver(receiver);

        super.onDestroy();
    }
    private boolean isNeedDownloadAgain() {
        boolean isNeedDownloadAgain = true;
        DownloadManager.Query query = new DownloadManager.Query();
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        long id = ShareUtils.getInstance().getCache("serviceProviderDownloadManagerId", -1L);
        // Toast.makeText(getApplicationContext(), "id..."+id, Toast.LENGTH_SHORT).show();
        if (id != -1) {
            query.setFilterById(id);
            Cursor cursor = downloadManager.query(query);
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int status = cursor.getInt(columnIndex);
                int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
                int reason = cursor.getInt(columnReason);
                switch (status) {
                    case DownloadManager.STATUS_FAILED:
                        switch (reason) {
                            case DownloadManager.ERROR_CANNOT_RESUME:
                                //some possibly transient error occurred but we can't resume the download
                                break;
                            case DownloadManager.ERROR_DEVICE_NOT_FOUND:
                                //no external storage device was found. Typically, this is because the SD card is not mounted
                                break;
                            case DownloadManager.ERROR_FILE_ALREADY_EXISTS:
                                //the requested destination file already exists (the download manager will not overwrite an existing file)
                                break;
                            case DownloadManager.ERROR_FILE_ERROR:
                                //a storage issue arises which doesn't fit under any other error code
                                break;
                            case DownloadManager.ERROR_HTTP_DATA_ERROR:
                                //an error receiving or processing data occurred at the HTTP level
                                break;
                            case DownloadManager.ERROR_INSUFFICIENT_SPACE://sd卡满了
                                //here was insufficient storage space. Typically, this is because the SD card is full
                                break;
                            case DownloadManager.ERROR_TOO_MANY_REDIRECTS:
                                //there were too many redirects
                                break;
                            case DownloadManager.ERROR_UNHANDLED_HTTP_CODE:
                                //an HTTP code was received that download manager can't handle
                                break;
                            case DownloadManager.ERROR_UNKNOWN:
                                //he download has completed with an error that doesn't fit under any other error code
                                break;
                        }
                        isNeedDownloadAgain = true;
                        break;
                    case DownloadManager.STATUS_PAUSED:
                        switch (reason) {
                            case DownloadManager.PAUSED_QUEUED_FOR_WIFI:
                                //the download exceeds a size limit for downloads over the mobile network and the download manager is waiting for a Wi-Fi connection to proceed

                                break;
                            case DownloadManager.PAUSED_UNKNOWN:
                                //the download is paused for some other reason
                                break;
                            case DownloadManager.PAUSED_WAITING_FOR_NETWORK:
                                //the download is waiting for network connectivity to proceed
                                break;
                            case DownloadManager.PAUSED_WAITING_TO_RETRY:
                                //the download is paused because some network error occurred and the download manager is waiting before retrying the request
                                break;
                        }
                        isNeedDownloadAgain = false;
                        break;
                    case DownloadManager.STATUS_PENDING:
                        isNeedDownloadAgain = false;
                        // Toast.makeText(getApplicationContext(), "STATUS_PENDING...", Toast.LENGTH_SHORT).show();
                        break;
                    case DownloadManager.STATUS_RUNNING:
                        Toast.makeText(getApplicationContext(), "正在下载...", Toast.LENGTH_SHORT).show();
                        isNeedDownloadAgain = false;
                        break;
                    case DownloadManager.STATUS_SUCCESSFUL:
                        //the download has successfully completed
                        isNeedDownloadAgain = true;
                        // isNeedDownloadAgain = false;
                        // installApk(id, downloadManager, mContext);
                        break;

                }
            }

        }

        return isNeedDownloadAgain;
    }

    // 接受下载完成后的intent
    class DownloadCompleteReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            //判断是否下载完成的广播
            if (intent.getAction().equals(
                    DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {

                //获取下载的文件id
                long completeDownloadId = intent.getLongExtra(
                        DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                Uri uri = downloadManager.getUriForDownloadedFile(completeDownloadId);
                if (uri != null) {
                    //自动安装apk
                    installAPK(downloadManager.getUriForDownloadedFile(completeDownloadId));
                } else {
                    Toast.makeText(getApplicationContext(), "下载失败！", Toast.LENGTH_SHORT).show();
                }
                //停止服务并关闭广播
                ApplicationUpdateService.this.stopSelf();

            }
        }

        /**
         * 安装apk文件
         */
        private void installAPK(Uri apk) {

            // 通过Intent安装APK文件
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DEFAULT);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            File apkFile = queryDownloadedApk();
            // String path = getRealFilePath(getApplicationContext(), apk);
            // File apkFile = new File(path);
            if(apkFile.exists()){
                try {
                    intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(ApplicationUpdateService.this,"安装包解析失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }else {

                Toast.makeText(ApplicationUpdateService.this,"安装文件不存在", Toast.LENGTH_SHORT).show();
            }
        }
        public String getRealFilePath(final Context context, final Uri uri) {
            if (null == uri) return null;
            final String scheme = uri.getScheme();
            String data = null;
            if (scheme == null)
                data = uri.getPath();
            else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
                data = uri.getPath();
            } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
                Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
                if (null != cursor) {
                    if (cursor.moveToFirst()) {
                        int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                        if (index > -1) {
                            data = cursor.getString(index);
                        }
                    }
                    cursor.close();
                }            }
            return data;
        }
        public File queryDownloadedApk() {
            File targetApkFile = null;
            if (downloadId != -1) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(downloadId);
                query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL);
                Cursor cur = downloadManager.query(query);
                if (cur != null) {
                    if (cur.moveToFirst()) {
                        String uriString = cur.getString(cur.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                        if (!TextUtils.isEmpty(uriString)) {
                            targetApkFile = new File(Uri.parse(uriString).getPath());
                        }
                    }
                    cur.close();
                }
            }
            return targetApkFile;
        }
    }
}
