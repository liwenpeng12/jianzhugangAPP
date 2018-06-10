package com.jlkg.jzg.jzg_android.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.jlkg.jzg.baselibrary.utils.ToastUtils;
import com.jlkg.jzg.jzg_android.R;
import com.lzy.okgo.OkGo;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @autor zcs
 * @time 2017/9/11
 * @describe fragment的基类
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Unbinder unbinder;
    protected boolean isViewCreated;
    private boolean isViewVisibity;
    protected ProgressDialog waitDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getArguments());

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isViewVisibity = true;
            lasyLoadData();

        } else if (getView() != null) {
            isViewVisibity = false;
            viewInvisible();
        }
    }

    /**
     * 界面可见，执行网络加载
     */
    private void lasyLoadData() {
        if (!isViewCreated || !isViewVisibity) {
            return;
        }
        loadHttpData();
        isViewCreated = false;
        isViewVisibity = false;
    }

    protected void loadHttpData() {

    }

    /**
     * 界面不可见
     */
    protected void viewInvisible() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(mContext).inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        isViewCreated = true;
        initView();
        lasyLoadData();
    }

    protected void init(Bundle arguments) {

    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initListener() {

    }


    public BaseFragment() {
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        OkGo.cancelTag(OkGo.getInstance().getOkHttpClient(), this);

    }

    public void showToast(CharSequence str) {
        ToastUtils.showShort(str);
    }

    protected void hideSoftKeyboard() {
        View view = getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getActivity().getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void openActivity(Class<?> cls) {
        if (isAdded()) {
            Intent i = new Intent(mContext, cls);
            startActivity(i);
        }
    }


    protected void openActivity(Class<?> cls, Bundle bundle) {
        if (bundle == null) {
            openActivity(cls);
            return;
        }
        Intent i = new Intent(mContext, cls);
        i.putExtras(bundle);
        startActivity(i);
        int version = Integer.valueOf(android.os.Build.VERSION.SDK);
    }

    protected void openActivityForResult(Class<?> cls, int requestCode) {
        Intent i = new Intent(mContext, cls);
        startActivityForResult(i, requestCode);
        int version = Integer.valueOf(android.os.Build.VERSION.SDK);
    }

    protected void openActivityForResult(Class<?> cls, int requestCode, Bundle bundle) {
        Intent i = new Intent(mContext, cls);
        i.putExtras(bundle);
        startActivityForResult(i, requestCode);
        int version = Integer.valueOf(android.os.Build.VERSION.SDK);
    }

    public void setLoading(boolean isLoading) {
        try {
            if (isLoading) {
                if (waitDialog == null || !waitDialog.isShowing()) {
                    waitDialog = new ProgressDialog(getActivity(), R.style.MyDialogStyleBottom);
                    waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    waitDialog.setCanceledOnTouchOutside(false);
                    ImageView view = new ImageView(getActivity());
                    view.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    Animation loadAnimation = AnimationUtils.loadAnimation(
                            getActivity(), R.anim.rotate);
                    view.startAnimation(loadAnimation);
                    loadAnimation.start();
                    view.setImageResource(R.mipmap.loading);
                    waitDialog.show();
                    waitDialog.setContentView(view);
                }
            } else {
                if (waitDialog != null && waitDialog.isShowing()) {
                    waitDialog.dismiss();
                    waitDialog = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
