package com.jlkg.jzg.jzg_android.base;


import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

/**
 * @autor zcs
 * @time 2017/12/11
 * @describe
 */

public abstract class BaseRefreshActivity extends BaseActivity implements OnRefreshLoadmoreListener {
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        httpData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        httpData();
    }

    protected abstract void httpData();
}
