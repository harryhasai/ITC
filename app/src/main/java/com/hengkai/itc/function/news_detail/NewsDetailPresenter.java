package com.hengkai.itc.function.news_detail;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.ImageNewsHasCommentEntity;
import com.hengkai.itc.network.entity.ImageNewsNoCommentEntity;
import com.hengkai.itc.network.entity.TextNewsHasCommentEntity;
import com.hengkai.itc.network.entity.TextNewsNoCommentEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/24.
 */
public class NewsDetailPresenter extends BasePresenter<NewsDetailActivity> {

    private final NewsDetailModel model;

    public NewsDetailPresenter() {
        model = new NewsDetailModel();
    }

    /**
     * 图片新闻, 有评论
     */
    public void getImageNewsHasComment(int ID) {
        model.getImageNewsHasComment(ID, new Observer<ImageNewsHasCommentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ImageNewsHasCommentEntity imageNewsHasCommentEntity) {
                switch (imageNewsHasCommentEntity.code) {
                    case 1:
                        view.getImageNewsHasComment(imageNewsHasCommentEntity);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(imageNewsHasCommentEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 图片新闻, 没有评论
     */
    public void getImageNewsNoComment(int ID) {
        model.getImageNewsNoComment(ID, new Observer<ImageNewsNoCommentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ImageNewsNoCommentEntity imageNewsNoCommentEntity) {
                switch (imageNewsNoCommentEntity.code) {
                    case 1:
                        view.getImageNewsNoComment(imageNewsNoCommentEntity);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(imageNewsNoCommentEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 文字新闻, 有评论
     */
    public void getTextNewsHasComment(int ID) {
        model.getTextNewsHasComment(ID, new Observer<TextNewsHasCommentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TextNewsHasCommentEntity textNewsHasCommentEntity) {
                switch (textNewsHasCommentEntity.code) {
                    case 1:
                        view.getTextNewsHasComment(textNewsHasCommentEntity);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(textNewsHasCommentEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 文字新闻, 没有评论
     */
    public void getTextNewsNoComment(int ID) {
        model.getTextNewsNoComment(ID, new Observer<TextNewsNoCommentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TextNewsNoCommentEntity textNewsNoCommentEntity) {
                switch (textNewsNoCommentEntity.code) {
                    case 1:
                        view.getTextNewsNoComment(textNewsNoCommentEntity);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(textNewsNoCommentEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 评论
     * @param newsId 当前新闻ID
     * @param content 评论内容
     */
    public void comment(int newsId, String content) {
        model.comment(newsId, content, new Observer<CommonEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommonEntity commonEntity) {
                switch (commonEntity.code) {
                    case 1:
                        view.comment();
                        ToastUtils.showShort("评论成功");
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(commonEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
