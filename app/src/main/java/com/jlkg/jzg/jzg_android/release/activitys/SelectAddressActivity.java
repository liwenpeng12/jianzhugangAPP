package com.jlkg.jzg.jzg_android.release.activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.jlkg.jzg.jzg_android.R;
import com.jlkg.jzg.jzg_android.base.BaseActivity;
import com.jlkg.jzg.jzg_android.other.inter.OnItemClickListener;
import com.jlkg.jzg.jzg_android.release.adapters.SelectAddressAdapter;
import com.jlkg.jzg.jzg_android.weidget.SelectTypeView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectAddressActivity extends BaseActivity implements OnItemClickListener, SelectTypeView.OnSelectResultListener {

    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.select_type_view)
    SelectTypeView selectTypeView;
    private PoiSearch mPoiSearch = PoiSearch.newInstance();
    private SuggestionSearch mSuggestionSearch = SuggestionSearch.newInstance();
    private List<SuggestionResult.SuggestionInfo> list;
    private String districtId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_address;
    }

    @Override
    protected void initViews() {
        super.initViews();
        setLoading(true);
        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);
        mSuggestionSearch.setOnGetSuggestionResultListener(listener);
        selectTypeView.setType(6, this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mEtAddress.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideSoftKeyboard(mEtAddress);
                    mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                            .keyword(TextUtils.isEmpty(mEtAddress.getText().toString()) ? selectTypeView.getSelectCity() : mEtAddress.getText().toString())
                            .city(selectTypeView.getSelectCity()));

                    /*mPoiSearch.searchInCity((new PoiCitySearchOption())
                            .city(selectTypeView.getSelectCity())
                            .keyword(TextUtils.isEmpty(mEtAddress.getText().toString()) ? selectTypeView.getSelectCity() : mEtAddress.getText().toString())
                            .pageNum(10));*/
                }
                return false;
            }
        });
    }

    @Override
    public void itemClickListener(int position) {
        Intent intent = new Intent();
        intent.putExtra("address", list.get(position).key);
        intent.putExtra("districtId", districtId);
        intent.putExtra("provinceId", selectTypeView.getSelectCity());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @OnClick(R.id.tv_cancel)
    void cancel() {
        mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                .keyword(TextUtils.isEmpty(mEtAddress.getText().toString()) ? selectTypeView.getSelectCity() : mEtAddress.getText().toString())
                .city(selectTypeView.getSelectCity()));

    }

    @Override
    protected void onDestroy() {
        mPoiSearch.destroy();
        super.onDestroy();
    }

    @Override
    public void onSelectResultListener(int type, String str) {
        setLoading(false);
        districtId = str;
        mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                .keyword(TextUtils.isEmpty(mEtAddress.getText().toString()) ? selectTypeView.getSelectCity() : mEtAddress.getText().toString())
                .city(selectTypeView.getSelectCity()));
       /* mPoiSearch.searchInCity((new PoiCitySearchOption())
                .city(selectTypeView.getSelectCity())
                .keyword(TextUtils.isEmpty(mEtAddress.getText().toString()) ? selectTypeView.getSelectCity() : mEtAddress.getText().toString())
                .pageNum(10));*/
    }

    OnGetSuggestionResultListener listener = new OnGetSuggestionResultListener() {
        public void onGetSuggestionResult(SuggestionResult res) {
            if (res == null || res.getAllSuggestions() == null) {
                showToast("搜索失败");
                return;
                //未找到相关结果
            }
            mRecycleView.setAdapter(new SelectAddressAdapter(SelectAddressActivity.this, list = res.getAllSuggestions(), SelectAddressActivity.this));
            //获取在线建议检索结果
        }
    };

    OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener() {

        public void onGetPoiResult(PoiResult result) {
            if (result.getAllPoi() == null) {
                showToast("搜索失败");
                return;
            }
            /*if (result.error != SearchResult.ERRORNO.NO_ERROR) {
                showToast("搜索失败");
                return;
            }*/
//            mRecycleView.setAdapter(new SelectAddressAdapter(SelectAddressActivity.this, list = result.getAllPoi(), SelectAddressActivity.this));
            //获取POI检索结果
        }

        public void onGetPoiDetailResult(PoiDetailResult result) {
            //获取Place详情页检索结果
        }

        @Override
        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

        }
    };
}
