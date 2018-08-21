package com.hengkai.itc.function.data_report;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonEntity;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/21.
 */
public class DataReportPresenter extends BasePresenter<DataReportActivity> {

    private final DataReportModel model;

    public DataReportPresenter() {
        model = new DataReportModel();
    }

    public void dataReport(Map<String, String> params) {
        model.dataReport(params, new Observer<CommonEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommonEntity commonEntity) {
                switch (commonEntity.code) {
                    case 1:
                        ToastUtils.showShort("上报成功");
                        view.finish();
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
