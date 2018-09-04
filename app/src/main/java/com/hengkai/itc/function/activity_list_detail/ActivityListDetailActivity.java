package com.hengkai.itc.function.activity_list_detail;

import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.function.activity_list_detail.sign_up.SignUpActivity;
import com.hengkai.itc.network.entity.ActivityListDetailImageEntity;
import com.hengkai.itc.network.entity.ActivityListDetailTextEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/31.
 * 资讯 - 活动列表详情
 */
public class ActivityListDetailActivity extends BaseActivity<ActivityListDetailPresenter> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_create_time)
    TextView tvCreateTime;
    @BindView(R.id.tv_activity_time)
    TextView tvActivityTime;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    /**
     * 当前活动的ID
     */
    private int activityID;

    @Override
    protected int setupView() {
        return R.layout.activity_activity_list_detail;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("活动详情");
        tvRight.setText("报名");

        activityID = getIntent().getIntExtra("activityID", 0);
        boolean isImgActivity = getIntent().getBooleanExtra("isImgActivity", false);
        if (isImgActivity) {
            //图片活动
            mPresenter.getActivityImageDetail(activityID);
        } else {
            //文字活动
            mPresenter.getActivityTextDetail(activityID);
        }

    }

    @Override
    protected ActivityListDetailPresenter bindPresenter() {
        return new ActivityListDetailPresenter();
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                Intent intent = new Intent(this, SignUpActivity.class);
                intent.putExtra("activityID", activityID);
                startActivity(intent);
                break;
        }
    }

    public void getActivityTextDetail(ActivityListDetailTextEntity.DataBean bean, String attachmentPath) {
        tvNewsTitle.setText(bean.activityName);
        tvAuthor.setText(bean.createUser);
        String createTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_1, bean.createTime);
        tvCreateTime.setText(createTime);
        String startTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, bean.activityStartTime);
        String endTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, bean.activityEndTime);
        tvActivityTime.setText(String.format("活动时间%s ~ %s", startTime, endTime));

        View view = View.inflate(this, R.layout.view_news_detail_image, null);
        ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
        TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);

        if (!TextUtils.isEmpty(bean.activityImg)) {
            Picasso.with(this)
                    .load(attachmentPath + bean.activityImg)
                    .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                    .into(ivNewsDetailImage);
        } else {
            ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
        }
        tvNewsDetailContent.setText(Html.fromHtml(bean.activityContent));

        llContent.addView(view);
    }

    public void getActivityImageDetail(ActivityListDetailImageEntity.DataBean bean, String attachmentPath, List<ActivityListDetailImageEntity.ImgListBean> imgList) {
        tvNewsTitle.setText(bean.activityName);
        tvAuthor.setText(bean.createUser);
        String createTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_1, bean.createTime);
        tvCreateTime.setText(createTime);
        String startTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, bean.activityStartTime);
        String endTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, bean.activityEndTime);
        tvActivityTime.setText(String.format("活动时间%s ~ %s", startTime, endTime));

        for (int i = 0; i < imgList.size(); i++) {
            ActivityListDetailImageEntity.ImgListBean imgListBean = imgList.get(i);
            View view = View.inflate(this, R.layout.view_news_detail_image, null);
            ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
            TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);
            if (!TextUtils.isEmpty(imgListBean.imgUrl)) {
                Picasso.with(this)
                        .load(attachmentPath + imgListBean.imgUrl)
                        .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                        .into(ivNewsDetailImage);
            } else {
                ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
            }
            tvNewsDetailContent.setText(imgListBean.imgDesc);
            llContent.addView(view);
        }
    }
}
