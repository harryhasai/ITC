package com.hengkai.itc.function.my_comment;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.MyCommentEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/21.
 */
public class MyCommentPresenter extends BasePresenter<MyCommentActivity> {

    private final MyCommentModel model;

    public MyCommentPresenter() {
        model = new MyCommentModel();
    }

    public void getCommentList(int pageNum) {
        model.getCommentList(pageNum, new Observer<MyCommentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyCommentEntity myCommentEntity) {
                switch (myCommentEntity.code) {
                    case 1:
                        view.getCommentList(myCommentEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(myCommentEntity.msg);
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
