package com.hengkai.itc.function.activity_list;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.ActivityListEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/30.
 */
public class ActivityListPresenter extends BasePresenter<ActivityListActivity> {

    private final ActivityListModel model;

    public ActivityListPresenter() {
        model = new ActivityListModel();
    }

    public void getActivityList(int activityTypeID, int pageNum) {
        model.getActivityList(activityTypeID, pageNum, new Observer<ActivityListEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ActivityListEntity activityListEntity) {
                switch (activityListEntity.code) {
                    case 1:
                        view.getActivityList(activityListEntity.data, activityListEntity.attachmentPath);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(activityListEntity.msg);
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
