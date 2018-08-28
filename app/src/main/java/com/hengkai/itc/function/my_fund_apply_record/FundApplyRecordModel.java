package com.hengkai.itc.function.my_fund_apply_record;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.FundApplyRecordEntity;
import com.hengkai.itc.network.service.FundApplyRecordService;
import com.hengkai.itc.utils.RetrofitHelper;
import com.hengkai.itc.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/27.
 */
public class FundApplyRecordModel extends BaseModel {

    private final FundApplyRecordService service;

    public FundApplyRecordModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(FundApplyRecordService.class);
    }

    public void getApplyList(int pageNum, Observer<FundApplyRecordEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("userId", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(30));

        service.getApplyList(URLFinal.FUND_APPLY_RECORD, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
