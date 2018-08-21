package com.hengkai.itc.function.informations;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.custom_view.DividerGridItemDecoration;
import com.hengkai.itc.network.entity.CommonItem;
import com.hengkai.itc.network.entity.InformationContentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 最外层列表的适配器
 */
public class InformationAdapter extends BaseQuickAdapter<CommonItem, BaseViewHolder> {

    private Activity mActivity;
    /**
     * 内容集合
     */
    private List<InformationContentEntity.DataBean> mList;

    public InformationAdapter(int layoutResId, @Nullable List<CommonItem> data, Activity activity,
                              List<InformationContentEntity.DataBean> mList) {
        super(layoutResId, data);
        mActivity = activity;

        this.mList = mList;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {
        helper.setText(R.id.tv_name, item.name);
        RecyclerView rvInformation = helper.getView(R.id.rv_information);
        rvInformation.setLayoutManager(new GridLayoutManager(mActivity, 3));

        List<CommonItem> data = new ArrayList<>();
        switch (helper.getAdapterPosition()) {
            case 0://园区
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("park_management")) {
                        data.add(new CommonItem(mList.get(i).paramName));
                    }
                }
                break;
            case 1://企业
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("enterprise_management")) {
                        data.add(new CommonItem(mList.get(i).paramName));
                    }
                }
                break;
            case 2://高校
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("colleges_management")) {
                        data.add(new CommonItem(mList.get(i).paramName));
                    }
                }
                break;
            case 3://机构
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("other_management")) {
                        data.add(new CommonItem(mList.get(i).paramName));
                    }
                }
                break;
            case 4://活动
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("activityType")) {
                        data.add(new CommonItem(mList.get(i).paramName));
                    }
                }
                break;
        }

        rvInformation.setAdapter(new InformationContentAdapter(R.layout.item_information_content, data, mActivity));
    }
}
