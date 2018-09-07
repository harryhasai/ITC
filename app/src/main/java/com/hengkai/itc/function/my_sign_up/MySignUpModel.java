package com.hengkai.itc.function.my_sign_up;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.MySignUpEntity;
import com.hengkai.itc.network.service.MySignUpService;
import com.hengkai.itc.utils.RetrofitHelper;
import com.hengkai.itc.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/30.
 */
public class MySignUpModel extends BaseModel {

    private final MySignUpService service;

    public MySignUpModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(MySignUpService.class);
    }

    public void getSignUpList(int pageNum, Observer<MySignUpEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("UserId", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("Token", SPUtils.getString(UserInfo.TOKEN.name(), ""));
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(30));

        service.getSignUpList(URLFinal.MY_SIGN_UP_LIST, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
