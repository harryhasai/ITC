package com.hengkai.itc.function.informations;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.InformationContentEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/20.
 */
public class InformationPresenter extends BasePresenter<InformationFragment> {

    private final InformationModel model;

    public InformationPresenter() {
        model = new InformationModel();
    }

    public void getInformationType() {
        model.getInformationType(new Observer<InformationContentEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(InformationContentEntity informationContentEntity) {
                switch (informationContentEntity.code) {
                    case 1:
                        view.getInformationType(informationContentEntity.data);
                        break;
                    case 0:
                        view.showLoginDialog(view.getContext());
                        break;
                    default:
                        ToastUtils.showShort(informationContentEntity.msg);
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
