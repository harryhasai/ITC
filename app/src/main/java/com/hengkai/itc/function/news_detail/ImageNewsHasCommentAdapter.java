package com.hengkai.itc.function.news_detail;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.ImageNewsHasCommentEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.hengkai.itc.utils.PicassoCircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Harry on 2018/8/25.
 * 图片新闻, 有评论
 */
public class ImageNewsHasCommentAdapter extends BaseQuickAdapter<ImageNewsHasCommentEntity.DataBean.CommentListBean, BaseViewHolder> {

    private Activity mActivity;
    private String attachmentPath;

    public ImageNewsHasCommentAdapter(int layoutResId, @Nullable List<ImageNewsHasCommentEntity.DataBean.CommentListBean> data,
                                      Activity activity, String attachmentPath) {
        super(layoutResId, data);
        this.mActivity = activity;
        this.attachmentPath = attachmentPath;
    }

    @Override
    protected void convert(BaseViewHolder helper, ImageNewsHasCommentEntity.DataBean.CommentListBean item) {
        TextView tvNoComment = helper.getView(R.id.tv_no_comment);
        if (tvNoComment == null) {

            Picasso.with(mActivity)
                    .load(attachmentPath + item.commentImg)
                    .error(R.drawable.ic_news_default_pic)
                    .placeholder(R.drawable.ic_news_default_pic)
                    .transform(new PicassoCircleTransform())
                    .resize(ConvertUtils.dp2px(50), ConvertUtils.dp2px(50))
                    .centerCrop()
                    .into((ImageView) helper.getView(R.id.iv_header));

            String time = DateFormatUtils.getFormatedNewsTime(item.createTime);
            helper.setText(R.id.tv_name, item.commentUser)
                    .setText(R.id.tv_content, item.content)
                    .setText(R.id.tv_time, time);
            LinearLayout llContainer = helper.getView(R.id.ll_container);
            if (TextUtils.isEmpty(item.replyUser) && TextUtils.isEmpty(item.replyContent)) {
                llContainer.setVisibility(View.GONE);
            } else {
                helper.setText(R.id.tv_reply_name, item.replyUser)
                        .setText(R.id.tv_reply_content, item.replyContent);
            }
        }

    }
}
