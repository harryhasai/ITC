package com.hengkai.itc.function.news_detail;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.ImageNewsHasCommentEntity;
import com.hengkai.itc.network.entity.ImageNewsNoCommentEntity;
import com.hengkai.itc.network.entity.TextNewsHasCommentEntity;
import com.hengkai.itc.network.entity.TextNewsNoCommentEntity;
import com.hengkai.itc.network.service.NewsDetailService;
import com.hengkai.itc.utils.RetrofitHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/24.
 */
public class NewsDetailModel extends BaseModel {

    private final NewsDetailService service;

    public NewsDetailModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(NewsDetailService.class);
    }

    /**
     * 图片新闻, 有评论
     */
    public void getImageNewsHasComment(int ID, Observer<ImageNewsHasCommentEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ID", String.valueOf(ID));
        params.put("IsComment", "yes");

        service.getImageNewsHasComment(URLFinal.GET_NEWS_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 图片新闻, 没有评论
     */
    public void getImageNewsNoComment(int ID, Observer<ImageNewsNoCommentEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ID", String.valueOf(ID));
        params.put("IsComment", "no");

        service.getImageNewsNoComment(URLFinal.GET_NEWS_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 文字新闻, 有评论
     */
    public void getTextNewsHasComment(int ID, Observer<TextNewsHasCommentEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ID", String.valueOf(ID));
        params.put("IsComment", "yes");

        service.getTextNewsHasComment(URLFinal.GET_NEWS_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 文字新闻, 没有评论
     */
    public void getTextNewsNoComment(int ID, Observer<TextNewsNoCommentEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("ID", String.valueOf(ID));
        params.put("IsComment", "no");

        service.getTextNewsNoComment(URLFinal.GET_NEWS_DETAIL, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
