package com.hengkai.itc.function.my_fund.detail;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.CommonItem;
import com.hengkai.itc.network.entity.MyFundDetailEntity;
import com.hengkai.itc.network.service.MyFundDetailService;
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
public class MyFundDetailModel extends BaseModel {

    private final MyFundDetailService service;

    public MyFundDetailModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(MyFundDetailService.class);
    }

    public void getFundDetail(int fundID, Observer<MyFundDetailEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ID", String.valueOf(fundID));

        service.getFundDetail(URLFinal.MY_FUND_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void signUp(int fundID, String applyContent, Observer<CommonEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("applyUserid", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("fundId", String.valueOf(fundID));
        params.put("applyContent", applyContent);

        service.signUp(URLFinal.MY_FUND_DETAIL_SIGN_UP, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
