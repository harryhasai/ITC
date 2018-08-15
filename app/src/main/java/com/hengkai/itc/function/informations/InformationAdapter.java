package com.hengkai.itc.function.informations;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.custom_view.DividerGridItemDecoration;
import com.hengkai.itc.network.entity.CommonItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 */
public class InformationAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    private Activity mActivity;
    /**
     * 内容集合
     */
    private List<CommonItem> mList;

    public InformationAdapter(int layoutResId, @Nullable List<CommonItem> data, Activity activity) {
        super(layoutResId, data);
        mActivity = activity;
        initContentData();
    }

    private void initContentData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new CommonItem());
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {
        helper.setText(R.id.tv_name, item.name);
        RecyclerView rvInformation = helper.getView(R.id.rv_information);
        rvInformation.setLayoutManager(new GridLayoutManager(mActivity, 3));
        rvInformation.setAdapter(new InformationContentAdapter(R.layout.item_information_content, mList));
        rvInformation.addItemDecoration(new DividerGridItemDecoration(mActivity));
    }
}
