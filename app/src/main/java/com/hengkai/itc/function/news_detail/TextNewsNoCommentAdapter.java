package com.hengkai.itc.function.news_detail;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.TextNewsNoCommentEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Harry on 2018/8/25.
 * 文字新闻, 没有评论
 */
public class TextNewsNoCommentAdapter extends BaseQuickAdapter<TextNewsNoCommentEntity.DataBean.NewsListBean, BaseViewHolder> {

    private Activity mActivity;
    private String attachmentPath;

    public TextNewsNoCommentAdapter(int layoutResId, @Nullable List<TextNewsNoCommentEntity.DataBean.NewsListBean> data, Activity activity, String attachmentPath) {
        super(layoutResId, data);
        this.mActivity = activity;
        this.attachmentPath = attachmentPath;
    }

    @Override
    protected void convert(BaseViewHolder helper, TextNewsNoCommentEntity.DataBean.NewsListBean item) {
        Picasso.with(mActivity)
                .load(attachmentPath + item.coverImg)
                .error(R.drawable.ic_news_default_pic)
                .placeholder(R.drawable.ic_news_default_pic)
                //.resize(WindowUtil.dp2px(50, mActivity), WindowUtil.dp2px(50, mActivity))
//                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_news_image));

        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, item.releaseTime);
        helper.setText(R.id.tv_title, item.newsTitle)
                .setText(R.id.tv_content, item.newsIntro)
                .setText(R.id.tv_label, item.paramName)
                .setText(R.id.tv_count, "浏览 " + item.pageView)
                .setText(R.id.tv_time, time);
    }
}
