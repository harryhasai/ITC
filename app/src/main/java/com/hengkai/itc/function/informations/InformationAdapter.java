package com.hengkai.itc.function.informations;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.function.activity_list.ActivityListActivity;
import com.hengkai.itc.function.news_list.NewsListActivity;
import com.hengkai.itc.network.entity.CommonItem;
import com.hengkai.itc.network.entity.InformationContentEntity;
import com.hengkai.itc.network.entity.InformationEntity;
import com.ruffian.library.RTextView;

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
    private int[] images = {R.drawable.ic_information_yq, R.drawable.ic_information_qy,
            R.drawable.ic_information_gx, R.drawable.ic_information_jg1, R.drawable.ic_information_hd};

    public InformationAdapter(int layoutResId, @Nullable List<CommonItem> data, Activity activity,
                              List<InformationContentEntity.DataBean> mList) {
        super(layoutResId, data);
        mActivity = activity;

        this.mList = mList;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonItem item) {
        RTextView tvName = helper.getView(R.id.tv_name);
        tvName.setIconNormal(mActivity.getResources().getDrawable(images[helper.getAdapterPosition()]));

        helper.setText(R.id.tv_name, item.name);

        RecyclerView rvInformation = helper.getView(R.id.rv_information);
        rvInformation.setLayoutManager(new GridLayoutManager(mActivity, 3));

        final List<InformationEntity> data = new ArrayList<>();
        switch (helper.getAdapterPosition()) {
            case 0://园区
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("park_management")) {
                        data.add(new InformationEntity(mList.get(i).paramName, mList.get(i).id));
                    }
                }
                break;
            case 1://企业
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("enterprise_management")) {
                        data.add(new InformationEntity(mList.get(i).paramName, mList.get(i).id));
                    }
                }
                break;
            case 2://高校
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("colleges_management")) {
                        data.add(new InformationEntity(mList.get(i).paramName, mList.get(i).id));
                    }
                }
                break;
            case 3://机构
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("other_management")) {
                        data.add(new InformationEntity(mList.get(i).paramName, mList.get(i).id));
                    }
                }
                break;
            case 4://活动
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).permission.equals("activityType")) {
                        data.add(new InformationEntity(mList.get(i).paramName, mList.get(i).id));
                    }
                }
                break;
        }


        InformationContentAdapter adapter = new InformationContentAdapter(R.layout.item_information_content, data, mActivity);
        rvInformation.setAdapter(adapter);
        if (helper.getAdapterPosition() == 4) { //如果是活动 , 则跳转到额外的活动列表页面
            adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(mActivity, ActivityListActivity.class);
                    intent.putExtra("childID", data.get(position).id);
                    intent.putExtra("name", data.get(position).name);
                    mActivity.startActivity(intent);
                }
            });
        } else {
            adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(mActivity, NewsListActivity.class);
                    intent.putExtra("childID", data.get(position).id);
                    intent.putExtra("name", data.get(position).name);
                    mActivity.startActivity(intent);
                }
            });
        }

    }
}
