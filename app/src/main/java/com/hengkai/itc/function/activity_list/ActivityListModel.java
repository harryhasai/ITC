package com.hengkai.itc.function.activity_list;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.ActivityListEntity;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.hengkai.itc.network.service.ActivityListService;
import com.hengkai.itc.utils.RetrofitHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/30.
 */
public class ActivityListModel extends BaseModel {

    private final ActivityListService service;

    public ActivityListModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(ActivityListService.class);
    }

    public void getActivityList(int activityTypeID, int pageNum, Observer<ActivityListEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ActivityType", String.valueOf(activityTypeID));
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(30));

        service.getActivityList(URLFinal.ACTIVITY_LIST, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
