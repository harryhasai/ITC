package com.hengkai.itc.function.informations;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.InformationContentEntity;
import com.hengkai.itc.network.service.InformationContentService;
import com.hengkai.itc.utils.RetrofitHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/20.
 */
public class InformationModel extends BaseModel {

    private final InformationContentService service;

    public InformationModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(InformationContentService.class);
    }

    public void getInformationType(Observer<InformationContentEntity> observer) {
        Map<String, String> params = new HashMap<>();

        service.getInformationType(URLFinal.INFORMATION_CONTENT, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
