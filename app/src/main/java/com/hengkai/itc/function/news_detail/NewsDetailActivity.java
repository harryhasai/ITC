package com.hengkai.itc.function.news_detail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.network.entity.ImageNewsHasCommentEntity;
import com.hengkai.itc.network.entity.ImageNewsNoCommentEntity;
import com.hengkai.itc.network.entity.TextNewsHasCommentEntity;
import com.hengkai.itc.network.entity.TextNewsNoCommentEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/24.
 * 新闻详情页面
 */
public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter> {

    /**
     * 文字新闻, 下方有推荐新闻
     */
    private static final int NEWS_TYPE1 = 101;
    /**
     * 文字新闻, 下方有评论, 并且可以新增评论
     */
    private static final int NEWS_TYPE2 = 102;
    /**
     * 图片新闻, 下方有推荐新闻
     */
    private static final int NEWS_TYPE3 = 103;
    /**
     * 图片新闻, 下方有评论, 并且可以新增评论
     */
    private static final int NEWS_TYPE4 = 104;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.tv_recommend_or_comment)
    TextView tvRecommendOrComment;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    /**
     * 是否是图片新闻
     */
    private boolean isImgNews;
    /**
     * 是否有评论(值为yes或者no)
     */
    private String isComment;
    /**
     * 新闻ID
     */
    private int newsId;

    @Override
    protected int setupView() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("新闻详情");

        isImgNews = getIntent().getBooleanExtra("isImgNews", false);
        isComment = getIntent().getStringExtra("isComment");
        newsId = getIntent().getIntExtra("newsId", 0);

        if (isImgNews) {
            if (isComment.equals("yes")) {
                mPresenter.getImageNewsHasComment(newsId);//图片新闻, 有评论
            } else {
                mPresenter.getImageNewsNoComment(newsId);//图片新闻, 没有评论
            }
        } else {
            if (isComment.equals("yes")) {
                mPresenter.getTextNewsHasComment(newsId);//文字新闻, 有评论
            } else {
                mPresenter.getTextNewsNoComment(newsId);//文字新闻, 没有评论
            }
        }
    }

    @Override
    protected NewsDetailPresenter bindPresenter() {
        return new NewsDetailPresenter();
    }

    /**
     * 图片新闻, 有评论
     */
    public void getImageNewsHasComment(ImageNewsHasCommentEntity imageNewsHasCommentEntity) {
        tvNewsTitle.setText(imageNewsHasCommentEntity.data.newsTitle);
        tvAuthor.setText(imageNewsHasCommentEntity.data.createUser);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, imageNewsHasCommentEntity.data.releaseTime);
        tvTime.setText(time);
        tvRecommendOrComment.setText("全部评论");

        List<ImageNewsHasCommentEntity.DataBean.ImgNewsListBean> imgNewsList = imageNewsHasCommentEntity.data.imgNewsList;

        for (int i = 0; i < imgNewsList.size(); i++) {
            ImageNewsHasCommentEntity.DataBean.ImgNewsListBean bean = imgNewsList.get(i);
            View view = View.inflate(this, R.layout.view_news_detail_image, null);
            ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
            TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);
            if (!TextUtils.isEmpty(bean.imgUrl)) {
                Picasso.with(this)
                        .load(imageNewsHasCommentEntity.attachmentPath + bean.imgUrl)
                        .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                        .into(ivNewsDetailImage);
            } else {
                ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
            }
            tvNewsDetailContent.setText(bean.imgDesc);
            llContent.addView(view);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        ImageNewsHasCommentAdapter adapter;
        List<ImageNewsHasCommentEntity.DataBean.CommentListBean> commentList = imageNewsHasCommentEntity.data.commentList;
        if (commentList.size() == 0) {
            ImageNewsHasCommentEntity.DataBean.CommentListBean bean = new ImageNewsHasCommentEntity.DataBean.CommentListBean();
            commentList.add(bean);
            adapter = new ImageNewsHasCommentAdapter(R.layout.item_no_comment, commentList,
                    this, imageNewsHasCommentEntity.attachmentPath);
        } else {
            adapter = new ImageNewsHasCommentAdapter(R.layout.item_news_detail_comment,
                    commentList, this, imageNewsHasCommentEntity.attachmentPath);
        }
        recyclerView.setAdapter(adapter);
    }

    /**
     * 图片新闻, 没有评论
     */
    public void getImageNewsNoComment(final ImageNewsNoCommentEntity imageNewsNoCommentEntity) {
        tvNewsTitle.setText(imageNewsNoCommentEntity.data.newsTitle);
        tvAuthor.setText(imageNewsNoCommentEntity.data.createUser);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, imageNewsNoCommentEntity.data.releaseTime);
        tvTime.setText(time);
        tvRecommendOrComment.setText("相关推荐");
        List<ImageNewsNoCommentEntity.DataBean.ImgNewsListBean> imgNewsList = imageNewsNoCommentEntity.data.imgNewsList;

        for (int i = 0; i < imgNewsList.size(); i++) {
            ImageNewsNoCommentEntity.DataBean.ImgNewsListBean bean = imgNewsList.get(i);
            View view = View.inflate(this, R.layout.view_news_detail_image, null);
            ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
            TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);
            if (!TextUtils.isEmpty(bean.imgUrl)) {
                Picasso.with(this)
                        .load(imageNewsNoCommentEntity.attachmentPath + bean.imgUrl)
                        .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                        .into(ivNewsDetailImage);
            } else {
                ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
            }
            tvNewsDetailContent.setText(bean.imgDesc);
            llContent.addView(view);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        ImageNewsNoCommentAdapter adapter = new ImageNewsNoCommentAdapter(R.layout.item_home_news_list,
                imageNewsNoCommentEntity.data.newsList, this, imageNewsNoCommentEntity.attachmentPath);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(NewsDetailActivity.this, NewsDetailActivity.class);
                intent.putExtra("isImgNews", imageNewsNoCommentEntity.data.newsList.get(position).isImgNews);
                intent.putExtra("isComment", imageNewsNoCommentEntity.data.newsList.get(position).isComment);
                intent.putExtra("newsId", imageNewsNoCommentEntity.data.newsList.get(position).id);
                startActivity(intent);
            }
        });
    }

    /**
     * 文字新闻, 有评论
     */
    public void getTextNewsHasComment(TextNewsHasCommentEntity textNewsHasCommentEntity) {
        tvNewsTitle.setText(textNewsHasCommentEntity.data.newsTitle);
        tvAuthor.setText(textNewsHasCommentEntity.data.createUser);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, textNewsHasCommentEntity.data.releaseTime);
        tvTime.setText(time);
        tvRecommendOrComment.setText("全部评论");

        View view = View.inflate(this, R.layout.view_news_detail_image, null);
        ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
        TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);
        if (!TextUtils.isEmpty(textNewsHasCommentEntity.data.coverImg)) {
            Picasso.with(this)
                    .load(textNewsHasCommentEntity.attachmentPath + textNewsHasCommentEntity.data.coverImg)
                    .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                    .into(ivNewsDetailImage);
        } else {
            ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
        }
        tvNewsDetailContent.setText(Html.fromHtml(textNewsHasCommentEntity.data.content));
        llContent.addView(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        TextNewsHasCommentAdapter adapter;
        List<TextNewsHasCommentEntity.DataBean.CommentListBean> commentList = textNewsHasCommentEntity.data.commentList;
        if (commentList.size() == 0) {
            TextNewsHasCommentEntity.DataBean.CommentListBean bean = new TextNewsHasCommentEntity.DataBean.CommentListBean();
            commentList.add(bean);
            adapter = new TextNewsHasCommentAdapter(R.layout.item_no_comment, commentList,
                    this, textNewsHasCommentEntity.attachmentPath);
        } else {
            adapter = new TextNewsHasCommentAdapter(R.layout.item_news_detail_comment,
                    commentList, this, textNewsHasCommentEntity.attachmentPath);
        }
        recyclerView.setAdapter(adapter);
    }

    /**
     * 文字新闻, 没有评论
     */
    public void getTextNewsNoComment(final TextNewsNoCommentEntity textNewsNoCommentEntity) {
        tvNewsTitle.setText(textNewsNoCommentEntity.data.newsTitle);
        tvAuthor.setText(textNewsNoCommentEntity.data.createUser);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, textNewsNoCommentEntity.data.releaseTime);
        tvTime.setText(time);
        tvRecommendOrComment.setText("相关推荐");

        View view = View.inflate(this, R.layout.view_news_detail_image, null);
        ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
        TextView tvNewsDetailContent = view.findViewById(R.id.tv_news_detail_content);
        if (!TextUtils.isEmpty(textNewsNoCommentEntity.data.coverImg)) {
            Picasso.with(this)
                    .load(textNewsNoCommentEntity.attachmentPath + textNewsNoCommentEntity.data.coverImg)
                    .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                    .into(ivNewsDetailImage);
        } else {
            ivNewsDetailImage.setImageResource(R.drawable.ic_news_default_pic);
        }
        tvNewsDetailContent.setText(Html.fromHtml(textNewsNoCommentEntity.data.content));
        llContent.addView(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        TextNewsNoCommentAdapter adapter = new TextNewsNoCommentAdapter(R.layout.item_home_news_list,
                textNewsNoCommentEntity.data.newsList, this, textNewsNoCommentEntity.attachmentPath);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(NewsDetailActivity.this, NewsDetailActivity.class);
                intent.putExtra("isImgNews", textNewsNoCommentEntity.data.newsList.get(position).isImgNews);
                intent.putExtra("isComment", textNewsNoCommentEntity.data.newsList.get(position).isComment);
                intent.putExtra("newsId", textNewsNoCommentEntity.data.newsList.get(position).id);
                startActivity(intent);
            }
        });

    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
