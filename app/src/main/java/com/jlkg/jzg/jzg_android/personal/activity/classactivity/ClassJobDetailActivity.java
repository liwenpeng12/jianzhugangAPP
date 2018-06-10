package com.jlkg.jzg.jzg_android.personal.activity.classactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.personal.bean.RecruitWorkersBean;
import com.jlkg.jzg.jzg_android.personal.bean.RecruitWorkersTeamBean;
import com.jlkg.jzg.jzg_android.weidget.MyToolbar;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassJobDetailActivity extends BaseActivity {


    @BindView(R.id.my_toolbar)
    MyToolbar myToolbar;
    @BindView(R.id.btn_bottom)
    Button btnBottom;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_need_left)
    TextView tvNeedLeft;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.lin_need)
    LinearLayout linNeed;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_type_left)
    TextView tvTypeLeft;
    @BindView(R.id.tv_type_right)
    TextView tvTypeRight;
    @BindView(R.id.tv_pice)
    TextView tvPice;
    @BindView(R.id.tv_require)
    TextView tvRequire;
    @BindView(R.id.tv_remark)
    TextView tvRemark;

    private RecruitWorkersTeamBean recruitWorkersTeamBean;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_job_detail;
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
        Bundle bundle=getIntent().getExtras();
        Serializable serializable=bundle.getSerializable("data");
        recruitWorkersTeamBean= (RecruitWorkersTeamBean) serializable;
       // tvJobName.setText(recruitWorkersTeamBean);
    }
}
