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

import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 */
public class InformationContentAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    public InformationContentAdapter(int layoutResId, @Nullable List<CommonItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {

    }
}
