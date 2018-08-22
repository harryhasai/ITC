package com.hengkai.itc.network.service;

import com.hengkai.itc.network.entity.MyReplyEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Harry on 2018/8/20.
 */
public interface MyReplyService {

    @FormUrlEncoded
    @POST
    Observable<MyReplyEntity> getCommentList(@Url String url, @FieldMap Map<String, String> params);
}
