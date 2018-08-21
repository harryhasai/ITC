package com.hengkai.itc.function.login;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.LoginEntity;
import com.hengkai.itc.network.service.LoginService;
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
public class LoginModel extends BaseModel {

    private final LoginService service;

    public LoginModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(LoginService.class);
    }

    public void login(String userName, String password, Observer<LoginEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("loginName", userName);
        params.put("passWord", password);
        params.put("type", "2");

        service.login(URLFinal.LOGIN, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
