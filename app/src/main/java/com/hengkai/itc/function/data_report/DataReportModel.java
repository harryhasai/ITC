package com.hengkai.itc.function.data_report;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.service.DataReportService;
import com.hengkai.itc.utils.RetrofitHelper;
import com.hengkai.itc.utils.SPUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/21.
 */
public class DataReportModel extends BaseModel {

    private final DataReportService service;

    public DataReportModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(DataReportService.class);
    }

    public void dataReport(Map<String, String> params, Observer<CommonEntity> observer) {

        params.put("userId", SPUtils.getString(UserInfo.USER_ID.name(), ""));

        service.dataReport(URLFinal.DATA_REPORT, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
