package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.ClickUtils;
import com.jlkg.jzg.jzg_android.other.utils.PixelUtil;
import com.jlkg.jzg.jzg_android.personal.activity.AddMemberActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.ClassMemberAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.personal.event.AddMemberRefreshEvent;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassMemberActivity extends BaseActivity {


    @BindView(R.id.list_content)
    SwipeMenuRecyclerView listContent;
    @BindView(R.id.tv_addMember)
    TextView tvAddMember;
    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;

    private ClassMemberAdapter classMemberAdapter;
    private List<ClassMemberBean> list;
    private int type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_member;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        type = getIntent().getExtras().getInt("type");
        if (type == 1) {
            myToolbar.setRightText("");
            tvAddMember.setVisibility(View.GONE);
        }
        if (type == 2) {
            myToolbar.setRightText("");
        } else {
            myToolbar.setClickListener(new ClickUtils.OnClickListener() {
                @Override
                public void onClick(View v, int type, int pos, int child) {
                    Bundle bundle = getIntent().getExtras();

                    openActivity(ClassHistoryMemberActivity.class, bundle);
                }
            });
        }
        smartRefresh.setEnableLoadmore(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        //  listContent.setItemViewSwipeEnabled(true);
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData();
            }
        });

        if (type != 1 && type != 2) {
            // 创建菜单：
            SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
                @Override
                public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
                    SwipeMenuItem deleteItem = new SwipeMenuItem(mContext);
                    deleteItem.setText("删除");
                    deleteItem.setHeight(-1);
                    deleteItem.setWidth(PixelUtil.dp2px(80));
                    deleteItem.setTextColorResource(R.color.white);
                    deleteItem.setBackground(R.color.color_ff4040);
                    // 各种文字和图标属性设置。
                    rightMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。

                    // 注意：哪边不想要菜单，那么不要添加即可。
                }
            };
            listContent.setSwipeMenuCreator(mSwipeMenuCreator);


            SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
                @Override
                public void onItemClick(SwipeMenuBridge menuBridge) {
                    // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                    menuBridge.closeMenu();

//                int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
//                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
//                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                    System.out.println("============menu=position===" + menuBridge.getPosition() + "====" + menuBridge.getAdapterPosition());
//                classMemberAdapter.notifyDataSetChanged();
                    final int pos = menuBridge.getAdapterPosition();
                    setLoading(true);
                    ApiManager.deleteTeamMember(list.get(menuBridge.getAdapterPosition()).getId() + "", ClassMemberActivity.class, new HttpUtils.OnCallBack() {
                        @Override
                        public void success(String response) {
                            setLoading(false);
                            list.remove(pos);
                            classMemberAdapter.setClassMemberBeans(list);
                        }

                        @Override
                        public void onError(String msg) {
                            setLoading(false);
                            toast(msg);
                        }
                    });
                }
            };

            // 菜单点击监听。
            listContent.setSwipeMenuItemClickListener(mMenuItemClickListener);
        }

    }

    @Subscribe
    public void onMainEventThread(AddMemberRefreshEvent addMemberRefreshEvent) {
        smartRefresh.autoRefresh();
    }


    @Override
    protected void initData() {
        super.initData();
        list = new ArrayList<>();

        classMemberAdapter = new ClassMemberAdapter(this, list);
        if (type == 2) {
            classMemberAdapter.setOnItemClockLisntener(new OnItemClickListener() {
                @Override
                public void itemClickListener(int position) {
                    EventBus.getDefault().post(list.get(position));
                    finish();
                }
            });
        }
        listContent.setAdapter(classMemberAdapter);

        smartRefresh.autoRefresh();
    }


    public void getData() {
        Bundle bundle = getIntent().getExtras();
        String teamId = "";
        if (bundle == null && type != 2) {
            teamId = MyApplication.sTeamLoginBean.getId() + "";
        } else {
            teamId = bundle.getString("teamId");
        }
        ApiManager.getTeamMember(teamId, this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                smartRefresh.finishRefresh();
                try {
                    list = JSON.parseArray(response, ClassMemberBean.class);
                    classMemberAdapter.setClassMemberBeans(list);
                    classMemberAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @OnClick(R.id.tv_addMember)
    public void onViewClicked() {
        Bundle bundle = getIntent().getExtras();
        openActivity(AddMemberActivity.class, bundle);
    }
}
