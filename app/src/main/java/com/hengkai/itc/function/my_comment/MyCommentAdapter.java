package com.hengkai.itc.function.my_comment;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.MyCommentEntity;

import java.util.List;

/**
 * Created by Harry on 2018/8/17.
 */
public class MyCommentAdapter extends BaseQuickAdapter<MyCommentEntity, BaseViewHolder> {

    public MyCommentAdapter(int layoutResId, @Nullable List<MyCommentEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCommentEntity item) {
        if (helper.getAdapterPosition() == 0) {
            helper.getView(R.id.view_common_line).setVisibility(View.GONE);
        }
    }
}
