package com.hengkai.itc.function.my_reply;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.MyCommentEntity;
import com.hengkai.itc.network.entity.MyReplyEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/21.
 */
public class MyReplyPresenter extends BasePresenter<MyReplyActivity> {

    private final MyReplyModel model;

    public MyReplyPresenter() {
        model = new MyReplyModel();
    }

    public void getCommentList(int pageNum) {
        model.getCommentList(pageNum, new Observer<MyReplyEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyReplyEntity myReplyEntity) {
                switch (myReplyEntity.code) {
                    case 1:
                        view.getCommentList(myReplyEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(myReplyEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
                view.stopRefreshing();
            }

            @Override
            public void onComplete() {
                view.stopRefreshing();
            }
        });
    }
}
