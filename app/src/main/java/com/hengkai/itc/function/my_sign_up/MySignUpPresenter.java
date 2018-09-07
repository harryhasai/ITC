package com.hengkai.itc.function.my_sign_up;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.MySignUpEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/30.
 */
public class MySignUpPresenter extends BasePresenter<MySignUpActivity> {

    private final MySignUpModel model;

    public MySignUpPresenter() {
        model = new MySignUpModel();
    }

    public void getSignUpList(int pageNum) {
        model.getSignUpList(pageNum, new Observer<MySignUpEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MySignUpEntity mySignUpEntity) {
                switch (mySignUpEntity.code) {
                    case 1:
                        view.getSignUpList(mySignUpEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(mySignUpEntity.msg);
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
