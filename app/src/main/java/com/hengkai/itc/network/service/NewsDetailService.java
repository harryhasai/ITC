package com.hengkai.itc.network.service;

import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.ImageNewsHasCommentEntity;
import com.hengkai.itc.network.entity.ImageNewsNoCommentEntity;
import com.hengkai.itc.network.entity.NewsDetailEntity;
import com.hengkai.itc.network.entity.TextNewsHasCommentEntity;
import com.hengkai.itc.network.entity.TextNewsNoCommentEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Harry on 2018/8/20.
 */
public interface NewsDetailService {

    @FormUrlEncoded
    @POST
    Observable<ImageNewsHasCommentEntity> getImageNewsHasComment(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<ImageNewsNoCommentEntity> getImageNewsNoComment(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<TextNewsHasCommentEntity> getTextNewsHasComment(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<TextNewsNoCommentEntity> getTextNewsNoComment(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<CommonEntity> comment(@Url String url, @FieldMap Map<String, String> params);
}
