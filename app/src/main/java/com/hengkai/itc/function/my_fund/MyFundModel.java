package com.hengkai.itc.function.my_fund;

import android.text.TextUtils;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.hengkai.itc.network.entity.MyFundEntity;
import com.hengkai.itc.network.service.HomeNewsListService;
import com.hengkai.itc.network.service.MyFundService;
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
public class MyFundModel extends BaseModel {

    private final MyFundService service;

    public MyFundModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(MyFundService.class);
    }

    public void getFundList(String newsTitle, int pageNum, Observer<MyFundEntity> observer) {
        Map<String, String> params = new HashMap<>();

        if (!TextUtils.isEmpty(newsTitle)) {
            params.put("newsTitle", newsTitle);
        }
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(30));

        service.getFundList(URLFinal.MY_FUND_LIST, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
