package com.hengkai.itc.function.my_sign_up;

import com.hengkai.itc.base.model.BaseModel;
import com.hengkai.itc.utils.RetrofitHelper;

import retrofit2.Retrofit;

/**
 * Created by Harry on 2018/8/30.
 */
public class MySignUpModel extends BaseModel {

    public MySignUpModel() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit();

    }
}
