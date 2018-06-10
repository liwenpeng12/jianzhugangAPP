package com.jlkg.jzg.jzg_android.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.Ibase.ValueInterface;
import com.yuyh.library.imgsel.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/5/2
 */

public class MySelectImageAdapter extends BaseAdapter {


    public ValueInterface valueInterface = null;
    private Context context;

    private List<String> mPathList=new ArrayList<>();
    //最多可以选择的数量
    private int maxCount=6;
    //是否显示添加的图标
    private boolean isAdd=true;
    private List<String> urlList=new ArrayList<>();
    private List<String> urlListId=new ArrayList<>();
    private List<String> allList=new ArrayList<>();
    public void setUrlList(List<String> urlList) {
        allList.removeAll(this.urlList);
        this.urlList = urlList;
        allList.addAll(urlList);
        notifyDataSetChanged();
    }

    public void setUrlListId(List<String> urlListId) {
        this.urlListId = urlListId;
        notifyDataSetChanged();
    }
    public MySelectImageAdapter(ValueInterface valueInterface, Context context) {
        this.valueInterface = valueInterface;
        this.context = context;
    }


    //this method need improve
    public void setmPathList(List<String> mPathList) {
        allList.removeAll(this.mPathList);
        this.mPathList=mPathList;
        allList.addAll(mPathList);
        notifyDataSetChanged();
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
        notifyDataSetChanged();
    }

    public void setAdd(boolean add) {
        isAdd = add;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(allList.size()>=maxCount) {
            return maxCount;
        }else{
            if(isAdd) {
                return allList.size() + 1;
            }else{
                return allList.size();
            }
        }
    }


    @Override
    public Object getItem(int position) {
        return allList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem_image_make_grid, null);
        ImageView image_iv = (ImageView) convertView.findViewById(R.id.img);
        ImageView iv_close = (ImageView) convertView.findViewById(R.id.iv_close);
        if (position == getCount() - 1) {
            LogUtils.e("进来执行了");
            if(isAdd) {
                image_iv.setImageResource(R.mipmap.icon_takephoto);
                iv_close.setVisibility(View.GONE);

                if (allList.size() == maxCount) {
                    Glide.with(parent.getContext()).load(allList.get(position)).into(image_iv);
                    iv_close.setVisibility(View.VISIBLE);
                }
            }else{
                if (position<allList.size()) {
                    Glide.with(parent.getContext()).load(allList.get(position)).into(image_iv);
                }
            }
        } else {
            Glide.with(parent.getContext()).load(allList.get(position)).into(image_iv);
            if(isAdd) {
                iv_close.setVisibility(View.VISIBLE);
            }
        }
        if(!isAdd) {
            iv_close.setVisibility(View.GONE);
        }
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position<urlList.size()) {
                    urlList.remove(position);
                    urlListId.remove(position);
                }else{
                    mPathList.remove(position-urlList.size());
                }
                allList.remove(position);
               // valueInterface.onValueChanged(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


}
