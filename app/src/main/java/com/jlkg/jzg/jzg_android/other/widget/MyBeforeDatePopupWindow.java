package com.jlkg.jzg.jzg_android.other.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.other.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.widget.WheelView;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2017/11/30
 */

public class MyBeforeDatePopupWindow extends PopupWindow implements PopupWindow.OnDismissListener {

    private WheelView.LineConfig lineConfig;
    private ViewHolder viewHolder;
    private ArrayList<String> listDataYear;
    private ArrayList<String> listDataMonth;
    private ArrayList<String> listDataDay;
    //当前年
    private int currentYear;
    //当前月
    private int currentMonth;
    //当前日
    private int currentDay;
    //选择的年 月 日
    private int selectYear,selectMonth,selectDay;

    private boolean isDay=true;
    private OnSelectDateContent onSelectDateContent;
    private Window window;
    private WindowManager.LayoutParams layoutParams;

    public void setOnSelectDateContent(OnSelectDateContent onSelectDateContent) {
        this.onSelectDateContent = onSelectDateContent;
    }

    @Override
    public void onDismiss() {
        if(layoutParams!=null){
            layoutParams.alpha=1;
            window.setAttributes(layoutParams);
        }
    }

    public interface  OnSelectDateContent{
        void getDate(String year, String month, String day);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        if(layoutParams!=null){
            System.out.println("===============01============");
            layoutParams.alpha=0.5f;
            window.setAttributes(layoutParams);
        }
    }


    public MyBeforeDatePopupWindow(final Context context, View viewGroup, boolean isDay) {
        this.isDay=isDay;
        initView(context,viewGroup);
    }
    public MyBeforeDatePopupWindow(final Context context, View viewGroup) {
        super(context);

        initView(context, viewGroup);


    }

    private void initView(final Context context, View viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.popwin_date_layout, null);
        viewHolder=new ViewHolder(view);
        this.setAnimationStyle(R.style.ButtomInOutAnim);
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        if(context instanceof Activity){
            System.out.println("===========activity=====");
            window=((Activity) context).getWindow();
            layoutParams=window.getAttributes();
        }
        this.setContentView(view);
        this.setOnDismissListener(this);
        showAtLocation(viewGroup, Gravity.BOTTOM, 0, 0);

        lineConfig=new WheelView.LineConfig();
        lineConfig.setRatio(0);
        lineConfig.setColor(context.getResources().getColor(R.color.color_039aff));
        viewHolder.wvHour.setTextColor(context.getResources().getColor(R.color.color_039aff));
        viewHolder.wvMinus.setTextColor(context.getResources().getColor(R.color.color_039aff));
        viewHolder.wvDate.setTextColor(context.getResources().getColor(R.color.color_039aff));

        getYearList();
        viewHolder.ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBeforeDatePopupWindow.this.dismiss();
            }
        });

        viewHolder.ivChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long currentLong=0l;
                if(isDay){
                    currentLong= TimeUtils.getTimeLong(selectYear+"-"+selectMonth+"-"+selectDay+" "+"00:00:00");

                }else{
                    currentLong= TimeUtils.getTimeLong(selectYear+"-"+selectMonth+"-"+"01"+" "+"00:00:00");

                }
                System.out.println("==========currentLong="+currentLong+"====="+selectYear);
                if(currentLong<=System.currentTimeMillis()) {
                    MyBeforeDatePopupWindow.this.dismiss();
                    if (onSelectDateContent != null) {
                        onSelectDateContent.getDate(selectYear + "", selectMonth + "", selectDay + "");
                    }
                }else{
                    Toast.makeText(context,"请选择过去的时间",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //获取年列表
    public void getYearList(){
        listDataYear=new ArrayList<>();
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        int mYear =c.get(Calendar.YEAR);
        int mMonth =c.get(Calendar.MONTH) + 1;
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        currentMonth=mMonth;
        currentYear=mYear;
        listDataYear.add(mYear+"");
        for(int i=0;i<50;i++){
            mYear--;
            listDataYear.add(mYear+"");
        }
        viewHolder.wvDate.setOnWheelListener(new WheelView.OnWheelListener() {
            @Override
            public void onSelected(boolean isUserScroll, int index, String item) {
                selectYear=Integer.parseInt(listDataYear.get(index));
                getDayList(selectYear,selectMonth);

            }
        });
        viewHolder.wvDate.setItems(listDataYear);
        viewHolder.wvDate.setLineConfig(lineConfig);
        if(isDay) {
            viewHolder.wvMinus.setLineConfig(lineConfig);
        }
        viewHolder.wvHour.setLineConfig(lineConfig);



        getMonthList();

    }
    //获取月份
    public void getMonthList(){
        listDataMonth=new ArrayList<>();
        for(int i=1;i<=12;i++){
            if(i<10) {
                listDataMonth.add("0"+i);
            }else{
                listDataMonth.add(""+i);
            }
        }
        viewHolder.wvHour.setOnWheelListener(new WheelView.OnWheelListener() {
            @Override
            public void onSelected(boolean isUserScroll, int index, String item) {
                selectMonth=Integer.parseInt(listDataMonth.get(index));
                getDayList(selectYear,selectMonth);
            }
        });
        viewHolder.wvHour.setItems(listDataMonth);
        viewHolder.wvHour.setSelectedIndex(currentMonth-1);
        if(isDay) {
            getDayList(currentYear, currentMonth);
        }else{
            viewHolder.wvMinus.setVisibility(View.GONE);
        }
    }

    //获取当前月的天数
    public void getDayList(int year,int month){
        if(isDay) {
            listDataDay = new ArrayList<>();
            if (year <= 0 || month <= 0) {
                return;
            }
            for (int i = 0; i < getDaysByYearMonth(year, month); i++) {
                if (i + 1 < 10) {
                    listDataDay.add("0" + (i + 1));
                } else {
                    listDataDay.add(i + 1 + "");
                }
            }
            viewHolder.wvMinus.setOnWheelListener(new WheelView.OnWheelListener() {
                @Override
                public void onSelected(boolean isUserScroll, int index, String item) {
                    selectDay = Integer.parseInt(listDataDay.get(index));
                }
            });

            viewHolder.wvMinus.setItems(listDataDay);
            viewHolder.wvMinus.setSelectedIndex(currentDay - 1);
        }
    }



    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    static class ViewHolder {
        @BindView(R.id.iv_cancel)
        TextView ivCancel;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_choose)
        TextView ivChoose;
        @BindView(R.id.wv_date)
        WheelView wvDate;
        @BindView(R.id.wv_hour)
        WheelView wvHour;
        @BindView(R.id.wv_minus)
        WheelView wvMinus;
        @BindView(R.id.ll_popup)
        LinearLayout llPopup;
        @BindView(R.id.rl_popup)
        RelativeLayout rlPopup;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
