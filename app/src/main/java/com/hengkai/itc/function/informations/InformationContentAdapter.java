package com.hengkai.itc.function.informations;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.network.entity.CommonItem;

import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 内容列表的适配器
 */
public class InformationContentAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    public InformationContentAdapter(int layoutResId, @Nullable List<CommonItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {

    }
}
