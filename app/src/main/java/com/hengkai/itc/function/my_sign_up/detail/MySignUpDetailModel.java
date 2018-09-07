package com.hengkai.itc.function.my_sign_up.detail;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.ActivityListDetailImageEntity;
import com.hengkai.itc.network.entity.ActivityListDetailTextEntity;
import com.hengkai.itc.network.service.ActivityListDetailService;
import com.hengkai.itc.utils.RetrofitHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/31.
 */
public class MySignUpDetailModel extends BaseModel {

    private final ActivityListDetailService service;

    public MySignUpDetailModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(ActivityListDetailService.class);
    }

    public void getActivityTextDetail(int activityID, Observer<ActivityListDetailTextEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("Id", String.valueOf(activityID));

        service.getActivityTextDetail(URLFinal.ACTIVITY_LIST_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getActivityImageDetail(int activityID, Observer<ActivityListDetailImageEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("Id", String.valueOf(activityID));

        service.getActivityImageDetail(URLFinal.ACTIVITY_LIST_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
