package com.hengkai.itc.function.informations;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.CommonItem;
import com.hengkai.itc.network.entity.InformationContentEntity;

import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 内容列表的适配器
 */
public class InformationContentAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    private Activity mActivity;

    public InformationContentAdapter(int layoutResId, @Nullable List<CommonItem> data, Activity mActivity) {
        super(layoutResId, data);
        this.mActivity = mActivity;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {
        helper.setText(R.id.tv_content_name, item.name);
        TextView tvContentName = helper.getView(R.id.tv_content_name);
        if ((helper.getAdapterPosition() + 1) % 3 == 0) {
            if(TextUtils.isEmpty(item.name)){
                tvContentName.setBackground(mActivity.getResources().getDrawable(R.drawable.shape_information_line1));
            } else {
                tvContentName.setBackground(mActivity.getResources().getDrawable(R.drawable.selector_item_information_line1));
            }
        } else {
            if(TextUtils.isEmpty(item.name)){
                tvContentName.setBackground(mActivity.getResources().getDrawable(R.drawable.shape_information_line2));
            } else {
                tvContentName.setBackground(mActivity.getResources().getDrawable(R.drawable.selector_item_information_line2));
            }
        }
    }
}
