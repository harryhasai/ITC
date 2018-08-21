package com.hengkai.itc.function.mine;

import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.network.entity.ModifyHeaderEntity;
import com.hengkai.itc.network.service.MineService;
import com.hengkai.itc.utils.RetrofitHelper;
import com.hengkai.itc.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/20.
 */
public class MineModel extends BaseModel {

    private final MineService service;

    public MineModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();
        service = retrofit.create(MineService.class);
    }

    public void modifyHeader(String base64, Observer<ModifyHeaderEntity> observer) {
        Map<String, String> params = new HashMap<>();

        params.put("headPortrait", base64);
        params.put("userId", SPUtils.getString(UserInfo.USER_ID.name(), ""));

        service.modifyHeader(URLFinal.MODIFY_HEADER, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
