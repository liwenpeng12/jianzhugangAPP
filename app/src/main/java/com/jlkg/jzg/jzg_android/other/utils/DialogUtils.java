package com.jlkg.jzg.jzg_android.other.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.IdentityConfimActivity;
import com.jlkg.jzg.jzg_android.other.LoginActivity;
import com.jlkg.jzg.jzg_android.other.activity.CompanyInfoActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.OptionAdapter;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.AddressPicker;


/**
 * Created by wei.qt on 2017/2/20
 */

public class DialogUtils {

    //警示弹框
    public static void showTipDialog(final Context context, String messsage, Handler handler) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_cus_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
//        p.dimAmount = 0f;
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(p);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_tip);
        message.setText(messsage);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }

    //警示弹框
    public static void showToastDialog(final Context context, String messsage) {

        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_cus_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//        p.width = (int) (d.getWidth() * 0.4); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_tip);
        message.setText(messsage);
        message.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (dialog != null && dialog.isShowing())
                    dialog.dismiss();
            }
        }, 2000);
    }

    //设置界面通用弹框
    public static void showSettingTipDialog(final Context context, String messsage, String btnText, final onCommitListener onCommitListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        message.setText(messsage);
        commit.setText(btnText);
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onCommitListener.onCommit();
                dialog.dismiss();
            }
        });
    }

    //Notitle通用弹框
    public static void showNoTitleCustomDialog(final Context context, String messsage, String btnText, final onCommitListener onCommitListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        message.setText(messsage);
        commit.setText(btnText);
        cancel.setText("取消");
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onCommitListener.onCommit();
                dialog.dismiss();
            }
        });
    }

    /**
     * 拨打电话弹窗
     *
     * @param context
     * @param messsage
     * @param btnText
     * @param onCommitListener
     */
    public static void showCallPhoneDialog(final Context context, String messsage, String btnText, final onCommitListener onCommitListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        message.setPadding(0, 60, 0, 60);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        ImageView imageView = dialogWindow.findViewById(R.id.iv_img);
        imageView.setVisibility(View.GONE);
        message.setText(messsage);
        commit.setText(btnText);
        cancel.setText("取消");
        commit.setText("拨打");
        message.setTextColor(Color.parseColor("#6ace89"));
        commit.setTextColor(Color.parseColor("#039aff"));
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onCommitListener.onCommit();
                dialog.dismiss();
            }
        });
    }

    /**
     * 未认证或者认证审核中
     *
     * @param context
     */
    public static void showInvitedDia(final Context context, final boolean isNo) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        message.setPadding(0, 40, 0, 40);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        ImageView imageView = dialogWindow.findViewById(R.id.iv_img);
        imageView.setVisibility(View.GONE);
        message.setText(isNo ? "您还未认证，请先填写认证信息！" : "您的认证信息还未通过审核，请等待审核通过！");
        cancel.setText("取消");
        cancel.setVisibility(isNo ? View.VISIBLE : View.GONE);
        commit.setText(isNo ? "立即认证" : "确定");
        commit.setTextColor(Color.parseColor("#039aff"));
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                if (isNo) {
                    Intent intent = new Intent();
                    if (MyApplication.isCompany) {
                        intent.setClass(context, CompanyInfoActivity.class);
                    } else {
                        intent.setClass(context, IdentityConfimActivity.class);
                    }
                    ((Activity) context).startActivityForResult(intent, 1);
                }
                dialog.dismiss();

            }
        });
    }

    /**
     * 未登录提示弹窗
     *
     * @param context
     */
    public static void showNoLoginDialog(final Context context) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_tip);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        message.setPadding(0, 40, 0, 40);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        ImageView imageView = dialogWindow.findViewById(R.id.iv_img);
        imageView.setVisibility(View.GONE);
        message.setText("您还未登录，请先登录！");
        cancel.setText("取消");
        commit.setText("立即登录");
        commit.setTextColor(Color.parseColor("#039aff"));
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                dialog.dismiss();
            }
        });
    }

    //选择性别弹框
    public static void showSexDialog(final Context context, final onChoosePicListener onChoosePicListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_upload_picture);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(true);
        TextView camera = (TextView) dialogWindow.findViewById(R.id.tv_camera);
        TextView phone = (TextView) dialogWindow.findViewById(R.id.tv_phone);
        TextView cancel = (TextView) dialogWindow.findViewById(R.id.tv_cancel);
        camera.setText("男");
        phone.setText("女");
        camera.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onChoosePicListener.onChooseCamera();
                dialog.dismiss();
            }
        });
        phone.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onChoosePicListener.onChoosePhone();
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
    }

    //选择招工类型弹框
    public static void showZhaoGongTypeDialog(final Context context, final onReasonListener listener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_zhaogong_type);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(true);
        TextView camera = dialogWindow.findViewById(R.id.tv_camera);
        TextView phone = dialogWindow.findViewById(R.id.tv_phone);
        TextView cancel = dialogWindow.findViewById(R.id.tv_cancel);
        TextView all = dialogWindow.findViewById(R.id.tv_all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onReason(0);
                dialog.dismiss();
            }
        });
        camera.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                listener.onReason(1);
                dialog.dismiss();
            }
        });
        phone.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                listener.onReason(2);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
    }


    //上传照片弹框
    public static void showUploadDialog(final Context context, final onChoosePicListener onChoosePicListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_upload_picture);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(true);
        TextView camera = (TextView) dialogWindow.findViewById(R.id.tv_camera);
        TextView phone = (TextView) dialogWindow.findViewById(R.id.tv_phone);
        TextView cancel = (TextView) dialogWindow.findViewById(R.id.tv_cancel);
        camera.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onChoosePicListener.onChooseCamera();
                dialog.dismiss();
            }
        });
        phone.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onChoosePicListener.onChoosePhone();
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
    }


    //设置通用弹框
    public static void showSettingDialog(final Context context, boolean isImage, String messsage, String btnText, int color, final onCommitListener onCommitListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_custom_setting);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(false);
        TextView message = (TextView) dialogWindow.findViewById(R.id.tv_message);
        Button cancel = (Button) dialogWindow.findViewById(R.id.no);
        Button commit = (Button) dialogWindow.findViewById(R.id.yes);
        ImageView imageView = dialogWindow.findViewById(R.id.img);
        message.setTextColor(context.getResources().getColor(color));
        if (isImage) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        message.setText(messsage);
        commit.setText(btnText);
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
        commit.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onCommitListener.onCommit();
                dialog.dismiss();
            }
        });
    }


    //选择地址
    public static AddressPicker getAddressDialog(Activity context, JSONArray array, AddressPicker.OnAddressPickListener onAddressPickListener) {
        AddressPicker addressPicker = null;
        if (addressPicker == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_picker_titleview, null);
            TextView title = (TextView) view.findViewById(R.id.tv_title);
            title.setText("选择地区");
            try {
                //省
                ArrayList<Province> arrayList1 = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {

                    JSONArray jsonArray = array.getJSONObject(i).getJSONArray("citys");
                    Province province = new Province();
                    province.setAreaName(array.getJSONObject(i).getString("province"));
                    province.setAreaId(array.getJSONObject(i).getString("id"));
                    ArrayList<City> arrayListCity = new ArrayList<>();
                    for (int j = 0; j < jsonArray.length(); j++) {

                        City city = new City();
                        city.setProvinceId(array.getJSONObject(i).getString("id"));
                        city.setAreaId(jsonArray.getJSONObject(j).getString("id"));
                        city.setAreaName(jsonArray.getJSONObject(j).getString("city"));

                        List<County> list = new ArrayList<>();

//                        for (int k = 0; k < jsonArray.getJSONObject(j).getJSONArray("counties").length(); k++) {
//                            County county = new County();
//                            county.setCityId(jsonArray.getJSONObject(j).getString("areaId"));
//                            county.setAreaId(jsonArray.getJSONObject(j).getJSONArray("counties").getJSONObject(k).getString("areaId"));
//                            county.setAreaName(jsonArray.getJSONObject(j).getJSONArray("counties").getJSONObject(k).getString("areaName"));
//                            list.add(county);
//                        }
                        city.setCounties(list);
                        arrayListCity.add(city);
                    }
                    province.setCities(arrayListCity);
                    arrayList1.add(province);

                }
                addressPicker = new AddressPicker((Activity) context, arrayList1);
                addressPicker.setHideCounty(true);
                addressPicker.setTitleView(view);
                addressPicker.setAnimationStyle(R.style.ButtomInOutAnim);

                addressPicker.setCancelText("");
                addressPicker.setSubmitText("");
                addressPicker.setTopHeight(50);

                addressPicker.setLineColor(context.getResources().getColor(R.color.color_1f1f1f));
                addressPicker.setTextColor(context.getResources().getColor(R.color.color_1f1f1f));
                addressPicker.setBackgroundColor(context.getResources().getColor(R.color.white));
                addressPicker.setOnAddressPickListener(onAddressPickListener);
                addressPicker.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            addressPicker.show();
        }
        return addressPicker;

    }


    //选择地址
    public static AddressPicker getAddressDialog02(Activity context,AddressPicker.OnAddressPickListener onAddressPickListener) {
        AddressPicker addressPicker = null;
        if (addressPicker == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_picker_titleview, null);
            TextView title = (TextView) view.findViewById(R.id.tv_title);
            title.setText("选择地区");
            try {
                //省
                InputStreamReader isr = new InputStreamReader(context.getResources().getAssets().open("jzg_city.json"), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
                br.close();
                isr.close();
                JSONArray array = new JSONArray(builder.toString());         //从JSONObject中取出数组对象

                ArrayList<Province> arrayList1 = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {

                    JSONArray jsonArray = array.getJSONObject(i).getJSONArray("citys");
                    Province province = new Province();
                    province.setAreaName(array.getJSONObject(i).getString("province"));
                    province.setAreaId(array.getJSONObject(i).getString("id"));
                    ArrayList<City> arrayListCity = new ArrayList<>();
                    for (int j = 0; j < jsonArray.length(); j++) {

                        City city = new City();
                        city.setProvinceId(array.getJSONObject(i).getString("id"));
                        city.setAreaId(jsonArray.getJSONObject(j).getString("id"));
                        city.setAreaName(jsonArray.getJSONObject(j).getString("city"));

                        List<County> list = new ArrayList<>();

                        for (int k = 0; k < jsonArray.getJSONObject(j).getJSONArray("districts").length(); k++) {
                            County county = new County();
                            county.setCityId(jsonArray.getJSONObject(j).getString("id"));
                            county.setAreaId(jsonArray.getJSONObject(j).getJSONArray("districts").getJSONObject(k).getString("id"));
                            county.setAreaName(jsonArray.getJSONObject(j).getJSONArray("districts").getJSONObject(k).getString("district"));
                            list.add(county);
                        }
                        if(list.size()<=0){
                            System.out.println("=============="+city.getAreaName());
                            County county=new County();
                            county.setCityId(city.getAreaId());
                            county.setAreaId(city.getAreaId());
                            county.setAreaName("");
                            list.add(county);
                        }
                        city.setCounties(list);
                        arrayListCity.add(city);
                    }
                    province.setCities(arrayListCity);
                    arrayList1.add(province);

                }
                addressPicker = new AddressPicker((Activity) context, arrayList1);
                addressPicker.setTitleView(view);
                addressPicker.setAnimationStyle(R.style.ButtomInOutAnim);

                addressPicker.setCancelText("");
                addressPicker.setSubmitText("");
                addressPicker.setTopHeight(50);

                addressPicker.setLineColor(context.getResources().getColor(R.color.color_1f1f1f));
                addressPicker.setTextColor(context.getResources().getColor(R.color.color_1f1f1f));
                addressPicker.setBackgroundColor(context.getResources().getColor(R.color.white));
                addressPicker.setOnAddressPickListener(onAddressPickListener);
                addressPicker.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            addressPicker.show();
        }
        return addressPicker;

    }


    //多条目弹框
    public static void showReasonDialog(final Context context, final List<String> optionList, final OnReasonListener01 onReasonListener) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.setContentView(R.layout.dialog_reason);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
        dialogWindow.setAttributes(lp);//此句代码一定要放在show()后面，否则不起作用
        dialog.setCanceledOnTouchOutside(true);
        RecyclerView rv_option = (RecyclerView) dialogWindow.findViewById(R.id.rv_option);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_option.setLayoutManager(linearLayoutManager);
        OptionAdapter adapter = new OptionAdapter(context, optionList);
        rv_option.setAdapter(adapter);
        TextView cancel = (TextView) dialogWindow.findViewById(R.id.tv_cancel);
        adapter.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                onReasonListener.onReason(optionList.get(pos));
                onReasonListener.onReasonPos(pos);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new ClickUtils.OnClickListener() {

            @Override
            public void onClick(View v, int type, int pos, int child) {
                dialog.dismiss();
            }
        });
    }


    public interface onCommitListener {
        void onCommit();
    }

    public interface onReasonListener {
        void onReason(int position);
    }

    public interface OnReasonListener01 {
        void onReason(String str);
        void onReasonPos(int pos);
    }

    public interface onChoosePicListener {
        void onChooseCamera();

        void onChoosePhone();
    }

}
