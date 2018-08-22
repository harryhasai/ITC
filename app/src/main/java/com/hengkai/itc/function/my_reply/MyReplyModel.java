package com.hengkai.itc.function.my_reply;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.MyCommentEntity;
import com.hengkai.itc.network.entity.MyReplyEntity;
import com.hengkai.itc.network.service.MyReplyService;
import com.hengkai.itc.utils.RetrofitHelper;
import com.hengkai.itc.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/21.
 */
public class MyReplyModel extends BaseModel {

    private final MyReplyService service;

    public MyReplyModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(MyReplyService.class);
    }

    public void getCommentList(int pageNum, Observer<MyReplyEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("UserId", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("token", SPUtils.getString(UserInfo.TOKEN.name(), ""));
        params.put("Type", "replyMe");
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", "10");

        service.getCommentList(URLFinal.MY_COMMENT_LIST, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
