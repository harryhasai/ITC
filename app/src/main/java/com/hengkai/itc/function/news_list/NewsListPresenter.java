package com.hengkai.itc.function.news_list;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.HomeNewsListEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/25.
 */
public class NewsListPresenter extends BasePresenter<NewsListActivity> {

    private final NewsListModel model;

    public NewsListPresenter() {
        model = new NewsListModel();
    }

    public void getNewsList(int childID, int pageNum) {
        model.getNewsList(childID, pageNum, new Observer<HomeNewsListEntity>() {
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
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(homeNewsListEntity.msg);
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
