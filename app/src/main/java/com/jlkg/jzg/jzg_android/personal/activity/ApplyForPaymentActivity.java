package com.jlkg.jzg.jzg_android.personal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.other.utils.ApiManager;
import com.jlkg.jzg.jzg_android.other.utils.DialogUtils;
import com.jlkg.jzg.jzg_android.personal.activity.classactivity.ClassMemberActivity;
import com.jlkg.jzg.jzg_android.personal.adapter.ApplyForPaymentAdapter;
import com.jlkg.jzg.jzg_android.personal.bean.ClassMemberBean;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApplyForPaymentActivity extends BaseActivity {

    @BindView(R.id.list_content)
    RecyclerView listContent;
    @BindView(R.id.tv_addPersonnel)
    TextView tvAddPersonnel;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.ib_back)
    ImageButton ibBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_right)
    ImageButton ibRight;
    @BindView(R.id.my_toolbar)
    LinearLayout myToolbar;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    private int mId;
    private String mAuditNo;
    private List<ClassMemberBean> mList = new ArrayList<>();
    private ApplyForPaymentAdapter applyForPaymentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_for_payment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Subscribe
    public void onMainEventThread(ClassMemberBean memberBean) {
        mList.add(memberBean);
        listContent.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void initViews() {
        super.initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            mId = getIntent().getExtras().getInt("id");
            mAuditNo = getIntent().getExtras().getString("auditNo");
        }
        tvTitle.setText(MyApplication.isCompany ? "申请成员" : "申请金额");
//        tvAddPersonnel.setVisibility(MyApplication.isCompany ? View.VISIBLE : View.GONE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContent.setLayoutManager(linearLayoutManager);
        // listContent.setPullRefreshEnabled(false);
        if (MyApplication.sTeamLoginBean.getTeamType() == null) {
            DialogUtils.showInvitedDia(mContext, true);
            return;
        }
        vertifyBindBank();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mList != null && mList.size() > 0) {
            ClassMemberBean bean = mList.get(0);
            bean.setId(MyApplication.sTeamLoginBean.getId());
            bean.setTitle(MyApplication.sTeamLoginBean.getTitle());
            bean.setIdNumber(MyApplication.sTeamLoginBean.getIdNumber());
            bean.setPhone(MyApplication.sTeamLoginBean.getUserName());
            bean.setCardNumber(MyApplication.sTeamLoginBean.getBankCardNo());
            bean.setBankName(MyApplication.sTeamLoginBean.getBankInfo());
            listContent.getAdapter().notifyDataSetChanged();
        }
    }

    private boolean vertifyBindBank() {
        if (MyApplication.isCompany) return false;
        if (MyApplication.sTeamLoginBean == null) return false;
        if (TextUtils.isEmpty(MyApplication.sTeamLoginBean.getBankInfo()) || TextUtils.isEmpty(MyApplication.sTeamLoginBean.getBankCardNo())) {
            DialogUtils.showSettingDialog(this, false, "您还没有绑定银行卡，\n请先绑定银行卡！", "去绑定", R.color.color_a5a5a5, new DialogUtils.onCommitListener() {
                @Override
                public void onCommit() {
                    openActivityForResult(BindCardActivity.class, 1);
                }
            });
            return false;
        }
        return true;
    }

    @Override
    protected void initData() {
        super.initData();

        ClassMemberBean bean = new ClassMemberBean();
        bean.setId(MyApplication.sTeamLoginBean.getId());
        bean.setTitle(MyApplication.sTeamLoginBean.getTitle());
        bean.setIdNumber(MyApplication.sTeamLoginBean.getIdNumber());
        bean.setPhone(MyApplication.sTeamLoginBean.getUserName());
        bean.setCardNumber(MyApplication.sTeamLoginBean.getBankCardNo());
        bean.setBankName(MyApplication.sTeamLoginBean.getBankInfo());
        mList.add(bean);
        applyForPaymentAdapter = new ApplyForPaymentAdapter(this, mList);
        applyForPaymentAdapter.setApplyForPaymentListener(new ApplyForPaymentAdapter.ApplyForPaymentListener() {
            @Override
            public void isAllEnter(boolean isEnter) {
//                tvConfirm.setEnabled(isEnter);
            }
        });
        setLoading(true);
        listContent.setAdapter(applyForPaymentAdapter);
        ApiManager.getTeamMember(MyApplication.sTeamLoginBean.getId() + "", this, new HttpUtils.OnCallBack() {
            @Override
            public void success(String response) {
                try {
                    List<ClassMemberBean> list = JSON.parseArray(response, ClassMemberBean.class);
                    mList.addAll(list);
                    setLoading(false);
                    listContent.getAdapter().notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    onError("获取班组信息失败");
                }
            }

            @Override
            public void onError(String msg) {
                setLoading(false);
                listContent.setVisibility(View.GONE);
                tvConfirm.setEnabled(false);
                showToast(msg);
            }
        });
    }


    @OnClick({R.id.ib_back, R.id.tv_addPersonnel, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.tv_addPersonnel:
                Bundle bundle = new Bundle();
                bundle.putString("teamId", MyApplication.sTeamLoginBean.getId() + "");
                bundle.putInt("type", 2);
                openActivity(ClassMemberActivity.class, bundle);
                break;
            case R.id.tv_confirm:
                if (MyApplication.sTeamLoginBean.getTeamType() == null) {
                    DialogUtils.showInvitedDia(mContext, true);
                    return;
                }
                if (!vertifyBindBank()) return;
                int size = mList.size();
                double appluAmount = 0;
                StringBuilder detail_teamId = new StringBuilder();
                StringBuilder detail_workerId = new StringBuilder();
                StringBuilder detail_workerName = new StringBuilder();
                StringBuilder detail_idNumber = new StringBuilder();
                StringBuilder detail_mobile = new StringBuilder();
                StringBuilder detail_bankName = new StringBuilder();
                StringBuilder detail_cardNumber = new StringBuilder();
                StringBuilder detail_salary = new StringBuilder();
                for (int i = 0; i < size; i++) {
                    ClassMemberBean bean = mList.get(i);
                    if (!TextUtils.isEmpty(bean.getMoney()))
                        appluAmount = appluAmount + Double.valueOf(bean.getMoney());
                    if (i == size - 1) {
                        detail_teamId.append(i == 0 ? MyApplication.sTeamLoginBean.getId() : "0");
                        detail_workerId.append(i == 0 ? "0" : bean.getId());
                        detail_workerName.append(bean.getTitle());
                        detail_idNumber.append(TextUtils.isEmpty(bean.getIdNumber()) ? "" : bean.getIdNumber());
                        detail_mobile.append(bean.getPhone());
                        detail_bankName.append(TextUtils.isEmpty(bean.getBankName()) ? "" : bean.getBankName());
                        detail_cardNumber.append(TextUtils.isEmpty(bean.getCardNumber()) ? "" : bean.getCardNumber());
                        detail_salary.append(TextUtils.isEmpty(bean.getMoney()) ? "0" : bean.getMoney());
                    } else {
                        detail_teamId.append(i == 0 ? MyApplication.sTeamLoginBean.getId() : "0").append(",");
                        detail_workerId.append(i == 0 ? "0" : bean.getId()).append(",");
                        detail_workerName.append(bean.getTitle()).append(",");
                        detail_idNumber.append(TextUtils.isEmpty(bean.getIdNumber()) ? "" : bean.getIdNumber()).append(",");
                        detail_mobile.append(bean.getPhone()).append(",");
                        detail_bankName.append(TextUtils.isEmpty(bean.getBankName()) ? "" : bean.getBankName()).append(",");
                        detail_cardNumber.append(TextUtils.isEmpty(bean.getCardNumber()) ? "" : bean.getCardNumber()).append(",");
                        detail_salary.append(TextUtils.isEmpty(bean.getMoney()) ? "0" : bean.getMoney()).append(",");
                    }
                }
                setLoading(true);
                ApiManager.addOrder(MyApplication.sTeamLoginBean.getId(), mId, /*mAuditNo*/"",
                        appluAmount + "", detail_teamId.toString(), detail_workerId.toString(),
                        detail_workerName.toString(), detail_idNumber.toString(), detail_mobile.toString(),
                        detail_bankName.toString(), detail_cardNumber.toString(), detail_salary.toString(),this, new HttpUtils.OnCallBack() {
                            @Override
                            public void success(String response) {
                                setLoading(false);
                                setResult(Activity.RESULT_OK);
                                finish();
                            }

                            @Override
                            public void onError(String msg) {
                                setLoading(false);
                                showToast(msg);
                            }
                        });
                break;
        }
    }
}
