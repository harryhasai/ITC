package com.hengkai.itc.function.my_reply;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.network.entity.MyReplyEntity;

import java.util.List;

/**
 * Created by Harry on 2018/8/18.
 */
public class MyReplyAdapter extends BaseQuickAdapter<MyReplyEntity, BaseViewHolder> {

    public MyReplyAdapter(int layoutResId, @Nullable List<MyReplyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyReplyEntity item) {

    }
}
