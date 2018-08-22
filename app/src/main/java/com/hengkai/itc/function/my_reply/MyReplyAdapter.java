package com.hengkai.itc.function.my_reply;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.network.entity.MyReplyEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.hengkai.itc.utils.PicassoCircleTransform;
import com.hengkai.itc.utils.SPUtils;
import com.hengkai.itc.utils.SpannableStringUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Harry on 2018/8/18.
 */
public class MyReplyAdapter extends BaseQuickAdapter<MyReplyEntity.DataBean, BaseViewHolder> {

    private Activity mActivity;

    public MyReplyAdapter(int layoutResId, @Nullable List<MyReplyEntity.DataBean> data, Activity activity) {
        super(layoutResId, data);
        mActivity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyReplyEntity.DataBean item) {
        if (!TextUtils.isEmpty(item.replyImg)) {
            Picasso.with(mActivity)
                    .load(SPUtils.getString(UserInfo.USER_ICON_FIRST_HALF.name(), "") + item.replyImg)
                    .error(R.drawable.ic_default_user_header)
                    .transform(new PicassoCircleTransform())
                    .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
                    .centerCrop()
                    .into((ImageView) helper.getView(R.id.iv_header));
        } else {
            helper.setImageResource(R.id.iv_header, R.drawable.ic_default_user_header);
        }

        SpannableString spannableString = SpannableStringUtils.setTextColor("回复@" + item.commentUser + ": " + item.replyContent , 2, item.commentUser.length() + 3);
        SpannableString spannableString1 = SpannableStringUtils.setTextColor("@" + item.commentUser + ": " + item.content , 0, item.commentUser.length() + 1);

        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_5, item.replyCreateTime);
        helper.setText(R.id.tv_name, item.replyUser)
                .setText(R.id.tv_time, time)
//                .setText(R.id.tv_content_name, "@" + item.commentUser)
                .setText(R.id.tv_content, spannableString)
                .setText(R.id.tv_later_reply, spannableString1)
                .setText(R.id.tv_quote_name, item.newsTitle)
                .setText(R.id.tv_quote_content, item.newsIntro);
    }
}
