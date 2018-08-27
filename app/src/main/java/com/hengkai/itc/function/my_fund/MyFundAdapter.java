package com.hengkai.itc.function.my_fund;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.MyFundEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Harry on 2018/8/27.
 */
public class MyFundAdapter extends BaseQuickAdapter<MyFundEntity.DataBean, BaseViewHolder> {

    private Activity mActivity;
    private String attachmentPath;

    public MyFundAdapter(int layoutResId, @Nullable List<MyFundEntity.DataBean> data, Activity activity, String attachmentPath) {
        super(layoutResId, data);

        this.mActivity = activity;
        this.attachmentPath = attachmentPath;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyFundEntity.DataBean item) {
        Picasso.with(mActivity)
                .load(attachmentPath + item.coverImg)
                .error(R.mipmap.ic_launcher)
                //.transform(new PicassoCircleTransform())
                //.resize(WindowUtil.dp2px(50, mActivity), WindowUtil.dp2px(50, mActivity))
//                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_news_image));

        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, item.releaseTime);
        helper.setText(R.id.tv_title, item.newsTitle)
                .setText(R.id.tv_content, item.newsIntro)
                .setText(R.id.tv_count, "浏览 " + item.pageView)
                .setText(R.id.tv_time, time);
    }
}
