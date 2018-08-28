package com.hengkai.itc.function.my_fund_apply_record;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.FundApplyRecordEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/27.
 */
public class FundApplyRecordPresenter extends BasePresenter<FundApplyRecordActivity> {

    private final FundApplyRecordModel model;

    public FundApplyRecordPresenter() {
        model = new FundApplyRecordModel();
    }

    public void getApplyList(int pageNum) {
        model.getApplyList(pageNum, new Observer<FundApplyRecordEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FundApplyRecordEntity fundApplyRecordEntity) {
                switch (fundApplyRecordEntity.code) {
                    case 1:
                        view.getApplyList(fundApplyRecordEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(fundApplyRecordEntity.msg);
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
