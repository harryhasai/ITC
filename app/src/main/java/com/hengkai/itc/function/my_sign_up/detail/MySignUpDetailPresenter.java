package com.hengkai.itc.function.my_sign_up.detail;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.activity_list_detail.ActivityListDetailActivity;
import com.hengkai.itc.function.activity_list_detail.ActivityListDetailModel;
import com.hengkai.itc.network.entity.ActivityListDetailImageEntity;
import com.hengkai.itc.network.entity.ActivityListDetailTextEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/31.
 */
public class MySignUpDetailPresenter extends BasePresenter<MySignUpDetailActivity> {

    private final MySignUpDetailModel model;

    public MySignUpDetailPresenter() {
        model = new MySignUpDetailModel();
    }

    public void getActivityTextDetail(int activityID) {
        model.getActivityTextDetail(activityID, new Observer<ActivityListDetailTextEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ActivityListDetailTextEntity activityListDetailTextEntity) {
                switch (activityListDetailTextEntity.code) {
                    case 1:
                        view.getActivityTextDetail(activityListDetailTextEntity.data, activityListDetailTextEntity.attachmentPath);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(activityListDetailTextEntity.msg);
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

    public void getActivityImageDetail(int activityID) {
        model.getActivityImageDetail(activityID, new Observer<ActivityListDetailImageEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ActivityListDetailImageEntity activityListDetailImageEntity) {
                switch (activityListDetailImageEntity.code) {
                    case 1:
                        view.getActivityImageDetail(activityListDetailImageEntity.data,
                                activityListDetailImageEntity.attachmentPath, activityListDetailImageEntity.imgList);
                        break;
                    case 0:
                        view.showLoginDialog(view);
                        break;
                    default:
                        ToastUtils.showShort(activityListDetailImageEntity.msg);
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
