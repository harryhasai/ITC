package com.hengkai.itc.function.my_fund;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.MyFundEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/27.
 */
public class MyFundPresenter extends BasePresenter<MyFundActivity> {

    private final MyFundModel model;

    public MyFundPresenter() {
        model = new MyFundModel();
    }

    public void getFundList(String newsTitle, int pageNum) {
        model.getFundList(newsTitle, pageNum, new Observer<MyFundEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyFundEntity myFundEntity) {
                switch (myFundEntity.code) {
                    case 1:
                        view.getFundList(myFundEntity.data, myFundEntity.attachmentPath);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(myFundEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {
                view.stopRefreshing();
            }
        });
    }
}
