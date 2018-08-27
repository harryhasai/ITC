package com.hengkai.itc.function.my_fund.detail;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.MyFundDetailEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/27.
 */
public class MyFundDetailPresenter extends BasePresenter<MyFundDetailActivity> {

    private final MyFundDetailModel model;

    public MyFundDetailPresenter() {
        model = new MyFundDetailModel();
    }

    public void getFundDetail(int fundID) {
        model.getFundDetail(fundID, new Observer<MyFundDetailEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyFundDetailEntity myFundDetailEntity) {
                switch (myFundDetailEntity.code) {
                    case 1:
                        view.getFundDetail(myFundDetailEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(myFundDetailEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
                view.finish();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void signUp(int fundID, String applyContent) {
        model.signUp(fundID, applyContent, new Observer<CommonEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommonEntity commonEntity) {
                switch (commonEntity.code) {
                    case 1:
                        view.signUpSuccess();
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
