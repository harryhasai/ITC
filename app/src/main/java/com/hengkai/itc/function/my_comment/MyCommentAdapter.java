package com.hengkai.itc.function.my_comment;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.network.entity.MyCommentEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.hengkai.itc.utils.PicassoCircleTransform;
import com.hengkai.itc.utils.SPUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Harry on 2018/8/17.
 */
public class MyCommentAdapter extends BaseQuickAdapter<MyCommentEntity.DataBean, BaseViewHolder> {

    private Activity mActivity;

    public MyCommentAdapter(int layoutResId, @Nullable List<MyCommentEntity.DataBean> data, Activity activity) {
        super(layoutResId, data);
        mActivity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCommentEntity.DataBean item) {
        if (helper.getAdapterPosition() == 0) {
            helper.getView(R.id.view_common_line).setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(item.commentImg)) {
            Picasso.with(mActivity)
                    .load(SPUtils.getString(UserInfo.USER_ICON_FIRST_HALF.name(), "") + item.commentImg)
                    .error(R.drawable.ic_default_user_header)
                    .transform(new PicassoCircleTransform())
                    .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
                    .centerCrop()
                    .into((ImageView) helper.getView(R.id.iv_header));
        } else {
            helper.setImageResource(R.id.iv_header, R.drawable.ic_default_user_header);
        }

        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_5, item.createTime);
        helper.setText(R.id.tv_name, item.commentUser)
                .setText(R.id.tv_time, time)
                .setText(R.id.tv_content, item.content)
                .setText(R.id.tv_quote_name, item.newsTitle)
                .setText(R.id.tv_quote_content, item.newsIntro);
    }
}
