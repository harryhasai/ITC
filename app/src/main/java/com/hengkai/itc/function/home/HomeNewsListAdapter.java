package com.hengkai.itc.function.home;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.network.entity.HomeNewsListEntity;

import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 首页 - 最新资讯
 */
public class HomeNewsListAdapter extends BaseQuickAdapter<HomeNewsListEntity, BaseViewHolder> {

    public HomeNewsListAdapter(int layoutResId, @Nullable List<HomeNewsListEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewsListEntity item) {

//        helper.setText(R.id.text, item.getTitle());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));

    }
}
