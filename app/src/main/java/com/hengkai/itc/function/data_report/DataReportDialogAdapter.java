package com.hengkai.itc.function.data_report;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.CommonItem;

import java.util.List;

/**
 * Created by Harry on 2018/8/18.
 */
public class DataReportDialogAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    public DataReportDialogAdapter(int layoutResId, @Nullable List<CommonItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {
        helper.setText(R.id.tv_content, item.name);
    }
}
