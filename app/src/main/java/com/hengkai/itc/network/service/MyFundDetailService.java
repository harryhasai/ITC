package com.hengkai.itc.network.service;

import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.MyFundDetailEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Harry on 2018/8/20.
 */
public interface MyFundDetailService {

    @FormUrlEncoded
    @POST
    Observable<MyFundDetailEntity> getFundDetail(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<CommonEntity> signUp(@Url String url, @FieldMap Map<String, String> params);
}
