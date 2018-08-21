package com.hengkai.itc.function.mine;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.ModifyHeaderEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/20.
 */
public class MinePresenter extends BasePresenter<MineFragment> {

    private final MineModel model;

    public MinePresenter() {
        model = new MineModel();
    }

    public void modifyHeader(String base64) {
        model.modifyHeader(base64, new Observer<ModifyHeaderEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ModifyHeaderEntity modifyHeaderEntity) {
                switch (modifyHeaderEntity.code) {
                    case 1:
                        ToastUtils.showShort("修改成功");
                        view.modifyHeader(modifyHeaderEntity.headPortraitLink);
                        break;
                    case 0:
                        view.showLoginDialog(view.getContext());
                        break;
                    default:
                        ToastUtils.showShort(modifyHeaderEntity.msg);
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
