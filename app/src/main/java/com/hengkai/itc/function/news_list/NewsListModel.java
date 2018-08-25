package com.hengkai.itc.function.news_list;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.hengkai.itc.network.service.HomeNewsListService;
import com.hengkai.itc.utils.RetrofitHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/25.
 */
public class NewsListModel extends BaseModel {

    private final HomeNewsListService service;

    public NewsListModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(HomeNewsListService.class);
    }

    public void getNewsList(int childID, int pageNum, Observer<HomeNewsListEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("Type", "releaseTime");
        params.put("ID", String.valueOf(childID));
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(30));

        service.getNewsList(URLFinal.GET_NEWS_LIST_HOME, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
