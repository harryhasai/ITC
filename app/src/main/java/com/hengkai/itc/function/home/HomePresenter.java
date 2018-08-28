package com.hengkai.itc.function.home;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.HomeNewsListEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/20.
 */
public class HomePresenter extends BasePresenter<HomeFragment> {

    private final HomeModel model;

    public HomePresenter() {
        model = new HomeModel();
    }

    public void getNewsList() {
        model.getNewsList(new Observer<HomeNewsListEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeNewsListEntity homeNewsListEntity) {
                switch (homeNewsListEntity.code) {
                    case 1:
                        view.getNewsList(homeNewsListEntity.data, homeNewsListEntity.attachmentPath);
                        break;
                    case 0:
                        view.showLoginDialog(view.getContext());
                        break;
                    default:
                        ToastUtils.showShort(homeNewsListEntity.msg);
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
